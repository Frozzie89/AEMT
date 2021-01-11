package be.helha.groupeB4.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB4.entities.Pae;

@Remote
public interface IPaeRemote {

	Pae addPae(Pae pae);
	List<Pae> getAllPaes();
	Pae deletePae(Pae pae);
	Pae updatePae(Pae oldPae, Pae newPae);
}
