package com.arm.nimbus.collab.client.model;

import com.arm.nimbus.collab.server.model.Product;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * TODO description
 *
 * @creator victor
 */
@ProxyFor(Product.class)
public interface ProductProxy extends AbstractEntityProxy {

    String getName();
    void setName(String name);

    String getCode();
    void setCode(String code);

}
