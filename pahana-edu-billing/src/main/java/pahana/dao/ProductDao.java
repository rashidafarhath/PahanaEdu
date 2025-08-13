package pahana.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pahana.model.Product;
public class ProductDao {




		public void addProduct(Product product) {
	        String query = "INSERT INTO products (productsName, productPrice, productQuantity, productDes) VALUES (?, ?, ?, ?)";

	        try 
	        {   Connection connection = DBConnectionFactory.getConnection();
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, product.getName());
	            statement.setDouble(2, product.getPrice());
	            statement.setInt(3, product.getQuantity());
	            statement.setString(4, product.getDescription());
	            statement.executeUpdate();
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	    }

	    public ArrayList<Product> getAllProducts() {
	    	
	    	try {ArrayList<Product> listproducts = new ArrayList<Product>();
	    	String query = "SELECT * FROM products";
	    	
	        Connection connection = DBConnectionFactory.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) 
	        {
	        	Product pro = new Product();
	        	pro.setProductId(resultSet.getInt("productsId"));
	        	pro.setName(resultSet.getString("productsName"));
	        	pro.setPrice(resultSet.getDouble("productPrice"));
	        	pro.setQuantity(resultSet.getInt("productQuantity"));
	        	pro.setDescription(resultSet.getString("productDes"));

	        	listproducts.add(pro);
	        	
	        	
	        }
	        return listproducts;
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    		return null;
	    	}
	    	
	    }
	    
	    
	    public void updateProduct(Product product) throws SQLException{
	    	try {
	    		String query = "UPDATE products SET productsName='"+product.getName()+"',productPrice='"+product.getPrice()+"',productQuantity='"+product.getQuantity()+"',productDes='"+product.getDescription()+"' where productsId='"+product.getProductId()+"' ";
	    		Connection connection = DBConnectionFactory.getConnection();
		        Statement statement = connection.createStatement();
	    		statement.executeUpdate(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    public void deleteProduct(Product pro) {
	    	try {
				String query ="DELETE from products where productsId = '"+pro.getProductId()+"'";
				Connection connection = DBConnectionFactory.getConnection();
		        Statement statement = connection.createStatement();
	    		statement.executeUpdate(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}



