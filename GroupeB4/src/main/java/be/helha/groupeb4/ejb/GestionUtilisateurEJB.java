package be.helha.groupeb4.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.groupeb4.dao.UtilisateurDAO;
import be.helha.groupeb4.entities.Utilisateur;

@Stateless
public class GestionUtilisateurEJB  {

	
	
	@EJB
	private UtilisateurDAO userDao;

	
	public Utilisateur add(Utilisateur utilisateur) { //LOGIQUE METIER
		// TODO Auto-generated method stub
		
		return userDao.add(utilisateur);
	}

}
