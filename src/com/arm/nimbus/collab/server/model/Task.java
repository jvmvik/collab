package com.arm.nimbus.collab.server.model;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Task extends PersistentEntity {

    @NotNull
    String productID;

    @NotNull
    String title;

    @NotNull
    String content;

    @NotNull
    String status;   // Free status

    @NotNull
    String userID;       // Owner of the task

    public Task(){
        super();
    }

	public Task(String title, String content, String status, User user) {
       super();
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
	public String getUserID() {
		return this.userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    /***
     * Find all task related to a user
     * @param user
     * @return
     */
    public static List<Task> findByUser(String userID){
        return null;
    }

}
