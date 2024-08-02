package com.lsd.logement.mapper;

import com.lsd.logement.dto.LigneCommandeDTO;
import com.lsd.logement.entity.Stock.LigneCommande;
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
public class LigneCommandeMapperImpl implements LigneCommandeMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public LigneCommandeDTO asDTO(LigneCommande entity) {
        if ( entity == null ) {
            return null;
        }

        LigneCommandeDTO ligneCommandeDTO = new LigneCommandeDTO();

        ligneCommandeDTO.setId( entity.getId() );
        ligneCommandeDTO.setCommande( entity.getCommande() );
        ligneCommandeDTO.setQte( entity.getQte() );
        ligneCommandeDTO.setPrixUnitaire( entity.getPrixUnitaire() );
        ligneCommandeDTO.setQteStock( entity.getQteStock() );
        ligneCommandeDTO.setCreatedAt( entity.getCreatedAt() );
        ligneCommandeDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        ligneCommandeDTO.setArticle( entity.getArticle() );

        return ligneCommandeDTO;
    }

    @Override
    public List<LigneCommande> asEntityList(List<LigneCommandeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LigneCommande> list = new ArrayList<LigneCommande>( dtoList.size() );
        for ( LigneCommandeDTO ligneCommandeDTO : dtoList ) {
            list.add( asEntity( ligneCommandeDTO ) );
        }

        return list;
    }

    @Override
    public List<LigneCommandeDTO> asDTOList(List<LigneCommande> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LigneCommandeDTO> list = new ArrayList<LigneCommandeDTO>( entityList.size() );
        for ( LigneCommande ligneCommande : entityList ) {
            list.add( asDTO( ligneCommande ) );
        }

        return list;
    }

    @Override
    public LigneCommande asEntity(LigneCommandeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LigneCommande ligneCommande = referenceMapper.resolve( dto, LigneCommande.class );

        ligneCommande.setId( dto.getId() );
        ligneCommande.setCommande( dto.getCommande() );
        ligneCommande.setQte( dto.getQte() );
        ligneCommande.setPrixUnitaire( dto.getPrixUnitaire() );
        ligneCommande.setCreatedAt( dto.getCreatedAt() );
        ligneCommande.setLastUpdatedAt( dto.getLastUpdatedAt() );
        ligneCommande.setQteStock( dto.getQteStock() );
        ligneCommande.setArticle( dto.getArticle() );

        return ligneCommande;
    }
}
