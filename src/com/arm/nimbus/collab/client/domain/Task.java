package com.arm.nimbus.collab.client.domain;

import com.arm.nimbus.collab.shared.ITask;

public class Task implements ITask {
	
	public Task(String string, User user) {
		this.title = string;
		this.author = user;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}

	String title;
	String content;
	String status;
	User author;
	
	//Date
	//Watcher : user list
	

}
