package com.arm.nimbus.collab.server.model;

import javax.validation.constraints.NotNull;

/**
 * TODO description
 *
 * @creator victor
 */
public class User extends PersistentEntity{

    @NotNull
    String username;

    @NotNull
    String role;

    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
