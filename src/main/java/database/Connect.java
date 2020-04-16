package database;

import java.sql.*;

import javax.swing.JOptionPane;

public class Connect {

	public Connection con;

	public static Connect connect;

	private Connect(String username,String password) {
		// overriding password
		password = "root";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"oes?serverTimezone=UTC",username,password);
			System.out.println("Connection Established.");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver is not Loaded.");
			System.out.println("Exception : "+e.getMessage());
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Can't connect to server.");
			System.out.println("Connection is not established : "+e.getMessage()+"\n\n"+e);
		}
		
	}

	public static Connect getConnectObject(String username,String password){
		if(connect!=null){
			return connect;
		}
		return new Connect(username,password);
	}
	public static void main(String []args)
	{
		Connect.getConnectObject("root","");
	}

}
