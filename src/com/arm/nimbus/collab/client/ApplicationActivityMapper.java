package com.arm.nimbus.collab.client;


import com.arm.nimbus.collab.client.dashboard.DashboardActivity;
import com.arm.nimbus.collab.client.dashboard.DashboardPlace;
import com.arm.nimbus.collab.client.dashboard.DashboardView;
import com.arm.nimbus.collab.client.requests.ApplicationRequestFactory;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

/**
 * TODO description
 *
 * @creator victor
 */
public class ApplicationActivityMapper implements ActivityMapper {

    @Inject
    private PlaceController placeController;

    @Inject
    private EventBus eventBus;

    @Inject
    private DashboardView dashboardView;

    private ApplicationRequestFactory rf;

    boolean init = false; // Initialization

    @Override
    public Activity getActivity(Place place) {
        if(!init){
            init();
            init = true;
        }

        if(place instanceof DashboardPlace){
           return new DashboardActivity((DashboardPlace)place, dashboardView, placeController);
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    void init(){
        // TODO Initialize the event bus

    }

    ApplicationRequestFactory getRF(EventBus eventBus){
         if(rf == null){
             rf = GWT.create(ApplicationRequestFactory.class);
             rf.initialize(eventBus);
         }
        return rf;
    }
}
