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

import com.lsd.logement.controller.CommandeController;
import com.lsd.logement.dto.CommandeDTO;
import com.lsd.logement.entity.Stock.Commande;
import com.lsd.logement.mapper.CommandeMapper;
import com.lsd.logement.model.ApiResponse;
import com.lsd.logement.service.CommandeService;

@RequestMapping("/api/commande")
@RestController
public class CommandeControllerImpl implements CommandeController {

    private final CommandeService commandeService;
    private final CommandeMapper commandeMapper;

    public CommandeControllerImpl(CommandeService commandeService, CommandeMapper commandeMapper) {
        this.commandeService = commandeService;
        this.commandeMapper = commandeMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> save(@RequestBody CommandeDTO commandeDTO) {
        try {
            Commande commande = commandeMapper.asEntity(commandeDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(commandeMapper.asDTO(commandeService.save(commande)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findById(@PathVariable("id") Integer id) {
        try {
            Commande commande = commandeService.findById(id).orElse(null);
            return ResponseEntity.ok(
                    new ApiResponse<>(commandeMapper.asDTO(commande))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable("id") Integer id) {
        try {
            commandeService.deleteById(id);
            return ResponseEntity.ok(
                    new ApiResponse<>(HttpStatus.OK.value(), "Commande supprimé avec succes")
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
                    new ApiResponse<>(commandeMapper.asDTOList(commandeService.findAll()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @GetMapping("/page-query")
    public ResponseEntity<ApiResponse<?>> pageQuery(Pageable pageable) {
        try {
            Page<Commande> commandePage = commandeService.findAll(pageable);
            List<CommandeDTO> dtoList = commandePage
                    .stream()
                    .map(commandeMapper::asDTO).collect(Collectors.toList());
            return ResponseEntity.ok(
                    new ApiResponse<>(new PageImpl<>(dtoList, pageable, commandePage.getTotalElements()))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody CommandeDTO commandeDTO, @PathVariable("id") Integer id) {
        try {
            Commande commande = commandeMapper.asEntity(commandeDTO);
            return ResponseEntity.ok(
                    new ApiResponse<>(commandeMapper.asDTO(commandeService.update(commande, id)))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.from(e));
        }
    }
}
