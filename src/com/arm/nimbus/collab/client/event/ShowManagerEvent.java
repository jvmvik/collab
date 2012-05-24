package com.arm.nimbus.collab.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowManagerEvent extends GwtEvent<ShowManagerEventHandler> {
	public static Type<ShowManagerEventHandler> TYPE = new Type<ShowManagerEventHandler>();

	@Override
	protected void dispatch(ShowManagerEventHandler handler) {
		handler.showProduct(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ShowManagerEventHandler> getAssociatedType() {
		return TYPE;
	}

}