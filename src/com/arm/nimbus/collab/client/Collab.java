package com.arm.nimbus.collab.client;

import com.arm.nimbus.collab.client.navigation.Navigation;
import com.github.gwtbootstrap.client.ui.FluidContainer;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.github.gwtbootstrap.client.ui.Container;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Collab implements EntryPoint {

    private final CollabGinInjector injector = GWT.create(CollabGinInjector.class);
    private SimplePanel container = new SimplePanel();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
        // Map action <> view
        ActivityMapper activityMapper = injector.getActivityMapper();

        // Init activity manager (gwt class)
        ActivityManager activityManager = new ActivityManager(activityMapper, injector.getEventBus());
        activityManager.setDisplay(container);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        CollabHistoryMapper historyMapper = GWT.create(CollabHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);

        // Display an empty menu
        RootPanel.get().add(ui());

        historyHandler.register(injector.getPlaceController(), injector.getEventBus(), injector.getDashboardPlace());
        historyHandler.handleCurrentHistory();;
	}

    private Container ui(){
        Container ui = new Container();
        ui.add(new Navigation());
        ui.add(container);
        return ui;
    }
}
