package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AmazonApplication 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		String DB_URL = "jdbc:mysql://localhost:3306/amazon";
		String user_name = "root";
		String password = "root";
		String query = "select * from products";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection(DB_URL, user_name, password);
		
		Statement stat = connect.createStatement();
		//execution of SQL query:
		ResultSet result = stat.executeQuery(query);
		
		//display results in console
		System.out.println("Products from Amazon DB ->");
		while(result.next())
		{
			System.out.print("Brand: "+result.getString("brand_name"));
			System.out.print("\t");
			System.out.print("Model: "+result.getString("model_name"));
			System.out.print("\t");
			System.out.print("Price: "+result.getString("price"));
			System.out.print("\t");
			System.out.println();
		}
	}
}
