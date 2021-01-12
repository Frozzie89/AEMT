
	package be.helha.groupeB4.excel;

	import java.io.File;
	import java.io.FileInputStream;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.util.CellReference;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import be.helha.groupeB4.entities.LearningActivity;
	import be.helha.groupeB4.entities.LearningUnit;
	import be.helha.groupeB4.entities.Pae;
	import be.helha.groupeB4.entities.Student;
	import be.helha.groupeB4.enumeration.ESection;

	public class InsertStudentFromExcel {

		public static List<Student> test(){
			 List<Student> l1= new ArrayList<>();
		        List<Student> l2= new ArrayList<>();
		        List<Student> l3= new ArrayList<>();
		        List<Student> finalList = new ArrayList<>();
	        try {
	            FileInputStream file = new FileInputStream(
	                    new File("C:\\listes.xlsx"));

	            // Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);

	            // Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);

	            int nbOfRows = getMaxNbRows(sheet);
	            l1 = createStudents(sheet, nbOfRows);
	            
	      /*     XSSFSheet sheet2 = workbook.getSheetAt(1);

	            int nbOfRows2 = getMaxNbRows(sheet2);
	            l2 = createStudents(sheet, nbOfRows);
	            
	            XSSFSheet sheet3 = workbook.getSheetAt(2);

	            int nbOfRows3 = getMaxNbRows(sheet2);
	            l3 = createStudents(sheet, nbOfRows);
	            
	            
	            finalList.addAll(l1);
	            finalList.addAll(l2);
	            finalList.addAll(l3);*/

	            file.close();
	            workbook.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        //System.out.println(oupas.toString());
			return l1;
	    }

	    public static int getMaxNbRows(XSSFSheet sheet) {
	        int nb = 0;

	        CellReference cr = new CellReference("B4");
	        Row row = sheet.getRow(cr.getRow());
	        Cell cell = row.getCell(cr.getCol());

	        while (cell != null) {
	            row = sheet.getRow(cr.getRow() + nb);
	            cell = row.getCell(cr.getCol());

	            nb++;
	        }
	        return nb;
	    }

	    public static List<Student> createStudents(XSSFSheet sheet, int sheetSize) {
	        // Deviendra un objet Student
	        String temporaryStudent;
	        String studentNameToSplit, studentMatricule, studentClassString;
	        String studentFirstName;
	        String studentLastName;
	        int studentClass;
	        List<Student> l1= new ArrayList<>();
	        List<Student> l2= new ArrayList<>();
	        List<Student> l3= new ArrayList<>();
	        List<Student> finalList = new ArrayList<>();

	        CellReference cr = new CellReference("B4");
	        Row row = sheet.getRow(cr.getRow());

	        // loop on each students
	        for (int i = 1; i < sheetSize; i++) {
	            // get student name, matricule and school class
	            studentNameToSplit = row.getCell(cr.getCol()).toString();
	            studentMatricule = row.getCell(cr.getCol() + 1).toString();
	            studentClassString = row.getCell(cr.getCol() + 2).toString();
	            
	            String[] studentNameSplit = studentNameToSplit.split(" ", 2); 
	            studentLastName = studentNameSplit[0];
	            studentFirstName = studentNameSplit[1];
	            
	            String[] studentClassSplit = studentClassString.split("B", 2);
	            studentClass = Integer.parseInt(studentClassSplit[0]);
	            
	            Student student = new Student(studentLastName, studentFirstName, studentMatricule, "20/21", studentClass, ESection.INFORMATIQUE_DE_GESTION);
	            //system.out.println(student.toString());
	            l1.add(student);

	            // jump to next row
	            row = sheet.getRow(cr.getRow() + i);
	        }
			return l1;

	    }

}
