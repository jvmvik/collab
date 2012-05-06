package com.arm.nimbus.collab.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Collab implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		TasksSummaryView view = new TasksSummaryView();
		RootPanel.get().add(view);
	}
}
