package es.ecp.models.daos.jpa;

import es.ecp.models.daos.TemaDao;
import es.ecp.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema,Integer>implements TemaDao {
	public TemaDaoJpa() {
        super(Tema.class);
    }
}


