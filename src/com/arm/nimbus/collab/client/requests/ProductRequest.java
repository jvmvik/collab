package com.arm.nimbus.collab.client.requests;

import com.arm.nimbus.collab.client.model.ProductProxy;
import com.arm.nimbus.collab.server.model.Product;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import java.util.List;

/**
 * TODO description
 *
 * @creator victor
 */
@Service(Product.class)
public interface ProductRequest extends RequestContext {

    Request<List<ProductProxy>> findAllProducts();

    Request<ProductProxy> findById(String id);

    InstanceRequest<ProductProxy, ProductProxy> persist();

    InstanceRequest<ProductProxy, Void> remove();
}
