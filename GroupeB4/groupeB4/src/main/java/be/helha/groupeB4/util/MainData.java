package be.helha.groupeB4.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Pae;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.entities.User;
import be.helha.groupeB4.enumeration.EPaeProgress;
import be.helha.groupeB4.enumeration.ESection;

public class MainData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("groupeB4_Local");
		EntityManager eManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = eManager.getTransaction();
		
		Student s1 = new Student("s1", "s1", "la1", "y1", 1, ESection.INFORMATIQUE_DE_GESTION);
		System.out.println("s1: " + s1.toString());
		
		Pae p1 = new Pae(EPaeProgress.TERMINE);
		
		LearningUnit ue1 = new LearningUnit("UE1", "ue1Label", 10, "y1");
		LearningUnit ue2 = new LearningUnit("UE2", "ue2Label", 10, "y2");
		
		LearningActivity aa1 = new LearningActivity("AA1", "aa1Label", 5);		
		LearningActivity aa2 = new LearningActivity("AA2", "aa2Label", 5);	
		LearningActivity aa3 = new LearningActivity("AA3", "aa3Label", 5);	
		
		ue1.addLearning(aa1);
		ue1.addLearning(aa2);
		
		p1.addLearningUnit(ue1);
		
		s1.setPae(p1);
		
		System.out.println(s1);
		
		User user = new User("u", "u", "ADMIN");
		System.out.println(user);
		
		tx.begin();
		// eManager.persist(s1);
		eManager.persist(user);
		tx.commit();
		
		eManager.close();
		entityManagerFactory.close();
	}

}
