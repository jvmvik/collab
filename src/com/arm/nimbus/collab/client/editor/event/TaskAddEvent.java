package com.arm.nimbus.collab.client.editor.event;

import com.arm.nimbus.collab.client.model.TaskProxy;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created with IntelliJ IDEA.
 * User: victor
 * Date: 6/23/12
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskAddEvent extends GwtEvent<TaskAddEventHandler> {
    public static Type<TaskAddEventHandler> TYPE = new Type<TaskAddEventHandler>();

    public TaskProxy taskProxy;

    public TaskAddEvent(TaskProxy taskProxy) {
        this.taskProxy = taskProxy;
    }

    public Type<TaskAddEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(TaskAddEventHandler handler) {
        handler.onTaskAdd(this);
    }
}
