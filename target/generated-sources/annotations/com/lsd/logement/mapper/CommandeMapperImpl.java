package com.lsd.logement.mapper;

import com.lsd.logement.dto.CommandeDTO;
import com.lsd.logement.entity.Stock.Commande;
import com.lsd.logement.entity.Stock.LigneCommande;
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
public class CommandeMapperImpl implements CommandeMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public CommandeDTO asDTO(Commande entity) {
        if ( entity == null ) {
            return null;
        }

        CommandeDTO commandeDTO = new CommandeDTO();

        commandeDTO.setId( entity.getId() );
        commandeDTO.setRefCmd( entity.getRefCmd() );
        commandeDTO.setDemandeur( entity.getDemandeur() );
        commandeDTO.setStatut( entity.getStatut() );
        commandeDTO.setCreatedAt( entity.getCreatedAt() );
        commandeDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        commandeDTO.setDateLivraison( entity.getDateLivraison() );
        commandeDTO.setFournisseurEntreprise( entity.getFournisseurEntreprise() );
        commandeDTO.setFournisseurParticulier( entity.getFournisseurParticulier() );
        commandeDTO.setPrixTotal( entity.getPrixTotal() );
        List<LigneCommande> list = entity.getLigneCommande();
        if ( list != null ) {
            commandeDTO.setLigneCommande( new ArrayList<LigneCommande>( list ) );
        }

        return commandeDTO;
    }

    @Override
    public List<Commande> asEntityList(List<CommandeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Commande> list = new ArrayList<Commande>( dtoList.size() );
        for ( CommandeDTO commandeDTO : dtoList ) {
            list.add( asEntity( commandeDTO ) );
        }

        return list;
    }

    @Override
    public List<CommandeDTO> asDTOList(List<Commande> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CommandeDTO> list = new ArrayList<CommandeDTO>( entityList.size() );
        for ( Commande commande : entityList ) {
            list.add( asDTO( commande ) );
        }

        return list;
    }

    @Override
    public Commande asEntity(CommandeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Commande commande = referenceMapper.resolve( dto, Commande.class );

        commande.setId( dto.getId() );
        commande.setRefCmd( dto.getRefCmd() );
        commande.setFournisseurEntreprise( dto.getFournisseurEntreprise() );
        commande.setFournisseurParticulier( dto.getFournisseurParticulier() );
        commande.setDemandeur( dto.getDemandeur() );
        commande.setStatut( dto.getStatut() );
        commande.setCreatedAt( dto.getCreatedAt() );
        commande.setLastUpdatedAt( dto.getLastUpdatedAt() );
        commande.setDateLivraison( dto.getDateLivraison() );
        List<LigneCommande> list = dto.getLigneCommande();
        if ( list != null ) {
            commande.setLigneCommande( new ArrayList<LigneCommande>( list ) );
        }
        commande.setPrixTotal( dto.getPrixTotal() );

        return commande;
    }
}
