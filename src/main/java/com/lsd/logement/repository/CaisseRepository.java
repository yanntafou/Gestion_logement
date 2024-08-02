package com.lsd.logement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.finance.Caisse;
import com.lsd.logement.entity.finance.Enum.StatutCaisse;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse, Integer> {

    @Query("select c from Caisse c where c.user.id = :userId and c.status = :status")
    Optional<Caisse> findOpenedCaisse(@Param("userId") int userId, @Param("status") StatutCaisse caisse);

    Optional<Caisse> findByUser_Id(int userId);

    boolean existsByPrincipalIsTrue();

    @Query("select c from Caisse c where c.principal = true")
    Optional<Caisse> findPrincipal();

}
