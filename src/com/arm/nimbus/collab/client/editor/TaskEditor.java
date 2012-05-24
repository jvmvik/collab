package com.arm.nimbus.collab.client.editor;

import java.util.HashMap;
import java.util.Map;

import com.arm.nimbus.collab.client.model.TaskProxy;
import com.arm.nimbus.collab.client.requests.TaskRequest;
import com.arm.nimbus.collab.client.sdk.editor.AbstractNimbusEditor;
import com.github.gwtbootstrap.client.ui.base.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;

public class TaskEditor extends AbstractNimbusEditor<TaskProxy>  {

	@UiField
	TextBox title;
	
	@UiField
	TextBox content;
	
	@UiField
	TextBox status;
	
	private static TaskEditorUiBinder uiBinder = GWT
			.create(TaskEditorUiBinder.class);

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
		clearErrors();
	}
	
	@Override
	public void notifyEditMode(
			com.arm.nimbus.collab.client.sdk.editor.AbstractNimbusEditor.EditorMode editorMode) {
		title.setReadOnly(true);
		content.setReadOnly(true);
		status.setReadOnly(true);
	}
	
	@UiHandler("save")
	public void save(ClickEvent event){
		try {
			save();
		} catch (Exception e) {
			e.printStackTrace();
			Window.alert("Erro while saving : " + e.getMessage());
		}
	}
	
	@UiHandler("remove")
	public void remove(ClickEvent event){
		
	}

	@Override
	public Map<String, Widget> getPathToFieldMap() {
		if (pathToFieldMap == null) {
			pathToFieldMap = new HashMap<String, Widget>();
			pathToFieldMap.put("title", title);
			pathToFieldMap.put("content", title);
			pathToFieldMap.put("statu", title);
		}
		return pathToFieldMap;

	}


	@Override
	public InstanceRequest<TaskProxy, TaskProxy> getInstanceRequest()
			throws Exception {
		TaskRequest requestContext = (TaskRequest) editorDriver.flush();
		return requestContext.persist();
	}


	@Override
	public Place getSavePlace(TaskProxy t) throws Exception {
		TaskBoardPlace taskBoar = new TaskBoardPlace();
		taskBoar.setEntityId(t.getId());
		return taskBoar;
	}

}
