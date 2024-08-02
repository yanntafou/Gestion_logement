package com.lsd.logement.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lsd.logement.dto.BailDTO;
import com.lsd.logement.dto.PayementDTO;
import com.lsd.logement.model.ApiResponse;

public interface BailController {

    ResponseEntity<ApiResponse<?>> save(@RequestBody BailDTO bailDTO, @PathVariable("userId") int appUserId);

    ResponseEntity<ApiResponse<?>> findById(@PathVariable("id") Integer id);

    ResponseEntity<ApiResponse<?>> delete(@PathVariable("id") Integer id);

    ResponseEntity<ApiResponse<?>> list();

    ResponseEntity<ApiResponse<?>> pageQuery(Pageable pageable);

    ResponseEntity<ApiResponse<?>> update(@RequestBody BailDTO dto, @PathVariable("id") Integer id);

    public ResponseEntity<ApiResponse<?>> addPayment(@RequestBody PayementDTO dto, @PathVariable("id") Integer id);

    public ResponseEntity<ApiResponse<?>> removePayment(@RequestBody PayementDTO dto, @PathVariable("id") Integer id);

    public ResponseEntity<ApiResponse<?>> cancelBail(@PathVariable("id") Integer id);

    public ResponseEntity<ApiResponse<?>> bailState();
}
