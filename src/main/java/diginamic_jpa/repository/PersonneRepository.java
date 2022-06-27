package diginamic_jpa.repository;

import java.util.List;

import diginamic_jpa.model.Genre;
import diginamic_jpa.model.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class PersonneRepository {

	public static Personne findById(Long id) {
		
		return PersistenceHelper.getEntityManager().find(Personne.class, id);
	}
	
	public static List<Personne> findAll(){
		
		// On va chercher l'EM
        EntityManager em = PersistenceHelper.getEntityManager();
        
        // On commence une Query JPQL
        TypedQuery<Personne> tq = em.createQuery(
                // La requ�te JPQL
                "SELECT p FROM Personne p",
                // Le type de retour du resultat - en gros le FROM de la req
                Personne.class);
        
        // Execute la requ�te et retourne LISTE de resultats
        return tq.getResultList();
        
	}
	
	public static void create(String nom, String prenom, Genre genre) {
		Personne personneToCreate = new Personne(nom, prenom, genre);
		
		EntityManager em = PersistenceHelper.getEntityManager();
        PersistenceHelper.beginTx(em);
        em.persist(personneToCreate);
        PersistenceHelper.commitTxAndClose(em);
	}
	
	public static Personne update(Personne personneUpdated) {
		
		// utiliser merge
        // on peut aussi v�rifier que la personne a bien une ID
        // et refuser la mise � jour si elle n'en a pas (optionnel)
        if (personneUpdated == null || personneUpdated.getId() == null) {
            throw new RuntimeException();
        }

        EntityManager em = PersistenceHelper.getEntityManager();
        PersistenceHelper.beginTx(em);
        Personne personneMerged = em.merge(personneUpdated);
        PersistenceHelper.commitTxAndClose(em);
        return personneMerged;
	}
	
	public static void delete(Long id) {
		
		EntityManager em = PersistenceHelper.getEntityManager();
        PersistenceHelper.beginTx(em);

        // 1ere �tape est de "find" la personne
        Personne personneToDelete = em.find(Personne.class, id);
        //  et de v�rifier si elle existe
        if (personneToDelete != null) {
            // 2nd �tape = delete
            em.remove(personneToDelete);
        }
        PersistenceHelper.commitTxAndClose(em);
	}
	
}
