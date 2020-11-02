package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	
	private static Connection connection;
	
	//quand une class est charge au memoire le premier bloc qui va s'executer
	//c'est le bloc static(Pour creer un objet une seul fois)
	static {
		try {
		     Class.forName("com.mysql.jdbc.Driver");
		     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeproduit", "root", "");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static Connection  getConnection() {
		return connection;
	}
	

}
