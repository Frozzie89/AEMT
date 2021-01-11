package be.helha.groupeb4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String libelle;
	double prix;
	
	public Article(String libelle, double prix) {
		super();
		this.libelle = libelle;
		this.prix = prix;
	}

	public Article() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", libelle=" + libelle + ", prix=" + prix + "]";
	}
	
	
	
	
}
