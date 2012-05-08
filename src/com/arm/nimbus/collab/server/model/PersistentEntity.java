package com.arm.nimbus.collab.server.model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Version;
import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;


/**
 * Domain common fields.
 *
 * @creator victor
 */
@Entity
public class PersistentEntity {

    /**
     * Generate a unique ID
     * Best description of the API
     */
    @Id
    private String id;

    /***
     * Set a version of the model model.
     * Simplify future migration.
     */
    @Version
    private Long version;

    public PersistentEntity() {
        id = new ObjectId().toString();
    }

    public String getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
