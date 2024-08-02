package com.lsd.logement.mapper;

import com.lsd.logement.dto.EmployeeDTO;
import com.lsd.logement.entity.personnel.Employee;
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
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public EmployeeDTO asDTO(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( entity.getId() );
        employeeDTO.setNom( entity.getNom() );
        employeeDTO.setPrenom( entity.getPrenom() );
        employeeDTO.setTelephone( entity.getTelephone() );
        employeeDTO.setFonction( entity.getFonction() );
        employeeDTO.setNas( entity.getNas() );
        employeeDTO.setStMarital( entity.getStMarital() );
        employeeDTO.setPersContact( entity.getPersContact() );
        employeeDTO.setPersTelephone( entity.getPersTelephone() );
        employeeDTO.setCreatedAt( entity.getCreatedAt() );
        employeeDTO.setLastUpdatedAt( entity.getLastUpdatedAt() );
        employeeDTO.setSalaireHoraire( String.valueOf( entity.getSalaireHoraire() ) );
        employeeDTO.setAddress( entity.getAddress() );
        employeeDTO.setStartDate( entity.getStartDate() );

        return employeeDTO;
    }

    @Override
    public List<Employee> asEntityList(List<EmployeeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtoList.size() );
        for ( EmployeeDTO employeeDTO : dtoList ) {
            list.add( asEntity( employeeDTO ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> asDTOList(List<Employee> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( entityList.size() );
        for ( Employee employee : entityList ) {
            list.add( asDTO( employee ) );
        }

        return list;
    }

    @Override
    public Employee asEntity(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = referenceMapper.resolve( dto, Employee.class );

        employee.setId( dto.getId() );
        employee.setNom( dto.getNom() );
        employee.setPrenom( dto.getPrenom() );
        employee.setAddress( dto.getAddress() );
        employee.setNas( dto.getNas() );
        employee.setTelephone( dto.getTelephone() );
        employee.setFonction( dto.getFonction() );
        if ( dto.getSalaireHoraire() != null ) {
            employee.setSalaireHoraire( Integer.parseInt( dto.getSalaireHoraire() ) );
        }
        employee.setStMarital( dto.getStMarital() );
        employee.setPersContact( dto.getPersContact() );
        employee.setPersTelephone( dto.getPersTelephone() );
        employee.setStartDate( dto.getStartDate() );
        employee.setCreatedAt( dto.getCreatedAt() );
        employee.setLastUpdatedAt( dto.getLastUpdatedAt() );

        return employee;
    }
}
