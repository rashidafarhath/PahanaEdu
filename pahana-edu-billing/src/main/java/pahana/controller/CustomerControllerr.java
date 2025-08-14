package pahana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.CustomerDao;
import pahana.model.Customer;


//@WebServlet("/CustomerControllerr")
public class CustomerControllerr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CustomerControllerr() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message= null;
		Customer cust1=new Customer();

		cust1.setCusname(request.getParameter("customername"));
		cust1.setCusadd(request.getParameter("customeraddress"));
		cust1.setCustel(Integer.parseInt(request.getParameter("customerphone")));
		cust1.setCusunit(Integer.parseInt(request.getParameter("customerunits")));
		
		
		CustomerDao custt = new CustomerDao();
		custt.addCustomer(cust1);
		
		message = "Product successfully added";
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomer");
		dispatcher.forward(request, response);
	}

}
