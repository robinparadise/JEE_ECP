package es.ecp.controllers;

public class ControllerFactory {

	private TemaController temaController;
	private AddTemaController addTemaController;
	private AddVotoController addVotoController;

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

	public AddVotoController getAddVotoController() {
		if (addVotoController == null)
			addVotoController = new AddVotoController();
		return addVotoController;
	}

}
