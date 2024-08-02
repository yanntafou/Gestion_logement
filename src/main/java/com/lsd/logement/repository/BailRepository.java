package com.lsd.logement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.infrastructure.Local;
import com.lsd.logement.entity.infrastructure.Enum.CategorieEnum;
import com.lsd.logement.entity.infrastructure.Enum.TypeLocal;
import com.lsd.logement.entity.reservation.Bail;
import com.lsd.logement.entity.reservation.Enum.BookingState;

@Repository
public interface BailRepository extends JpaRepository<Bail, Integer> {

    @Query("select count(b.id) as qte from Bail b where b.statut = :status")
    int countBailWithStatus(@Param("status") BookingState status);

    @Query("select distinct l from Local l where l.typeLocal = :typeLocal and l.categorie = :categorie and l not in (select b.local from Bail b where b.validate between :startDate and :endDate)")
    List<Local> findLocalAvailable(@Param("typeLocal") TypeLocal typeLocal, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("categorie") CategorieEnum categorie);

    int countAllByValidateLessThanEqualAndStatutIsNot(Date now, BookingState state);

    int countAllByValidateGreaterThanEqualAndStatutIsNot(Date now, BookingState state);

    @Query("select count(b) from Bail b")
    int countAllDueDate(@Param("now") Date now);

    @Query("select count(b.id) as qte from Bail b where b.statut = :status")
    long countByStatus(@Param("status") String status);
}
