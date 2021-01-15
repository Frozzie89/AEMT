package be.helha.groupeB4.control;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import be.helha.groupeB4.ejb.LearningUnitEJB;
import be.helha.groupeB4.ejb.StudentEJB;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.excel.InsertStudentFromExcel;

@Named("ic")
@RequestScoped
public class ImportController {
	
	@Inject
	private StudentEJB ejbStudent;
	
	@Inject
	private LearningUnitEJB ejbLU;
	
	UploadedFile importedFile;
	File file;
	
	public void importXLSX(File l_file) {
		
		List<LearningUnit> ue = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		
		//Lecture du fichier Excel
		InsertStudentFromExcel.initFile(l_file);
		ue = InsertStudentFromExcel.createLearningUnits();
		students = InsertStudentFromExcel.createStudents();
		
		
		ejbLU.addLearningUnits(ue);		
		ejbStudent.addStudents(students);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++ Petite Liste	 ++++++++++++++++++++++++++++++++++++++++++++++++"+ue.toString());
	}
	
	public void handleImportedFile(FileUploadEvent l_event) throws IOException {
		FacesMessage message = new FacesMessage("Succès", l_event.getFile().getFileName()+" a bien été importé"); 
		FacesContext.getCurrentInstance().addMessage(null, message);
		setImportedFile(l_event.getFile());
		setFile(l_event.getFile());
	}

	public void setImportedFile(UploadedFile l_importedFile) {
		this.importedFile = l_importedFile;
	}

	public void setFile(UploadedFile l_file) throws IOException {
		file = new File(l_file.getFileName());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++ OK SALE MERDE ++++++++++++++++++++++++++++++++++++++++++++++++=");
		FileUtils.copyInputStreamToFile(l_file.getInputstream(), file);
		importXLSX(file);
		
	}
	
	
	

}
