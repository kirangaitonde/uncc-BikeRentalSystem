package controller;

import business.Product;
import data.ProductDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author K G
 */
public class CatalogController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println(getPrincipal().getUserName());
        String requestURI = request.getRequestURI();
        String productCode = request.getParameter("productCode");
        ProductDB pDB = new ProductDB();
        String url;
        List<Product> productList = new ArrayList<Product>();

        if (productCode != null) {
            request.setAttribute("product", pDB.getProduct(productCode));
            url = "/item.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);

        } else {
            productList = ProductDB.getAllProducts();
            request.setAttribute("productList", productList);
            url = "/index.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }

    }
}
