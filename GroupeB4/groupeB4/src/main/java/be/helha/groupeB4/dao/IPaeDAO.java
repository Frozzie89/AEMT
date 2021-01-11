package be.helha.groupeB4.dao;

import java.util.List;

import be.helha.groupeB4.entities.Pae;

public interface IPaeDAO {

	public Pae AddPAE(Pae pae);
	public List<Pae> getAllPae();
	public Pae DeletePae(Pae pae);
	public Pae UpdatePae(Pae oldPae, Pae newPae);
	
}
