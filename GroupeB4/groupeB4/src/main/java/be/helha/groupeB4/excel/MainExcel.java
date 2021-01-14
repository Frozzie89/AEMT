
	package be.helha.groupeB4.excel;

	import java.util.List;

import be.helha.groupeB4.dao.StudentDAO;
import be.helha.groupeB4.control.FilterController;
import be.helha.groupeB4.control.LearningUnitController;
import be.helha.groupeB4.control.PaeController;
import be.helha.groupeB4.dao.LearningUnitDAO;
import be.helha.groupeB4.dao.StudentDAO;
import be.helha.groupeB4.entities.LearningActivity;
	import be.helha.groupeB4.entities.LearningUnit;
	import be.helha.groupeB4.entities.Student;
	import be.helha.groupeB4.enumeration.ESection;

	public class MainExcel {
		
	
		public static void main(String[] args) {
			//List<Student> listStudentTest = createStudents();
//			FilterController fc = new FilterController();
//			fc.getListSections();
			
//			PaeController pc = new PaeController();
//			System.out.println(pc.doGetUEFromLUC());
			
//			LearningUnitController lc = new LearningUnitController();
//			LearningUnitDAO lud = new LearningUnitDAO();
//			System.out.println(lud.getAllLearningUnits());
			
			StudentDAO st = new StudentDAO();
			System.out.println(st.getAllStudent());
			
		}
	
	}