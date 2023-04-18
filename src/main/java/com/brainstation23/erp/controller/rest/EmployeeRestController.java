package com.brainstation23.erp.controller.rest;


import com.brainstation23.erp.mapper.EmployeeMapper;
import com.brainstation23.erp.model.dto.CreateEmployeeRequest;
import com.brainstation23.erp.model.dto.EmployeeResponse;
import com.brainstation23.erp.model.dto.UpdateEmployeeRequest;
import com.brainstation23.erp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/Employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<Page<EmployeeResponse>> getAll(Pageable pageable) {
        log.info("Getting List of Employees");
        var domains = employeeService.getAll(pageable);
        return ResponseEntity.ok(domains.map(employeeMapper::domainToResponse));
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getOne(@PathVariable UUID id) {
        log.info("Getting Details of Employee({})", id);
        var domain = employeeService.getOne(id);
        return ResponseEntity.ok(employeeMapper.domainToResponse(domain));
    }

    @PostMapping
    public ResponseEntity<Void> createOne(@RequestBody @Valid CreateEmployeeRequest createRequest) {
        log.info("Creating an Employee: {} ", createRequest);
        var id = employeeService.createOne(createRequest);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateOne(@PathVariable UUID id,
                                          @RequestBody @Valid UpdateEmployeeRequest updateRequest) {
        log.info("Updating an Employee({}): {} ", id, updateRequest);
        employeeService.updateOne(id, updateRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID id) {
        log.info("Deleting an Employee({}) ", id);
        employeeService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
}
