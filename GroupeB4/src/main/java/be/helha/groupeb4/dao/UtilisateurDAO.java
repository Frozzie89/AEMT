package be.helha.groupeb4.dao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.groupeb4.entities.Adresse;
import be.helha.groupeb4.entities.Utilisateur;

@Stateless 
public class UtilisateurDAO {

	@PersistenceContext(unitName = "groupe4")
	private EntityManager em;
	
	@EJB
	private AdresseDAO adresseDAO;
	
	public Utilisateur add(Utilisateur utilisateur) {
		//il ne faut pas dupliquer l'adresse
		Adresse testAdresse = adresseDAO.find(utilisateur.getAddresse());
		// A FINIR
		if(testAdresse == null) {
			em.persist(utilisateur);
			return utilisateur;
		}
		else {
			utilisateur.setAddresse(testAdresse);
			em.persist(utilisateur);
			return utilisateur;
		}
		
	}
}
