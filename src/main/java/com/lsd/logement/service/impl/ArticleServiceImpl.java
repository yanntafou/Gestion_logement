package com.lsd.logement.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lsd.logement.entity.Stock.Article;
import com.lsd.logement.repository.ArticleRepository;
import com.lsd.logement.service.ArticleService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;

    public ArticleServiceImpl(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Article save(Article entity) {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        entity.setCreatedAt(currentDateTime);
        entity.setLastUpdatedAt(currentDateTime);
        return repository.save(entity);
    }

    @Override
    public List<Article> save(List<Article> entities) {
        return (List<Article>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Article> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Article> findAll() {
        return (List<Article>) repository.findAll();
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        Page<Article> entityPage = repository.findAll(pageable);
        List<Article> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Article update(Article entity, Integer id) {
        Optional<Article> optional = findById(id);
        if (optional.isPresent()) {
            entity.setId(optional.get().getId());
            entity.setCreatedAt(optional.get().getCreatedAt());
            entity.setLastUpdatedAt(ZonedDateTime.now());
            return save(entity);
        }
        return null;
    }
}
