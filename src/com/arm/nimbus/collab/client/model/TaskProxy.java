package com.arm.nimbus.collab.client.model;

import com.arm.nimbus.collab.server.model.Task;
import com.arm.nimbus.collab.server.model.User;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(Task.class)
public interface TaskProxy extends AbstractEntityProxy {

	public String getTitle();
	public void setTitle(String title);
	
	public String getContent();
	public void setContent(String content);
	
	public String getStatus();
	public void setStatus(String status);
	
	public UserProxy getUser();
	public void setUser(UserProxy User);

    public String getProductID();
    public void setProductID(String productID);
}
