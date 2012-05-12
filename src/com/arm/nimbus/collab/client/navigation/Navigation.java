package com.arm.nimbus.collab.client.navigation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
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

    interface NavigationUiBinder extends UiBinder<HTMLPanel, Navigation> {
    }

    private static NavigationUiBinder ourUiBinder = GWT.create(NavigationUiBinder.class);

    public Navigation() {
        HTMLPanel navbar = ourUiBinder.createAndBindUi(this);
        initWidget(navbar);
    }
}