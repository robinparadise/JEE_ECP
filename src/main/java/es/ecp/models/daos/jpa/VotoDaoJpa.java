package es.ecp.models.daos.jpa;

import es.ecp.models.daos.VotoDao;
import es.ecp.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(Voto.class);
	}

}
