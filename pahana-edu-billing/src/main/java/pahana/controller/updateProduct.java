package pahana.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.ProductDao;
import pahana.model.Product;


/*@WebServlet("/updateProduct")*/
public class updateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public updateProduct() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product pro = new Product();

	    
	    String productIdStr = request.getParameter("productId");
	    String name = request.getParameter("name");
	    String priceStr = request.getParameter("price");
	    String quantityStr = request.getParameter("quantity");
	    String description = request.getParameter("description");

	    if (productIdStr == null || name == null || priceStr == null || quantityStr == null || description == null) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
	        return;
	    }

	    try {
	        
	        int productId = Integer.parseInt(productIdStr.trim());
	        pro.setProductId(productId);

	       
	        pro.setName(name.trim());

	        
	        double price = Double.parseDouble(priceStr.trim());
	        pro.setPrice(price);

	        
	        int quantity = Integer.parseInt(quantityStr.trim());
	        pro.setQuantity(quantity);

	       
	        pro.setDescription(description.trim());

	       
	        ProductDao dao = new ProductDao();
	        dao.updateProduct(pro); 

	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewProduct");
	        dispatcher.forward(request, response);
	    } catch (NumberFormatException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format for product ID, price, or quantity");
	    } catch (SQLException e) {
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred while updating product");
	        e.printStackTrace(); 
	    } catch (Exception e) {
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while updating the product");
	        e.printStackTrace(); 
	    }
	}

}
