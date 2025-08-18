package pahana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.CustomerDao;
import pahana.model.Customer;



//@WebServlet("/deleteCustomer")
public class deleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleteCustomer() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer cus = new Customer();
		cus.setCusId(Integer.parseInt(request.getParameter("customerId")));
		
		CustomerDao dao = new CustomerDao();
		dao.deleteCustomer(cus);
		
        request.setAttribute("successMessage", "Customer deleted successfully!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomer");
		dispatcher.forward(request, response);
	}

}
