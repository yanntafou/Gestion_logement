package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.BookingDTO;
import com.lsd.logement.entity.reservation.Booking;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface BookingMapper extends GenericMapper<Booking, BookingDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Booking asEntity(BookingDTO dto);
}
