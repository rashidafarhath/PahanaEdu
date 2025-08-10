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
	        String query = "INSERT INTO Product (name, price, quantity, description) VALUES (?, ?, ?, ?)";

	        try 
	        {   Connection connection = DBConnectionFactory.getConnection();
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, product.getName());
	            statement.setDouble(2, product.getPrice());
	            statement.setDouble(3, product.getQuantity());
	            statement.setString(4, product.getDescription());
	            statement.executeUpdate();
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	    }

	    public List<Product> getAllProducts() throws SQLException {
	        List<Product> products = new ArrayList<>();
	        String query = "SELECT * FROM Product";

	        Connection connection = DBConnectionFactory.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) 
	        {
	        	int id = resultSet.getInt("productsId");
	        	String name = resultSet.getString("productsName");
	        	double price = resultSet.getDouble("productPrice");
	        	int quantity = resultSet.getInt("productQuantity");
	        	String desc = resultSet.getString("productDes");
	        	products.add(new Product(id, name, price, quantity, desc));
	        }

	        return products;
	    }
	}



