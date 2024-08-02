package com.lsd.logement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.SousCaisse;

@Repository
public interface SousCaisseRepository extends JpaRepository<SousCaisse, Integer> {

    Optional<SousCaisse> findByNameAndCaisse_Id(String name, Integer caisseId);

}
