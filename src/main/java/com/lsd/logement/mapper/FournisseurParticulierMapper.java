package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.FournisseurParticulierDTO;
import com.lsd.logement.entity.Stock.FournisseurParticulier;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface FournisseurParticulierMapper extends GenericMapper<FournisseurParticulier, FournisseurParticulierDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    FournisseurParticulier asEntity(FournisseurParticulierDTO dto);
}
