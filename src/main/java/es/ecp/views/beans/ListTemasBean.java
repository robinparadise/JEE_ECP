package es.ecp.views.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import es.ecp.controllers.TemaController;
import es.ecp.models.entities.Tema;

@ManagedBean
public class ListTemasBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;

	TemaController temaController = this.getControllerFactory()
			.getTemaController();

	private List<Tema> temas;

	private String test = "test";

	public ListTemasBean() {
		super();
	}

	public List<Tema> getTemas() {
		return this.temas;
	}
	
	public String getTest() {
		return test ;
	}
	
	public void update() {
		this.temas = temaController.getTemas();
	}

}
