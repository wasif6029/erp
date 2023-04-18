package com.brainstation23.erp.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class AdminResponse {
    @Schema(description = "Admin ID", example = "JDFJNB435FNF3WFEGFGG35")
    private UUID id;

    @Schema(description = "Admin First Name", example = "Wasif")
    private String firstName;

    @Schema(description = "Admin Last Name", example = "Islam")
    private String lastName;

    @Schema(description = "Admin User Name", example = "Wasif29")
    private String userName;

    @Schema(description = "Admin Password", example = "018wasif")
    private String password;
}
