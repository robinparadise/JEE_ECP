package es.ecp.views.beans;

import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;
import es.ecp.models.utils.NivelEstudios;

public class AddVotoBean {

	private Integer id;
	private String user_ip;
	private NivelEstudios nivel_estudios;
	private Integer valoracion;
	private Tema tema;
	
	
	private static String[] names() {
	    NivelEstudios[] nivelEstudios = NivelEstudios.values();
	    String[] names = new String[nivelEstudios.length];

	    for (int i = 0; i < nivelEstudios.length; i++) {
	        names[i] = nivelEstudios[i].name();
	    }

	    return names;
	}
	public String[] niveles_estudios = names();
	public String[] getNivelesEstudios() {
		System.out.println(">>");
		System.out.println(this.niveles_estudios[0]);
		return this.niveles_estudios;
	}
	public int getNivelesEstudiosSize() {
		return NivelEstudios.values().length;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserIp() {
		return this.user_ip;
	}

	public void setUserIp(String ip) {
		this.user_ip = ip;
	}

	public NivelEstudios getNivelEstudios() {
		return this.nivel_estudios;
	}

	public void setNivelEstudios(NivelEstudios n) {
		this.nivel_estudios = n;
	}

	public Integer getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(Integer val) {
		this.valoracion = val;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void setTemaId(Integer id) {
		this.tema = DaoJpaFactory.getFactory().getTemaDao().read(id);
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void process() {
	}

}
