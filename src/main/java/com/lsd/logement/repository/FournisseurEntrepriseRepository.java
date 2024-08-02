package com.lsd.logement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.Stock.FournisseurEntreprise;

@Repository
public interface FournisseurEntrepriseRepository extends JpaRepository<FournisseurEntreprise, Integer> {

}
