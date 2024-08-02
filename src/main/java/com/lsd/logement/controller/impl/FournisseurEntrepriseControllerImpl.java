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

import com.lsd.logement.controller.FournisseurEntrepriseController;
import com.lsd.logement.dto.FournisseurEntrepriseDTO;
import com.lsd.logement.entity.Stock.FournisseurEntreprise;
import com.lsd.logement.mapper.FournisseurEntrepriseMapper;
import com.lsd.logement.model.ApiResponse;
import com.lsd.logement.service.FournisseurEntrepriseService;

@RequestMapping("/api/fournisseur/entreprise")
@RestController
public class FournisseurEntrepriseControllerImpl implements FournisseurEntrepriseController {

    private final FournisseurEntrepriseService fournisseurEntrepriseService;
    private final FournisseurEntrepriseMapper fournisseurEntrepriseMapper;

    public FournisseurEntrepriseControllerImpl(FournisseurEntrepriseService fournisseurEntrepriseService, FournisseurEntrepriseMapper fournisseurEntrepriseMapper) {
        this.fournisseurEntrepriseService = fournisseurEntrepriseService;
        this.fournisseurEntrepriseMapper = fournisseurEntrepriseMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> save(@RequestBody FournisseurEntrepriseDTO fournisseurEntrepriseDTO) {
        try {
            FournisseurEntreprise fournisseurEntreprise = fournisseurEntrepriseMapper.asEntity(fournisseurEntrepriseDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(fournisseurEntrepriseMapper.asDTO(fournisseurEntrepriseService.save(fournisseurEntreprise)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findById(@PathVariable("id") Integer id) {
        try {
            FournisseurEntreprise fournisseurEntreprise = fournisseurEntrepriseService.findById(id).orElse(null);
            return ResponseEntity.ok(
                    new ApiResponse<>(fournisseurEntrepriseMapper.asDTO(fournisseurEntreprise))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable("id") Integer id) {
        try {
            fournisseurEntrepriseService.deleteById(id);
            return ResponseEntity.ok(
                    new ApiResponse<>(HttpStatus.OK.value(), "FournisseurEntreprise supprimé avec succes")
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
                    new ApiResponse<>(fournisseurEntrepriseMapper.asDTOList(fournisseurEntrepriseService.findAll()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/page-query")
    public ResponseEntity<ApiResponse<?>> pageQuery(Pageable pageable) {
        try {
            Page<FournisseurEntreprise> fournisseurEntreprisePage = fournisseurEntrepriseService.findAll(pageable);
            List<FournisseurEntrepriseDTO> dtoList = fournisseurEntreprisePage
                    .stream()
                    .map(fournisseurEntrepriseMapper::asDTO).collect(Collectors.toList());
            return ResponseEntity.ok(
                    new ApiResponse<>(new PageImpl<>(dtoList, pageable, fournisseurEntreprisePage.getTotalElements()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody FournisseurEntrepriseDTO fournisseurEntrepriseDTO, @PathVariable("id") Integer id) {
        try {
            FournisseurEntreprise fournisseurEntreprise = fournisseurEntrepriseMapper.asEntity(fournisseurEntrepriseDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(fournisseurEntrepriseMapper.asDTO(fournisseurEntrepriseService.update(fournisseurEntreprise, id)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }
}
