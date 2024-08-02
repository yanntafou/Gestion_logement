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
import com.lsd.logement.entity.reservation.Booking;
import com.lsd.logement.entity.reservation.Enum.BookingState;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("select count(b.id) as qte from Booking b where b.statut = :status")
    int countBookingWithStatus(@Param("status") BookingState status);

    @Query("select distinct l from Local l where l.typeLocal = :typeLocal and l.categorie = :categorie and l not in (select b.local from Booking b where b.validate > :startDate or b.statut <> :state) and l not in (select b.local from Bail b where b.validate > :startDate or b.statut <> :state)")
    List<Local> findLocalAvailable(@Param("typeLocal") TypeLocal typeLocal, @Param("startDate") Date startDate, @Param("categorie") CategorieEnum categorie, BookingState state);

    int countAllByValidateGreaterThanEqualAndStatutIsNot(Date date, BookingState cloturer);
}
