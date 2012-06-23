package com.arm.nimbus.collab.client.place;

import com.google.gwt.place.shared.Place;

/**
 * TODO description
 * Common parent class for place.
 *
 * @creator victor
 */
public class ApplicationPlace extends Place {

    private String entityId = "-1";

    public ApplicationPlace() {
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityId() {
        return entityId;
    }
}
