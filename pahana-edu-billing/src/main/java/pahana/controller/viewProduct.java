package pahana.controller;
import pahana.dao.ProductDao;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import pahana.model.Product;

/**
 * Servlet implementation class viewProduct
 */
/*@WebServlet("/viewProduct")*/
public class viewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public viewProduct() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productss= new ProductDao();
		ArrayList<Product> prod = productss.getAllProducts();
		request.setAttribute("productList", prod);
	
		RequestDispatcher dispacher = request.getRequestDispatcher("products.jsp");
		dispacher.forward(request, response);
	}

}
