package com.arm.nimbus.collab.server.model;

import com.arm.nimbus.collab.client.model.ProductProxy;
import com.arm.nimbus.collab.server.EntityManager;
import com.google.code.morphia.annotations.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * TODO description
 *
 * @creator victor
 */
@Entity
public class Product extends PersistentEntity {

    // Product name
    @NotNull
    String name;

    // A product code (version, SAP ID)
    String code;
    
    @NotNull
    String owner; // project owner name

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

    public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	/***
     * Find a product
     * @param id
     * @return
     */
    public static Product findById(String id){
        return  EntityManager.getInstance().getDs().find(Product.class, "id", id).get();
    }

    public static List<Product> findAllProducts(){
        return EntityManager.getInstance().getDs().find(Product.class).asList();
    }

    public Product persist() {
        EntityManager.getInstance().persist(this);
        return this;
    }

    public void remove() {
        EntityManager.getInstance().getDs().delete(this);
    }
    
    /**
     * This field is mandatory !
     * http://stackoverflow.com/questions/6295567/gwt-app-cannot-find-matching-method-from-my-requestcontext-interface
     * @param id
     * @return
     */
    public static Product findProduct(String id) {
		return EntityManager.getInstance().getDs().find(Product.class, "id", id).get();
	}
}
