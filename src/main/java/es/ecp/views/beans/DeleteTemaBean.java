package es.ecp.views.beans;

import java.io.Serializable;

import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;

public class DeleteTemaBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tema tema;
	private int temaId;

	public void setTemaId(Integer id) {
		this.tema = DaoJpaFactory.getFactory().getTemaDao().read(id);
	}
	
	public int getTemaId() {
		return temaId;
	}
	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}
	
	public String process() {
		System.out.println("Delete");
		this.getControllerFactory().getDeleteTemaController().deleteById(tema.getId());
		return "temas";
	}

}
