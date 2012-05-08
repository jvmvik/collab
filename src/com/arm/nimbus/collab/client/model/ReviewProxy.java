package com.arm.nimbus.collab.client.model;

import com.arm.nimbus.collab.server.model.Review;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * TODO description
 *
 * @creator victor
 */
@ProxyFor(Review.class)
public interface ReviewProxy {

    String getTaskID();

    void setTaskID(String taskID);

    String getUsername();

    void setUsername(String username);

    String getStatus();

    void setStatus(String status);

    String getNote();

    void setNote(String note);
}
