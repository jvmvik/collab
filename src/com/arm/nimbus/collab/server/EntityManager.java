package com.arm.nimbus.collab.server;

import com.arm.nimbus.collab.server.model.*;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * TODO description
 *
 * @creator victor
 */
public class EntityManager {

    Logger log = Logger.getLogger(EntityManager.class.getName());
    private static final EntityManager localInstance = new EntityManager();
    private Mongo mongo;
    private Datastore ds;
    private Morphia morphia;

    private EntityManager() {
        try {
            mongo = new Mongo();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MongoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            morphia = new Morphia();

            morphia.map(User.class);
            morphia.map(Product.class);
            morphia.map(Task.class);
            morphia.map(Review.class);

            ds = morphia.createDatastore(mongo, "collab_dev");
            ds.delete(ds.createQuery(User.class));
            ds.delete(ds.createQuery(Product.class));
            ds.delete(ds.createQuery(Task.class));
            ds.delete(ds.createQuery(Review.class));


        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("Datastore created");
        log.info("Datastore created");

        // Add mock data
        mockupData();
    }

    public static EntityManager getInstance() {
        return localInstance;
    }

    public void persist(PersistentEntity persistentEntity) {
        ds.save(persistentEntity);
    }

    public Datastore getDs() {
        return ds;
    }

    private void mockupData() {
        // Create a user
        User user = new User();
        user.setUsername("bart");
        user.setRole("worker");

        persist(user);

        log.info("User created");

        // Create a product
        Product p = new Product();
        p.setName("product1");
        p.setCode("nimbus");

        persist(p);

        log.info("Product created");

        // Associate one task to this product
        Task task = new Task();
        task.setUser(user);
        task.setProductID(p.getId());
        task.setTitle("Task 1");
        task.setContent("Explanation formatted as HTML <ul><li>Subtask 1</li><li>Subtask 2</li></ul>");
        task.setStatus("In progress");

        persist(task);

        log.info("Task created");

        Review review = new Review();
        review.setUsername(user.getUsername());
        review.setTaskID(task.getId());
        review.setStatus("in development");
        review.setNote("here it is a <b>quick example of note !</b>");

        persist(review);

        log.info("Review created");
    }
}
