package pahana.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.ProductDao;
import pahana.dao.UserDao;
import pahana.model.User;


//@WebServlet("/UserController")
public class UserController extends HttpServlet {
	//public UserDao userDao;
	private static final long serialVersionUID = 1L;
	
	

    public UserController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("adduser.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cashierName = request.getParameter("cashierName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match!");
            request.getRequestDispatcher("adduser.jsp").forward(request, response);
            return;
        }

        
        // Create user object
        User user = new User();
        user.setCashierName(cashierName.trim());
        user.setCashierUsername(username.trim());
        user.setCashierspassword(password.trim());;


		UserDao user1 = new UserDao();
		try {
			user1.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("successMessage", "Errr! Something went wrong");
		}
		
        request.setAttribute("successMessage", "User added successfully!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewUser");
		dispatcher.forward(request, response);
        /*try {
            // Attempt to register user
            boolean isRegistered = UserDao.addUser(user); // Fixed: Use instance
            if (isRegistered) 
            {
                request.setAttribute("success", "Registration successful! Please login.");
                request.getRequestDispatcher("viewUser").forward(request, response);
            } else {
                request.setAttribute("error", "Registration failed. Username may already exist.");
                request.getRequestDispatcher("adduser.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // MySQL duplicate entry
                request.setAttribute("error", "Username already exists. Please choose a different username.");
            } else {
                request.setAttribute("error", "Database error occurred. Please try again.");
                e.printStackTrace();
            }
            request.getRequestDispatcher("adduser.jsp").forward(request, response);
        }*/
    }
	}


