package com.foodzone;

import java.util.Scanner;

public class MainFoodzone {

	public static void main(String[] args) 
	{
		System.out.println("Food Zone app started.....");
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to our app.....\n Seelct the Option below   \n  1.Login \n 2. SignUp \n ");
		int x= sc.nextInt();
		switch(x)
		{
			case 1: {
						System.out.println("Enter mobile number or email id");
						String username= sc.next()+"";
						System.out.println("Enter password...");
						String password= sc.next();
						
						login l= new login();
						l.Login(username, password);
					}; break;
					
			case 2: {
						login l= new login();
						l.signUp();
					}; break;
			default: System.out.println("Invalid Option");
		}
		

	}

}
