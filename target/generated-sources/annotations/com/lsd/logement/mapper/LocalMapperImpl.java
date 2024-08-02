package com.lsd.logement.mapper;

import com.lsd.logement.dto.LocalDTO;
import com.lsd.logement.entity.infrastructure.Immobilisation;
import com.lsd.logement.entity.infrastructure.Local;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T13:58:04-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LocalMapperImpl implements LocalMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public LocalDTO asDTO(Local entity) {
        if ( entity == null ) {
            return null;
        }

        LocalDTO localDTO = new LocalDTO();

        localDTO.setId( entity.getId() );
        localDTO.setVille( entity.getVille() );
        localDTO.setPays( entity.getPays() );
        localDTO.setQuartier( entity.getQuartier() );
        localDTO.setImmeuble( entity.getImmeuble() );
        localDTO.setTypeLocal( entity.getTypeLocal() );
        localDTO.setNomLocal( entity.getNomLocal() );
        localDTO.setNumeroLocal( entity.getNumeroLocal() );
        localDTO.setEtage( entity.getEtage() );
        localDTO.setLocalisation( entity.getLocalisation() );
        localDTO.setCategorie( entity.getCategorie() );
        localDTO.setFumeur( entity.isFumeur() );
        localDTO.setClim( entity.isClim() );
        localDTO.setPiscine( entity.isPiscine() );
        localDTO.setWifi( entity.isWifi() );
        localDTO.setAnimaux( entity.isAnimaux() );
        localDTO.setChauffage( entity.isChauffage() );
        localDTO.setParkingIn( entity.isParkingIn() );
        localDTO.setGadienJour( entity.isGadienJour() );
        localDTO.setGardientNuit( entity.isGardientNuit() );
        localDTO.setGroupeElect( entity.isGroupeElect() );
        localDTO.setNbrChambre( entity.getNbrChambre() );
        localDTO.setNbrDouche( entity.getNbrDouche() );
        localDTO.setCa( entity.getCa() );
        localDTO.setPrix( entity.getPrix() );
        localDTO.setTypePrix( entity.getTypePrix() );
        localDTO.setContrat( entity.getContrat() );
        localDTO.setStatus( entity.getStatus() );
        localDTO.setCreatedAt( entity.getCreatedAt() );
        localDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        List<Immobilisation> list = entity.getImmobilisations();
        if ( list != null ) {
            localDTO.setImmobilisations( new ArrayList<Immobilisation>( list ) );
        }

        return localDTO;
    }

    @Override
    public List<Local> asEntityList(List<LocalDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Local> list = new ArrayList<Local>( dtoList.size() );
        for ( LocalDTO localDTO : dtoList ) {
            list.add( asEntity( localDTO ) );
        }

        return list;
    }

    @Override
    public List<LocalDTO> asDTOList(List<Local> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LocalDTO> list = new ArrayList<LocalDTO>( entityList.size() );
        for ( Local local : entityList ) {
            list.add( asDTO( local ) );
        }

        return list;
    }

    @Override
    public Local asEntity(LocalDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Local local = referenceMapper.resolve( dto, Local.class );

        local.setId( dto.getId() );
        local.setVille( dto.getVille() );
        local.setPays( dto.getPays() );
        local.setQuartier( dto.getQuartier() );
        local.setImmeuble( dto.getImmeuble() );
        local.setTypeLocal( dto.getTypeLocal() );
        local.setNomLocal( dto.getNomLocal() );
        local.setNumeroLocal( dto.getNumeroLocal() );
        local.setEtage( dto.getEtage() );
        local.setLocalisation( dto.getLocalisation() );
        local.setCategorie( dto.getCategorie() );
        local.setFumeur( dto.getFumeur() );
        local.setClim( dto.getClim() );
        local.setPiscine( dto.getPiscine() );
        local.setWifi( dto.getWifi() );
        local.setAnimaux( dto.getAnimaux() );
        local.setChauffage( dto.getChauffage() );
        local.setParkingIn( dto.getParkingIn() );
        local.setGadienJour( dto.getGadienJour() );
        local.setGardientNuit( dto.getGardientNuit() );
        local.setGroupeElect( dto.getGroupeElect() );
        local.setNbrChambre( dto.getNbrChambre() );
        local.setNbrDouche( dto.getNbrDouche() );
        local.setPrix( dto.getPrix() );
        local.setTypePrix( dto.getTypePrix() );
        local.setContrat( dto.getContrat() );
        local.setStatus( dto.getStatus() );
        local.setCreatedAt( dto.getCreatedAt() );
        local.setLastUpdatedAt( dto.getLastUpdatedAt() );
        local.setCa( dto.getCa() );
        List<Immobilisation> list = dto.getImmobilisations();
        if ( list != null ) {
            local.setImmobilisations( new ArrayList<Immobilisation>( list ) );
        }

        return local;
    }
}
