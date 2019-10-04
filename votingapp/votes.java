package votingapp;
import java.sql.*;
public class votes {
	void result() throws ClassNotFoundException, SQLException
	{
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tecob230","root","mysql");
		Statement stm=con.createStatement();
		String sql="select * from votes;";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getString("name")+"   "+rs.getString("count"));
		}
	}
	int vote(int i,String email) throws SQLException, ClassNotFoundException
	{
		String inic="";
		String name="Candidate "+Integer.toString(i);
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tecob230","root","mysql");
		Statement stm=con.createStatement();
		String sql="select count from votes where name='"+name+"';";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			inic=rs.getString("count");
		}
		int newc=1+Integer.parseInt(inic);
		String n=Integer.toString(newc);
		String sql1="update votes set count='"+n+"' where name='"+name+"';";
		int r=stm.executeUpdate(sql1);
		String s="yes";
		String sql2="update voter set status='"+s+"' where email='"+email+"';";
		stm.executeUpdate(sql2);
		return r;
	}

}
