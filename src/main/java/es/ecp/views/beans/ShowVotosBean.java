package es.ecp.views.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import es.ecp.models.daos.VotoDao;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;
import es.ecp.models.entities.Voto;
import es.ecp.models.utils.NivelEstudios;

@ManagedBean
public class ShowVotosBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tema tema = null;
	private List<Voto> votos;
	private VotoDao votoDao = DaoJpaFactory.getFactory().getVotoDao();
	private int media = 0;
	private Map<NivelEstudios, Integer> mediaByNivelEstudios;
	private int numVotos;
	private int temaId;

	public void setTemaId(int temaid) {
		this.tema = DaoJpaFactory.getFactory().getTemaDao().read(temaid);
		this.temaId = temaid;
	}

	private int calcMedia(List<Voto> votos) {
		int media = 0;
		int size = votos.size();
		for (Voto voto : votos) {
			media = media + voto.getValoracion();
		}
		if (size > 0) media = media / votos.size();
		return media;
	}

	private Map<NivelEstudios, Integer> calcMediaByNivelEstudios(
			Map<NivelEstudios, List<Voto>> votosLevels) {

		Map<NivelEstudios, Integer> mediaByLevels = new HashMap<NivelEstudios, Integer>();
		int size;
		int media;
		for (List<Voto> votosLevel : votosLevels.values()) {
			size = votosLevel.size();
			media = 0;
			NivelEstudios key = null;
			for (Voto voto : votosLevel) {
				if (key == null) {
					key = voto.getNivelEstudios();
				}
				media = media + voto.getValoracion();
			}
			if (size > 0) mediaByLevels.put(key, media / size);
		}

		return mediaByLevels;
	}

	private Map<NivelEstudios, List<Voto>> VotosByHash(List<Voto> votos) {
		Map<NivelEstudios, List<Voto>> levels = new HashMap<NivelEstudios, List<Voto>>();
		for (NivelEstudios level : NivelEstudios.values()) {
			levels.put(level, new ArrayList<Voto>());
		}
		for (Voto voto : votos) {
			levels.get(voto.getNivelEstudios()).add(voto);
		}
		return levels;
	}

	public int getMedia() {
		return this.media;
	}
	public Map<NivelEstudios, Integer> getMediaByNivelEstudios() {
		return this.mediaByNivelEstudios;
	}
	public int getMediaByNivelEstudios(NivelEstudios nivel) {
		return this.mediaByNivelEstudios.get(nivel);
	}
	public int getMediaByNivelEstudios(Integer nivel) {
		return this.mediaByNivelEstudios.get((int) nivel);
	}
	public Tema getTema() {
		return this.tema;
	}
	public int getNumVotos() {
		return this.numVotos;
	}
	public int getTemaId() {
		return this.temaId;
	}
	
	public void update() {
		if (this.tema == null) {
			this.tema = DaoJpaFactory.getFactory().getTemaDao().read(this.temaId);
		}
		System.out.println("ZZZ");
		System.out.println(this.tema.toString());
		votos = votoDao.findByTemaId(this.temaId);
		this.numVotos = votos.size();
		this.media = calcMedia(votos);
		Map<NivelEstudios, List<Voto>> votosByHash = VotosByHash(votos);
		this.mediaByNivelEstudios = calcMediaByNivelEstudios(votosByHash);
	}

	public void process() {
	}

}
