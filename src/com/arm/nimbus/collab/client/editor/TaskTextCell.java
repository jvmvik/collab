package com.arm.nimbus.collab.client.editor;

import com.arm.nimbus.collab.client.model.TaskProxy;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class TaskTextCell extends AbstractCell<TaskProxy>{

	@Override
	public void render(Context context, TaskProxy value, SafeHtmlBuilder sb) {
		sb.appendEscaped(value.getId()  + " - " + value.getTitle());
	}

}
