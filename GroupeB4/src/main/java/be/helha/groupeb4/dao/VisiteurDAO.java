package be.helha.groupeb4.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.groupeb4.entities.Utilisateur;
import be.helha.groupeb4.entities.Visiteur;


@Stateless
public class VisiteurDAO {
	@PersistenceContext(unitName = "groupe4")
	private EntityManager em; //le serveur va fournir le EM pas de new => JTA, c'est le serveur qui gere les transactions
	
	@SuppressWarnings("unchecked")
	public List<Visiteur> findAll(){
		// juste pour tester la comm entre les ejb:
		// return new ArrayList<>(Arrays.asList(new Visiteur("test")));
		
		return em.createQuery("SELECT visiteur From Visiteur visiteur").getResultList();
				
	}
	
	
	public Visiteur add(Visiteur visiteur) {
		em.persist(visiteur);
		return visiteur;
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findAllUsers() {
		// TODO Auto-generated method stub
		return em.createQuery("select utilisateur from Utilisateur utilisateur").getResultList();
	}

	public Utilisateur addU(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		em.persist(utilisateur);
		return utilisateur;
	}

}
