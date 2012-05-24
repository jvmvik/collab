package com.arm.nimbus.collab.client.requests;

import com.arm.nimbus.collab.client.model.TaskProxy;
import com.arm.nimbus.collab.server.EntityManager;
import com.arm.nimbus.collab.server.model.Task;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import java.util.List;

/**
 * TODO description
 *
 * @creator victor
 */
@Service(Task.class)
public interface TaskRequest extends RequestContext {

    Request<List<TaskProxy>> findByUser(String userID);
    
    Request<List<TaskProxy>> findByProduct(String productID);
    
    Request<List<TaskProxy>> findByUserAndProduct(String userID, String productID);

    Request<TaskProxy> findTask(String id);
    
    Request<List<TaskProxy>> findAll();

	InstanceRequest<TaskProxy, TaskProxy> persist();

    InstanceRequest<TaskProxy, Void> remove();
}
