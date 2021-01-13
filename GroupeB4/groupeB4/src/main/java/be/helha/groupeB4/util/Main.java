package be.helha.groupeB4.util;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Pae;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.EPaeProgress;
import be.helha.groupeB4.enumeration.ESection;

public class Main {

	public static void main(String[] args) {
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

	}

}
