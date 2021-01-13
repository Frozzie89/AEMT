package be.helha.groupeB4.excel;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.Part;

import be.helha.groupeB4.entities.User;

@Named
@SessionScoped
public class importExcel implements Serializable{
	private Part excelFile;

	public void loadExcel(){
		// charger la nouvelle table des étudiants / pae ici
	}
	
	// Getters and setters
	public Part getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(Part excelFile) {
		this.excelFile = excelFile;
	}
	
}
