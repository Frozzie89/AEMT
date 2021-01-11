package be.helha.groupeb4.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	LocalDate date;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Article> articles;

public Commande() {
	super();
	
	this.date = LocalDate.now();
	articles = new ArrayList<>();
}



public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public List<Article> getArticles() {
	return articles;
}

public void setArticles(List<Article> articles) {
	this.articles = articles;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((articles == null) ? 0 : articles.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Commande other = (Commande) obj;
	if (articles == null) {
		if (other.articles != null)
			return false;
	} else if (!articles.equals(other.articles))
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public String toString() {
	return "Commande [id=" + id + ", date=" + date + ", articles=" + articles + "]";
}
	
	
	
	
	
	
}
