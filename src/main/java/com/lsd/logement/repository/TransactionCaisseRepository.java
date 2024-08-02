package com.lsd.logement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.TransactionCaisse;

@Repository
public interface TransactionCaisseRepository extends JpaRepository<TransactionCaisse, Integer> {

}
