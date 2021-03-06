package es.ecp.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.ecp.models.daos.VotoDao;
import es.ecp.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	private EntityManager entityManager = DaoJpaFactory
			.getEntityManagerFactory().createEntityManager();

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
	public List<Voto> findByNivelEstudios(Integer tema_id, Integer nivel) {
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Voto> query = criteria.createQuery(Voto.class);
		Root<Voto> rootVoto = query.from(Voto.class);
		Predicate p1 = criteria.equal(rootVoto.get("tema").get("id").as(Integer.class), tema_id);
		Predicate p2 = criteria.equal(rootVoto.get("nivel_estudios").as(Integer.class), nivel);
		query.where(criteria.and(p1, p2));
		TypedQuery<Voto> votacionQuery = entityManager.createQuery(query);
		return votacionQuery.getResultList();
	}

}
