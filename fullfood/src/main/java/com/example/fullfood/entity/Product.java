package com.example.fullfood.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int proid;
	private String proname;
	private String description;
	private int weight;
	private int price;
	private String imagename;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="catogiry_id",referencedColumnName="id")
	private catogiry catogiry;
	public Product(int proid, String proname, String description, int weight, int price, String imagename,
			catogiry catogiry) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.description = description;
		this.weight = weight;
		this.price = price;
		this.imagename = imagename;
		this.catogiry = catogiry;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [proid=" + proid + ", proname=" + proname + ", description=" + description + ", weight="
				+ weight + ", price=" + price + ", imagename=" + imagename + ", catogiry=" + catogiry + ", getProid()="
				+ getProid() + ", getProname()=" + getProname() + ", getDescription()=" + getDescription()
				+ ", getWeight()=" + getWeight() + ", getPrice()=" + getPrice() + ", getImagename()=" + getImagename()
				+ ", getCato()=" + getCatogiry() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public catogiry getCatogiry() {
		return catogiry;
	}
	public void setCatogiry(catogiry catogiry) {
		this.catogiry = catogiry;
	}

}
