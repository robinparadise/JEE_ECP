package es.ecp.views.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ecp.models.daos.VotoDao;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;
import es.ecp.models.entities.Voto;
import es.ecp.models.utils.NivelEstudios;

public class ShowVotosBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tema tema;
	private List<Voto> votos;
	private VotoDao votoDao = DaoJpaFactory.getFactory().getVotoDao();
	private int media = 0;
	private Map<NivelEstudios, Integer> mediaByNivelEstudios;

	public void setTemaId(Integer temaid) {
		this.tema = DaoJpaFactory.getFactory().getTemaDao().read(temaid);
	}

	public int getMedia() {
		return this.media;
	}
	
	public void update() {
	}

	public void process() {
	}

}
