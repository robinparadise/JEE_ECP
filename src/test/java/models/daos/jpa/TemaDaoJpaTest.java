package models.daos.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.ecp.models.daos.DaoFactory;
import es.ecp.models.daos.TemaDao;
import es.ecp.models.daos.jpa.DaoJpaFactory;
import es.ecp.models.entities.Tema;

public class TemaDaoJpaTest {
	
	private Tema tema;
	private TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();;
	
	@BeforeClass
	public static void beforeClass(){
		DaoFactory.setFactory(new DaoJpaFactory());
	}

	@Before
	public void before(){
		this.tema = new Tema("name_test", "question_test");
		temaDao.create(this.tema);
	}

	@Test
	public void testCreate(){
		Tema tema = new Tema("name_t1", "q_t1");
		temaDao.create(tema);
		Tema tema1 = temaDao.read(tema.getId());
		assertEquals(tema.getId(), tema1.getId());
		temaDao.deleteById(tema.getId());
	}
	
	@Test
	public void testRead() {
		assertEquals(this.tema.getId(), temaDao.read(this.tema.getId()).getId());
	}
	
	@Test
	public void testUpdate(){
		this.tema.setName("name_updated");
		this.tema.setQuestion("question_updated");
		temaDao.update(this.tema);
		assertEquals(this.tema.getId(), temaDao.read(this.tema.getId()).getId());
		assertEquals(this.tema.getName(), temaDao.read(this.tema.getId()).getName());
		assertEquals(this.tema.getQuestion(), temaDao.read(this.tema.getId()).getQuestion());
	}
	
	@After
    public void after() {
        temaDao.deleteById(this.tema.getId());
    }

}
