package es.ecp.views.beans;

import es.ecp.controllers.AddTemaController;
import es.ecp.models.entities.Tema;

public class AddTemaView extends ViewBean {

	private Tema tema;

	public AddTemaView(String name, String question) {
		this.tema = new Tema(name, question);
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public void setName(String name) {
		this.tema.setName(name);
	}
	
	public void setQuestion(String ques) {
		this.tema.setQuestion(ques);
	}

	public void update() {
		AddTemaController addTemaController = this.getControllerFactory().getAddTemaController();
		addTemaController.add(tema);
	}

}
