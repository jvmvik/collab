package com.arm.nimbus.collab.shared;

import java.util.List;

import com.arm.nimbus.collab.client.domain.Task;
import com.arm.nimbus.collab.client.domain.User;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

interface DomainFactory extends AutoBeanFactory{

	AutoBean<Task> task();
	AutoBean<User> user();
	
	AutoBean<List<Task>> tasks();
	AutoBean<List<User>> users();
	
}
