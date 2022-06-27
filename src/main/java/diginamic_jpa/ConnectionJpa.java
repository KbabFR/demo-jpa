package diginamic_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionJpa {
	
	private static EntityManagerFactory sessionFactory;

	public static void main(String[] args) {
		
		sessionFactory = Persistence.createEntityManagerFactory("tp-jpa");
		
		EntityManager entityManager = sessionFactory.createEntityManager();
		
		System.out.println(entityManager.isOpen());
		
		entityManager.close();

	}

}
