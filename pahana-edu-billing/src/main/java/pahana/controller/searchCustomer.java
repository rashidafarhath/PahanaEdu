package pahana.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.CustomerDao;
import pahana.model.Customer;


//@WebServlet("/searchCustomer")
public class searchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchCustomer() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerTel = (Integer.parseInt(request.getParameter("customerTel")));

        CustomerDao customerDAO = new CustomerDao();
        try {
            Customer customer = customerDAO.getByTel(customerTel);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            if (customer != null) {
                out.print("Customer account found: " + customer.getCusname());
            } else {
                out.print("Customer not found");
            }
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().print("Database error: " + e.getMessage());
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int customerTel = (Integer.parseInt(request.getParameter("productquantity")));

        CustomerDao customerDAO = new CustomerDao();
        try {
            Customer customer = customerDAO.getByTel(customerTel);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            if (customer != null) {
                out.print("Customer account found: " + customer.getCusname());
            } else {
                out.print("Customer not found");
            }
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().print("Database error: " + e.getMessage());
        }
	}

}
