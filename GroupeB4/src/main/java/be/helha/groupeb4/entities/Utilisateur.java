package be.helha.groupeb4.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur extends Visiteur {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;*/
	private String login;
	private String password;
	private String email;
	
	private String role; // avec getter et setter
	
	@OneToOne(cascade = CascadeType.ALL)
	private Compte compte;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Adresse addresse;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Commande> commandes;
	
	
	public Utilisateur() {
		super();
		this.commandes = new ArrayList<>();
	}


	public Utilisateur(String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.commandes = new ArrayList<>();
	}
	
	
	
	public Utilisateur(String ip,String login, String password, String email) {
		super(ip);
		// TODO Auto-generated constructor stub
		this.login = login;
		this.password = password;
		this.email = email;
		this.commandes = new ArrayList<>();
	}
	
	public Utilisateur(String ip,String login, String password, String email,String role) {
		super(ip);
		// TODO Auto-generated constructor stub
		this.login = login;
		this.password = password;
		this.email = email;
		this.commandes = new ArrayList<>();
		this.role = role;
	}

	public void ajoutcommande(Commande c) {
		if (c != null) {
			commandes.add(c);
		}
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "login=" + login + ", password=" + password + " email= " + email;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public Adresse getAddresse() {
		return addresse;
	}


	public void setAddresse(Adresse addresse) {
		this.addresse = addresse;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	
	
	
	
}
