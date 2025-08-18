package pahana.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;
import pahana.model.User;

public class UserDao {
	
	public static boolean addUser(User user) throws SQLException {
        String query = "INSERT INTO cashiers (cashierName, cashierUsername, cashierspassword) VALUES (?, ?, ?)";
        //boolean isSuccess = false;

        try {Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query); {
            statement.setString(1, user.getCashierName());
            statement.setString(2, user.getCashierUsername());
            statement.setString(3, user.getCashierspassword());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }}
             catch (SQLException e) 
 	        {
 	            e.printStackTrace();
 	            return false;
 	        }
	    }
	
	
	public boolean validate(User user) {
		try {
			String query = "SELECT * FROM cashiers where cashierUsername='"+user.getCashierUsername()+"' and cashierspassword='"+user.getCashierspassword()+"' ";
    		
			Connection connection = DBConnectionFactory.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(query);
	         
	         if(resultSet.next()) {
	        	 return true;
	         }
	         
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<User> getAllUsers() {


	    try {	    ArrayList<User> userlist = new ArrayList<>();
	    	    String query = "SELECT * FROM pahanaedu.cashiers";
	    		
	    		Connection connection = DBConnectionFactory.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(query);

	        //System.out.println("Connected to DB: " + connection.getMetaData().getURL());

	        while (resultSet.next()) {
	            User user = new User();
	            user.setCashierId(resultSet.getInt("cashierId"));
	            user.setCashierName(resultSet.getString("cashierName")); 
	            user.setCashierUsername(resultSet.getString("cashierUsername"));
	            user.setCashierspassword(resultSet.getString("cashierspassword"));

	            /*System.out.println("Fetched User: " 
	                + user.getCashierId() + " | " 
	                + user.getCashierName());*/

	            userlist.add(user);
	        }
	        return userlist;}

	     catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }}
	      // always return, even if empty
	

    
    
    public void updateUser(User user) throws SQLException{
    	try {
    		String query = "UPDATE cashiers SET cashierName='"+user.getCashierName()+"',cashierUsername='"+user.getCashierUsername()+"',cashierspassword='"+user.getCashierspassword()+"' where cashierId= '"+user.getCashierId()+"'";
    		Connection connection = DBConnectionFactory.getConnection();
	        Statement statement = connection.createStatement();
    		statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void deleteUser(User user) {
    	try {
			String query ="DELETE from cashiers where cashierId = '"+user.getCashierId()+"'";
			Connection connection = DBConnectionFactory.getConnection();
	        Statement statement = connection.createStatement();
    		statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
