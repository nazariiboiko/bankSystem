package com.example.banksystem.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_WORKER,
    ROLE_HELPER,
    ROLE_DEVELOPER;

    @Override
    public String getAuthority() {
        return name();
    }
}
