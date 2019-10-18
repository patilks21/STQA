package votingapp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class userinfoTest {
	votingapp vo = new votingapp();
	userinfo u = new userinfo();
	Scanner sc = new Scanner(System.in);
	
	@Test
	void testaddnew() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Name: ");
		String reqName = sc.next();
		System.out.println("Enter Email: ");
		String reqEmail = sc.next();
		System.out.println("Enter Password: ");
		String reqPass = sc.next();
		System.out.println("Enter Age: ");
		String reqAge = sc.next();
		String status = "no";
		boolean expectedOutput = false;
		boolean addedUser = u.addnew(reqName, reqEmail, reqPass, reqAge, status);	
		assertEquals(expectedOutput,addedUser,"Test Case Failed, Failed To Register");
		
	}

	@Test
	void testPassval() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter Email: ");
		String reqEmail = sc.next();
		System.out.println("Enter Password: ");
		String reqPass = sc.next();
		boolean passChecked = u.passval(reqEmail, reqPass);
		assertTrue("Test Case Failed, Password Incorrect",passChecked);
		
	}

	@Test
	void testAgeval() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Email: ");
		String reqEmail = sc.next();
		boolean ageChecked = u.ageval(reqEmail);
		assertTrue("Test Case Failed, Age is < 18 ",ageChecked);
	}

	@Test
	void testStatusval() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Email: ");
		String reqEmail = sc.next();
		boolean expectedOutput = false;
		boolean statusChecked = u.ageval(reqEmail);
		assertEquals(expectedOutput, statusChecked,"Test Case Failed, Voter Already Voted");
		
	}

}
