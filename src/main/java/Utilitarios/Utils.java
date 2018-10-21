package Utilitarios;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils implements Serializable{
	
	public EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("uds");
		}
		
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

}
