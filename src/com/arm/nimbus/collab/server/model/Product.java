package com.arm.nimbus.collab.server.model;

import com.arm.nimbus.collab.client.model.ProductProxy;
import com.google.code.morphia.annotations.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * TODO description
 *
 * @creator victor
 */
@Entity
public class Product extends PersistentEntity implements ProductProxy {

    // Product name
    @NotNull
    String name;

    // A product code (version, SAP ID)
    @Null
    String code;

    public Product() {
        super();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /***
     * Find a product
     * @param id
     * @return
     */
    public static Product findById(String id){
        //TODO Implement
        return new Product();
    }
}
