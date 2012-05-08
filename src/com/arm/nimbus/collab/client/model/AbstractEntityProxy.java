package com.arm.nimbus.collab.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;

public interface AbstractEntityProxy extends EntityProxy {

	public Long getVersion();

	public String getId();

}
