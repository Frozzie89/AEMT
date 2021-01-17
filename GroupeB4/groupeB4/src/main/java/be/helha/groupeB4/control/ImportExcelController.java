package be.helha.groupeB4.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.xmlbeans.impl.values.XmlBooleanRestriction;

import be.helha.groupeB4.ejb.LearningUnitEJB;
import be.helha.groupeB4.ejb.PaeEJB;
import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.GenStudents;


@Named
@SessionScoped
public class ImportExcelController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private StudentEJB studentEjb;
	
	@Inject
	private LearningUnitEJB learningUnitEjb;
	
	private Part excelPart;

	public void loadExcel() {
		
		studentEjb.clean();
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
