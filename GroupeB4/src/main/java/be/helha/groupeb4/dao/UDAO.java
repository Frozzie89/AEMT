package be.helha.groupeb4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.groupeb4.entities.Adresse;
import be.helha.groupeb4.entities.Article;
import be.helha.groupeb4.entities.Commande;
import be.helha.groupeb4.entities.Utilisateur;
import be.helha.groupeb4.entities.Visiteur;



public class UDAO {

	
	private EntityManagerFactory emFactory;
	
	private EntityManager em;
	private EntityTransaction tx;
	
	
	public UDAO() {
		emFactory = Persistence.createEntityManagerFactory("groupe4");
		em = emFactory.createEntityManager();
		tx = em.getTransaction();
	}
	 public Utilisateur add(Utilisateur u) {
		 if(u==null)
			 return null;
		 em.persist(u);
		 commit();
		 
		 return u;
		 
	 }
	 
	 public Utilisateur find(Integer id) {
		 return em.find(Utilisateur.class, id);
	 }
	 
	 public Utilisateur remove(Utilisateur u) {
		 if(u ==null)
			 return null;
		 em.remove(u);
		 commit();
		 return u;
	 }
	 
	 public Utilisateur update(Utilisateur u) {
		 if(u==null)
			 return null;
		 
		 
		 em.merge(u);
		 commit();
		 return u;
	 }
	 

	 public void close() {
		 em.close();
		 emFactory.close();
	 }
	 
	 public void commit() {
		 
		 tx.begin();
		 tx.commit();
	 }
	 
	public void update(int idmodif, String pseudo2, String email2, String mdp2) {
		// TODO Auto-generated method stub
		Utilisateur u = find(idmodif);
		
		if (u==null)
			return;
		
		if (pseudo2 != null)
			u.setLogin(pseudo2);
		
		if (email2 != null)
			u.setEmail(email2);
		
		if(mdp2 != null)
			u.setPassword(mdp2);
		
		
		em.merge(u);
		commit();
	}
	 
	public Utilisateur findUserByLogin(Utilisateur u) {
		if(u ==null) {
			return null;
		}
		String requeteString = "Select utilisateur from Utilisateur utilisateur "
				+ "Where utilisateur.login =?1";
		
		Query query = em.createQuery(requeteString);
		query.setParameter(1, u.getLogin());
		@SuppressWarnings("unchecked")
		List<Utilisateur> resultesList = query.getResultList();
		if (resultesList.size() == 0) {
			return null;
		}
		Utilisateur user = (Utilisateur) resultesList.get(0);
		
		return user;
		}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> finUtilisateurByAdresse(Adresse adresse){
		if(adresse == null) {
			return new ArrayList<>();
		}
		String requeteString = "Select utilisateur from Utilisateur utilisateur "
				+ "where utilisateur.adresse.cp = ?1 "
				+ "and utilisateur.adresse.numero = ?2 "
				+ "and utilisateur.adresse.rue = ?3 "
				+ "and utilisateur.adresse.Ville = ?4";
		
		Query sqlQuery = em.createQuery(requeteString);
		sqlQuery.setParameter(1, adresse.getCp());
		sqlQuery.setParameter(2, adresse.getNumero());
		sqlQuery.setParameter(3, adresse.getRue());
		sqlQuery.setParameter(4, adresse.getVille());
		
		return sqlQuery.getResultList();
	
	}
	
	public List<Utilisateur> finduUtilisateursbycp(int codePostal){
		if(codePostal < 1000) {
			return new ArrayList<>();
		}
		
		
		String requeteCPString = " Select utilisateur from Utilisateur utilisateur where "
				+ "utilisateur.adresse.cp = ?1";
		
		Query queryCP = em.createQuery(requeteCPString);
		
		queryCP.setParameter(1, codePostal);

		@SuppressWarnings("unchecked")
		List<Utilisateur> resultesList = queryCP.getResultList();
		if (resultesList.size() == 0) {
			return null;
		}
		
		return resultesList;
		
	}
	
	public Adresse findAddresseByUtilisateur(Utilisateur u) {
		if(u == null) {
			return null;
		}
		
		return null;
		
	}
	public List<Commande> findCommandByUser(Utilisateur u) {
		// TODO Auto-generated method stub
		if(u == null)
			return new ArrayList<>();	
		
		Utilisateur user = findUserByLogin(u);
		if(user == null)
			return new ArrayList<>();
		
		

        String sqlQueryStr = "SELECT utilisateur.commandes FROM Utilisateur utilisateur WHERE utilisateur.login = ?1";
        TypedQuery<Commande> sqlQuery = em.createQuery(sqlQueryStr, Commande.class);
        sqlQuery.setParameter(1, user.getLogin());
		
		
		return sqlQuery.getResultList();
	}
	public Article addArticle(Article a) {
		// TODO Auto-generated method stub
		
		
		em.persist(a);
		return null;
	}
	
	
	public Visiteur addVisiteur(Visiteur v) {
		if(v == null)
			return null;
		
		if (v instanceof Utilisateur && findUserByLogin((Utilisateur) v) != null ) {
				return null;
		}
		tx.begin();
		em.persist(v);
		tx.commit();
		System.out.println("dans dao"+v);
		return v;
	}
	 
}
