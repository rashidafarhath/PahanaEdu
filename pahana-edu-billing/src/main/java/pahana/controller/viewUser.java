package pahana.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.UserDao;
import pahana.model.User;


//@WebServlet("/viewUser")
public class viewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public viewUser() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao users= new UserDao();
		ArrayList<User> userr = users.getAllUsers();
		request.setAttribute("userList", userr);
	
		RequestDispatcher dispacher = request.getRequestDispatcher("cashiers.jsp");
		dispacher.forward(request, response);
	}

}
