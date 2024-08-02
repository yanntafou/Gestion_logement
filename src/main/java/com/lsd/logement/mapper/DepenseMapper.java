package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.DepenseDTO;
import com.lsd.logement.entity.finance.Depense;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DepenseMapper extends GenericMapper<Depense, DepenseDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Depense asEntity(DepenseDTO dto);
}
