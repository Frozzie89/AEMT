package be.helha.groupeB4.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

	@PersistenceContext(unitName = "groupe4") //Voir persistance.xml -> JTA
	EntityManager em;
}
