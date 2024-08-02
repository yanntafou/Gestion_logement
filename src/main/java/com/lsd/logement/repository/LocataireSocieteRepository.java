package com.lsd.logement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.client.LocataireSociete;

@Repository
public interface LocataireSocieteRepository extends JpaRepository<LocataireSociete, Integer> {

}
