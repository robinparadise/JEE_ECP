package es.ecp.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import es.ecp.models.daos.VotoDao;
import es.ecp.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	private EntityManager entityManager;

	public VotoDaoJpa() {
		super(Voto.class);
	}

	@Override
	public List<Voto> findByTemaId(Integer tema_id) {
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Voto> query = criteria.createQuery(Voto.class);
		Root<Voto> rootVoto = query.from(Voto.class);
		query.where(criteria.equal(
				rootVoto.get("tema").get("id").as(Integer.class), tema_id));
		TypedQuery<Voto> votacionQuery = entityManager.createQuery(query);
		return votacionQuery.getResultList();
	}

	@Override
	public List<Voto> findByNivelEstudios(Integer nivel) {
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Voto> query = criteria.createQuery(Voto.class);
		Root<Voto> rootVoto = query.from(Voto.class);
		query.where(criteria.equal(
				rootVoto.get("nivel_estudios").as(Integer.class), nivel));
		TypedQuery<Voto> votacionQuery = entityManager.createQuery(query);
		return votacionQuery.getResultList();
	}

}
