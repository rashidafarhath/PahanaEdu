package pahana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.UserDao;
import pahana.model.User;


//@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public deleteUser() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setCashierId(Integer.parseInt(request.getParameter("cashierId")));
		
		UserDao dao = new UserDao();
		dao.deleteUser(user);
		
        request.setAttribute("successMessage", "User deleted successfully!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewUser");
		dispatcher.forward(request, response);
	}

}
