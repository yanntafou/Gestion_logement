package com.lsd.logement.mapper;

import com.lsd.logement.dto.BailDTO;
import com.lsd.logement.entity.finance.Payement;
import com.lsd.logement.entity.reservation.Bail;
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
public class BailMapperImpl implements BailMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public BailDTO asDTO(Bail entity) {
        if ( entity == null ) {
            return null;
        }

        BailDTO bailDTO = new BailDTO();

        bailDTO.setId( entity.getId() );
        bailDTO.setDateEntre( entity.getDateEntre() );
        bailDTO.setValidate( entity.getValidate() );
        bailDTO.setNumReservation( entity.getNumReservation() );
        bailDTO.setStatut( entity.getStatut() );
        bailDTO.setSejour( entity.getSejour() );
        bailDTO.setPeriodQty( entity.getPeriodQty() );
        bailDTO.setPaymentStatus( entity.getPaymentStatus() );
        bailDTO.setCreatedAt( entity.getCreatedAt() );
        bailDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        bailDTO.setLocal( entity.getLocal() );
        bailDTO.setLocataireSociete( entity.getLocataireSociete() );
        bailDTO.setLocataireParticulier( entity.getLocataireParticulier() );
        List<Payement> list = entity.getPayements();
        if ( list != null ) {
            bailDTO.setPayements( new ArrayList<Payement>( list ) );
        }
        bailDTO.setEcheance( entity.getEcheance() );

        return bailDTO;
    }

    @Override
    public List<Bail> asEntityList(List<BailDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Bail> list = new ArrayList<Bail>( dtoList.size() );
        for ( BailDTO bailDTO : dtoList ) {
            list.add( asEntity( bailDTO ) );
        }

        return list;
    }

    @Override
    public List<BailDTO> asDTOList(List<Bail> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BailDTO> list = new ArrayList<BailDTO>( entityList.size() );
        for ( Bail bail : entityList ) {
            list.add( asDTO( bail ) );
        }

        return list;
    }

    @Override
    public Bail asEntity(BailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Bail bail = referenceMapper.resolve( dto, Bail.class );

        bail.setId( dto.getId() );
        bail.setDateEntre( dto.getDateEntre() );
        bail.setValidate( dto.getValidate() );
        bail.setNumReservation( dto.getNumReservation() );
        bail.setStatut( dto.getStatut() );
        bail.setSejour( dto.getSejour() );
        bail.setPeriodQty( dto.getPeriodQty() );
        bail.setPaymentStatus( dto.getPaymentStatus() );
        bail.setCreatedAt( dto.getCreatedAt() );
        bail.setLastUpdatedAt( dto.getLastUpdatedAt() );
        bail.setLocal( dto.getLocal() );
        bail.setLocataireSociete( dto.getLocataireSociete() );
        bail.setLocataireParticulier( dto.getLocataireParticulier() );
        List<Payement> list = dto.getPayements();
        if ( list != null ) {
            bail.setPayements( new ArrayList<Payement>( list ) );
        }
        bail.setEcheance( dto.getEcheance() );

        return bail;
    }
}
