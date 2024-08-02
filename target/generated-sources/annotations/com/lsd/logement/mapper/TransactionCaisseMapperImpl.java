package com.lsd.logement.mapper;

import com.lsd.logement.dto.TransactionCaisseDTO;
import com.lsd.logement.entity.TransactionCaisse;
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
public class TransactionCaisseMapperImpl implements TransactionCaisseMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public TransactionCaisseDTO asDTO(TransactionCaisse entity) {
        if ( entity == null ) {
            return null;
        }

        TransactionCaisseDTO transactionCaisseDTO = new TransactionCaisseDTO();

        transactionCaisseDTO.setId( entity.getId() );
        transactionCaisseDTO.setAmount( entity.getAmount() );
        transactionCaisseDTO.setPaymentMethod( entity.getPaymentMethod() );
        transactionCaisseDTO.setCaisse( entity.getCaisse() );
        transactionCaisseDTO.setCreatedAt( entity.getCreatedAt() );
        transactionCaisseDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        transactionCaisseDTO.setType( entity.getType() );

        return transactionCaisseDTO;
    }

    @Override
    public List<TransactionCaisse> asEntityList(List<TransactionCaisseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TransactionCaisse> list = new ArrayList<TransactionCaisse>( dtoList.size() );
        for ( TransactionCaisseDTO transactionCaisseDTO : dtoList ) {
            list.add( asEntity( transactionCaisseDTO ) );
        }

        return list;
    }

    @Override
    public List<TransactionCaisseDTO> asDTOList(List<TransactionCaisse> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TransactionCaisseDTO> list = new ArrayList<TransactionCaisseDTO>( entityList.size() );
        for ( TransactionCaisse transactionCaisse : entityList ) {
            list.add( asDTO( transactionCaisse ) );
        }

        return list;
    }

    @Override
    public TransactionCaisse asEntity(TransactionCaisseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransactionCaisse transactionCaisse = referenceMapper.resolve( dto, TransactionCaisse.class );

        transactionCaisse.setId( dto.getId() );
        transactionCaisse.setAmount( dto.getAmount() );
        transactionCaisse.setPaymentMethod( dto.getPaymentMethod() );
        transactionCaisse.setCreatedAt( dto.getCreatedAt() );
        transactionCaisse.setLastUpdatedAt( dto.getLastUpdatedAt() );
        transactionCaisse.setCaisse( dto.getCaisse() );
        transactionCaisse.setType( dto.getType() );

        return transactionCaisse;
    }
}
