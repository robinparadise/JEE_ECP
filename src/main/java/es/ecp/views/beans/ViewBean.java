package es.ecp.views.beans;

import es.ecp.controllers.ControllerFactory;

public abstract class ViewBean {

	private ControllerFactory controllerFactory;

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}

	protected ControllerFactory getControllerFactory() {
		if (controllerFactory == null)
			controllerFactory = new ControllerFactory();
		return controllerFactory;
	}

}
