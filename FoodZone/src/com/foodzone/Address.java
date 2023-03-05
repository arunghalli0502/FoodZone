package com.foodzone;

public class Address 
{
	private String HoNo;
	private String street;
	private String area;
	private String state;
	private String landmark;
	
	public Address()
	{
		
	}

	public String getHoNo() {
		return HoNo;
	}

	public void setHoNo(String hoNo) {
		HoNo = hoNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Address(String hoNo, String street, String area, String state, String landmark) {
		super();
		HoNo = hoNo;
		this.street = street;
		this.area = area;
		this.state = state;
		this.landmark = landmark;
	}

	@Override
	public String toString() {
		return "Address [HoNo=" + HoNo + ", street=" + street + ", area=" + area + ", state=" + state + ", landmark="
				+ landmark + "]";
	}
	
	
	
	

}
