package com.lsd.logement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<E, M> {

    E save(E entity);

    List<E> save(List<E> entities);

    void deleteById(M id);

    Optional<E> findById(M id);

    List<E> findAll();

    Page<E> findAll(Pageable pageable);

    E update(E entity, M id);
}
