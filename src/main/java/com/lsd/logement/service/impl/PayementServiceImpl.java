package com.lsd.logement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lsd.logement.entity.finance.Payement;
import com.lsd.logement.entity.finance.Enum.PaymentStatus;
import com.lsd.logement.exception.ConstraintsMessage;
import com.lsd.logement.exception.GeneralBaseException;
import com.lsd.logement.repository.PayementRepository;
import com.lsd.logement.service.PayementService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PayementServiceImpl implements PayementService {

    private final PayementRepository repository;

    public PayementServiceImpl(PayementRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payement save(Payement entity) {
        checkStatutPayment(entity);
        return repository.save(entity);
    }

    private void checkStatutPayment(Payement entity) {
        if (entity.getBooking() != null && (entity.getBooking().getPaymentStatus() != PaymentStatus.PARTIELLE || entity.getBooking().getPaymentStatus() != PaymentStatus.IMPAYE)) {
            throw new GeneralBaseException(ConstraintsMessage.MISMATCH_STATUS);
        }

    }

    @Override
    public List<Payement> save(List<Payement> entities) {
        return (List<Payement>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Payement> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Payement> findAll() {
        return (List<Payement>) repository.findAll();
    }

    @Override
    public Page<Payement> findAll(Pageable pageable) {
        Page<Payement> entityPage = repository.findAll(pageable);
        List<Payement> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Payement update(Payement entity, Integer id) {
        Optional<Payement> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
