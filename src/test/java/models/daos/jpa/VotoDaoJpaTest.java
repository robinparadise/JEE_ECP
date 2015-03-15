package models.daos.jpa;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.ecp.models.daos.DaoFactory;
import es.ecp.models.daos.TemaDao;
import es.ecp.models.daos.VotoDao;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;
import es.ecp.models.entities.Voto;
import es.ecp.models.utils.NivelEstudios;

public class VotoDaoJpaTest {

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
	}

	private Tema tema;
	private Voto voto;
	private VotoDao votoDao;
	private TemaDao temaDao;

	@Before
	public void before() {
		this.tema = new Tema("name_test", "question_test");
		this.voto = new Voto("127.0.0.1", NivelEstudios.FP, 9, tema);
		votoDao = DaoJpaFactory.getFactory().getVotoDao();
		temaDao = DaoJpaFactory.getFactory().getTemaDao();
		temaDao.create(this.tema);
		votoDao.create(this.voto);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
