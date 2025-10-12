package com.paledev.hobbsched.models;


import lombok.Getter;

@Getter
public enum ServiceType {
    ESTETICA("ESTETICA"),
    ALIMENTICIO("ALIMENTICIO"),
    LIMPEZA("LIMPEZA"),
    CONSULTA("CONSULTA"),;

    private final String description;

    ServiceType(String description) {
        this.description = description;
    }

}
