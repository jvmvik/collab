package com.arm.nimbus.collab.client.dashboard;

import com.arm.nimbus.collab.client.ApplicationAbstractActivity;
import com.arm.nimbus.collab.client.model.ProductProxy;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;

import java.util.List;

/**
 * TODO description
 *
 * @creator victor
 */
public class DashboardActivity extends ApplicationAbstractActivity {

    private DashboardView dashboardView;

    public DashboardActivity(DashboardPlace place, DashboardView dashboardView,
                             PlaceController placeController) {
        super(placeController, place);
        this.dashboardView = dashboardView;

    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {
        panel.setWidget(dashboardView.asWidget());

        final AsyncDataProvider<ProductProxy> dataProvider = new AsyncDataProvider<ProductProxy>() {

            @Override
            protected void onRangeChanged(HasData<ProductProxy> display) {
                getRequestFactory(eventBus).productRequest().findAllProducts()
                        .fire(new Receiver<List<ProductProxy>>() {
                            @Override
                            public void onSuccess(List<ProductProxy> response) {
                                dashboardView.getProducts().setRowData(0, response);
                            }
                        });
            }
        };
        Range range = dashboardView.getProducts().getVisibleRange();
        dashboardView.getProducts().setVisibleRangeAndClearData(range, true);
        dataProvider.addDataDisplay(dashboardView.getProducts());
    }
}
