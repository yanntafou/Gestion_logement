package com.lsd.logement.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lsd.logement.entity.client.LocataireParticulier;
import com.lsd.logement.repository.LocataireParticulierRepository;
import com.lsd.logement.service.LocataireParticulierService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocataireParticulierServiceImpl implements LocataireParticulierService {

    private final LocataireParticulierRepository repository;

    public LocataireParticulierServiceImpl(LocataireParticulierRepository repository) {
        this.repository = repository;
    }

    @Override
    public LocataireParticulier save(LocataireParticulier entity) {
        ZonedDateTime currentDate = ZonedDateTime.now();
        entity.setCreatedAt(currentDate);
        entity.setLastUpdatedAt(currentDate);
        return repository.save(entity);
    }

    @Override
    public List<LocataireParticulier> save(List<LocataireParticulier> entities) {
        entities.forEach(entity -> {
            ZonedDateTime currentDate = ZonedDateTime.now();
            entity.setCreatedAt(currentDate);
            entity.setLastUpdatedAt(currentDate);
        });
        return (List<LocataireParticulier>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<LocataireParticulier> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<LocataireParticulier> findAll() {
        return (List<LocataireParticulier>) repository.findAll();
    }

    @Override
    public Page<LocataireParticulier> findAll(Pageable pageable) {
        Page<LocataireParticulier> entityPage = repository.findAll(pageable);
        List<LocataireParticulier> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public LocataireParticulier update(LocataireParticulier entity, Integer id) {
        Optional<LocataireParticulier> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
