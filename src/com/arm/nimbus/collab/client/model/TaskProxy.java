package com.arm.nimbus.collab.client.model;

import com.arm.nimbus.collab.server.model.Task;
import com.arm.nimbus.collab.server.model.User;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(Task.class)
public interface TaskProxy {

	public String getTitle();
	public void setTitle(String title);
	
	public String getContent();
	public void setContent(String content);
	
	public String getStatus();
	public void setStatus(String status);
	
	public User getUser();
	public void setUser(User User);
}
