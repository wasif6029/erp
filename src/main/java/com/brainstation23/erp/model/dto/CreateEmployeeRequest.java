package com.brainstation23.erp.model.dto;

import com.brainstation23.erp.persistence.entity.OrganizationEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class CreateEmployeeRequest {

    @Schema(description = "Employee First Name", example = "Wasif")
    private String firstName;

    @Schema(description = "Employee Last Name", example = "Islam")
    private String lastName;

    @Schema(description = "Employee User Name", example = "Wasif29")
    private String userName;

    @Schema(description = "Employee Password", example = "018wasif")
    private String password;

    @Schema(description = "Employee Email", example = "wwasif29@gmail.com")
    private String email;

    @Schema(description = "Employee Account Balance", example = "17.50")
    private double balance;

    @Schema(description = "Organization ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00F")
    private UUID organizationId;
}
