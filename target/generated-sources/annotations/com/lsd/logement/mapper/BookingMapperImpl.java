package com.lsd.logement.mapper;

import com.lsd.logement.dto.BookingDTO;
import com.lsd.logement.entity.finance.Payement;
import com.lsd.logement.entity.reservation.Booking;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T13:58:05-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public BookingDTO asDTO(Booking entity) {
        if ( entity == null ) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId( entity.getId() );
        bookingDTO.setDateReservation( entity.getDateReservation() );
        bookingDTO.setNom( entity.getNom() );
        bookingDTO.setPrenom( entity.getPrenom() );
        bookingDTO.setTelephone( entity.getTelephone() );
        bookingDTO.setValidate( entity.getValidate() );
        bookingDTO.setNumReservation( entity.getNumReservation() );
        bookingDTO.setSejour( entity.getSejour() );
        bookingDTO.setStatut( entity.getStatut() );
        bookingDTO.setPaymentStatus( entity.getPaymentStatus() );
        bookingDTO.setPreriodUnit( entity.getPreriodUnit() );
        bookingDTO.setCreatedAt( entity.getCreatedAt() );
        bookingDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        bookingDTO.setLocal( entity.getLocal() );
        bookingDTO.setLocataireSociete( entity.getLocataireSociete() );
        bookingDTO.setLocataireParticulier( entity.getLocataireParticulier() );
        List<Payement> list = entity.getPayements();
        if ( list != null ) {
            bookingDTO.setPayements( new ArrayList<Payement>( list ) );
        }

        return bookingDTO;
    }

    @Override
    public List<Booking> asEntityList(List<BookingDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Booking> list = new ArrayList<Booking>( dtoList.size() );
        for ( BookingDTO bookingDTO : dtoList ) {
            list.add( asEntity( bookingDTO ) );
        }

        return list;
    }

    @Override
    public List<BookingDTO> asDTOList(List<Booking> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BookingDTO> list = new ArrayList<BookingDTO>( entityList.size() );
        for ( Booking booking : entityList ) {
            list.add( asDTO( booking ) );
        }

        return list;
    }

    @Override
    public Booking asEntity(BookingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Booking booking = referenceMapper.resolve( dto, Booking.class );

        booking.setId( dto.getId() );
        booking.setDateReservation( dto.getDateReservation() );
        booking.setNom( dto.getNom() );
        booking.setPrenom( dto.getPrenom() );
        booking.setTelephone( dto.getTelephone() );
        booking.setValidate( dto.getValidate() );
        booking.setNumReservation( dto.getNumReservation() );
        booking.setStatut( dto.getStatut() );
        booking.setSejour( dto.getSejour() );
        booking.setPreriodUnit( dto.getPreriodUnit() );
        booking.setCreatedAt( dto.getCreatedAt() );
        booking.setLastUpdatedAt( dto.getLastUpdatedAt() );
        booking.setLocal( dto.getLocal() );
        booking.setLocataireSociete( dto.getLocataireSociete() );
        booking.setLocataireParticulier( dto.getLocataireParticulier() );
        List<Payement> list = dto.getPayements();
        if ( list != null ) {
            booking.setPayements( new ArrayList<Payement>( list ) );
        }
        booking.setPaymentStatus( dto.getPaymentStatus() );

        return booking;
    }
}
