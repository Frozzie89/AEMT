package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeB4.dao.PaeDAO;
import be.helha.groupeB4.entities.Pae;

@Stateless
public class PaeEJB implements IPaeRemote {

	@EJB
	private PaeDAO dao;

	@Override
	public Pae addPae(Pae pae) {
		// TODO Auto-generated method stub
		return dao.addPAE(pae);
	}

	@Override
	public List<Pae> getAllPaes() {
		// TODO Auto-generated method stub
		return dao.getAllPaes();
	}

	@Override
	public Pae deletePae(Pae pae) {
		// TODO Auto-generated method stub
		return dao.deletePae(pae);
	}

	@Override
	public Pae updatePae(Pae oldPae, Pae newPae) {
		// TODO Auto-generated method stub
		return dao.updatePae(oldPae, newPae);
	}
}
