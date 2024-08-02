package com.lsd.logement.mapper;

import com.lsd.logement.dto.FournisseurParticulierDTO;
import com.lsd.logement.entity.Stock.FournisseurParticulier;
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
public class FournisseurParticulierMapperImpl implements FournisseurParticulierMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public FournisseurParticulierDTO asDTO(FournisseurParticulier entity) {
        if ( entity == null ) {
            return null;
        }

        FournisseurParticulierDTO fournisseurParticulierDTO = new FournisseurParticulierDTO();

        fournisseurParticulierDTO.setId( entity.getId() );
        fournisseurParticulierDTO.setNom( entity.getNom() );
        fournisseurParticulierDTO.setPrenom( entity.getPrenom() );
        fournisseurParticulierDTO.setLocalisation( entity.getLocalisation() );
        fournisseurParticulierDTO.setTelephone( entity.getTelephone() );
        fournisseurParticulierDTO.setCaCumule( entity.getCaCumule() );
        fournisseurParticulierDTO.setEcheance( entity.getEcheance() );
        fournisseurParticulierDTO.setMail1( entity.getMail1() );
        fournisseurParticulierDTO.setMail2( entity.getMail2() );
        fournisseurParticulierDTO.setCreatedAt( entity.getCreatedAt() );
        fournisseurParticulierDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );

        return fournisseurParticulierDTO;
    }

    @Override
    public List<FournisseurParticulier> asEntityList(List<FournisseurParticulierDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FournisseurParticulier> list = new ArrayList<FournisseurParticulier>( dtoList.size() );
        for ( FournisseurParticulierDTO fournisseurParticulierDTO : dtoList ) {
            list.add( asEntity( fournisseurParticulierDTO ) );
        }

        return list;
    }

    @Override
    public List<FournisseurParticulierDTO> asDTOList(List<FournisseurParticulier> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FournisseurParticulierDTO> list = new ArrayList<FournisseurParticulierDTO>( entityList.size() );
        for ( FournisseurParticulier fournisseurParticulier : entityList ) {
            list.add( asDTO( fournisseurParticulier ) );
        }

        return list;
    }

    @Override
    public FournisseurParticulier asEntity(FournisseurParticulierDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FournisseurParticulier fournisseurParticulier = referenceMapper.resolve( dto, FournisseurParticulier.class );

        fournisseurParticulier.setId( dto.getId() );
        fournisseurParticulier.setNom( dto.getNom() );
        fournisseurParticulier.setPrenom( dto.getPrenom() );
        fournisseurParticulier.setLocalisation( dto.getLocalisation() );
        fournisseurParticulier.setTelephone( dto.getTelephone() );
        fournisseurParticulier.setCaCumule( dto.getCaCumule() );
        fournisseurParticulier.setEcheance( dto.getEcheance() );
        fournisseurParticulier.setMail1( dto.getMail1() );
        fournisseurParticulier.setMail2( dto.getMail2() );
        fournisseurParticulier.setLastUpdatedAt( dto.getLastUpdatedAt() );
        fournisseurParticulier.setCreatedAt( dto.getCreatedAt() );

        return fournisseurParticulier;
    }
}
