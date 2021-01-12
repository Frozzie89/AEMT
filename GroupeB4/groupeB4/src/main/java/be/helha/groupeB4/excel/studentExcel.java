package be.helha.groupeB4.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import be.helha.groupeB4.entities.Grade;
import be.helha.groupeB4.entities.LearningActivity;
import be.helha.groupeB4.entities.LearningUnit;
import be.helha.groupeB4.entities.Student;
import be.helha.groupeB4.enumeration.ESection;

public class studentExcel {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static int nbOfRows;
	
    static CellReference cr;
    
	
	public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(
                    new File("C:\\listes.xlsx"));

            // Create Workbook instance holding reference to .xlsx file
            workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            sheet = workbook.getSheetAt(0);

            nbOfRows = getMaxNbRows(sheet);
            //createStudents(sheet, nbOfRows);
            //createLearningUnits(sheet, nbOfRows);
            createGrade(sheet, nbOfRows);

            file.close();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void createStudents(XSSFSheet sheet, int sheetSize) {
        // Deviendra un objet Student
        String temporaryStudent;
        String studentNameToSplit, studentMatricule, studentClassString;
        String studentFirstName;
        String studentLastName;
        int studentClass;

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
            
            System.out.println(student.toString());

            // jump to next row
            row = sheet.getRow(cr.getRow() + i);
        }

    }

    public static List<LearningUnit> createLearningUnits(XSSFSheet sheet, int sheetSize) {
        String temporaryUE, temporaryAA;
        List<LearningUnit> listUnit = new ArrayList<>();
        
        // UE
        LearningUnit learningUnit ;
    	String idUnit;
    	String labelUnit;
    	int totalCreditsUnit;
    	String schoolYearUnit;
        
    	// AA
        LearningActivity learningActivity ;
        String idActivity;
    	String labelActivity;
    	int creditAA;
    	
        int i = 0;
        
        Row rowLabel, rowType, rowCredits, rowGrades;
        Cell cellLabel, cellType, cellCredit, cellGrades;
        double gradeAA=0.;


        // first cell to read
        cr = new CellReference("E1");

        // row of label of UE's and AA's
        rowLabel = sheet.getRow(cr.getRow());

        // row of types of columns (if UE or AA)
        rowType = sheet.getRow(cr.getRow() + 1);
        
        rowCredits = sheet.getRow(cr.getRow() + 2);

        // label of UE's and AA's
        cellLabel = rowLabel.getCell(cr.getCol());

        // type of column (if UE or AA)
        cellType = rowType.getCell(cr.getCol());
        
        // Credit of column
        cellCredit = rowCredits.getCell(cr.getCol());

        // loop on the UE's and AA's, stops when next data does not concern UE's and
        // AA's
        while (!cellLabel.toString().equals("%")) {
            // reading UE
        		//------------------ idUnit & labelUnit ------------------
            temporaryUE = cellLabel.toString();
            String[] ueSplit = temporaryUE.split(" ", 5);
            idUnit = ueSplit[3];
            labelUnit = ueSplit[4];
            totalCreditsUnit = (int)cellCredit.getNumericCellValue();
            schoolYearUnit = "20/21";

            // preparation on reading next AA's
            i += 2;
            cellLabel = rowLabel.getCell(cr.getCol() + i);
            
            cellType = rowType.getCell(cr.getCol() + i);
            
            cellCredit = rowCredits.getCell(cr.getCol()+i);

            learningUnit = new LearningUnit(idUnit, labelUnit, totalCreditsUnit, schoolYearUnit);
            // while the column is not targetting on a learning unit
            while (cellType != null && !cellType.toString().substring(0, 2).equals("UE")) {
                // reading AA
            		//------------------ idAA & labelAA ------------------
                temporaryAA = cellLabel.toString();
                String [] aaSplit = temporaryAA.split(":", 2);
                idActivity = aaSplit[0];
                labelActivity = aaSplit[1];
                
                // Reading Credit
                	//------------------ creditAA ------------------
                rowCredits = sheet.getRow(cr.getRow()+2);
                cellCredit = rowCredits.getCell(cr.getCol() + i);
                creditAA = (int)cellCredit.getNumericCellValue();

                // reset 1st row of grade to line 4
                rowGrades = sheet.getRow(cr.getRow() + 3);

                // reading students grades
                for (int j = 1; j < sheetSize; j++) {
                    cellGrades = rowGrades.getCell(cr.getCol() + i);
                    switch (cellGrades.getCellType()) {
                        // if the value of the cell is a number, it's the value of the grade
                        case NUMERIC:
                            //System.out.println("POINTS : " + cellGrades.toString());
                        	gradeAA = cellGrades.getNumericCellValue();
                            break;

                        // if the value of the cell is a string, the student didn't get a grade (ex :
                        // PP)
                        case STRING:
                        	//System.out.println(cellGrades.toString());
                            if(cellGrades.toString().equals("-")) {
                            	gradeAA = -1;
                            }else if(cellGrades.toString().equals("PR")){
                            	gradeAA = -2;
                            }
                            break;

                        // reject any other values
                        default:
                            break;
                    }
                    //gradeStudent = new Grade(gradeAA);
                    
                    learningActivity = new LearningActivity(idActivity, labelActivity, creditAA);
                    learningUnit.addLearning(learningActivity);
                    gradeAA = 0;
                    // jump to next row
                    rowGrades = sheet.getRow(cr.getRow() + 3 + j);
                }

                
                // end of while loop, preparation for next loop
                i++;
                cellLabel = rowLabel.getCell(cr.getCol() + i);
                cellType = rowType.getCell(cr.getCol() + i);
                cellCredit = rowCredits.getCell(cr.getCol() + i);
            }
            listUnit.add(learningUnit);
            
        }
        return listUnit;
    }
    //HashMap<LearningActivity, Grade>
    public static void createGrade(XSSFSheet sheet, int sheetSize){
    	double gradeAA = 0;
    	int i = 0, compteurActivity = 0;
    	Grade gradeStudent;
    	HashMap<LearningActivity, Grade> mapGrade = new HashMap<>();
    	List<LearningActivity> listActivity = getAllActivitiesFromUnits(createLearningUnits(sheet, nbOfRows));
    	
    	Row rowGrades, rowLabel, rowType;
        Cell cellGrades, cellLabel, cellType;
        
        // first cell to read
        cr = new CellReference("E1");

        // row of label of UE's and AA's
        rowLabel = sheet.getRow(cr.getRow());

        // row of types of columns (if UE or AA)
        rowType = sheet.getRow(cr.getRow() + 1);
        
        // label of UE's and AA's
        cellLabel = rowLabel.getCell(cr.getCol());

        // type of column (if UE or AA)
        cellType = rowType.getCell(cr.getCol());

        
        while (!cellLabel.toString().equals("%")) {
        	//System.out.println(cellLabel.toString()+"-----------");
            // preparation on reading next AA's
            i += 2;
            cellLabel = rowLabel.getCell(cr.getCol() + i);        
            cellType = rowType.getCell(cr.getCol() + i);
            // while the column is not targetting on a learning unit
            while (cellType != null && !cellType.toString().substring(0, 2).equals("UE")) {
            	System.out.println("---------------------------"+cellLabel.toString()+"---------------------------");
			        rowGrades = sheet.getRow(cr.getRow() + 3);
			        
			    	// reading students grades
			        for (int j = 1; j < sheetSize; j++) {
			            cellGrades = rowGrades.getCell(cr.getCol() + i);
			            switch (cellGrades.getCellType()) {
			                // if the value of the cell is a number, it's the value of the grade
			                case NUMERIC:
			                    //System.out.println("POINTS : " + cellGrades.toString());
			                	gradeAA = cellGrades.getNumericCellValue();
			                    break;
			
			                // if the value of the cell is a string, the student didn't get a grade (ex :
			                // PP)
			                case STRING:
			                	//System.out.println(cellGrades.toString());
			                    if(cellGrades.toString().equals("-")) {
			                    	gradeAA = -1;
			                    }else if(cellGrades.toString().equals("PR")){
			                    	gradeAA = -2;
			                    }else if(cellGrades.toString().equals("PP")) {
			                    	gradeAA = -3;
			                    }
			                    break;
			
			                // reject any other values
			                default:
			                    break;
			            }
			            gradeStudent = new Grade(gradeAA);
			            
			            System.out.println("Grade: " + gradeStudent.getGrade());
			            gradeAA = 0;
			            // jump to next row
			            rowGrades = sheet.getRow(cr.getRow() + 3 + j);
			        }
		        //}
		        i++;
                cellLabel = rowLabel.getCell(cr.getCol() + i);
                cellType = rowType.getCell(cr.getCol() + i);
            }
        }
    	//return mapGrade;
    }
    
    public static List<LearningActivity> getAllActivitiesFromUnits(List<LearningUnit> listUnit){
    	List<LearningActivity> listActivity = new ArrayList<>();
    	List<LearningActivity> listActivityFromUnit;
    	
    	for(int i = 0; i < listUnit.size(); i++) {
    		listActivityFromUnit = listUnit.get(i).getAaList();
    		for(int j = 0 ; j < listActivityFromUnit.size(); j++){
    			if(!listActivity.contains(listActivityFromUnit.get(j))) {
    				listActivity.add(listActivityFromUnit.get(j));
    			}
    			
    		}
    		
    	}

    	return listActivity;
    }
}
