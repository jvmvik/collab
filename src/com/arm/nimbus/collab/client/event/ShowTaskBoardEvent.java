package com.arm.nimbus.collab.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowTaskBoardEvent extends GwtEvent<ShowTaskBoardEventHandler> {
	public static Type<ShowTaskBoardEventHandler> TYPE = new Type<ShowTaskBoardEventHandler>();

	String productID;
	
	public ShowTaskBoardEvent() {
		this.productID = null;
	}
	
	public ShowTaskBoardEvent(String productID){
		this.productID = productID;
	}
	
	public String getProductID(){
		return this.productID;
	}
	
	@Override
	protected void dispatch(ShowTaskBoardEventHandler handler) {
		handler.onShowTaskBoard(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ShowTaskBoardEventHandler> getAssociatedType() {
		return TYPE;
	}

}