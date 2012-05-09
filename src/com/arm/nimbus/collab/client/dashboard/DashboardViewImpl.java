package com.arm.nimbus.collab.client.dashboard;

import com.arm.nimbus.collab.client.model.ProductProxy;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;

/**
 * TODO description
 *
 * @creator victor
 */
public class DashboardViewImpl extends Composite implements DashboardView {

    @Inject
    EventBus eventBus;

    @Inject
    PlaceController placeController;

    @Override
    public HasData<ProductProxy> getProducts() {
        return productList ;
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    interface DashboardViewImplUiBinder extends UiBinder<HTMLPanel, DashboardViewImpl>{
    }

    private static DashboardViewImplUiBinder ourUiBinder = GWT.create(DashboardViewImplUiBinder.class);

    public DashboardViewImpl() {
        HTMLPanel panel = ourUiBinder.createAndBindUi(this);
        initWidget(panel);
    }

    @UiField
    CellList<ProductProxy> productList;

    @UiFactory CellList<ProductProxy> add(){
        return new CellList<ProductProxy>(new ProductCell());
    }

    /**
     * The Cell used to render a {@link com.sun.corba.se.pept.transport.ContactInfo}.
     */
    static class ProductCell extends AbstractCell<ProductProxy> {

        /**
         * The html of the image used for contacts.
         */

        public ProductCell() {

        }

        @Override
        public void render(Context context, ProductProxy value, SafeHtmlBuilder sb) {
            // Value can be null, so do a null check..
            if (value == null) {
                return;
            }

            sb.appendHtmlConstant("<div>");
            sb.appendEscaped(value.getName());
            sb.appendHtmlConstant("</div>");
        }
    }
}