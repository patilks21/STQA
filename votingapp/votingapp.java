package votingapp;

import java.sql.SQLException;
import java.util.Scanner;

public class votingapp {
	Scanner sc=new Scanner(System.in);
	void adduser() throws ClassNotFoundException, SQLException
	{
		userinfo ui=new userinfo();
		String name;
		String email;
		String password;
		String age;
		String status="no";
		System.out.println("Enter Name");
		name=sc.next();
		System.out.println("Enter Email");
		email=sc.next();
		System.out.println("Enter Password");
		password=sc.next();
		System.out.println("Enter Age");
		age=sc.next();
		ui.addnew(name,email,password,age,status);
	}
	void login() throws ClassNotFoundException, SQLException
	{
		userinfo ui=new userinfo();
		votes v=new votes();
		String email;
		String password;
		System.out.println("Enter Email");
		email=sc.next();
		System.out.println("Enter Password");
		password=sc.next();
		if(ui.passval(email,password))
		{
			if(ui.ageval(email))
			{
				if(ui.statusval(email))
				{
					System.out.println("verification successfull enter id to vote");
					System.out.println("1. Candidate 1");
					System.out.println("2. Candidate 2");
					System.out.println("3. Candidate 3");
					System.out.println("4. Candidate 4");
					System.out.println("5. Candidate 5");
					int id=sc.nextInt();
					v.vote(id,email);
					System.out.println("voted successfully");
				}
				else
				{
					System.out.println("You have already voted");
				}
			}
			else
			{
				System.out.println("you are younger to vote");
			}
		}
		else
		{
			System.out.println("Invalid password");
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		votingapp va=new votingapp();
		votes v=new votes();
		//userinfo ui=new userinfo();
		while(true)
		{
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Result");
			System.out.println("4. Exit");
			int c=sc.nextInt();
			switch(c)
			{
			case 1:va.login();
			break;
			case 2:va.adduser();
			break;
			case 3:v.result();
			break;
			case 4:break;
			default:System.out.println("Enter correct input");
			}
		}
		
		

	}

}
