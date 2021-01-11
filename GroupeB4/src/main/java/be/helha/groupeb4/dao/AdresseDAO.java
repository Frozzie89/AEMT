package be.helha.groupeb4.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupeb4.entities.Adresse;

@Stateless
public class AdresseDAO {

	@PersistenceContext(unitName = "groupe4")
	private EntityManager em;
	
	public Adresse find(Adresse adresse) {
		String requeteString = "Select adresse from Adresse adresse "
				+ "where adresse.cp = ?1 "
				+ "and adresse.numero = ?2 "
				+ "and adresse.rue = ?3 "
				+ "and adresse.Ville = ?4";
		
		TypedQuery<Adresse> sqlQuery = em.createQuery(requeteString, Adresse.class);
		sqlQuery.setParameter(1, adresse.getCp());
		sqlQuery.setParameter(2, adresse.getNumero());
		sqlQuery.setParameter(3, adresse.getRue());
		sqlQuery.setParameter(4, adresse.getVille());
		List<Adresse> adresses = sqlQuery.getResultList();
		return adresses.isEmpty()? null:adresses.get(0);
	}
}
