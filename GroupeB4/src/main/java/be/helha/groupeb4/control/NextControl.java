package be.helha.groupeb4.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NextControl implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	
	
	public String doNext() {
		return "next.xhtml";
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
