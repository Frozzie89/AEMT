package be.helha.groupeB4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Stateless
public class LearningUnitDAO{

	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	private InsertStudentFromExcel stu;
	
	// add a LearningUnit into the db
	public LearningUnit addLearningUnit(LearningUnit ue) {
		em.persist(ue);
		return ue;
	}
	
	// add multiple LearningUnits into the db
	public List<LearningUnit> addLearningUnits(List<LearningUnit> units) {
		for (int i=0; i< units.size() ;i++) {
			em.persist(units.get(i));
		}
		return units;
		
	}

	// find a return a LearningUnit by its identification
	public LearningUnit getLearningUnit(String identification) {
		String sqlRequestStr = "SELECT learningUnit from LearningUnit learningUnit "
                + "WHERE learningUnit.id = ?1 ";
		TypedQuery<LearningUnit> query = em.createQuery(sqlRequestStr,LearningUnit.class);
		query.setParameter(1, identification);
		List<LearningUnit> result = query.getResultList();
		return result.isEmpty()? null:result.get(0);
	}

	
	// returns all the LearningUnits
	public List<LearningUnit> getAllLearningUnits() {
		return em.createQuery("SELECT learningUnit FROM LearningUnit learningUnit").getResultList();
	}
}
