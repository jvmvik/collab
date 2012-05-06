package com.arm.nimbus.collab.shared;


import com.arm.nimbus.collab.client.domain.Task;

public interface ITasks extends Page<Task> {

	Page<Task> getTask();
	
	void setTasks(Page<Task> task);
}
