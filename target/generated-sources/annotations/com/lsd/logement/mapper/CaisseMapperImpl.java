package com.lsd.logement.mapper;

import com.lsd.logement.dto.CaisseDTO;
import com.lsd.logement.entity.SousCaisse;
import com.lsd.logement.entity.TransactionCaisse;
import com.lsd.logement.entity.finance.Caisse;
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
public class CaisseMapperImpl implements CaisseMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public CaisseDTO asDTO(Caisse entity) {
        if ( entity == null ) {
            return null;
        }

        CaisseDTO caisseDTO = new CaisseDTO();

        caisseDTO.setId( entity.getId() );
        caisseDTO.setNom( entity.getNom() );
        caisseDTO.setRef( entity.getRef() );
        caisseDTO.setStatus( entity.getStatus() );
        caisseDTO.setSolde( entity.getSolde() );
        caisseDTO.setAppUser( entity.getAppUser() );
        caisseDTO.setCreatedAt( entity.getCreatedAt() );
        caisseDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        caisseDTO.setLastOpening( entity.getLastOpening() );
        caisseDTO.setLastClosing( entity.getLastClosing() );
        List<TransactionCaisse> list = entity.getTransactionCaisses();
        if ( list != null ) {
            caisseDTO.setTransactionCaisses( new ArrayList<TransactionCaisse>( list ) );
        }
        List<SousCaisse> list1 = entity.getSousCaisses();
        if ( list1 != null ) {
            caisseDTO.setSousCaisses( new ArrayList<SousCaisse>( list1 ) );
        }
        caisseDTO.setPrincipal( entity.isPrincipal() );

        return caisseDTO;
    }

    @Override
    public List<Caisse> asEntityList(List<CaisseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Caisse> list = new ArrayList<Caisse>( dtoList.size() );
        for ( CaisseDTO caisseDTO : dtoList ) {
            list.add( asEntity( caisseDTO ) );
        }

        return list;
    }

    @Override
    public List<CaisseDTO> asDTOList(List<Caisse> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CaisseDTO> list = new ArrayList<CaisseDTO>( entityList.size() );
        for ( Caisse caisse : entityList ) {
            list.add( asDTO( caisse ) );
        }

        return list;
    }

    @Override
    public Caisse asEntity(CaisseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Caisse caisse = referenceMapper.resolve( dto, Caisse.class );

        caisse.setId( dto.getId() );
        caisse.setNom( dto.getNom() );
        caisse.setRef( dto.getRef() );
        caisse.setSolde( dto.getSolde() );
        caisse.setCreatedAt( dto.getCreatedAt() );
        caisse.setLastUpdatedAt( dto.getLastUpdatedAt() );
        caisse.setStatus( dto.getStatus() );
        caisse.setAppUser( dto.getAppUser() );
        caisse.setLastOpening( dto.getLastOpening() );
        caisse.setLastClosing( dto.getLastClosing() );
        List<TransactionCaisse> list = dto.getTransactionCaisses();
        if ( list != null ) {
            caisse.setTransactionCaisses( new ArrayList<TransactionCaisse>( list ) );
        }
        List<SousCaisse> list1 = dto.getSousCaisses();
        if ( list1 != null ) {
            caisse.setSousCaisses( new ArrayList<SousCaisse>( list1 ) );
        }
        caisse.setPrincipal( dto.isPrincipal() );

        return caisse;
    }
}
