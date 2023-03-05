package com.foodzone;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class login 
{
	
	Scanner sc= new Scanner(System.in);
	User u1= new User("vani", "shree", "vani@gmail.com", "vani123", 12345678l);
	HashMap<String, User> datab= new HashMap<String, User>();
	{
		datab.put(u1.getEmail(), u1);
	}

	
	Hotel h1= new Hotel("Taj");
	Hotel h2= new Hotel("Ullas");
	Hotel h3= new Hotel("Vijay");
	Hotel h4= new Hotel("Ganesh");
	Hotel h5= new Hotel("Darshan");
	
	HashMap<Integer, Hotel> hotel= new HashMap<Integer, Hotel>();
	{
		hotel.put(1, h1);
		hotel.put(2, h2);
		hotel.put(3, h3);
		hotel.put(4, h4);
		hotel.put(5, h5);
		
	}
	
	
	
	public  void Login(String username, String password)
	{
		boolean hotelpresent=false;
		if(datab.containsKey(username))
		{
			if(datab.get(username).getPassword().equals(password))
			{
				System.out.println("Login successful.....\n Enter the hotel to serch ...");
				String htlname = sc.next();
				
				
				List<Hotel> dhtl= new ArrayList<Hotel>(hotel.values());				
				for(int i=0; i<dhtl.size(); i++)
				{
					if(dhtl.get(i).getHotelname().equals(htlname))
					{
						hotelpresent=true;
					}
				}
				if( hotelpresent )
				{
					System.out.println("Select option    \n 1. Veg   \n2.Non-Veg");
					int options= sc.nextInt();
					switch(options)
					{
					case 1: {
								FoodOrders fodrdr= new FoodOrders();
								fodrdr.food("veg");
							}
					case 2:{

								FoodOrders fodrdr= new FoodOrders();
								fodrdr.food("Non-veg");
						   }
					}
					
				}
				else
				{
					System.out.println("No Result found..... \n Please find the below hotel");									
					for(int i=1; i<dhtl.size();i++)
					{
						System.out.println(i+". "+dhtl.get(i));
					}
				}				
			}
		}
		else
		{
			System.out.println("Invalid credential");
		}
		
	
		
	}
}
