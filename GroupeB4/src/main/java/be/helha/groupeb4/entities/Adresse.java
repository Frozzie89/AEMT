package be.helha.groupeb4.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Adresse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String rue;
	String numero;
	String Ville;
	int cp;
	
	
	public Adresse() {
		super();
	}


	public Adresse( String rue, String numero, String ville, int cp) {
		
		

		this.rue = rue;
		this.numero = numero;
		Ville = ville;
		this.cp = cp;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ville == null) ? 0 : Ville.hashCode());
		result = prime * result + cp;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
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
		Adresse other = (Adresse) obj;
		if (Ville == null) {
			if (other.Ville != null)
				return false;
		} else if (!Ville.equals(other.Ville))
			return false;
		if (cp != other.cp)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Addresse [id=" + id + ", rue=" + rue + ", numero=" + numero + ", Ville=" + Ville + ", cp=" + cp + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getVille() {
		return Ville;
	}


	public void setVille(String ville) {
		Ville = ville;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}
	
	
	
	
	

}
