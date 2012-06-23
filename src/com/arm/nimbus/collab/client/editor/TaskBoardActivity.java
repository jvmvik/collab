package com.arm.nimbus.collab.client.editor;

import java.util.List;

import com.arm.nimbus.collab.client.CollabAbstractActivity;
import com.arm.nimbus.collab.client.model.ProductProxy;
import com.arm.nimbus.collab.client.model.TaskProxy;
import com.arm.nimbus.collab.client.place.ApplicationPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class TaskBoardActivity extends CollabAbstractActivity {

	TaskBoardView view;
	String productID ;
	
	public TaskBoardActivity(PlaceController placeController, TaskBoardPlace place, TaskBoardView taskboardview) {
		super(placeController, place);
		this.view = taskboardview;
		this.productID = place.getProductID();
	}

	@Override
	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		panel.setWidget(view.asWidget());
		
		/*
		 * Preload task
		 */
		 final AsyncDataProvider<TaskProxy> dataProvider = new AsyncDataProvider<TaskProxy>() {

	            @Override
	            protected void onRangeChanged(HasData<TaskProxy> display) {
	             getRequestFactory(eventBus).taskRequest().findAll()
	                        .fire(new Receiver<List<TaskProxy>>() {
	                            @Override
	                            public void onSuccess(List<TaskProxy> response) {
                                    // Note; Response must be not null
	                                view.list().setRowData(0, response);
	                            }
	                        });
            }
        };
        Range range = view.list().getVisibleRange();
        view.list().setVisibleRangeAndClearData(range, true);
        dataProvider.addDataDisplay(view.list());
	}

}
