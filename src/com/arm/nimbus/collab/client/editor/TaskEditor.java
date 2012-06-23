package com.arm.nimbus.collab.client.editor;

import java.util.HashMap;
import java.util.Map;

import com.arm.nimbus.collab.client.editor.event.TaskAddEvent;
import com.arm.nimbus.collab.client.editor.event.TaskDeleteEvent;
import com.arm.nimbus.collab.client.model.TaskProxy;
import com.arm.nimbus.collab.client.requests.TaskRequest;
import com.arm.nimbus.collab.client.sdk.editor.AbstractNimbusEditor;
import com.github.gwtbootstrap.client.ui.base.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;

public class TaskEditor extends AbstractNimbusEditor<TaskProxy>  {

    //private EventBus eventBus;

	@UiField
	TextBox title;
	
	@UiField
	TextBox content;
	
	@UiField
	TextBox status;

    @Inject
    EventBus eventBus;
	
	private static TaskEditorUiBinder uiBinder = GWT
			.create(TaskEditorUiBinder.class);

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    interface TaskEditorUiBinder extends UiBinder<Widget, TaskEditor> {
	}
	
	interface EditorDriver extends RequestFactoryEditorDriver<TaskProxy, TaskEditor> {
	}

	private final EditorDriver editorDriver = GWT.create(EditorDriver.class);

	@SuppressWarnings("unchecked")
	public TaskEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		setEditorDriver((RequestFactoryEditorDriver)editorDriver);
	}


	public TaskEditor(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void notifyErrorsCleared() {
	}
	
	@Override
	public void notifyEditMode(
			com.arm.nimbus.collab.client.sdk.editor.AbstractNimbusEditor.EditorMode editorMode) {
        if(editorMode.equals(EditorMode.VIEW)){
            title.setReadOnly(true);
            content.setReadOnly(true);
            status.setReadOnly(true);
        }
	}
	
	@UiHandler("save")
	public void save(ClickEvent event){
			eventBus.fireEvent(new TaskAddEvent(cachedObject));
	}
	
	@UiHandler("remove")
	public void remove(ClickEvent event){
        eventBus.fireEvent(new TaskDeleteEvent(cachedObject));
	}

	@Override
	public Map<String, Widget> getPathToFieldMap() {

		if (pathToFieldMap == null) {
			pathToFieldMap = new HashMap<String, Widget>();
			pathToFieldMap.put("title", title);
			pathToFieldMap.put("content", content);
			pathToFieldMap.put("status", status);
		}
		return pathToFieldMap;

	}


	@Override
	public InstanceRequest<TaskProxy, TaskProxy> getInstanceRequest() throws Exception {
		TaskRequest requestContext = (TaskRequest) editorDriver.flush();
		return requestContext.persist();
	}


	@Override
	public Place getSavePlace(TaskProxy taskProxy) throws Exception {
		TaskBoardPlace taskBoar = new TaskBoardPlace();
		taskBoar.setEntityId(taskProxy.getId());
		return taskBoar;
	}

}
