package com.arm.nimbus.collab.client.editor;

import com.arm.nimbus.collab.client.place.ApplicationPlace;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TaskBoardPlace extends ApplicationPlace {
	
	String productID;
	
	public TaskBoardPlace(){
	}
	
	public TaskBoardPlace(String productID) {
		this.productID = productID;
	}
	
	public String getProductID(){
		return productID;
	}
	
    public static class Tokenizer implements PlaceTokenizer<TaskBoardPlace> {

		@Override
		public TaskBoardPlace getPlace(String token) {
			return new TaskBoardPlace(token); // productID == token
		}

		@Override
		public String getToken(TaskBoardPlace place) {
			if(place == null){
				return "taskboard";
			}
			return place.getProductID();
		}
    }
}
