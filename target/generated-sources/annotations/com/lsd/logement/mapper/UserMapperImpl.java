package com.lsd.logement.mapper;

import com.lsd.logement.dto.UserDTO;
import com.lsd.logement.entity.personnel.AppUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T13:58:05-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public UserDTO asDTO(AppUser entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setUsername( entity.getUsername() );
        userDTO.setPassword( entity.getPassword() );
        userDTO.setCreatedAt( entity.getCreatedAt() );
        userDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        userDTO.setConnectedAt( entity.getConnectedAt() );
        userDTO.setEnabled( entity.getEnabled() );
        userDTO.setFirstname( entity.getFirstname() );
        userDTO.setLastname( entity.getLastname() );
        userDTO.setPhone( entity.getPhone() );
        userDTO.setAddress( entity.getAddress() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setRoles( entity.getRoles() );

        return userDTO;
    }

    @Override
    public List<AppUser> asEntityList(List<UserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AppUser> list = new ArrayList<AppUser>( dtoList.size() );
        for ( UserDTO userDTO : dtoList ) {
            list.add( asEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> asDTOList(List<AppUser> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entityList.size() );
        for ( AppUser appUser : entityList ) {
            list.add( asDTO( appUser ) );
        }

        return list;
    }

    @Override
    public AppUser asEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AppUser appUser = referenceMapper.resolve( dto, AppUser.class );

        appUser.setId( dto.getId() );
        appUser.setFirstname( dto.getFirstname() );
        appUser.setLastname( dto.getLastname() );
        appUser.setPhone( dto.getPhone() );
        appUser.setAddress( dto.getAddress() );
        appUser.setEmail( dto.getEmail() );
        appUser.setUsername( dto.getUsername() );
        appUser.setPassword( dto.getPassword() );
        appUser.setRoles( dto.getRoles() );
        appUser.setEnabled( dto.getEnabled() );
        appUser.setCreatedAt( dto.getCreatedAt() );
        appUser.setLastUpdatedAt( dto.getLastUpdatedAt() );
        appUser.setConnectedAt( dto.getConnectedAt() );

        return appUser;
    }
}
