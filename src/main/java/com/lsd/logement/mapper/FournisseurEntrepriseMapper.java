package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.FournisseurEntrepriseDTO;
import com.lsd.logement.entity.Stock.FournisseurEntreprise;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface FournisseurEntrepriseMapper extends GenericMapper<FournisseurEntreprise, FournisseurEntrepriseDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    FournisseurEntreprise asEntity(FournisseurEntrepriseDTO dto);
}
