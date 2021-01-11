package be.helha.groupeb4.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface AbstractDAO  {
	
	@PersistenceContext(unitName = "groupe4")
	EntityManager em; 
	

}
