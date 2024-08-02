package com.lsd.logement.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsd.logement.controller.ArticleController;
import com.lsd.logement.dto.ArticleDTO;
import com.lsd.logement.entity.Stock.Article;
import com.lsd.logement.mapper.ArticleMapper;
import com.lsd.logement.model.ApiResponse;
import com.lsd.logement.service.ArticleService;

@RequestMapping("/api/article")
@RestController
public class ArticleControllerImpl implements ArticleController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    public ArticleControllerImpl(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> save(@RequestBody ArticleDTO articleDTO) {
        try {
            Article article = articleMapper.asEntity(articleDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(articleMapper.asDTO(articleService.save(article)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findById(@PathVariable("id") Integer id) {
        try {
            Article article = articleService.findById(id).orElse(null);
            return ResponseEntity.ok(
                    new ApiResponse<>(articleMapper.asDTO(article))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable("id") Integer id) {
        try {
            articleService.deleteById(id);
            return ResponseEntity.ok(
                    new ApiResponse<>(HttpStatus.OK.value(), "Article supprimé avec succes")
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }

    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<?>> list() {
        try {
            return ResponseEntity.ok(
                    new ApiResponse<>(articleMapper.asDTOList(articleService.findAll()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/page-query")
    public ResponseEntity<ApiResponse<?>> pageQuery(Pageable pageable) {
        try {
            Page<Article> articlePage = articleService.findAll(pageable);
            List<ArticleDTO> dtoList = articlePage
                    .stream()
                    .map(articleMapper::asDTO).collect(Collectors.toList());
            return ResponseEntity.ok(
                    new ApiResponse<>(new PageImpl<>(dtoList, pageable, articlePage.getTotalElements()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody ArticleDTO articleDTO, @PathVariable("id") Integer id) {
        try {
            Article article = articleMapper.asEntity(articleDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(articleMapper.asDTO(articleService.update(article, id)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }
}
