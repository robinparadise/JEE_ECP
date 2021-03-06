package es.ecp.controllers;

import java.util.List;

import es.ecp.models.daos.TemaDao;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;

public class TemaController {

	private TemaDao temaDao;

	TemaController() {
		this.temaDao = DaoJpaFactory.getFactory().getTemaDao();
	}

	public List<Tema> getTemas() {
		return temaDao.findAll();
	}

}
