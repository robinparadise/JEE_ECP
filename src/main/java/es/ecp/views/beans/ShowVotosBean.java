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

	private int calcMedia(List<Voto> votos) {
		int media = 0;
		for (Voto voto : votos) {
			media = media + voto.getValoracion();
		}
		media = media / votos.size();
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
			mediaByLevels.put(key, media / size);
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
	
	public void update() {
		votos = votoDao.findByTemaId(tema.getId());
		this.media = calcMedia(votos);
		Map<NivelEstudios, List<Voto>> votosByHash = VotosByHash(votos);
		this.mediaByNivelEstudios = calcMediaByNivelEstudios(votosByHash);
	}

	public void process() {
	}

}
