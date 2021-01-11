package be.helha.groupeb4.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeb4.ejb.GestionVisiteurEJB;
import be.helha.groupeb4.entities.Utilisateur;

@Named
@RequestScoped
public class UtilisateurControl implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestionVisiteurEJB visiteurEJB; 

	public List<Utilisateur> doSelectAll(){
		return visiteurEJB.findAllUser();
	}
	
	
	

}
