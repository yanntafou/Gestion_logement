package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.CommandeDTO;
import com.lsd.logement.entity.Stock.Commande;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CommandeMapper extends GenericMapper<Commande, CommandeDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Commande asEntity(CommandeDTO dto);
}
