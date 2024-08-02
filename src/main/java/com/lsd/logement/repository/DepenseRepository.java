package com.lsd.logement.repository;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.finance.Depense;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Integer> {

    @Query("select sum(d.montant) from Depense d where d.createdAt between :startDate and :endDate")
    Optional<Long> getDepenseOfMonth(@Param("startDate") ZonedDateTime startDate, @Param("endDate") ZonedDateTime endDate);
}
