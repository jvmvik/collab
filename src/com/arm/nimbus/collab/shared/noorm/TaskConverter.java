package com.arm.nimbus.collab.shared.noorm;

import java.util.List;

import com.arm.nimbus.collab.server.model.Task;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

public class TaskConverter {
	// Instantiate the factory
	DomainFactory factory = GWT.create(DomainFactory.class);
	  /*
	Task makeTask(){
		//AutoBean<Task> task = factory.task();
		return task.as();
	}
	
	String serializeToJson(Task task){
		AutoBean<Task> bean = AutoBeanUtils.getAutoBean(task);
		return AutoBeanCodex.encode(bean).getPayload();
	}
	
	Task deserializeFromJson(String json){
		AutoBean<Task> bean = AutoBeanCodex.decode(factory, Task.class, json);
		return bean.as();
	}
		  
	List<Task> makeTasks(){
		//AutoBean<List<Task>> tasks = factory.tasks();
		return tasks.as();
	}
	
	String serializeToJsons(Page<Task> tasks){
		AutoBean<Page<Task>> bean = AutoBeanUtils.getAutoBean(tasks);
		return AutoBeanCodex.encode(bean).getPayload();
	}
	
	// Solution ; http://stackoverflow.com/questions/5307265/a-parameterized-autobean-type-containing-a-typed-member
	
	Page<Task> deserializeFromJsons(String json){
		return AutoBeanCodex.decode(factory, Tasks.class, json).as();
	}    */
}
