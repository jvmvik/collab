package com.arm.nimbus.collab.client.navigation;

import com.arm.nimbus.collab.client.dashboard.DashboardPlace;
import com.arm.nimbus.collab.client.editor.TaskBoardPlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

/**
 * TODO description
 *
 * @creator victor
 */
public class Navigation extends Composite {

    @Inject
    EventBus eventBus;

    @Inject
    PlaceController placeController;

    interface NavigationUiBinder extends UiBinder<HTMLPanel, Navigation> {
    }

    private static NavigationUiBinder ourUiBinder = GWT.create(NavigationUiBinder.class);

    public Navigation() {
        HTMLPanel navbar = ourUiBinder.createAndBindUi(this);
        initWidget(navbar);
    }

    @UiHandler("product")
    public void product(ClickEvent event){
        GWT.log("Select product");
          placeController.goTo(new DashboardPlace());
    }

    @UiHandler("tasks")
    public void tasks(ClickEvent event){
        placeController.goTo(new TaskBoardPlace());
    }
}