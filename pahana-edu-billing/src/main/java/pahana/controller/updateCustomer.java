package pahana.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.CustomerDao;
import pahana.model.Customer;


//@WebServlet("/updateCustomer")
public class updateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public updateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer cus = new Customer();

	    
	    String customerIdStr = request.getParameter("customerId");
	    String customernameStr = request.getParameter("customername");
	    String custaddStr = request.getParameter("customeraddress");
	    String cusTelStr = request.getParameter("customerphone");
	    String cusUnitStr = request.getParameter("customerunits");


	    if (customerIdStr == null || customernameStr == null || custaddStr == null || cusTelStr == null || cusUnitStr == null) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
	        return;
	    }

	    try {
	        
	        int custId = Integer.parseInt(customerIdStr.trim());
	        cus.setCusId(custId);

	       
	        cus.setCusname(customernameStr.trim());

	        cus.setCusadd(custaddStr.trim());
	        
	        int cusTellStr = Integer.parseInt(cusTelStr.trim());
	        cus.setCustel(cusTellStr);

	       
	        int cusUnit = Integer.parseInt(cusUnitStr.trim());
	        cus.setCusunit(cusUnit);

	       
	        CustomerDao dao = new CustomerDao();
	        dao.updateCustomer(cus); 

	        request.setAttribute("successMessage", "Customer updated successfully!");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomer");
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
