package be.helha.groupeB4.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;

@Stateless
public class LearningActivityDAO{

	@PersistenceContext(unitName = "groupeB4")
	private EntityManager em; 
	
	public LearningActivity addLearningActivity(LearningActivity aa) {
		// TODO Auto-generated method stub
		em.persist(aa);
		return aa;
	}

	
	public LearningActivity getLearningActivity(String identification) {
		// TODO Auto-generated method stub
		String sqlRequestStr = "SELECT learningActivity FROM LearningActivity learningActivity "
                + "WHERE learningActivity.id = ?1 ";
		TypedQuery<LearningActivity> query = em.createQuery(sqlRequestStr,LearningActivity.class);
		query.setParameter(1, identification);
		List<LearningActivity> result = query.getResultList();
		return result.isEmpty()? null:result.get(0);
	}

	
	public List<LearningActivity> getAllLearningActivities() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT learningActivity FROM LearningActivity learningActivity").getResultList();
	}

}
