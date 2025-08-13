package pahana.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.CustomerDao;
import pahana.model.Customer;


//@WebServlet("/viewCustomer")
public class viewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public viewCustomer() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao custs= new CustomerDao();
		ArrayList<Customer> customerss = custs.getAllCustomers();
		request.setAttribute("customerList", customerss);
	
		RequestDispatcher dispacher = request.getRequestDispatcher("customers.jsp");
		dispacher.forward(request, response);
		
	}

}
