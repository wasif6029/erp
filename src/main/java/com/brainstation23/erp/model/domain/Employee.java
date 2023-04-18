package com.brainstation23.erp.model.domain;

import com.brainstation23.erp.persistence.entity.OrganizationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private double balance;
    private OrganizationEntity organization;
}
