package com.lsd.logement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lsd.logement.entity.TransactionCaisse;
import com.lsd.logement.repository.TransactionCaisseRepository;
import com.lsd.logement.service.TransactionCaisseService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionCaisseServiceImpl implements TransactionCaisseService {

    private final TransactionCaisseRepository repository;

    public TransactionCaisseServiceImpl(TransactionCaisseRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionCaisse save(TransactionCaisse transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<TransactionCaisse> save(List<TransactionCaisse> entities) {
        return (List<TransactionCaisse>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<TransactionCaisse> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<TransactionCaisse> findAll() {
        return (List<TransactionCaisse>) repository.findAll();
    }

    @Override
    public Page<TransactionCaisse> findAll(Pageable pageable) {
        Page<TransactionCaisse> entityPage = repository.findAll(pageable);
        List<TransactionCaisse> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public TransactionCaisse update(TransactionCaisse entity, Integer id) {
        Optional<TransactionCaisse> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
