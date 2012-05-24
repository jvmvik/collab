package com.arm.nimbus.collab.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class TaskView extends Composite {

	private static TaskViewUiBinder uiBinder = GWT
			.create(TaskViewUiBinder.class);

	interface TaskViewUiBinder extends UiBinder<Widget, TaskView> {
	}

	public TaskView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public TaskView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
