package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.PaeDAO;
import be.helha.groupeB4.entities.Pae;

@Stateless
public class PaeEJB {

	@EJB
	private PaeDAO dao;
	
	// Calls Dao Method to add a Pae
	public Pae addPae(Pae pae) {
		return dao.addPAE(pae);
	}

	// Calls Dao Method to get all Pae
	public List<Pae> getAllPaes() {
		return dao.getAllPaes();
	}
	
	// Calls Dao Method to get a Pae
	public Pae getPAE(Pae pae) {
		return dao.findPae(pae);
	}

	// Calls Dao Method to delete a Pae
	public Pae deletePae(Pae pae) {
		return dao.deletePae(pae);
	}
	
	// Calls Dao Method to update a Pae
	public Pae updatePae(Pae oldPae, Pae newPae) {
		// TODO Auto-generated method stub
		return dao.updatePae(oldPae, newPae);
	}
}
