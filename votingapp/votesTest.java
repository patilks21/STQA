package votingapp;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class votesTest {
	userinfoTest u = new userinfoTest();
	votes v = new votes();
	Scanner sc = new Scanner(System.in);
	
	@Test
	void testResult() throws ClassNotFoundException, SQLException {
		int access = v.result();
		assertEquals(1, access,"Test Case Failed, Unable to Access Database");
	}

	@Test
	void testVote() throws ClassNotFoundException, SQLException {
		System.out.println("Enter The Candidate Number: ");
		int canNo = sc.nextInt();
		int flag = 0;
		if(canNo > 0 && canNo < 6)
			flag = 1;
		assertEquals(1,flag,"Test Case Failed, No Such Candidate in List");
	
	}

}
