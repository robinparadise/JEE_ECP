package es.ecp.views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import es.ecp.controllers.AddVotoController;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;
import es.ecp.models.entities.Voto;
import es.ecp.models.utils.NivelEstudios;

@ManagedBean
public class AddVotoBean extends ViewBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private AddVotoController addVotoController = this.getControllerFactory().getAddVotoController();

	private Integer id;
	private String user_ip;
	private NivelEstudios nivel_estudios;
	private Integer valoracion;
	private Tema tema;
	private Voto voto;
	private int temaId;

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
		if(this.user_ip == null){
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			this.user_ip = req.getHeader("X-FORWARDED-FOR");
			if( this.user_ip == null ) {
			    this.user_ip = req.getRemoteAddr();
			}
		}
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
		if (this.tema == null) {
			this.tema = DaoJpaFactory.getFactory().getTemaDao().read(this.temaId);
		}
		this.voto = new Voto(getUserIp(), nivel_estudios, valoracion, tema);
	}

	public String process() {
		if (this.voto == null) {
			this.update();
		}
		this.addVotoController.add(voto);
		return "temas";
	}

	public int getTemaId() {
		return temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}
}
