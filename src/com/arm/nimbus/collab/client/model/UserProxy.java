package com.arm.nimbus.collab.client.model;

import com.arm.nimbus.collab.server.model.User;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * TODO description
 *
 * @creator victor
 */
@ProxyFor(User.class)
public interface UserProxy extends AbstractEntityProxy {

    public String getUsername();
    public void setUsername(String username);

    public String getRole();
    public void setRole(String role);

}
