package es.ecp.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import es.ecp.models.utils.NivelEstudios;

@Entity
public class Voto {

	public static final String TABLE = "voto";
	public static final String ID = "id";
	public static final String IP = "user_ip";
	public static final String NIVEL_ESTUDIO = "nivel_estudio";
	public static final String TEMA = "tema_id";
	public static final String VALORACION = "valoracion";

	@Id
	@GeneratedValue
	@Column(name = ID)
	private Integer id;

	@Column(name = IP, nullable = false)
	private String user_ip;

	@Enumerated(EnumType.STRING)
	private NivelEstudios nivel_estudios;

	@Column(name = VALORACION, nullable = false)
	private Integer valoracion;

	@ManyToOne
	@JoinColumn(name = TEMA, nullable = false)
	@CascadeOnDelete
	private Tema tema;

	public Voto() {
	}

	public Voto(String ip, NivelEstudios nivelEstudios, Integer valoracion,
			Tema tema) {
		this.user_ip = ip;
		this.nivel_estudios = nivelEstudios;
		this.valoracion = valoracion;
		this.tema = tema;
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

	@Override
	public String toString() {
		return "Voto[" + id + ":" + valoracion + "]";
	}
}
