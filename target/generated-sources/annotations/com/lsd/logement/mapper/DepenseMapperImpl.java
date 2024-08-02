package com.lsd.logement.mapper;

import com.lsd.logement.dto.DepenseDTO;
import com.lsd.logement.entity.finance.Depense;
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
public class DepenseMapperImpl implements DepenseMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public DepenseDTO asDTO(Depense entity) {
        if ( entity == null ) {
            return null;
        }

        DepenseDTO depenseDTO = new DepenseDTO();

        depenseDTO.setId( entity.getId() );
        depenseDTO.setDemandeur( entity.getDemandeur() );
        depenseDTO.setLocal( entity.getLocal() );
        depenseDTO.setCategorie( entity.getCategorie() );
        depenseDTO.setMontant( entity.getMontant() );
        depenseDTO.setCommentaire( entity.getCommentaire() );
        depenseDTO.setPieceJointe( entity.getPieceJointe() );
        depenseDTO.setCreatedAt( entity.getCreatedAt() );
        depenseDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        depenseDTO.setStatus( entity.getStatus() );
        depenseDTO.setSrcDepense( entity.getSrcDepense() );
        depenseDTO.setType( entity.getType() );

        return depenseDTO;
    }

    @Override
    public List<Depense> asEntityList(List<DepenseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Depense> list = new ArrayList<Depense>( dtoList.size() );
        for ( DepenseDTO depenseDTO : dtoList ) {
            list.add( asEntity( depenseDTO ) );
        }

        return list;
    }

    @Override
    public List<DepenseDTO> asDTOList(List<Depense> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DepenseDTO> list = new ArrayList<DepenseDTO>( entityList.size() );
        for ( Depense depense : entityList ) {
            list.add( asDTO( depense ) );
        }

        return list;
    }

    @Override
    public Depense asEntity(DepenseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Depense depense = referenceMapper.resolve( dto, Depense.class );

        depense.setId( dto.getId() );
        depense.setDemandeur( dto.getDemandeur() );
        depense.setLocal( dto.getLocal() );
        depense.setCategorie( dto.getCategorie() );
        depense.setMontant( dto.getMontant() );
        depense.setCommentaire( dto.getCommentaire() );
        depense.setPieceJointe( dto.getPieceJointe() );
        depense.setCreatedAt( dto.getCreatedAt() );
        depense.setLastUpdatedAt( dto.getLastUpdatedAt() );
        depense.setStatus( dto.getStatus() );
        depense.setSrcDepense( dto.getSrcDepense() );
        depense.setType( dto.getType() );

        return depense;
    }
}
