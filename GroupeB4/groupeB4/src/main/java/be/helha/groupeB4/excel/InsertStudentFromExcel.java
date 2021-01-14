
	package be.helha.groupeB4.excel;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.util.CellReference;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
	import be.helha.groupeB4.entities.LearningActivity;
	import be.helha.groupeB4.entities.LearningUnit;
	import be.helha.groupeB4.entities.Student;
	import be.helha.groupeB4.enumeration.ESection;

	public class InsertStudentFromExcel {
		static FileInputStream file;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		static int nbOfRows;
		
	    static CellReference cr;
	    
	    public static void initFile(){
	        try {
	            file = new FileInputStream(
	                    new File("C:\\Cours\\ListeShortBis.xlsx"));

	            // Create Workbook instance holding reference to .xlsx file
	            workbook = new XSSFWorkbook(file);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		public static void closeFile() {

            try {
				file.close();
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
            
		}

	    public static int getMaxNbRows() {
	        int nb = 0;
			nb = sheet.getLastRowNum() - 1;
	        return nb;
	    }

	    public static List<Student> createStudents() {
	        // initFile
	        initFile();
	    	
	        // Deviendra un objet Student
	        String studentNameToSplit, studentMatricule, studentClassString;
	        String studentFirstName;
	        String studentLastName;
	        int studentClass;
	        
	        Student student = new Student();
	        
	        HashMap<LearningActivity, Double> mapGrade;
	        
	        List<Student> listStudent= new ArrayList<>();

	        CellReference cr = new CellReference("B4");
	        
	        for(int sh = 0; sh < workbook.getNumberOfSheets() ; sh++) {
	        	
	        	sheet = workbook.getSheetAt(sh);
	            
	            nbOfRows = getMaxNbRows();
	            
	            Row row = sheet.getRow(cr.getRow());
	            List<LearningActivity> listActivity = getAllActivitiesFromUnits(createLearningUnits(sheet));
	            
	            cr = new CellReference("B4");
	            row = sheet.getRow(cr.getRow());
	        
	            // loop on each students
		        for (int i = 1; i < nbOfRows; i++) {
		            // get student name, matricule and school class
		            studentNameToSplit = row.getCell(cr.getCol()).toString();
		            studentMatricule = row.getCell(cr.getCol() + 1).toString();
		            studentClassString = row.getCell(cr.getCol() + 2).toString();
		            
		            String[] studentNameSplit = studentNameToSplit.split(" ", 2); 
		            studentLastName = studentNameSplit[0];
		            studentFirstName = studentNameSplit[1];
		            
		            String[] studentClassSplit = studentClassString.split("B", 2);
		            studentClass = Integer.parseInt(studentClassSplit[0]);
		            
		            switch(sheet.getSheetName()) {
		            case "IG":
		            	student = new Student(studentLastName, studentFirstName, studentMatricule, "20/21", studentClass, ESection.INFORMATIQUE_DE_GESTION);
		            	break;
		            case "AD": 
		            	student = new Student(studentLastName, studentFirstName, studentMatricule, "20/21", studentClass, ESection.ASSISTANT_DE_DIRECTION);
		            	break;
		            case "CT":
		            	student = new Student(studentLastName, studentFirstName, studentMatricule, "20/21", studentClass, ESection.COMPTABILITE);
		            	break;
		            default:
		            	break;
		            }
	
		            mapGrade = createGrade(sheet, nbOfRows, row, listActivity);
		            student.setBulletin(mapGrade);
		            listStudent.add(student);
		            
		            
		            // jump to next row
		            row = sheet.getRow(cr.getRow() + i);
		        }
	        	listActivity = null;
	        }
	        closeFile();
	        return listStudent;
	    }
	    public static List<LearningUnit> createLearningUnits(){
	    	List<LearningUnit> list = new ArrayList<>();
	    	List<LearningUnit> listBis = new ArrayList<>();
	    	initFile();
	    	for(int i=0; i < workbook.getNumberOfSheets() ; i++) {
	    		sheet = workbook.getSheetAt(i);
	    		listBis = createLearningUnits(sheet);
	    		for(int j = 0; j < listBis.size() ; j++) {
	    			list.add(listBis.get(j));
	    		}
	    		
	    	}
	    	return list;
	    }
	    public static List<LearningUnit> createLearningUnits(XSSFSheet sheet) {
	    	
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
	            while (cellType != null && !cellType.toString().substring(0, 2).equals("UE") && !cellType.toString().substring(0, 2).equals("UP")) {
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

	                learningActivity = new LearningActivity(idActivity, labelActivity, creditAA);
                    learningUnit.addLearning(learningActivity);
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
	    public static HashMap<LearningActivity, Double> createGrade(XSSFSheet sheet, int sheetSize, Row row, List<LearningActivity> listActivity){
	    	HashMap<LearningActivity, Double> mapGrade = new HashMap<>();
	    	
	    	double gradeAA=0.;
	    	
	        int i = 0, z=0;
	    	Row rowLabel, rowType, rowGrade;
	        Cell cellLabel, cellType, cellGrade;
	    	// first cell to read
	        cr = new CellReference("E1");

	        // row of label of UE's and AA's
	        rowLabel = sheet.getRow(cr.getRow());

	        // row of types of columns (if UE or AA)
	        rowType = sheet.getRow(cr.getRow() + 1);
	        
	        rowGrade = sheet.getRow(row.getRowNum());
	        
	        // label of UE's and AA's
	        cellLabel = rowLabel.getCell(cr.getCol());

	        // type of column (if UE or AA)
	        cellType = rowType.getCell(cr.getCol());
	        
	        cellGrade = rowGrade.getCell(cr.getCol());   
	        
	        while (!cellLabel.toString().equals("%")) {

	            // preparation on reading next AA's
	            i += 2;
	            cellLabel = rowLabel.getCell(cr.getCol() + i);
	            cellType = rowType.getCell(cr.getCol() + i);
	            cellGrade = rowGrade.getCell(cr.getCol() + i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	            
	            // while the column is not targetting on a learning unit
	            while (cellType != null && !cellType.toString().substring(0, 2).equals("UE") && !cellType.toString().substring(0, 2).equals("UP")) {
	            	
	            	switch (cellGrade.getCellType()) {
		                // if the value of the cell is a number, it's the value of the grade
		                case NUMERIC:
		                	gradeAA = cellGrade.getNumericCellValue();
		                    break;
		
		                // if the value of the cell is a string, the student didn't get a grade (ex :
		                // PP)
		                case STRING:
		                	if(cellGrade.toString().endsWith(Character.toString((char)176))) {
		                		String tmp = cellGrade.toString().substring(0, cellGrade.toString().length()-1);
		                		String[] tmpSplit = tmp.split(",", 2);
		                		if(tmpSplit.length == 1) {
			                		gradeAA = Double.parseDouble(tmpSplit[0] + ".0");
		                		}else {
			                		gradeAA = Double.parseDouble(tmpSplit[0] + "." + tmpSplit[1]);
		                		}
		                	}else {
		                		switch(cellGrade.toString()) {
				                    case "-":
				                    	gradeAA = -1;
				                    	break;
				                    case "PR":
				                    	gradeAA = -2;
				                    	break;
				                    case "PP":
				                    	gradeAA = -3;
				                    	break;
				                    case "D":
				                    	gradeAA = -4;
				                    	break;
				                    case "DV":
				                    	gradeAA = -5;
				                    	break;
				                    case "Z":
				                    	gradeAA = 0;
				                    	break;
				                    default:
				                    	gradeAA = -10;
				                    	break;
		                		}
		                	}
		                    break;
		                case BLANK:
		                	gradeAA = -6;
		                	break;
		                // reject any other values
		                default:
		                	gradeAA = -10;
		                    break;
	            	}
	            	mapGrade.put(listActivity.get(z), gradeAA);
	            	z++;
	                
	            	
	            	i++;
	            	cellLabel = rowLabel.getCell(cr.getCol() + i);
	                cellType = rowType.getCell(cr.getCol() + i);
	                cellGrade = rowGrade.getCell(cr.getCol() + i);
	            }
	        }
	    	return mapGrade;
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
