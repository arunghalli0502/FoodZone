package com.foodzone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FoodOrders 
{
	Scanner sc = new Scanner(System.in);

	Foodlist f1= new Foodlist("jira rice", "veg", 50.0);
	Foodlist f2= new Foodlist("Pulav", "veg", 30.0);
	Foodlist f3= new Foodlist("Chiken Biriyani", "Non-veg", 250.0);
	Foodlist f4= new Foodlist("Chiken 65", "Non-veg", 90.0);
	Foodlist f5= new Foodlist("Nir dose", "veg", 35.0);
	Foodlist f6= new Foodlist("Fish curry", "Non-veg", 150.0);
	Foodlist f7= new Foodlist("Puri", "veg", 40.0);
	
	HashMap<Integer, Foodlist> Foodlst= new HashMap<Integer, Foodlist>();
	{
		Foodlst.put(1, f1);
		Foodlst.put(2, f2);
		Foodlst.put(3, f3);
		Foodlst.put(4, f4);
		Foodlst.put(5, f5);
		Foodlst.put(6, f6);
		Foodlst.put(7, f7);
	}
	List<Foodlist> flst= new ArrayList<Foodlist>(Foodlst.values());
	
	public  void food(String type)
	{
		boolean ordermore= true;
		ArrayList<Integer> orderfl= new ArrayList<Integer>();
		
		if(type.equals("veg"))
		{
			while(ordermore)
			{
				System.out.println("Select food items  \n");
				
				for(int y=1; y<flst.size(); y++) //---------------**************************************
				{
					if(flst.get(y).getType().equals("veg"))
					{
						System.out.println(y+". "+  flst.get(y).getName() +"  "+flst.get(y).getPrice());
					}
				}
				int orderedfoodID= sc.nextInt();
				orderfl.add(orderedfoodID);
				System.out.println("Do you want ot order more? yes/no :");
				String s=sc.next();
				if(s.equals("yes"))
				{
					ordermore= true;
				}
				else
				{
					ordermore= false;
				}
			}
			System.out.println("\n");
			
			
			
			Map<String, Double> fp= finalprice(orderfl);

			System.out.println("Confirm us to procede further: yes/no ");
			String s2=	sc.next();
			
			
			if(s2.equals("yes"))
			{
				Address ordradd = roderaddress();
				if(ordradd!= null)
				{
					System.out.println("Select the Payment mode\n"
							+"1. CashOn Delivery \n  2. Debit Card \n");
					System.out.println("Enter the payment option");
					Scanner scan= new Scanner(System.in);
					int paymentoption= scan.nextInt();
					switch(paymentoption)
					{
						case 1: {
									System.out.println("CashOn Delivery selected");
									float discount=0;
									if(fp.get("finalPrice")>300)
									{
										System.out.println("Congratualzation you got 3% of discount");
										discount=3;
									}else if(fp.get("finalPrice")>3000)
									{
										{
											System.out.println("Congratualzation you got 9% of discount");
											discount=9;
										}
									}
									fp.put("finalPrice", (fp.get("finalPrice")*(discount/100)));
									System.out.println("Total Payable amount is: "+fp.get("finalPrice")+"\n payments Status : Pending(COD)");
								};
								break;
						case 2:{
									boolean repeate=true;
									System.out.println("Debit Card selected");
									float discount=0;
									if(fp.get("finalPrice")>300)
									{
										System.out.println("Congratualzation you got 4% of discount");
										discount=3;
									}else if(fp.get("finalPrice")>3000)
									{
										{
											System.out.println("Congratualzation you got 11% of discount");
											discount=9;
										}
									}
									
									System.out.println("Total Food price is: -->  "+fp.get("finalPrice"));
									
									if(discount>0)
									{
										fp.put("finalPrice", (fp.get("finalPrice")*(discount/100)));
									}
									System.out.println("Total Payable amount is: "+fp.get("finalPrice"));

								while(repeate==true)
								{
									System.out.println("Please Enter the Card details");
									System.out.println("Enter the 16 digit card number");
									Scanner sc= new Scanner(System.in);
									long cardno= sc.nextLong();
									
									System.out.println("Enter the cvv number");
									Scanner sc1= new Scanner(System.in);
									int cvv= sc1.nextInt();
									
									
									
									System.out.println("\n");
									
									
									if((cardno+"").length()==16 && (cvv+"").length()==3)
									{
										repeate=false;
										DebitCard dbc= new DebitCard();
										dbc.setCardnumber(cardno);
										dbc.setCvv(cvv);
										List<DebitCard> dbclist= new ArrayList<DebitCard>();
										dbclist.add(dbc);
										System.out.println("Please wait a momment, transaction being proceding.....\n"
												+ "***** Payment successful *****\n"
												+ "Orderplaced Succesfully................................\n"
												+ "@@@@@@@@@@@@@@@---- Thank you, Visit again ----@@@@@@@@@@@@@@@");
										break;
										
									}
									else
									{
										System.out.println("please enter valid details");
										repeate=true;
									}
								}
									
							   }
								break;
						default: System.out.println("Invalid option...!!!!!!!!!!!");
								break;
					}
					
				}
			}
			else
			{
				System.out.println("order Again");
				orderfl.removeAll(orderfl);
				food(type);
			}
		}
		else
		{
			while(ordermore)
			{
				System.out.println("Select Non-veg food items  \n");
				
				for(int i=1; i<flst.size(); i++) //---------------**************************************
				{
					if(flst.get(i).getType().equals("Non-veg"))
					{
						System.out.println(i+". "+  flst.get(i).getName() +"  "+flst.get(i).getPrice());
					}
				}
				int orderedfoodID= sc.nextInt();
				orderfl.add(orderedfoodID);
				System.out.println("Do you want ot order more? yes/no :");
				String s=sc.next();
				if(s.equals("yes"))
				{
					ordermore= true;
				}
				else
				{
					ordermore= false;
				}
			}
			System.out.println("\n");
			
			Map<String, Double> fp=finalprice(orderfl);
			
			System.out.println("Confirm us to procede further: yes/no ");
			String s2=	sc.next();
			if(s2.equals("yes"))
			{
				Address ordradd = roderaddress();
				if(ordradd!= null)
				{
					System.out.println("Select the Payment mode\n"
							+"1. CashOn Delivery \n  2. Debit Card \n");
					Scanner sc3= new Scanner(System.in);
					int paymentoption= sc3.nextInt();
					switch(paymentoption)
					{
						case 1: {
									System.out.println("CashOn Delivery selected");
									float discount=0;
									if(fp.get("finalPrice")>300)
									{
										System.out.println("Congratualzation you got 3% of discount");
										discount=3;
									}else if(fp.get("finalPrice")>3000)
									{
										{
											System.out.println("Congratualzation you got 9% of discount");
											discount=9;
										}
									}
									fp.put("finalPrice", (fp.get("finalPrice")*(discount/100)));
									System.out.println("Total Payable amount is: "+fp.get("finalPrice")+"\n payments Status : Pending(COD)");
								}
								break;
						case 2:{
									boolean repeate=true;
									System.out.println("Debit Card selected");
									float discount=0;
									if(fp.get("finalPrice")>300)
									{
										System.out.println("Congratualzation you got 4% of discount");
										discount=3;
									}else if(fp.get("finalPrice")>3000)
									{
										{
											System.out.println("Congratualzation you got 11% of discount");
											discount=9;
										}
									}
									fp.put("finalPrice", (fp.get("finalPrice")*(discount/100)));
									System.out.println("Total Payable amount is: "+fp.get("finalPrice"));

								while(repeate==true)
								{
									System.out.println("Please Enter the Card details");
									System.out.println("Enter the 16 digit card number");
									Scanner sc4= new Scanner(System.in);
									long cardno= sc4.nextLong();
									
									System.out.println("Enter the cvv number");
									int cvv= sc4.nextInt();
									
									if((cardno+"").length()==16 && (cvv+"").length()==3)
									{
										repeate=false;
										DebitCard dbc= new DebitCard();
										dbc.setCardnumber(cardno);
										dbc.setCvv(cvv);
										List<DebitCard> dbclist= new ArrayList<DebitCard>();
										dbclist.add(dbc);
										System.out.println("Please wait a momment, transaction being proceding.....\n"
												+ "***** Payment successful *****\n"
												+ "Orderplaced Succesfully................................\n"
												+ "@@@@@@@@@@@@@@@---- Thank you, Visit again ----@@@@@@@@@@@@@@@");
										
									}
									else
									{
										System.out.println("please enter valid details");
										repeate=true;
									}
								}
									
							   }
								break;
						default: System.out.println("Invalid option...!!!!!!!!!!!");
					}
					
				}
			}
			else
			{
				System.out.println("order Again");
				orderfl.removeAll(orderfl);
				food(type);
			}
			
		}
	}

	public Map<String, Double> finalprice(List<Integer> orderedfood)
	{		
		Map<String, Double> fp=  new HashMap<String, Double>();
		double toatalprice= 0.0;
				
		for(Integer obj : orderedfood)
			
		{
			System.out.println("\n Ordered food prices:----------------"
					+ flst.get(obj).getPrice());
			toatalprice= toatalprice+ (flst.get(obj).getPrice());
		}

		double gst= toatalprice*0.12;
		double finalPrice=gst+toatalprice;
		
		fp.put("toatalprice", toatalprice);
		fp.put("gst", gst);
		fp.put("finalPrice", finalPrice);
		
		System.out.println(
				"Please find the bill here "
				+ "\n toatalprice :  "+fp.get("toatalprice")
				+ "\n gst         :  "+fp.get("gst")
				+ "\n finalPrice  :  "+fp.get("finalPrice"));
		
		
		
		return fp;
	}
	
	
	
	public Address roderaddress()
	{
		System.out.println("Please Enter the Devlivery Address\n");
		
		System.out.println("Enter house No: ");
		String houseno= sc.next();
		
		System.out.println("Enter Street: ");
		String street= sc.next();
		
		System.out.println("Enter area: ");
		String area= sc.next();
		
		System.out.println("Enter state: ");
		String state= sc.next();
		
		System.out.println("Enter landmark: ");
		String landmark= sc.next();
		
		Address add= new Address();
		add.setArea(area);
		add.setHoNo(houseno);
		add.setState(state);
		add.setStreet(street);
		
		return add;
	}
	
}

