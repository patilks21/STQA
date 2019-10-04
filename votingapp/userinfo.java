package votingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userinfo {
	
	boolean addnew(String name,String email,String password,String age,String status) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tecob230","root","mysql");
		Statement stm=con.createStatement();
		String sql="insert into voter values('"+name+"','"+email+"','"+password+"','"+age+"','"+status+"');";
		boolean b= stm.execute(sql);
		return b;
	}
	boolean passval(String email,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String em="";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tecob230","root","mysql");
		Statement stm=con.createStatement();
		String sql="select password from voter where email='"+email.trim()+"';";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			em=rs.getString("password").trim();
		}
		
		if(em.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	boolean ageval(String email) throws ClassNotFoundException, SQLException
	{
		
		String ag="";
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tecob230","root","mysql");
		Statement stm=con.createStatement();
		String sql="select age from voter where email='"+email.trim()+"';";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			ag=rs.getString("age");
		}
		int a=Integer.parseInt(ag);
		if(a>=18)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	boolean statusval(String email) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		String stat="";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tecob230","root","mysql");
		Statement stm=con.createStatement();
		String sql="select status from voter where email='"+email.trim()+"';";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			stat=rs.getString("status").trim();
		}
		if(stat.equals("no"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
