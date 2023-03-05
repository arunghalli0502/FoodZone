package com.foodzone;

public class Hotel 
{
	private String hotelname;

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	
	public Hotel()
	{
		
	}

	public Hotel(String hotelname) {
		super();
		this.hotelname = hotelname;
	}

	@Override
	public String toString() {
		return "hotelname= " + hotelname ;
	}
	
	
}
