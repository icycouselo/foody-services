package com.icycouselo.apiwrapper.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@ToString
public class UserRole implements GrantedAuthority {
    private transient Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
