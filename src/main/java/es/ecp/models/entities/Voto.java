package es.ecp.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voto {

	@Id
	@GeneratedValue
	private Integer id;

	public Voto() {
	}

}
