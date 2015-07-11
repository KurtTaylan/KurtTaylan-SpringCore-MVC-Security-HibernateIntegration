package com.taylan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message", catalog = "springhibernate")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String message;
	private People people;

	public Message() {
	}

	public Message(String message,People people) {
		this.message = message;
		this.people = people;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmessage", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "message", nullable = false)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "people_idpeople", nullable = false)
	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}
