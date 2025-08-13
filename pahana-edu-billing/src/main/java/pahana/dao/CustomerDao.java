package pahana.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pahana.model.Customer;
import pahana.model.Product;



public class CustomerDao {
	
	public void addCustomer(Customer customer) {
        String query = "INSERT INTO customers (customersName, customersAddress, customerTel, customersunits) VALUES (?, ?, ?, ?)";

        try 
        {   Connection connection = DBConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer.getCusname());
            statement.setString(2, customer.getCusadd());
            statement.setInt(3, customer.getCustel());
            statement.setInt(4, customer.getCusunit());

            statement.executeUpdate();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
	
    public ArrayList<Customer> getAllCustomers() {
    	
    	try {ArrayList<Customer> listcust = new ArrayList<Customer>();
    	String query = "SELECT * FROM customers";
    	
        Connection connection = DBConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) 
        {
        	Customer cus = new Customer();
        	cus.setCusId(resultSet.getInt("customersNo"));
        	cus.setCusname(resultSet.getString("customersName"));
        	cus.setCusadd(resultSet.getString("customersAddress"));
        	cus.setCustel(resultSet.getInt("customerTel"));
        	cus.setCusunit(resultSet.getInt("customersunits"));

        	
        	listcust.add(cus);
        	
        	
        }
        return listcust;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	
    }
    
    public void updateCustomer(Customer customer) throws SQLException{
    	try {
    		String query = "UPDATE customers SET customersName='"+customer.getCusname()+"',customersAddress='"+customer.getCusadd()+"',customerTel='"+customer.getCustel()+"',customersunits='"+customer.getCusunit()+"' where customersNo='"+customer.getCusId()+"' ";
    		Connection connection = DBConnectionFactory.getConnection();
	        Statement statement = connection.createStatement();
    		statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void deleteCustomer(Customer cust) {
    	try {
			String query ="DELETE from customers where customersNo = '"+cust.getCusId()+"'";
			Connection connection = DBConnectionFactory.getConnection();
	        Statement statement = connection.createStatement();
    		statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
