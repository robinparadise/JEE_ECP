package es.ecp.models.daos.jdbc;

import java.util.List;

import es.ecp.models.daos.TemaDao;
import es.ecp.models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements
		TemaDao {

	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255) NOT NULL, "
			+ "%s VARCHAR(255) NOT NULL, PRIMARY KEY (%s))";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.NAME,
				Tema.QUESTION, Tema.ID);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Tema entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tema read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub

	}

}
