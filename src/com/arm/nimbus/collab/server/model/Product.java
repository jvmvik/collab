package com.arm.nimbus.collab.server.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * TODO description
 *
 * @creator victor
 */
public class Product extends PersistentEntity {

    // Product name
    @NotNull
    String name;

    // A product code (version, SAP ID)
    @Null
    String code;

    public Product() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

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
