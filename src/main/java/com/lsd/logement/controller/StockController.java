package com.lsd.logement.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lsd.logement.dto.StockDTO;
import com.lsd.logement.model.ApiResponse;

public interface StockController {

    public ResponseEntity<ApiResponse<?>> save(@RequestBody StockDTO stock);

    public ResponseEntity<ApiResponse<?>> findById(@PathVariable("id") Integer id);

    public ResponseEntity<ApiResponse<?>> delete(@PathVariable("id") Integer id);

    public ResponseEntity<ApiResponse<?>> list();

    public ResponseEntity<ApiResponse<?>> pageQuery(Pageable pageable);

    public ResponseEntity<ApiResponse<?>> update(@RequestBody StockDTO dto, @PathVariable("id") Integer id);
}
