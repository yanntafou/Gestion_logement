package com.lsd.logement.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.infrastructure.Local;
import com.lsd.logement.entity.infrastructure.Enum.CategorieEnum;
import com.lsd.logement.entity.reservation.Enum.BookingState;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {

    @Query("select l from Local l Where l in (select b.local from Booking b where b.statut = 'CLOTURER' or b.statut = 'ANNULE') or l not in (select b.local from Booking b) order by l.id desc")
    Page<Local> findAllAvailable(Pageable pageable);

    int countAllByCategorie(CategorieEnum categorieEnum);

    @Query("SELECT l FROM Local l "
            + "WHERE l.id = :id "
            + "AND l NOT IN (SELECT b.local FROM Booking b WHERE b.validate > :startDate OR b.statut <> :state) "
            + "AND l NOT IN (SELECT b.local FROM Bail b WHERE b.validate > :startDate OR b.statut <> :state)")
    Optional<Local> localIsFree(@Param("id") Integer id, @Param("startDate") Date startDate, @Param("state") BookingState state);

}
