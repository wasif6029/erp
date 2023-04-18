package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.Admin;
import com.brainstation23.erp.model.dto.AdminResponse;
import com.brainstation23.erp.persistence.entity.AdminEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin entityToDomain(AdminEntity entity);

    AdminResponse domainToResponse(Admin admin);
}
