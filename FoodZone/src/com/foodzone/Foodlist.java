package com.foodzone;

public class Foodlist
{

	private String name;
	private double price;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Foodlist(String name, String type, double price) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	
	public Foodlist()
	{
		
	}
	@Override
	public String toString() {
		return name +" "+type+" "+price;
	}
	
	
	
	
}
