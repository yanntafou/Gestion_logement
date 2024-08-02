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

import com.lsd.logement.controller.StockController;
import com.lsd.logement.dto.StockDTO;
import com.lsd.logement.entity.Stock.Stock;
import com.lsd.logement.mapper.StockMapper;
import com.lsd.logement.model.ApiResponse;
import com.lsd.logement.service.StockService;

@RequestMapping("/api/stock")
@RestController
public class StockControllerImpl implements StockController {

    private final StockService stockService;
    private final StockMapper stockMapper;

    public StockControllerImpl(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> save(@RequestBody StockDTO stockDTO) {
        try {
            Stock stock = stockMapper.asEntity(stockDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(stockMapper.asDTO(stockService.save(stock)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findById(@PathVariable("id") Integer id) {
        try {
            Stock stock = stockService.findById(id).orElse(null);
            return ResponseEntity.ok(
                    new ApiResponse<>(stockMapper.asDTO(stock))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable("id") Integer id) {
        try {
            stockService.deleteById(id);
            return ResponseEntity.ok(
                    new ApiResponse<>(HttpStatus.OK.value(), "Stock supprimé avec succes")
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
                    new ApiResponse<>(stockMapper.asDTOList(stockService.findAll()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/page-query")
    public ResponseEntity<ApiResponse<?>> pageQuery(Pageable pageable) {
        try {
            Page<Stock> stockPage = stockService.findAll(pageable);
            List<StockDTO> dtoList = stockPage
                    .stream()
                    .map(stockMapper::asDTO).collect(Collectors.toList());
            return ResponseEntity.ok(
                    new ApiResponse<>(new PageImpl<>(dtoList, pageable, stockPage.getTotalElements()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody StockDTO stockDTO, @PathVariable("id") Integer id) {
        try {
            Stock stock = stockMapper.asEntity(stockDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(stockMapper.asDTO(stockService.update(stock, id)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }
}
