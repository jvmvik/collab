package com.arm.nimbus.collab.client.editor;

import com.arm.nimbus.collab.client.model.TaskProxy;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.HasData;

/**
 * @author victor benarbia
 */
public interface TaskBoardView extends IsWidget {

    HasData<TaskProxy> list();

}
