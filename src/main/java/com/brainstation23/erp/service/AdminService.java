package com.brainstation23.erp.service;

import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.mapper.AdminMapper;
import com.brainstation23.erp.model.domain.Admin;
import com.brainstation23.erp.model.dto.CreateAdminRequest;
import com.brainstation23.erp.model.dto.UpdateAdminRequest;
import com.brainstation23.erp.persistence.entity.AdminEntity;
import com.brainstation23.erp.persistence.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {
    public static final String ADMIN_NOT_FOUND = "Admin Not Found";
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public Page<Admin> getAll(Pageable pageable) {
        var entities = adminRepository.findAll(pageable);
        return entities.map(adminMapper::entityToDomain);
    }

    public Admin getOne(UUID id) {
        var entity = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ADMIN_NOT_FOUND));
        return adminMapper.entityToDomain(entity);
    }

    public UUID createOne(CreateAdminRequest createRequest) {
        var entity = new AdminEntity();
        entity.setFirstName(createRequest.getFirstName());
        entity.setLastName(createRequest.getLastName());
        entity.setUserName(createRequest.getUserName());
        entity.setPassword(createRequest.getPassword());
        var createdEntity = adminRepository.save(entity);
        return createdEntity.getId();
    }

    public void updateOne(UUID id, UpdateAdminRequest updateRequest) {
        var entity = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ADMIN_NOT_FOUND));
        entity.setFirstName(updateRequest.getFirstName());
        entity.setLastName(updateRequest.getLastName());
        entity.setUserName(updateRequest.getUserName());
        entity.setPassword(updateRequest.getPassword());
        adminRepository.save(entity);
    }

    public void deleteOne(UUID id) {
        adminRepository.deleteById(id);
    }
}
