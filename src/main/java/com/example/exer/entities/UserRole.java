package com.example.exer.entities;

public enum UserRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String nomRole;

    UserRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public String getNomRole() {
        return nomRole;
    }
}
