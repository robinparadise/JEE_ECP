package es.ecp.controllers;

public class ControllerFactory {

	private TemaController temaController;

	public TemaController getTemaController() {
		if (temaController == null)
			temaController = new TemaController();
		return temaController;
	}

}
