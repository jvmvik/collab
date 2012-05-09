package com.arm.nimbus.collab.client.dashboard;

import com.arm.nimbus.collab.client.model.ProductProxy;
import com.arm.nimbus.collab.server.model.Product;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.HasData;

/**
 * TODO description
 *
 * @creator victor
 */
public interface DashboardView extends IsWidget {

    HasData<ProductProxy> getProducts();

}
