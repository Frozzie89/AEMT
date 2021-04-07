package be.helha.groupeB4.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.groupeB4.ejb.LearningUnitEJB;
import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.ESection;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Named("luc")
@SessionScoped
public class LearningUnitController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HtmlDataTable table;
	
	@Inject
	private LearningUnitEJB ejb;
	
	private InsertStudentFromExcel stfu;
	
	public List<LearningUnit> doSelectAll(){
		return ejb.getAllLearningUnits();
	}
	
	public List<LearningUnit> getLearningUnits() {
		List<LearningUnit> maliste = new ArrayList<>();
		maliste = stfu.createLearningUnits();
		ejb.addLearningUnits(maliste);
		return maliste;
	}
	
	public List<LearningUnit> doSelectSectionUESuccess(Student s){
		// Initialize lists that will contain student's UE and AA
		List<LearningUnit> listUE = new ArrayList<>();
		List<LearningUnit> listAllUE = new ArrayList<>();
		List<LearningActivity> listfromBU = new ArrayList<>();
		List<Double> listePointFromBulletin = new ArrayList<>();
		
		// Set student's current PAE in map
		// Binds student's grades with its AA
		Map<LearningActivity, Double> test = s.getBulletin();
		
		// For each AA, append it to lists
		for (Map.Entry<LearningActivity, Double> entry : test.entrySet()) {
            LearningActivity key = entry.getKey();
            Double value = entry.getValue();
            
            listfromBU.add(key);
            listePointFromBulletin.add(value);
        }
		
		// get all UE
		listAllUE = doSelectAll();
		
		// for each UE, gets means UE grades of all AA
		for(LearningUnit ue : listAllUE) {
			Double compteur = 0.;
			
			for (int i = 0; i < listfromBU.size(); i++) {	  
				if(ue.getAaList().contains(listfromBU.get(i))) {	  
					  // if course is a suspended course (-5 and -4 are flags for suspended courses)
					  if(listePointFromBulletin.get(i) == -5 || listePointFromBulletin.get(i) == -4) {
						  // we add 24 to the counter to make sure that the UE si passed
						  compteur += 24;
					  }
					  compteur += listePointFromBulletin.get(i);
					  
					  // if AA is optional course, do not divide per number of AA 
					  if(ue.getId().contains("UP")) {
						  if(compteur >= 10)
						  {
							  if(!listUE.contains(ue)) {
								  listUE.add(ue);
							  }
						  }
				       // else divide per number of AA to get mean grades
					  }else {
						  if((compteur/ue.getAaList().size()) >= 9.75)
						  {
							  if(!listUE.contains(ue)) {
								  listUE.add(ue);
							  }
						  }
					}
					  
					 
					
				  }
				}
		}
		
		// When loop is done, returns the ue list
		return listUE;
	}
	
	public List<LearningUnit> doSelectSectionUE(Student s){
		List<LearningUnit> listUE = new ArrayList<>();
		List<LearningUnit> listUEB1 = new ArrayList<>();
		List<LearningUnit> listUEB1Test = new ArrayList<>();
		List<LearningUnit> listAllUE = new ArrayList<>();
		List<LearningActivity> listfromBU = new ArrayList<>();
		List<Double> listePointFromBulletin = new ArrayList<>();
		
	
		Map<LearningActivity, Double> test = s.getBulletin();
		
		for (Map.Entry<LearningActivity, Double> entry : test.entrySet()) {
            LearningActivity key = entry.getKey();
            Double value = entry.getValue();
         //   System.out.println("Clé: " + key + ", Valeur: " + value);
            listfromBU.add(key);
            listePointFromBulletin.add(value);
        }
		
		listAllUE = doSelectAll();
		
		for(LearningUnit ue : listAllUE) {
			Double compteur = 0.;
			for (int i = 0; i < listfromBU.size(); i++) {
				  if(ue.getAaList().contains(listfromBU.get(i))) {
					  if(listePointFromBulletin.get(i) == -5 || listePointFromBulletin.get(i) == -4) {
						  compteur += 24;
					  }
					  compteur += listePointFromBulletin.get(i);
					  
					  if(ue.getId().contains("UP")) {
						  if(compteur >= 10)
						  {
							  if(!listUE.contains(ue)) {
								  listUE.add(ue);
							  }
						  }
					  }else {
						  if((compteur/ue.getAaList().size()) < 9.75)
						  {
							  if(!listUE.contains(ue)) {
								  listUE.add(ue);
							  }
						  }
					}

				  }
				}
		}
		
		if(s.getBloc() == 1) {
			int testNbCredits = 0;
			listUEB1Test = doSelectSectionUESuccess(s);
			
			for(LearningUnit ueTest : listUEB1Test) {
				testNbCredits += ueTest.getTotalCredits();
			}
			
			if(testNbCredits < 30) {
				for(LearningUnit ueAll : listUE) {
					if(ueAll.getId().startsWith("0") || ueAll.getId().startsWith("AD1") || ueAll.getId().startsWith("IG1")) {
						listUEB1.add(ueAll);
					}
					
				}
				
				return listUEB1;
				
			}
			
		}
		
		

		return listUE;
	}
}
