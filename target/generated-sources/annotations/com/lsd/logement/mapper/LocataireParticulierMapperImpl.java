package com.lsd.logement.mapper;

import com.lsd.logement.dto.LocataireParticulierDTO;
import com.lsd.logement.entity.client.LocataireParticulier;
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
public class LocataireParticulierMapperImpl implements LocataireParticulierMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public LocataireParticulierDTO asDTO(LocataireParticulier entity) {
        if ( entity == null ) {
            return null;
        }

        LocataireParticulierDTO locataireParticulierDTO = new LocataireParticulierDTO();

        locataireParticulierDTO.setId( entity.getId() );
        locataireParticulierDTO.setType( entity.getType() );
        locataireParticulierDTO.setCreatedAt( entity.getCreatedAt() );
        locataireParticulierDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        locataireParticulierDTO.setNom( entity.getNom() );
        locataireParticulierDTO.setPrenom( entity.getPrenom() );
        locataireParticulierDTO.setTelephone( entity.getTelephone() );
        locataireParticulierDTO.setLieuTravail( entity.getLieuTravail() );
        locataireParticulierDTO.setCni( entity.getCni() );
        locataireParticulierDTO.setPjCni( entity.getPjCni() );
        locataireParticulierDTO.setStMaritale( entity.getStMaritale() );
        locataireParticulierDTO.setPersContact( entity.getPersContact() );
        locataireParticulierDTO.setPersTelephone( entity.getPersTelephone() );
        locataireParticulierDTO.setPjContrat( entity.getPjContrat() );
        List<Booking> list = entity.getBookings();
        if ( list != null ) {
            locataireParticulierDTO.setBookings( new ArrayList<Booking>( list ) );
        }

        return locataireParticulierDTO;
    }

    @Override
    public List<LocataireParticulier> asEntityList(List<LocataireParticulierDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LocataireParticulier> list = new ArrayList<LocataireParticulier>( dtoList.size() );
        for ( LocataireParticulierDTO locataireParticulierDTO : dtoList ) {
            list.add( asEntity( locataireParticulierDTO ) );
        }

        return list;
    }

    @Override
    public List<LocataireParticulierDTO> asDTOList(List<LocataireParticulier> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LocataireParticulierDTO> list = new ArrayList<LocataireParticulierDTO>( entityList.size() );
        for ( LocataireParticulier locataireParticulier : entityList ) {
            list.add( asDTO( locataireParticulier ) );
        }

        return list;
    }

    @Override
    public LocataireParticulier asEntity(LocataireParticulierDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LocataireParticulier locataireParticulier = referenceMapper.resolve( dto, LocataireParticulier.class );

        locataireParticulier.setId( dto.getId() );
        locataireParticulier.setType( dto.getType() );
        locataireParticulier.setCreatedAt( dto.getCreatedAt() );
        locataireParticulier.setLastUpdatedAt( dto.getLastUpdatedAt() );
        locataireParticulier.setNom( dto.getNom() );
        locataireParticulier.setPrenom( dto.getPrenom() );
        locataireParticulier.setTelephone( dto.getTelephone() );
        locataireParticulier.setLieuTravail( dto.getLieuTravail() );
        locataireParticulier.setCni( dto.getCni() );
        locataireParticulier.setPjCni( dto.getPjCni() );
        locataireParticulier.setStMaritale( dto.getStMaritale() );
        locataireParticulier.setPersContact( dto.getPersContact() );
        locataireParticulier.setPersTelephone( dto.getPersTelephone() );
        locataireParticulier.setPjContrat( dto.getPjContrat() );
        List<Booking> list = dto.getBookings();
        if ( list != null ) {
            locataireParticulier.setBookings( new ArrayList<Booking>( list ) );
        }

        return locataireParticulier;
    }
}
