package pahana.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import pahana.dao.UserDao;
import pahana.model.User;


//@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    String username = request.getParameter("Username");
	    String password = request.getParameter("password");
	    
	    if("admin".equals(username) && "admin009".equals(password)) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("adminhome.jsp");
	        dispatcher.forward(request, response);
	        return; 
	    }
	    User user = new User();
	    
	    user.setCashierUsername(username);
	    user.setCashierspassword(password);
	    
		
		UserDao userr = new UserDao();
		boolean status = userr.validate(user);
		
		if(status) {
			RequestDispatcher dispatcher= request.getRequestDispatcher("cashierhome.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("successMessage", "Errr! Incorrect Input.");
			RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}

}
