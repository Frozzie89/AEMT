package test;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.groupeB4.entities.Pae;

@Stateless
public class PAEDAO {


	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	public Pae addPAE(Pae pae) {
		// TODO Auto-generated method stub
		em.persist(pae);
		return pae;
	}

	
	public List<Pae> getAllPaes() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT pae FROM Pae pae").getResultList();
	}

	
	public Pae deletePae(Pae pae) {
		// TODO Auto-generated method stub
		Pae tmp = findPae(pae);
		if(tmp == null) {
			return null;
		}
		em.remove(tmp);
		return tmp;
	}

	
	public Pae updatePae(Pae oldPae, Pae newPae) {
		// TODO Auto-generated method stub
		if(oldPae == null || newPae == null || oldPae.getId()<0) {
			return null;
		}
		Pae tmp = findPae(oldPae);
		if(tmp == null) {
			return null;
		}
		tmp = newPae;
		tmp.setId(oldPae.getId());
		em.merge(tmp);
		return tmp;
	}

	public Pae findPae(Pae pae) {
		Pae paeFound = em.find(Pae.class, pae.getId());
		if(paeFound == null) {
			return null;
		}
		return paeFound;
	}

	
}
