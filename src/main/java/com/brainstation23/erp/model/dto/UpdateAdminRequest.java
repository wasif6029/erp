package com.brainstation23.erp.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UpdateAdminRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
