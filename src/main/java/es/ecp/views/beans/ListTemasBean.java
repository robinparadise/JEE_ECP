package es.ecp.views.beans;

import java.io.Serializable;
import java.util.List;

import es.ecp.controllers.TemaController;
import es.ecp.models.entities.Tema;

public class TemaBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;

	TemaController temaController = this.getControllerFactory()
			.getTemaController();
	
	public TemaBean() {
		super();
	}

	private List<Tema> temas;

	public void update() {
		this.temas = temaController.getTemas();
	}

}