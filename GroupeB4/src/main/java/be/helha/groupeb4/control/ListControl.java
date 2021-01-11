package be.helha.groupeb4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeb4.ejb.GestionVisiteurEJB;
import be.helha.groupeb4.entities.Visiteur;

@Named
@RequestScoped
public class ListControl implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestionVisiteurEJB visiteurEJB; 
	

	public String doNext() {
		return "liste.xhtml";
	}
	
	
	public List<Visiteur> doSelectAll(){
		return visiteurEJB.findAll(); 
	}


	
	
	

}
