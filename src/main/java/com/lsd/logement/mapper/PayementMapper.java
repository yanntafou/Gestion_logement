package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.PayementDTO;
import com.lsd.logement.entity.finance.Payement;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface PayementMapper extends GenericMapper<Payement, PayementDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Payement asEntity(PayementDTO dto);
}
