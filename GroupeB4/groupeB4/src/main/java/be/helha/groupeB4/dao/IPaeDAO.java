package be.helha.groupeB4.dao;

import java.util.List;

import be.helha.groupeB4.entities.Pae;

public interface IPaeDAO {

	Pae addPAE(Pae pae);
	List<Pae> getAllPaes();
	Pae deletePae(Pae pae);
	Pae updatePae(Pae oldPae, Pae newPae);
	
	
	
}
