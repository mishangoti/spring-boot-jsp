package com.jpa.test.book.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authodId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="language")
	private String language;
	
	public int getAuthodId() {
		return authodId;
	}
	public void setAuthodId(int authodId) {
		this.authodId = authodId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Author(int authodId, String firstName, String lastname, String language) {
		super();
		this.authodId = authodId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.language = language;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Author [authodId=" + authodId + ", firstName=" + firstName + ", lastname=" + lastname + ", language="
				+ language + "]";
	}
}
