package com.lsd.logement.mapper;

import com.lsd.logement.dto.TransfertCaisseDTO;
import com.lsd.logement.entity.finance.TransfertCaisse;
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
public class TransfertCaisseMapperImpl implements TransfertCaisseMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public TransfertCaisseDTO asDTO(TransfertCaisse entity) {
        if ( entity == null ) {
            return null;
        }

        TransfertCaisseDTO transfertCaisseDTO = new TransfertCaisseDTO();

        transfertCaisseDTO.setId( entity.getId() );
        transfertCaisseDTO.setTransactionRef( entity.getTransactionRef() );
        transfertCaisseDTO.setTransfertDe( entity.getTransfertDe() );
        transfertCaisseDTO.setTransfertA( entity.getTransfertA() );
        transfertCaisseDTO.setMontant( entity.getMontant() );
        transfertCaisseDTO.setStatut( entity.getStatut() );
        transfertCaisseDTO.setCreatedAt( entity.getCreatedAt() );
        transfertCaisseDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );

        return transfertCaisseDTO;
    }

    @Override
    public List<TransfertCaisse> asEntityList(List<TransfertCaisseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TransfertCaisse> list = new ArrayList<TransfertCaisse>( dtoList.size() );
        for ( TransfertCaisseDTO transfertCaisseDTO : dtoList ) {
            list.add( asEntity( transfertCaisseDTO ) );
        }

        return list;
    }

    @Override
    public List<TransfertCaisseDTO> asDTOList(List<TransfertCaisse> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TransfertCaisseDTO> list = new ArrayList<TransfertCaisseDTO>( entityList.size() );
        for ( TransfertCaisse transfertCaisse : entityList ) {
            list.add( asDTO( transfertCaisse ) );
        }

        return list;
    }

    @Override
    public TransfertCaisse asEntity(TransfertCaisseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransfertCaisse transfertCaisse = referenceMapper.resolve( dto, TransfertCaisse.class );

        transfertCaisse.setId( dto.getId() );
        transfertCaisse.setTransactionRef( dto.getTransactionRef() );
        transfertCaisse.setTransfertDe( dto.getTransfertDe() );
        transfertCaisse.setTransfertA( dto.getTransfertA() );
        transfertCaisse.setMontant( dto.getMontant() );
        transfertCaisse.setStatut( dto.getStatut() );
        transfertCaisse.setCreatedAt( dto.getCreatedAt() );
        transfertCaisse.setLastUpdatedAt( dto.getLastUpdatedAt() );

        return transfertCaisse;
    }
}
