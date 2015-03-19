package es.ecp.controllers;

public class ControllerFactory {

	private TemaController temaController;
	private AddTemaController addTemaController;

	public TemaController getTemaController() {
		if (temaController == null)
			temaController = new TemaController();
		return temaController;
	}

	public AddTemaController getAddTemaController() {
		if (addTemaController == null)
			addTemaController = new AddTemaController();
		return addTemaController;
	}

}
