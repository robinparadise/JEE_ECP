package es.ecp.views.beans;

import java.io.Serializable;

import es.ecp.controllers.TemaController;

public class TemaBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;

	TemaController temaController = this.getControllerFactory()
			.getTemaController();

	private TemaController temas;

	public void update() {
		this.temas = temaController.getTemas();
	}

}
