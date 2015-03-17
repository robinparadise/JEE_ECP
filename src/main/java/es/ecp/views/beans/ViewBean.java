package es.ecp.views.beans;

import javax.faces.bean.ManagedProperty;

import es.ecp.controllers.ControllerFactory;

public abstract class ViewBean {

	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}

	protected ControllerFactory getControllerFactory() {
		return controllerFactory;
	}

}
