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
	
	
	public Pae addPae(Pae pae) {
		// TODO Auto-generated method stub
		return dao.addPAE(pae);
	}

	
	public List<Pae> getAllPaes() {
		// TODO Auto-generated method stub
		return dao.getAllPaes();
	}

	
	public Pae deletePae(Pae pae) {
		// TODO Auto-generated method stub
		return dao.deletePae(pae);
	}

	
	public Pae updatePae(Pae oldPae, Pae newPae) {
		// TODO Auto-generated method stub
		return dao.updatePae(oldPae, newPae);
	}
}
