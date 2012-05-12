package com.arm.nimbus.collab.client;

import com.arm.nimbus.collab.client.dashboard.DashboardPlace;
import com.arm.nimbus.collab.client.dashboard.DashboardView;
import com.arm.nimbus.collab.client.dashboard.DashboardViewImpl;
import com.arm.nimbus.collab.client.requests.InjectablePlaceController;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Singleton;

/**
 * TODO description
 *
 * About this work.
 *
 * A good example of event bus inside GWT.
 * http://stackoverflow.com/questions/6030202/how-to-use-the-gwt-eventbus
 *
 * @creator victor
 */
public class CollabGinModule extends AbstractGinModule {

    @Override
    protected void configure(){
        // inject eventBus
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

        // inject placement controller
        bind(PlaceController.class).to(InjectablePlaceController.class).in(Singleton.class);

        // inject activity mapper
        bind(ActivityMapper.class).to(CollabActivityMapper.class).in(Singleton.class);

        // dashboard
        bind(DashboardView.class).to(DashboardViewImpl.class).in(Singleton.class);

        bind(DashboardPlace.class);
    }

}
