package es.ecp.controllers;

import java.util.List;

import es.ecp.models.daos.TemaDao;
import es.ecp.models.daos.VotoDao;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Voto;

public class DeleteTemaController {

	VotoDao votoDao = DaoJpaFactory.getFactory().getVotoDao();
	TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();

	public void deleteById(Integer temaid) {
		List<Voto> votos = votoDao.findByTemaId(temaid);
		
		for (Voto voto : votos) {
			votoDao.deleteById(voto.getId());
		}
		temaDao.deleteById(temaid);
	}
}
