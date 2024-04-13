package com.ty.Springboot.RestAPI;

public class SmartPhones {
	private int id;
	private String brand;
	private String model;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public SmartPhones(int id, String brand, String model, int price) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	@Override
	public String toString() {
		return "SmartPhones [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
	}
	

	

}
