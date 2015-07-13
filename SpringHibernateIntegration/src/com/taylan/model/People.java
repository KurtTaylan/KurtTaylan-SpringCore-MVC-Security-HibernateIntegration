package com.taylan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * 
 *  	Author Taylan Kurt  taylankurt@gmail.com
 */


@Entity
@Table(name = "people", catalog = "springhibernate")
public class People implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String surname;
	private int age;
	private String email;
	private List<Message> messages = new ArrayList<Message>();

	public People() {
	}

	public People(String name, String surname, int age, String email, List<Message> messages) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.messages = messages;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpeople", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", nullable = false)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "people")
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
