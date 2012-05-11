package com.arm.nimbus.collab.server.model;

import com.arm.nimbus.collab.client.model.ReviewProxy;
import com.arm.nimbus.collab.server.EntityManager;

import javax.validation.constraints.NotNull;

/**
 * TODO description
 *
 * @creator victor
 */
public class Review extends PersistentEntity {

    // Related to a task
    @NotNull
    String taskID;

    @NotNull
    String username;

    @NotNull
    String status;

    @NotNull
    String note;

    // TODO createdDate, updateDate

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public static Review findReview(String id) {
		return EntityManager.getInstance().getDs().find(Review.class, "id", id).get();
	}
}
