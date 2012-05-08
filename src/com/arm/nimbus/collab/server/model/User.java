package com.arm.nimbus.collab.server.model;

import com.google.code.morphia.annotations.Entity;

import javax.validation.constraints.NotNull;

/**
 * TODO description
 *
 * @creator victor
 */
@Entity
public class User extends PersistentEntity{

    //TODO Controller must check if the username is unique or not
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
