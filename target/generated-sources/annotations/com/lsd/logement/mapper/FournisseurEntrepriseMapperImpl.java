package com.lsd.logement.mapper;

import com.lsd.logement.dto.FournisseurEntrepriseDTO;
import com.lsd.logement.entity.Stock.FournisseurEntreprise;
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
public class FournisseurEntrepriseMapperImpl implements FournisseurEntrepriseMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public FournisseurEntrepriseDTO asDTO(FournisseurEntreprise entity) {
        if ( entity == null ) {
            return null;
        }

        FournisseurEntrepriseDTO fournisseurEntrepriseDTO = new FournisseurEntrepriseDTO();

        fournisseurEntrepriseDTO.setId( entity.getId() );
        fournisseurEntrepriseDTO.setLogo( entity.getLogo() );
        fournisseurEntrepriseDTO.setRaisonSociale( entity.getRaisonSociale() );
        fournisseurEntrepriseDTO.setNiu( entity.getNiu() );
        fournisseurEntrepriseDTO.setRccm( entity.getRccm() );
        fournisseurEntrepriseDTO.setPoste( entity.getPoste() );
        fournisseurEntrepriseDTO.setTelephone( entity.getTelephone() );
        fournisseurEntrepriseDTO.setCaCumule( entity.getCaCumule() );
        fournisseurEntrepriseDTO.setEcheance( entity.getEcheance() );
        fournisseurEntrepriseDTO.setMail1( entity.getMail1() );
        fournisseurEntrepriseDTO.setMail2( entity.getMail2() );
        fournisseurEntrepriseDTO.setCreatedAt( entity.getCreatedAt() );
        fournisseurEntrepriseDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );

        return fournisseurEntrepriseDTO;
    }

    @Override
    public List<FournisseurEntreprise> asEntityList(List<FournisseurEntrepriseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FournisseurEntreprise> list = new ArrayList<FournisseurEntreprise>( dtoList.size() );
        for ( FournisseurEntrepriseDTO fournisseurEntrepriseDTO : dtoList ) {
            list.add( asEntity( fournisseurEntrepriseDTO ) );
        }

        return list;
    }

    @Override
    public List<FournisseurEntrepriseDTO> asDTOList(List<FournisseurEntreprise> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FournisseurEntrepriseDTO> list = new ArrayList<FournisseurEntrepriseDTO>( entityList.size() );
        for ( FournisseurEntreprise fournisseurEntreprise : entityList ) {
            list.add( asDTO( fournisseurEntreprise ) );
        }

        return list;
    }

    @Override
    public FournisseurEntreprise asEntity(FournisseurEntrepriseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FournisseurEntreprise fournisseurEntreprise = referenceMapper.resolve( dto, FournisseurEntreprise.class );

        fournisseurEntreprise.setId( dto.getId() );
        fournisseurEntreprise.setLogo( dto.getLogo() );
        fournisseurEntreprise.setRaisonSociale( dto.getRaisonSociale() );
        fournisseurEntreprise.setNiu( dto.getNiu() );
        fournisseurEntreprise.setRccm( dto.getRccm() );
        fournisseurEntreprise.setPoste( dto.getPoste() );
        fournisseurEntreprise.setTelephone( dto.getTelephone() );
        fournisseurEntreprise.setCaCumule( dto.getCaCumule() );
        fournisseurEntreprise.setEcheance( dto.getEcheance() );
        fournisseurEntreprise.setMail1( dto.getMail1() );
        fournisseurEntreprise.setMail2( dto.getMail2() );
        fournisseurEntreprise.setCreatedAt( dto.getCreatedAt() );
        fournisseurEntreprise.setLastUpdatedAt( dto.getLastUpdatedAt() );

        return fournisseurEntreprise;
    }
}
