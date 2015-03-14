package es.ecp.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.ecp.models.entities.Tema;
import es.ecp.models.entities.Voto;
import es.ecp.models.utils.NivelEstudios;

public class HelloJPA {
    public static void main(String[] args) {
    	
    	System.out.println("Se borran y se crean las tablas");
    	
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        EntityManager em = Persistence.createEntityManagerFactory("JEE_ECP", properties)
                .createEntityManager();
        
        
        System.out.println("[001]");
              
        Tema t1 = new Tema("Quimica", "Simbolo de la oro?");
        // Create
        em.getTransaction().begin();
        em.persist(t1);
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(Tema.class, 1));
        
        Voto v1 = new Voto("127.0.0.1", NivelEstudios.FP, 9, t1);
        // Create
        em.getTransaction().begin();
        em.persist(v1);
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(Voto.class, 1));
        
    }
}
