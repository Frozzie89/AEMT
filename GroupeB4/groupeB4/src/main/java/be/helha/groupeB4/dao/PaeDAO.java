package be.helha.groupeB4.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.groupeB4.entities.Pae;

@Stateless
public class PaeDAO{

	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	// add a PAE into the db
	public Pae addPAE(Pae pae) {
		em.persist(pae);
		return pae;
	}

	// returns à PAE
	public List<Pae> getAllPaes() {
		return em.createQuery("SELECT pae FROM Pae pae").getResultList();
	}

	// delete a Pae in db
	public Pae deletePae(Pae pae) {
		
		// First finds the Pae
		Pae tmp = findPae(pae);
		
		// If the Pae is not found, returns null
		if(tmp == null) {
			return null;
		}
		
		// Else if it has been found, remove the Pae from db
		em.remove(tmp);
		return tmp;
	}

	
	// Replace an old Pae with a new Pae
	public Pae updatePae(Pae oldPae, Pae newPae) {
		
		// First check if data is correct
		if(oldPae == null || newPae == null || oldPae.getId()<0) {
			return null;
		}
		
		// Then find the Pae to replace
		Pae tmp = findPae(oldPae);
		
		// If it wasn't found, return null
		if(tmp == null) {
			return null;
		}
		
		// Else, replace the old Pae by the new Pae in db
		tmp = newPae;
		tmp.setId(oldPae.getId());
		em.merge(tmp);
		return tmp;
	}
	
	// returns a Pae from Db
	public Pae findPae(Pae pae) {
		// If Pae not found, returns null, else returns the actual Pae
		Pae paeFound = em.find(Pae.class, pae.getId());
		if(paeFound == null) {
			return null;
		}
		return paeFound;
	}

	
}
