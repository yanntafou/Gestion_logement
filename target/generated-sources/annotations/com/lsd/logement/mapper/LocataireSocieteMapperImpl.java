package com.lsd.logement.mapper;

import com.lsd.logement.dto.LocataireSocieteDTO;
import com.lsd.logement.entity.client.LocataireSociete;
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
public class LocataireSocieteMapperImpl implements LocataireSocieteMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public LocataireSocieteDTO asDTO(LocataireSociete entity) {
        if ( entity == null ) {
            return null;
        }

        LocataireSocieteDTO locataireSocieteDTO = new LocataireSocieteDTO();

        locataireSocieteDTO.setId( entity.getId() );
        locataireSocieteDTO.setCreatedAt( entity.getCreatedAt() );
        locataireSocieteDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        locataireSocieteDTO.setRaisonSociale( entity.getRaisonSociale() );
        locataireSocieteDTO.setNiu( entity.getNiu() );
        locataireSocieteDTO.setNomGerant( entity.getNomGerant() );
        locataireSocieteDTO.setProfession( entity.getProfession() );
        locataireSocieteDTO.setPersContact1( entity.getPersContact1() );
        locataireSocieteDTO.setPersTelephone1( entity.getPersTelephone1() );
        locataireSocieteDTO.setPersEmail1( entity.getPersEmail1() );
        locataireSocieteDTO.setPersContacter2( entity.getPersContacter2() );
        locataireSocieteDTO.setPersTelephone2( entity.getPersTelephone2() );
        locataireSocieteDTO.setPersEmail2( entity.getPersEmail2() );
        List<Booking> list = entity.getBookings();
        if ( list != null ) {
            locataireSocieteDTO.setBookings( new ArrayList<Booking>( list ) );
        }

        return locataireSocieteDTO;
    }

    @Override
    public List<LocataireSociete> asEntityList(List<LocataireSocieteDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LocataireSociete> list = new ArrayList<LocataireSociete>( dtoList.size() );
        for ( LocataireSocieteDTO locataireSocieteDTO : dtoList ) {
            list.add( asEntity( locataireSocieteDTO ) );
        }

        return list;
    }

    @Override
    public List<LocataireSocieteDTO> asDTOList(List<LocataireSociete> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LocataireSocieteDTO> list = new ArrayList<LocataireSocieteDTO>( entityList.size() );
        for ( LocataireSociete locataireSociete : entityList ) {
            list.add( asDTO( locataireSociete ) );
        }

        return list;
    }

    @Override
    public LocataireSociete asEntity(LocataireSocieteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LocataireSociete locataireSociete = referenceMapper.resolve( dto, LocataireSociete.class );

        locataireSociete.setId( dto.getId() );
        locataireSociete.setCreatedAt( dto.getCreatedAt() );
        locataireSociete.setLastUpdatedAt( dto.getLastUpdatedAt() );
        locataireSociete.setRaisonSociale( dto.getRaisonSociale() );
        locataireSociete.setNiu( dto.getNiu() );
        locataireSociete.setNomGerant( dto.getNomGerant() );
        locataireSociete.setProfession( dto.getProfession() );
        locataireSociete.setPersContact1( dto.getPersContact1() );
        locataireSociete.setPersTelephone1( dto.getPersTelephone1() );
        locataireSociete.setPersEmail1( dto.getPersEmail1() );
        locataireSociete.setPersContacter2( dto.getPersContacter2() );
        locataireSociete.setPersTelephone2( dto.getPersTelephone2() );
        locataireSociete.setPersEmail2( dto.getPersEmail2() );
        List<Booking> list = dto.getBookings();
        if ( list != null ) {
            locataireSociete.setBookings( new ArrayList<Booking>( list ) );
        }

        return locataireSociete;
    }
}
