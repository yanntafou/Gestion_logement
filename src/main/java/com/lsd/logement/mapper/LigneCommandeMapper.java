package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.LigneCommandeDTO;
import com.lsd.logement.entity.Stock.LigneCommande;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface LigneCommandeMapper extends GenericMapper<LigneCommande, LigneCommandeDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    LigneCommande asEntity(LigneCommandeDTO dto);
}
