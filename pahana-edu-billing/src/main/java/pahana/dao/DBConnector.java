package pahana.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
		
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/pahanaedu";
	private static DBConnector instance;
	private Connection connection;
		
	private DBConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/pahanaedu";
			String username ="root";
			String password = "mysql2001";
			this.connection = DriverManager.getConnection(url, username , password);
		} catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
		}
	}
		
	public static DBConnector getInstance(){
		if(instance ==null){
			synchronized (DBConnector.class) {
			if(instance == null){
				instance = new DBConnector();
			}
			}
		}
		return instance;
	}
	public Connection getConnection() {
	    return connection;
	}

}
