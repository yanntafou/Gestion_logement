package com.lsd.logement.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lsd.logement.entity.client.LocataireSociete;
import com.lsd.logement.repository.LocataireSocieteRepository;
import com.lsd.logement.service.LocataireSocieteService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocataireSocieteServiceImpl implements LocataireSocieteService {

    private final LocataireSocieteRepository repository;

    public LocataireSocieteServiceImpl(LocataireSocieteRepository repository) {
        this.repository = repository;
    }

    @Override
    public LocataireSociete save(LocataireSociete entity) {
        ZonedDateTime currentDate = ZonedDateTime.now();
        entity.setCreatedAt(currentDate);
        entity.setLastUpdatedAt(currentDate);
        return repository.save(entity);
    }

    @Override
    public List<LocataireSociete> save(List<LocataireSociete> entities) {
        entities.forEach(entity -> {
            ZonedDateTime currentDate = ZonedDateTime.now();
            entity.setCreatedAt(currentDate);
            entity.setLastUpdatedAt(currentDate);
        });
        return (List<LocataireSociete>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<LocataireSociete> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<LocataireSociete> findAll() {
        return (List<LocataireSociete>) repository.findAll();
    }

    @Override
    public Page<LocataireSociete> findAll(Pageable pageable) {
        Page<LocataireSociete> entityPage = repository.findAll(pageable);
        List<LocataireSociete> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public LocataireSociete update(LocataireSociete entity, Integer id) {
        Optional<LocataireSociete> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
