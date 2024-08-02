package com.lsd.logement.mapper;

import com.lsd.logement.dto.PayementDTO;
import com.lsd.logement.entity.finance.Payement;
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
public class PayementMapperImpl implements PayementMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public PayementDTO asDTO(Payement entity) {
        if ( entity == null ) {
            return null;
        }

        PayementDTO payementDTO = new PayementDTO();

        payementDTO.setId( entity.getId() );
        payementDTO.setCreatedAt( entity.getCreatedAt() );
        payementDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        payementDTO.setPaymentMethod( entity.getPaymentMethod() );
        payementDTO.setAmount( entity.getAmount() );
        payementDTO.setIsLast( entity.getIsLast() );
        payementDTO.setRest( entity.getRest() );
        payementDTO.setBooking( entity.getBooking() );
        payementDTO.setDiscount( entity.getDiscount() );
        payementDTO.setBail( entity.getBail() );

        return payementDTO;
    }

    @Override
    public List<Payement> asEntityList(List<PayementDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Payement> list = new ArrayList<Payement>( dtoList.size() );
        for ( PayementDTO payementDTO : dtoList ) {
            list.add( asEntity( payementDTO ) );
        }

        return list;
    }

    @Override
    public List<PayementDTO> asDTOList(List<Payement> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PayementDTO> list = new ArrayList<PayementDTO>( entityList.size() );
        for ( Payement payement : entityList ) {
            list.add( asDTO( payement ) );
        }

        return list;
    }

    @Override
    public Payement asEntity(PayementDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Payement payement = referenceMapper.resolve( dto, Payement.class );

        payement.setId( dto.getId() );
        payement.setCreatedAt( dto.getCreatedAt() );
        payement.setLastUpdatedAt( dto.getLastUpdatedAt() );
        payement.setAmount( dto.getAmount() );
        payement.setIsLast( dto.getIsLast() );
        payement.setRest( dto.getRest() );
        payement.setBooking( dto.getBooking() );
        payement.setPaymentMethod( dto.getPaymentMethod() );
        payement.setDiscount( dto.getDiscount() );
        payement.setBail( dto.getBail() );

        return payement;
    }
}
