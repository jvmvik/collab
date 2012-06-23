package com.arm.nimbus.collab.client;


import com.arm.nimbus.collab.client.dashboard.DashboardPlace;
import com.arm.nimbus.collab.client.dashboard.DashboardView;
import com.arm.nimbus.collab.client.editor.TaskBoardPlace;
import com.arm.nimbus.collab.client.editor.TaskBoardView;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.event.shared.EventBus;

/**
 * TODO description
 *

 *
 *
 * @creator victor
 */
@GinModules(CollabGinModule.class)
public interface CollabGinInjector extends Ginjector {

    EventBus getEventBus();

    PlaceController getPlaceController();

    ActivityMapper getActivityMapper();

    DashboardPlace getDashboardPlace();

    DashboardView getDashboardView();

    TaskBoardView getTaskBoardView();

    TaskBoardPlace getTaskBoardPlace();
}
