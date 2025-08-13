package pahana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pahana.dao.ProductDao;
import pahana.model.Product;


/*@WebServlet("/deleteProduct")*/
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteProduct() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product prod = new Product();
		prod.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		ProductDao dao = new ProductDao();
		dao.deleteCustomer(prod);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewProduct");
		dispatcher.forward(request, response);
	}

}
