package es.ecp.models.daos.jdbc;

import java.util.List;

import es.ecp.models.daos.VotoDao;
import es.ecp.models.entities.Voto;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements
		VotoDao {

	private static final String INSERT_QUERY = "INSERT INTO %s (%d,%s,%s) VALUES ('%s','%s','%s')";
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s INT, %s VARCHAR(255), %s VARCHAR(255), PRIMARY KEY (%s))";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, Voto.IP,
				Voto.NIVEL_ESTUDIO, Voto.VALORACION, Voto.ID);
	}

	@Override
	public void create(Voto voto) {
		this.updateSql(String.format(INSERT_QUERY, Voto.TABLE, Voto.IP,
				Voto.VALORACION, Voto.NIVEL_ESTUDIO, voto.getUserIp(),
				voto.getValoracion(), voto.getNivelEstudios()));

		voto.setId(this.autoId());
	}

	@Override
	public Voto read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Voto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto> findByTemaId(Integer tema_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto> findByNivelEstudios(Integer nivel) {
		// TODO Auto-generated method stub
		return null;
	}

}
