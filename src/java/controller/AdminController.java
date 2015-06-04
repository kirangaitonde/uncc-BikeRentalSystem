/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.ProductDB;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author K G
 */
public class AdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String updatePrice = request.getParameter("updatePrice");
        String selectedProductForPrice = request.getParameter("selectedProductForPrice");
        String productPrice = request.getParameter("productPrice");
        String addDiscount = request.getParameter("addDiscount");
        String selectedProductForDiscount = request.getParameter("selectedProductForDiscount");
        String discountValue = request.getParameter("discountValue");
        String successMsg;
        String url;
        if (updatePrice != null) {
            if (updatePrice.equals("updatePrice")) {
                double price = Double.parseDouble(productPrice);
                ProductDB.updateHourlyPrice(selectedProductForPrice, price);

                successMsg = "Price updated!!";
                request.setAttribute("successMsgPrice", successMsg);
                url = "/admin/admin_index.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
            }
        }
        if (addDiscount != null) {
            if (addDiscount.equals("addDiscount")) {
                ProductDB.addDiscount(selectedProductForDiscount, Double.parseDouble(discountValue));
                successMsg = "Discount added!!";
                request.setAttribute("successMsgDiscount", successMsg);
                url = "/admin/admin_index.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);

            }

        }

    }

}
