package com.example.fullfood.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class catogiry {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cato_name;
	public catogiry(int id, String cato_name) {
		super();
		this.id = id;
		this.cato_name = cato_name;
	}
	public catogiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "catogiry [id=" + id + ", cato_name=" + cato_name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCato_name() {
		return cato_name;
	}
	public void setCato_name(String cato_name) {
		this.cato_name = cato_name;
	}
	
	

}
