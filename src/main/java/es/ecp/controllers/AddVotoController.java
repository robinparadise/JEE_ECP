package es.ecp.controllers;

import es.ecp.models.daos.VotoDao;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Voto;

public class AddVotoController {
	
	public void add(Voto voto) {
		VotoDao votoDao = DaoJpaFactory.getFactory().getVotoDao();
		votoDao.create(voto);
	}

}
