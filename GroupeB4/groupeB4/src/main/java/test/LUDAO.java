package test;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Stateless
public class LUDAO {

	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	private InsertStudentFromExcel stu;
	
	public List<LearningUnit> getliste(){
		List<LearningUnit> studs = new ArrayList<>();
		
		studs = stu.createLearningUnits();
		addLearningUnits(studs);
		
		
		return studs;
	
	}
	public LearningUnit addLearningUnit(LearningUnit ue) {
		// TODO Auto-generated method stub
		em.persist(ue);
		return ue;
	}
	
	public List<LearningUnit> addLearningUnits(List<LearningUnit> units) {
		for (int i=0; i< units.size() ;i++) {
			em.persist(units.get(i));
		}
		return units;
		
	}

	
	public LearningUnit getLearningUnit(String identification) {
		// TODO Auto-generated method stub
		String sqlRequestStr = "SELECT learningUnit from LearningUnit learningUnit "
                + "WHERE learningUnit.id = ?1 ";
		TypedQuery<LearningUnit> query = em.createQuery(sqlRequestStr,LearningUnit.class);
		query.setParameter(1, identification);
		List<LearningUnit> result = query.getResultList();
		return result.isEmpty()? null:result.get(0);
	}

	
	public List<LearningUnit> getAllLearningUnits() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT learningUnit FROM LearningUnit learningUnit").getResultList();
	}

	
	public List<LearningActivity> getAllLearningActivities() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT learningUnit FROM LearningUnit learningUnit "
				+ "JOIN learningUnit.aaList learningActivity").getResultList();
	}

}
