package com.example.fullfood.productdto;

public class prodto {
	private int proid;
	private String proname;
	private String description;
	private int weight;
	private int price;
	private String imagename;
	private int catog_id;
	public int getProid() {
		return proid;
	}
	public prodto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public prodto(int proid, String proname, String description, int weight, int price, String imagename,
			int catog_id) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.description = description;
		this.weight = weight;
		this.price = price;
		this.imagename = imagename;
		this.catog_id = catog_id;
	}
	@Override
	public String toString() {
		return "prodto [proid=" + proid + ", proname=" + proname + ", description=" + description + ", weight=" + weight
				+ ", price=" + price + ", imagename=" + imagename + ", catog_id=" + catog_id + "]";
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
	public int getCatog_id() {
		return catog_id;
	}
	public void setCatog_id(int catog_id) {
		this.catog_id = catog_id;
	}

}
