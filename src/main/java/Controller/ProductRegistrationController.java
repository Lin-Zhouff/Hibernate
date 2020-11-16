package Controller;
import DAO.ProductsDAO;
import DAO.ProductsDAOImpl;
import Model.Products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/register")
public class ProductRegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductsDAO productsDao = ProductsDAOImpl.getInstance();

    public ProductRegistrationController() {
        // Do Nothing
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");


        Products products = new Products(name, price);

        if (productId == null || productId == "")
            productsDao.saveProduct(products);
        else {
            int id = Integer.parseInt(productId);
            products.setId(id);
            productsDao.updateProduct(products);
        }

        response.sendRedirect(request.getContextPath() + "/");
    }
}
