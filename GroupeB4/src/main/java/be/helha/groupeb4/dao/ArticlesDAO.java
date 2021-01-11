package be.helha.groupeb4.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.groupeb4.entities.Article;

@Stateless
public class ArticlesDAO {

	@PersistenceContext(unitName = "groupe4")
	private EntityManager em;
	
	public Article add(Article article) {
		return null;
	}
}
