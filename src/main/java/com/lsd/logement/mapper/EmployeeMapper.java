package com.lsd.logement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lsd.logement.dto.EmployeeDTO;
import com.lsd.logement.entity.personnel.Employee;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDTO> {

    @Override
    @Mapping(target = "id", ignore = false)
    Employee asEntity(EmployeeDTO dto);
}
