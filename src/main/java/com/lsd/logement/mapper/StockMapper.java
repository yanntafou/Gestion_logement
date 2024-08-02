package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.StockDTO;
import com.lsd.logement.entity.Stock.Stock;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface StockMapper extends GenericMapper<Stock, StockDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Stock asEntity(StockDTO dto);
}
