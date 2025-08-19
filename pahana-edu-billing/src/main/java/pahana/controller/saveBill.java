package pahana.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import pahana.dao.CustomerDao;
import pahana.dao.ProductDao;
import pahana.model.Customer;




//@WebServlet("/saveBill")
public class saveBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public saveBill() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerTelStr = request.getParameter("customerTel");
        String[] productIds = request.getParameterValues("productIds");
        String[] quantities = request.getParameterValues("quantities");

        if (customerTelStr == null || productIds == null || quantities == null || productIds.length != quantities.length) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("Invalid input");
            return;
        }

        
        int customerTel;
        try {
            customerTel = Integer.parseInt(customerTelStr);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("Invalid phone number");
            return;
        }

        CustomerDao customerDAO = new CustomerDao();
        ProductDao productDAO = new ProductDao();

        try {
            
            Customer customer = customerDAO.getByTel(customerTel);
            if (customer == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().print("Customer not found");
                return;
            }

            int totalUnits = 0;
            for (int i = 0; i < productIds.length; i++) {
                int id = Integer.parseInt(productIds[i]);
                int qty = Integer.parseInt(quantities[i]);
                totalUnits += qty;
                productDAO.updateQuantity(id, qty);
            }
            customerDAO.updateUnits(customerTel, totalUnits);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print("Bill saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().print("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("Invalid product or quantity data");
        }
    }
	}


