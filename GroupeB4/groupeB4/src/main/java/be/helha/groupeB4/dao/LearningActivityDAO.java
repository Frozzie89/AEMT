package be.helha.groupeB4.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupeB4.entities.LearningActivity;

@Stateless
public class LearningActivityDAO {

    @PersistenceContext(unitName = "groupeB4")
    private EntityManager em;

    // adds a LearningActivity into the db
    public LearningActivity addLearningActivity(LearningActivity aa) {
        em.persist(aa);
        return aa;
    }

    // finds a returns a LearningActivity by its identification
    public LearningActivity getLearningActivity(String identification) {
        String sqlRequestStr = "SELECT learningActivity FROM LearningActivity learningActivity "
                + "WHERE learningActivity.id = ?1 ";
        TypedQuery<LearningActivity> query = em.createQuery(sqlRequestStr, LearningActivity.class);
        query.setParameter(1, identification);
        List<LearningActivity> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // returns all the LearningActivities form db
    public List<LearningActivity> getAllLearningActivities() {
        // TODO Auto-generated method stub
        return em.createQuery("SELECT learningActivity FROM LearningActivity learningActivity").getResultList();
    }

}
