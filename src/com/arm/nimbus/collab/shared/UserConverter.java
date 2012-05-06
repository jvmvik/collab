package com.arm.nimbus.collab.shared;

import com.arm.nimbus.collab.client.domain.User;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

public class UserConverter {
	// Instantiate the factory
	DomainFactory factory = GWT.create(DomainFactory.class);
	
	User makeUser(){
		AutoBean<User> user = factory.user();
		return user.as();
	}
	
	String serializeToJson(User user){
		AutoBean<User> bean = AutoBeanUtils.getAutoBean(user);
		return AutoBeanCodex.encode(bean).getPayload();
	}
	
	User deserializeFromJson(String json){
		AutoBean<User> bean = AutoBeanCodex.decode(factory, User.class, json);
		return bean.as();
	}
		  
}
