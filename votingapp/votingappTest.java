package votingapp;

import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*;
import org.junit.jupiter.api.Test;

class VotingAppTest {
	Scanner sc = new Scanner(System.in);
	@Test
	void testAdduser() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Name: ");
		String name = sc.next();
		Pattern p = Pattern.compile("^[a-zA-Z]*$");
		Matcher m = p.matcher(name);
		boolean output = m.matches();
		assertTrue("Test Case Failed, INVALID FORMAT FOR NAME",output);
	}
}
