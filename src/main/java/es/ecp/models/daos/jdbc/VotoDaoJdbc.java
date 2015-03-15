package es.ecp.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.ecp.models.daos.DaoFactory;
import es.ecp.models.daos.VotoDao;
import es.ecp.models.entities.Voto;
import es.ecp.models.utils.NivelEstudios;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements
		VotoDao {

	private static final String INSERT_QUERY = "INSERT INTO %s (%d,%s,%s) VALUES ('%s','%s','%s')";
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s INT, %s VARCHAR(255), %s VARCHAR(255), PRIMARY KEY (%s))";
	
	private Logger log = LogManager.getLogger(VotoDaoJdbc.class);

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, Voto.IP,
				Voto.NIVEL_ESTUDIO, Voto.VALORACION, Voto.ID);
	}
	
	private Voto create(ResultSet resultSet) {
		Voto result = null;
		try {
			if (resultSet != null && resultSet.next()) {
				int temaId = resultSet.getInt(Voto.TEMA);
				result = new Voto(resultSet.getString(Voto.IP),
						NivelEstudios.valueOf(resultSet
								.getString(Voto.NIVEL_ESTUDIO)),
						resultSet.getInt(Voto.VALORACION), DaoFactory
								.getFactory().getTemaDao().read(temaId));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return result;
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
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID,
				Voto.TABLE, id));
		return this.create(resultSet);
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
