package com.arm.nimbus.collab.client;

import com.arm.nimbus.collab.client.place.ApplicationPlace;
import com.arm.nimbus.collab.client.requests.ApplicationRequestFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import com.google.gwt.event.shared.EventBus;

/**
 * TODO description
 *
 * @creator victor
 */
public abstract class CollabAbstractActivity extends AbstractActivity {

    private ApplicationRequestFactory rf;
    protected PlaceController placeController;
    protected ApplicationPlace place;

    public CollabAbstractActivity(PlaceController placeController, ApplicationPlace place) {
        this.placeController = placeController;
        this.place = place;
    }

    public abstract void start(AcceptsOneWidget panel, EventBus eventBus);

    public ApplicationRequestFactory getRequestFactory(EventBus eventBus) {
        if (rf == null) {
            rf = GWT.create(ApplicationRequestFactory.class);
            rf.initialize(eventBus);
        }
        return rf;
    }

    public void setRf(ApplicationRequestFactory rf) {
        this.rf = rf;
    }

    /**
     * Navigate to a new Place in the browser
     */
    public void goTo(Place place) {
        placeController.goTo(place);
    }

    /**
     * Ask user before stopping this activity
     */
    @Override
    public String mayStop() {
        return null;
    }

    protected String getModuleUrl() {
        String moduleUrl = Window.Location.getHref();

        if (moduleUrl.indexOf("#") != -1) {
            moduleUrl = moduleUrl.substring(0, Window.Location.getHref().indexOf("#"));
        }

        return moduleUrl;
    }
}
