package com.arm.nimbus.collab.client;

import com.arm.nimbus.collab.client.dashboard.DashboardPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * TODO description
 *
 * @creator victor
 */
@WithTokenizers({DashboardPlace.Tokenizer.class})
public interface CollabHistoryMapper extends PlaceHistoryMapper{
}
