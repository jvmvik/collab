package com.arm.nimbus.collab.server.model;

import com.arm.nimbus.collab.client.model.ReviewProxy;

import javax.validation.constraints.NotNull;

/**
 * TODO description
 *
 * @creator victor
 */
public class Review extends PersistentEntity implements ReviewProxy {

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


    @Override
    public String getTaskID() {
        return taskID;
    }

    @Override
    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }
}
