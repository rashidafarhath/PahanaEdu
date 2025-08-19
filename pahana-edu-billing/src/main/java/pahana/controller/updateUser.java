package pahana.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pahana.dao.UserDao;
import pahana.model.User;


//@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateUser() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();

	    
	    String userIdStr = request.getParameter("cashierId");
	    String cashiername = request.getParameter("cashierName");
	    String usernameStr = request.getParameter("cashierUsername");
	    String passwordStr = request.getParameter("cashierPassword");

	    if (userIdStr == null || cashiername == null || usernameStr == null || passwordStr == null) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
	        return;
	    }

	    try {
	        
	        int cashierId = Integer.parseInt(userIdStr.trim());
	        user.setCashierId(cashierId);

	       
	        user.setCashierName(cashiername.trim());

	        
	        user.setCashierUsername(usernameStr.trim());

	       
	        user.setCashierspassword(passwordStr.trim());

	       
	        UserDao dao = new UserDao();
	        dao.updateUser(user); 

	        request.setAttribute("successMessage", "User updated successfully!");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewUser");
	        dispatcher.forward(request, response);
	    } catch (SQLException e) {
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred while updating user");
	        e.printStackTrace(); 
	    } catch (Exception e) {
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while updating the user");
	        e.printStackTrace(); 
	    }
	}


}
