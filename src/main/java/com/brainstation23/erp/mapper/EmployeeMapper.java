package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.Employee;
import com.brainstation23.erp.model.dto.EmployeeResponse;
import com.brainstation23.erp.persistence.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee entityToDomain(EmployeeEntity entity);

    EmployeeResponse domainToResponse(Employee organization);
}
