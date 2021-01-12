package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.entities.Pae;
import be.helha.groupeB4.enumeration.EPaeProgress;
import test.PAEEJB;

@Named
@RequestScoped
public class TestPAE implements Serializable {
	
	@Inject
	private PAEEJB ejb;
	
	public List<Pae> doSelectAll(){
		return ejb.getAllPaes(); 
	}
	
	public Pae addPae() {
		Pae pae = new Pae(EPaeProgress.A_FAIRE);
		ejb.addPae(pae);
		return pae;
	}
	
	public Pae deletePae() {
		return null;
		//ejb.deletePae(pae);
	}

}
