package com.brainstation23.erp.service;

import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.mapper.EmployeeMapper;
import com.brainstation23.erp.model.domain.Employee;
import com.brainstation23.erp.model.dto.CreateEmployeeRequest;
import com.brainstation23.erp.model.dto.UpdateEmployeeRequest;
import com.brainstation23.erp.persistence.entity.EmployeeEntity;
import com.brainstation23.erp.persistence.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {
    public static final String EMPLOYEE_NOT_FOUND = "Employee Not Found";
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public Page<Employee> getAll(Pageable pageable) {
        var entities = employeeRepository.findAll(pageable);
        return entities.map(employeeMapper::entityToDomain);
    }

    public Employee getOne(UUID id) {
        var entity = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
        return employeeMapper.entityToDomain(entity);
    }

    public UUID createOne(CreateEmployeeRequest createRequest) {
        var entity = new EmployeeEntity();
        entity.setFirstName(createRequest.getFirstName());
        entity.setLastName(createRequest.getLastName());
        var createdEntity = employeeRepository.save(entity);
        return createdEntity.getId();
    }

    public void updateOne(UUID id, UpdateEmployeeRequest updateRequest) {
        var entity = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
        entity.setFirstName(updateRequest.getFirstName());
        entity.setLastName(updateRequest.getLastName());
        employeeRepository.save(entity);
    }

    public void deleteOne(UUID id) {
        employeeRepository.deleteById(id);
    }
}
