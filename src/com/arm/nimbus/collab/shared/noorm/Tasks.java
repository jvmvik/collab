package com.arm.nimbus.collab.shared.noorm;


import com.arm.nimbus.collab.server.model.Task;
import com.arm.nimbus.collab.shared.noorm.Page;

public interface Tasks extends Page<Task> {

	Page<Task> getTask();
	
	void setTasks(Page<Task> task);
}
