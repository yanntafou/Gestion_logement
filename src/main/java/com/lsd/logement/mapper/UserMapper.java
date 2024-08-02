package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.UserDTO;
import com.lsd.logement.entity.personnel.AppUser;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface UserMapper extends GenericMapper<AppUser, UserDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    AppUser asEntity(UserDTO dto);
}
