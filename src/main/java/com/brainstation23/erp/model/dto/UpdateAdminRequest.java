package com.brainstation23.erp.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UpdateAdminRequest {
    @Schema(description = "Admin First Name", example = "Wasif")
    private String firstName;

    @Schema(description = "Admin Last Name", example = "Islam")
    private String lastName;

    @Schema(description = "Admin User Name", example = "Wasif29")
    private String userName;

    @Schema(description = "Admin Password", example = "018wasif")
    private String password;
}
