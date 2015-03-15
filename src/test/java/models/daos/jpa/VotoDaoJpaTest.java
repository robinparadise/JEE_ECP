package models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
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
	public void testCreate() {
		Tema tema1 = new Tema("test2", "test2");
		temaDao.create(tema1);
		Voto voto1 = new Voto("127.0.0.1", NivelEstudios.FP, 9, tema1);
		votoDao.create(voto1);
		Voto voto2 = votoDao.read(voto1.getId());
		assertEquals(voto1, voto2);
		votoDao.deleteById(voto1.getId());
		temaDao.deleteById(tema1.getId());
	}

	@Test
	public void testRead() {
		assertEquals(this.voto, votoDao.read(this.voto.getId()));
	}

	@Test
	public void testUpdate() {
		this.voto.setNivelEstudios(NivelEstudios.MASTER);
		this.voto.setValoracion(8);
		votoDao.update(this.voto);
		assertEquals(this.voto, votoDao.read(this.voto.getId()));
	}

	@After
	public void after() {
		votoDao.deleteById(this.voto.getId());
		temaDao.deleteById(this.voto.getTema().getId());
	}

}
