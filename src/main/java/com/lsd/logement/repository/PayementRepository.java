package com.lsd.logement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.finance.Payement;

@Repository
public interface PayementRepository extends JpaRepository<Payement, Integer> {

}
