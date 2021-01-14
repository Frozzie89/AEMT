package be.helha.groupeB4.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.Part;

import be.helha.groupeB4.entities.User;
import be.helha.groupeB4.excel.GenStudents;


@Named
@SessionScoped
public class ImportExcelController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Part excelPart;

	public void loadExcel() {
	    String fileName = Paths.get(excelPart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    
	    try (InputStream input = excelPart.getInputStream()) {
	        File excelFile = new File(fileName);
	        GenStudents gs = new GenStudents(new FileInputStream(excelFile));
	        gs.createLearningUnits();
	        gs.createStudents();
	        
	    }
	    catch (IOException e) {
	        // Show faces message?
	    }
	    
	    
	}

	public Part getExcelPart() {
		return excelPart;
	}

	public void setExcelPart(Part excelPart) {
		this.excelPart = excelPart;
	}
	
	
}
