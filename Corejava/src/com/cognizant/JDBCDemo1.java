package com.cognizant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

//import com.mysql.jdbc.Statement;




public class JDBCDemo1 {

	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String input;
		sc = new Scanner(System.in);
		System.out.println("Enter the table name");
		
		input=sc.next();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		Statement stmt =conn.createStatement();
		String a = "SELECT * FROM "+input;
		ResultSet rs=stmt.executeQuery(a);
		ResultSetMetaData d=(ResultSetMetaData) rs.getMetaData();
		int g=d.getColumnCount();
		for(int i=1;i<=g;i++)
		{
			System.out.print(d.getColumnName(i)+"\t");
		}
		
		while(rs.next()) {
			for(int i=1;i<=g;i++)
		{
			System.out.print(rs.getString(i)+"\t" );
		}
			System.out.println();
		}
		rs.close();
		stmt.close();
		conn.close();
		
		

	}

}
