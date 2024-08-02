package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.BailDTO;
import com.lsd.logement.entity.reservation.Bail;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface BailMapper extends GenericMapper<Bail, BailDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Bail asEntity(BailDTO dto);
}
