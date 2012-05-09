package com.arm.nimbus.collab.client.dashboard;

import com.arm.nimbus.collab.client.place.ApplicationPlace;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * TODO description
 *
 * @creator victor
 */
public class DashboardPlace extends ApplicationPlace {

     public DashboardPlace(){

     }

    public static class Tokenizer implements PlaceTokenizer<DashboardPlace> {

        @Override
        public DashboardPlace getPlace(String token) {
            DashboardPlace dashboardPlace = new DashboardPlace();
            return dashboardPlace;
        }

        @Override
        public String getToken(DashboardPlace place) {
            return "place";
        }
    }
}
