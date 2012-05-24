package com.arm.nimbus.collab.client.editor;


import com.arm.nimbus.collab.client.model.TaskProxy;
import com.arm.nimbus.collab.client.requests.ApplicationRequestFactory;
import com.arm.nimbus.collab.client.sdk.editor.AbstractNimbusEditor.EditorMode;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;

public class TaskBoard extends Composite {

	private static TaskBoardUiBinder uiBinder = GWT
			.create(TaskBoardUiBinder.class);

	interface TaskBoardUiBinder extends UiBinder<Widget, TaskBoard> {
	}

	@Inject
	EventBus eventBus;
	
	@Inject
	PlaceController placeController;
	
	ApplicationRequestFactory rf;
	
	public TaskBoard() {
		initWidget(uiBinder.createAndBindUi(this));
		
		final SingleSelectionModel<TaskProxy> selectionModel = new SingleSelectionModel<TaskProxy>();
		selectionModel.addSelectionChangeHandler(new Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				TaskProxy entityProxy = (TaskProxy)selectionModel.getSelectedObject();
                GWT.log("Select : " + entityProxy.getTitle());
                editor.setInput(entityProxy, getRequestFactory(eventBus).taskRequest(), EditorMode.EDIT, placeController);
			}
		});
		list.setSelectionModel(selectionModel);
	}

	@UiField
	CellList<TaskProxy> list;
	
	@UiFactory CellList<TaskProxy> make(){
		// Cell formatter
		TaskTextCell ttc = new TaskTextCell();
		// Construct
		return new CellList<TaskProxy>(ttc);
	}
	
	
	@UiField
	TaskEditor editor;

	private ApplicationRequestFactory getRequestFactory(EventBus eventBus) {
		  if(rf == null){
	             rf = GWT.create(ApplicationRequestFactory.class);
	             rf.initialize(eventBus);
	         }
	        return rf;
	}

}
