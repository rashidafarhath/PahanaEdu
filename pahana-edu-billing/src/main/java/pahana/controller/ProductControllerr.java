package pahana.controller;
import pahana.dao.ProductDao;
import pahana.model.Product;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class ProductControllerr
 */

public class ProductControllerr extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductControllerr() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= null;
			Product product1=new Product();
			product1.setName(request.getParameter("productname"));
			product1.setPrice(Double.parseDouble(request.getParameter("productprice")));
			product1.setQuantity(Integer.parseInt(request.getParameter("productquantity")));
			product1.setDescription(request.getParameter("productdes"));
			
			ProductDao productt = new ProductDao();
			productt.addProduct(product1);
			
			message = "Product successfully added";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewProduct");
			dispatcher.forward(request, response);

	}

}
