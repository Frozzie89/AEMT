package be.helha.groupeb4.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.core.EntityTag;

import be.helha.groupeb4.entities.Utilisateur;
import be.helha.groupeb4.entities.Visiteur;

public class MainData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tUtilisateurB");
		EntityManager eManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = eManager.getTransaction();
		
		String tmpString = "" + System.currentTimeMillis()%1000;
		
		Utilisateur u = new Utilisateur(tmpString, "u", "C/6TXnDDIcfKOvx1zg0MovmLVCLgCLsxwAxtfx8cCtY=", tmpString+"@helha.be", "ADMIN");
		//Visiteur u1 = new Visiteur("l"+tmpString);
		
		tx.begin();
		eManager.persist(u);
		tx.commit();
		
		eManager.close();
		entityManagerFactory.close();
	}

}
