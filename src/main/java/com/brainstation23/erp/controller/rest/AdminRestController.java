package com.brainstation23.erp.controller.rest;


import com.brainstation23.erp.mapper.AdminMapper;
import com.brainstation23.erp.model.dto.CreateAdminRequest;
import com.brainstation23.erp.model.dto.AdminResponse;
import com.brainstation23.erp.model.dto.UpdateAdminRequest;
import com.brainstation23.erp.service.AdminService;
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
@RequestMapping(value = "api/Admin")
public class AdminRestController {
    private final AdminService adminService;
    private final AdminMapper adminMapper;

    @GetMapping
    public ResponseEntity<Page<AdminResponse>> getAll(Pageable pageable) {
        log.info("Getting List of Admins");
        var domains = adminService.getAll(pageable);
        return ResponseEntity.ok(domains.map(adminMapper::domainToResponse));
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminResponse> getOne(@PathVariable UUID id) {
        log.info("Getting Details of Admin({})", id);
        var domain = adminService.getOne(id);
        return ResponseEntity.ok(adminMapper.domainToResponse(domain));
    }

    @PostMapping
    public ResponseEntity<Void> createOne(@RequestBody @Valid CreateAdminRequest createRequest) {
        log.info("Creating an Admin: {} ", createRequest);
        var id = adminService.createOne(createRequest);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateOne(@PathVariable UUID id,
                                          @RequestBody @Valid UpdateAdminRequest updateRequest) {
        log.info("Updating an Admin({}): {} ", id, updateRequest);
        adminService.updateOne(id, updateRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID id) {
        log.info("Deleting an Admin({}) ", id);
        adminService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
}
