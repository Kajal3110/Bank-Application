package com.bankApp;

import java.util.Scanner;

import com.bankApp.dao.BankEmployeeOperations;

public class App 
{
    public static void main( String[] args )
    {
    	boolean status=true;
    	try
    	{
    		do
    		{
        Scanner scan=new Scanner(System.in);
        System.out.println("=======================================================================");
        System.out.println("                            Welcome to XYZ bank                        ");
        System.out.println("=======================================================================");
        System.out.println("1 -> Bank Employee");
        System.out.println("2 -> Bank User");
        System.out.println("Enter your account type:");
        int userType=scan.nextInt();
        
        if(userType==1)
        {
        	
        	System.out.println("Enter your Employee id:");
        	int eid=scan.nextInt();
        	System.out.println("Enter Password:");
        	String password=scan.next();
        	
        	BankEmployeeOperations ob=new BankEmployeeOperations();
        	//System.out.println(ob.login(eid, password));
        	if(ob.login(eid, password))
        	{
                System.out.println("=======================================================================");
        		System.out.println("Login successfull!!");
                System.out.println("=======================================================================");
        		System.out.println("1.Open Account\r\n"
        				+ "2.Delete Account\r\n"
        				+ "3.Check UserInfo\r\n"
        				+ "4.Password Change\r\n"
        				+ "5.Logout");
        		int op=scan.nextInt();
        	if(op==1)
        	{
        		System.out.println("Enter account Id for the new user:");
        		long acid=scan.nextLong();
        		System.out.println("Enter account Holder name:");
        		String accname=scan.nextLine();
        		System.out.println("Enter account Holder address:");
        		String accaddress=scan.nextLine();
        		System.out.println("Enter phone number:");
        		long phone=scan.nextLong();
        		System.out.println("Enter valid email id:");
        		String email=scan.nextLine();
        		System.out.println("Enter initial balance :");
        		double balance=scan.nextDouble();
        		System.out.println("Set Password for the new user :");
        		String pass=scan.nextLine();
        		ob.openAccount(acid,accname,accaddress,phone,email,balance,pass);
        	}
        		
        		
        	}
        	else
        	{
        		System.out.println("Login unsuccessfull!!");
        	}
        	
        	
        }
        else if(userType==2)
        {
        	System.out.println("Enter your user id:");
        	int uid=scan.nextInt();
        	System.out.println("Enter Password:");
        	String password=scan.nextLine();
        }
        else
        {
        	System.out.println("Please provide a valid input..!!");
        }
      }
    		while(status);		
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
        
        
        
    }
}
