package com.test.dbc.agibank.models;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountHolder {

    @NotNull
    @Id
    private String uuid = UUID.randomUUID().toString();

    private String name;

}
