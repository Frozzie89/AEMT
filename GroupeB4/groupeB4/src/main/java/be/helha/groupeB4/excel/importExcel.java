package be.helha.groupeB4.excel;

import java.io.IOException;
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

	public void loadExcel() throws IOException{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("groupeB4_Local");
		EntityManager eManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = eManager.getTransaction();
		
		String current = new java.io.File( "." ).getCanonicalPath();
		
		User user = new User(current, current);
		
		tx.begin();
		// eManager.persist(s1);
		eManager.persist(user);
		tx.commit();
		
		eManager.close();
		entityManagerFactory.close();
		
		excelFile.write(".\\" + getFileName(excelFile));
	}
	
	public static String getFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1 ).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1 ).substring(filename.lastIndexOf('\\') + 1);
			}
		}
		
		return null;
	}
	
	// Getters and setters
	public Part getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(Part excelFile) {
		this.excelFile = excelFile;
	}
	
}
