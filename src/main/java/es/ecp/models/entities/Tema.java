package es.ecp.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {
	
	public static final String TABLE = "tema";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String QUESTION = "question";
	
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String question;

	public Tema(String name) {
		this.name = name;
	}

    public Tema(){	
    }
    
    public Tema(String name, String question){
    	this.name = name;
    	this.question = question;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Tema [id=" + id + ", name=" + name + ":" + question + "]";
	}

}
