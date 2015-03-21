package es.ecp.models.daos;

import java.util.List;

import es.ecp.models.entities.Voto;

public interface VotoDao extends GenericDao<Voto, Integer> {

	List<Voto> findByTemaId(Integer tema_id);

	List<Voto> findByNivelEstudios(Integer tema_id, Integer nivel);

}
