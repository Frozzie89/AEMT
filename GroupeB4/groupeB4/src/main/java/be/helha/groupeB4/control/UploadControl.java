package be.helha.groupeB4.control;

import java.io.File;
import java.io.IOException;
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

@Named
@RequestScoped
public class UploadControl {

    /*@Inject
    private GestionStudentEJB gestionStudentEJB;
    UploadedFile uploadedFile;
    File file;

    public void importxlsx(File file){
        ReadXLSX.lire(file);

        List<Student> students = ReadXLSX.STUDENTS_XLS;



        gestionStudentEJB.truncate();
        students.forEach(student -> {
           gestionStudentEJB.post(student);
        });
    }*/
	
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
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++ Petite Liste     ++++++++++++++++++++++++++++++++++++++++++++++++"+ue.toString());
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        FacesMessage message = new FacesMessage("Succès", event.getFile().getFileName() + " est bien téléchargé");
        FacesContext.getCurrentInstance().addMessage(null, message);
        setUploadedFile(event.getFile());
        setFile(event.getFile());
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void setFile(UploadedFile uploadedFile) throws IOException {
        file = new File(uploadedFile.getFileName());
        FileUtils.copyInputStreamToFile(uploadedFile.getInputstream(), file);
        importxlsx(file);
    }

}