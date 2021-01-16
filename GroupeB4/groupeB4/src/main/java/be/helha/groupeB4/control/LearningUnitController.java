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
	
	public List<LearningUnit> doSelectSectionUE(Student s){
		List<LearningUnit> listUE = new ArrayList<>();
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
	/*	System.out.println(listAllUE.toString());
		for(int i = 0; i < listAllUE.size() ; i++) {
			switch(s.getSection()) {
				case COMPTABILITE:
					if(listAllUE.get(i).getId().contains("S")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				case INFORMATIQUE_DE_GESTION:
					if(listAllUE.get(i).getId().contains("IG")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				case ASSISTANT_DE_DIRECTION:
					if(listAllUE.get(i).getId().contains("AD")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				default: 
					listUE.add(listAllUE.get(i));
				break;
			}
			
		}
		*/
		return listUE;
	}
	
	public List<LearningUnit> doSelectSectionUEAvailable(Student s){
		List<LearningUnit> listUE = new ArrayList<>();
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
	/*	System.out.println(listAllUE.toString());
		for(int i = 0; i < listAllUE.size() ; i++) {
			switch(s.getSection()) {
				case COMPTABILITE:
					if(listAllUE.get(i).getId().contains("S")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				case INFORMATIQUE_DE_GESTION:
					if(listAllUE.get(i).getId().contains("IG")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				case ASSISTANT_DE_DIRECTION:
					if(listAllUE.get(i).getId().contains("AD")) {
						listUE.add(listAllUE.get(i));
					}
					break;
				default: 
					listUE.add(listAllUE.get(i));
				break;
			}
			
		}
		*/
		return listUE;
	}
}
