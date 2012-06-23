package com.arm.nimbus.collab.client.editor.event;

import com.arm.nimbus.collab.client.model.TaskProxy;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created with IntelliJ IDEA.
 * User: victor
 * Date: 6/23/12
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskDeleteEvent extends GwtEvent<TaskDeleteEventHandler> {
    public static Type<TaskDeleteEventHandler> TYPE = new Type<TaskDeleteEventHandler>();

    public TaskProxy taskProxy;

    public TaskDeleteEvent(TaskProxy taskProxy) {
        this.taskProxy = taskProxy;
    }

    public Type<TaskDeleteEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(TaskDeleteEventHandler handler) {
        handler.onTaskDelete(this);
    }
}
