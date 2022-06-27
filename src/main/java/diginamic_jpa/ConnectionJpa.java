package diginamic_jpa;

import java.util.List;

import diginamic_jpa.model.Genre;
import diginamic_jpa.model.Personne;
import diginamic_jpa.repository.PersonneRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionJpa {
	
	private static EntityManagerFactory sessionFactory;

	public static void main(String[] args) {
		
		sessionFactory = Persistence.createEntityManagerFactory("mariadb-pu");
		
		EntityManager entityManager = sessionFactory.createEntityManager();
		
		if(entityManager.isOpen())
			System.out.println("EntityManager ouvert");
		
		PersonneRepository.create("Boivin", "Edwige", Genre.FEMME);
		PersonneRepository.create("Barale", "Léonore", Genre.FEMME);
		PersonneRepository.create("Soucrant", "Benjamin", Genre.HOMME);
		
		PersonneRepository.findAll().forEach(p -> p.toString());
		
		Personne ed = new Personne("Boirin", "Edwige", Genre.FEMME);
		ed.setId(1L);
		PersonneRepository.update(ed);
		PersonneRepository.findById(1L).toString();
	
		PersonneRepository.delete(1L);
		PersonneRepository.findAll().forEach(p -> p.toString());
		
		
		entityManager.close();

	}

}
