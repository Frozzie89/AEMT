package be.helha.groupeb4.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeb4.dao.UtilisateurDAO;
import be.helha.groupeb4.dao.VisiteurDAO;
import be.helha.groupeb4.entities.Utilisateur;
import be.helha.groupeb4.entities.Visiteur;

@Stateless
public class GestionVisiteurEJB{
	
	@EJB //possible car accés local  a visDao
 	private VisiteurDAO dao;
	@EJB
	private UtilisateurDAO userDao;
	
	public List<Visiteur> findAll() { // va passer par le dao
		return dao.findAll(); 
	}
	
	public Visiteur add(Visiteur visiteur) {
		return dao.add(visiteur);
	}

	public List<Utilisateur> findAllUser() {
		// TODO Auto-generated method stub
	return dao.findAllUsers();
	}

	public Utilisateur addU(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return userDao.add(utilisateur);
	}

	
}

