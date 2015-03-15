package es.ecp.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.ecp.models.daos.TemaDao;
import es.ecp.models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements
		TemaDao {

	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255) NOT NULL, "
			+ "%s VARCHAR(255) NOT NULL, PRIMARY KEY (%s))";
	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s) VALUES ('%s','%s')";
	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";
	
	private Logger log = LogManager.getLogger(TemaDaoJdbc.class);

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.NAME,
				Tema.QUESTION, Tema.ID);
	}
	
	private Tema create(ResultSet resultSet) {
		try {
			if (resultSet != null && resultSet.next()) {
				return new Tema(resultSet.getString(Tema.NAME),
						resultSet.getString(Tema.QUESTION));
			}
		} catch (SQLException e) {
			log.error("read: " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public void create(Tema tema) {
		this.updateSql(String.format(SQL_INSERT, Tema.TABLE, Tema.NAME,
				Tema.QUESTION, tema.getName(), tema.getQuestion()));
		tema.setId(this.autoId());
	}
	
	@Override
	public Tema read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID,
				Tema.TABLE, id));
		return this.create(resultSet);
	}
	
	@Override
	public void update(Tema tema) {
		this.updateSql(String.format(SQL_UPDATE, Tema.TABLE, Tema.NAME,
				tema.getName(), Tema.QUESTION, tema.getQuestion(), tema.getId()));
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

}
