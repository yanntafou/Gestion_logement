package com.lsd.logement.mapper;

import com.lsd.logement.dto.SousCaisseDTO;
import com.lsd.logement.entity.SousCaisse;
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
public class SousCaisseMapperImpl implements SousCaisseMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public SousCaisseDTO asDTO(SousCaisse entity) {
        if ( entity == null ) {
            return null;
        }

        SousCaisseDTO sousCaisseDTO = new SousCaisseDTO();

        sousCaisseDTO.setId( entity.getId() );
        sousCaisseDTO.setName( entity.getName() );
        sousCaisseDTO.setSoldeInit( entity.getSoldeInit() );
        sousCaisseDTO.setTotal( entity.getTotal() );
        sousCaisseDTO.setSoldeFin( entity.getSoldeFin() );
        sousCaisseDTO.setDiff( entity.getDiff() );
        sousCaisseDTO.setCaisse( entity.getCaisse() );
        sousCaisseDTO.setCreatedAt( entity.getCreatedAt() );
        sousCaisseDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );

        return sousCaisseDTO;
    }

    @Override
    public List<SousCaisse> asEntityList(List<SousCaisseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SousCaisse> list = new ArrayList<SousCaisse>( dtoList.size() );
        for ( SousCaisseDTO sousCaisseDTO : dtoList ) {
            list.add( asEntity( sousCaisseDTO ) );
        }

        return list;
    }

    @Override
    public List<SousCaisseDTO> asDTOList(List<SousCaisse> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SousCaisseDTO> list = new ArrayList<SousCaisseDTO>( entityList.size() );
        for ( SousCaisse sousCaisse : entityList ) {
            list.add( asDTO( sousCaisse ) );
        }

        return list;
    }

    @Override
    public SousCaisse asEntity(SousCaisseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SousCaisse sousCaisse = referenceMapper.resolve( dto, SousCaisse.class );

        sousCaisse.setId( dto.getId() );
        sousCaisse.setName( dto.getName() );
        sousCaisse.setSoldeInit( dto.getSoldeInit() );
        sousCaisse.setTotal( dto.getTotal() );
        sousCaisse.setSoldeFin( dto.getSoldeFin() );
        sousCaisse.setDiff( dto.getDiff() );
        sousCaisse.setCreatedAt( dto.getCreatedAt() );
        sousCaisse.setLastUpdatedAt( dto.getLastUpdatedAt() );
        sousCaisse.setCaisse( dto.getCaisse() );

        return sousCaisse;
    }
}
