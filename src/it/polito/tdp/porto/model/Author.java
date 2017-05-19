package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private int id;
	private String lastname;
	private String firstname;
	
	private List<Paper> articoliProdotti = new ArrayList<Paper>();
	private List<Author> coautori = new ArrayList<Author>();
		
	public Author(int id, String lastname, String firstname) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void add(Paper p){
		this.articoliProdotti.add(p);
	}
	
	

	/**
	 * @return the articoliProdotti
	 */
	public List<Paper> getArticoliProdotti() {
		return articoliProdotti;
	}

	/**
	 * @param articoliProdotti the articoliProdotti to set
	 */
	public void setArticoliProdotti(List<Paper> articoliProdotti) {
		this.articoliProdotti = articoliProdotti;
	}
	
	public void addCoautore(Author a){
		if (!this.coautori.contains(a)){
		     this.coautori.add(a);
		}
	}

	/**
	 * @return the coautori
	 */
	public List<Author> getCoautori() {
		return coautori;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + " " + lastname + " " + firstname;
	}
}
