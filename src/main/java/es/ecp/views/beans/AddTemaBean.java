package es.ecp.views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import es.ecp.controllers.AddTemaController;
import es.ecp.models.entities.Tema;

@ManagedBean
public class AddTemaBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tema tema;
	private String name = "";
	private String question = "";
	
	public AddTemaBean() {
		super();
		this.tema = new Tema();
	}

	public AddTemaBean(String name, String question) {
		this.tema = new Tema(name, question);
		this.name = tema.getName();
		this.question = tema.getQuestion();
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
		this.name = tema.getName();
		this.question = tema.getQuestion();
	}
	public String getName() {
		return name;
	}
	public String getQuestion() {
		return question;
	}
	
	public void setName(String name) {
		this.tema.setName(name);
		this.name = name;
	}
	
	public void setQuestion(String ques) {
		this.tema.setQuestion(ques);
		this.question = ques;
	}

	public String process() {
		AddTemaController addTemaController = this.getControllerFactory().getAddTemaController();
		addTemaController.add(tema);
		return "temas";
	}

}
