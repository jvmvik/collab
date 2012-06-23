package com.arm.nimbus.collab.client;


import com.arm.nimbus.collab.client.dashboard.DashboardActivity;
import com.arm.nimbus.collab.client.dashboard.DashboardPlace;
import com.arm.nimbus.collab.client.dashboard.DashboardView;
import com.arm.nimbus.collab.client.editor.TaskBoard;
import com.arm.nimbus.collab.client.editor.TaskBoardActivity;
import com.arm.nimbus.collab.client.editor.TaskBoardPlace;
import com.arm.nimbus.collab.client.editor.TaskBoardView;
import com.arm.nimbus.collab.client.editor.event.TaskAddEvent;
import com.arm.nimbus.collab.client.editor.event.TaskAddEventHandler;
import com.arm.nimbus.collab.client.editor.event.TaskDeleteEvent;
import com.arm.nimbus.collab.client.editor.event.TaskDeleteEventHandler;
import com.arm.nimbus.collab.client.model.TaskProxy;
import com.arm.nimbus.collab.client.requests.ApplicationRequestFactory;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;

/**
 * TODO description
 *
 * @creator victor
 */
public class CollabActivityMapper implements ActivityMapper {

    @Inject
    private PlaceController placeController;

    @Inject
    private EventBus eventBus;

    @Inject
    private DashboardView dashboardView;

    @Inject
    private TaskBoardView taskBoardView;

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
        }else if(place instanceof TaskBoardPlace){
           return new TaskBoardActivity(placeController, (TaskBoardPlace)place, taskBoardView);
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    void init(){
        // Delete task
        eventBus.addHandler(TaskDeleteEvent.TYPE, new TaskDeleteEventHandler() {
            @Override
            public void onTaskDelete(TaskDeleteEvent event) {
                getRF(eventBus).taskRequest().remove().using(event.taskProxy).fire(new Receiver<Void>() {
                    @Override
                    public void onSuccess(Void response) {
                        placeController.goTo(new TaskBoardPlace());
                    }
                });
            }
        });

        // Add task
        eventBus.addHandler(TaskAddEvent.TYPE, new TaskAddEventHandler() {
            @Override
            public void onTaskAdd(TaskAddEvent event) {
                getRF(eventBus).taskRequest().persist().using(event.taskProxy).fire(new Receiver<TaskProxy>() {
                    @Override
                    public void onSuccess(TaskProxy response) {
                        placeController.goTo(new TaskBoardPlace());
                    }
                });
            }
        });
    }

    ApplicationRequestFactory getRF(EventBus eventBus){
         if(rf == null){
             rf = GWT.create(ApplicationRequestFactory.class);
             rf.initialize(eventBus);
         }
        return rf;
    }
}
