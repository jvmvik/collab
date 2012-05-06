package com.arm.nimbus.collab.shared;

import com.arm.nimbus.collab.client.domain.User;

public interface ITask {

	public String getTitle();
	public void setTitle(String title);
	
	public String getContent();
	public void setContent(String content);
	
	public String getStatus();
	public void setStatus(String status);
	
	public User getAuthor();
	public void setAuthor(User author);
}
