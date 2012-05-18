package com.arm.nimbus.collab.client.dashboard;

import com.arm.nimbus.collab.client.editor.TaskEditor;
import com.arm.nimbus.collab.client.model.ProductProxy;
import com.arm.nimbus.collab.client.sdk.editor.AbstractNimbusEditor.EditorMode;
import com.github.gwtbootstrap.client.ui.FluidContainer;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
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

    @UiField
    TaskEditor taskEditor;
    
    @Override
    public HasData<ProductProxy> getProducts() {
        return productList ;
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    interface DashboardViewImplUiBinder extends UiBinder<FluidContainer, DashboardViewImpl>{
    }

    private static DashboardViewImplUiBinder ourUiBinder = GWT.create(DashboardViewImplUiBinder.class);

    public DashboardViewImpl() {
        FluidContainer panel = ourUiBinder.createAndBindUi(this);
        initWidget(panel);
        
        // Event
        Label label = new Label("No product available");
        productList.setEmptyListWidget(label);
        
        final SingleSelectionModel<ProductProxy> selectionModel = new SingleSelectionModel<ProductProxy>();
		productList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ProductProxy product = selectionModel.getSelectedObject();
				if(product == null){
					taskEditor.setVisible(false);
				}else{
					taskEditor.setEditMode(EditorMode.EDIT);
				}
			}
		});
        
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
            
            String s = "<div class=\"alert alert-block alert-info\">" +
            		"<a class=\"close\" data-dismiss=\"alert\">×</a>" +
            		"<h4 class=\"alert-heading\">" + value.getName() + "<small></small></h4>"+
            		"<p>Owner: " + value.getOwner() + "<br/>" +
            		"Code: " + value.getCode() + "</p></div>";
            
            sb.appendHtmlConstant(s);
            
        }
    }
}