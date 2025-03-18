package com.example.fullfood.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Username;
	private String Email;
	public admin(int id, String username, String email, String password) {
		super();
		Id = id;
		Username = username;
		Email = email;
		Password = password;
	}
	public admin() {
	
	}
	@Override
	public String toString() {
		return "admin [Id=" + Id + ", Username=" + Username + ", Email=" + Email + ", Password=" + Password
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	private String Password;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
