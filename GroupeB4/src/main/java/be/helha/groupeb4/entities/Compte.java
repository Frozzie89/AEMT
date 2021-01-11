package be.helha.groupeb4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger; 
	private String numero;
	
	
	public Compte() {
	}


	public Compte(String numero) {
		super();
		this.numero = numero;
	}


	public Integer getIdInteger() {
		return idInteger;
	}


	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInteger == null) ? 0 : idInteger.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Compte other = (Compte) obj;
		if (idInteger == null) {
			if (other.idInteger != null)
				return false;
		} else if (!idInteger.equals(other.idInteger))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return idInteger + "  :  "+ numero;
	}
	
	
	
	

}
