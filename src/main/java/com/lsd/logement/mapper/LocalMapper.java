package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.LocalDTO;
import com.lsd.logement.entity.infrastructure.Local;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface LocalMapper extends GenericMapper<Local, LocalDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Local asEntity(LocalDTO dto);
}
