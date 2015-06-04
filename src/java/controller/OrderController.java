/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Cart;
import business.OrderItem;
import business.Orders;
import business.Product;
import business.User;
import data.OrderItemDB;
import data.OrdersDB;
import data.ProductDB;
import data.UserDB;
import email.Email;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author K G
 */
public class OrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url;
        ProductDB pDB = new ProductDB();
        HttpSession session = request.getSession();
        String productCode = request.getParameter("rent");
        String ifUpdate = request.getParameter("upadteCart");
        String ifCheckOut = request.getParameter("checkOut");
        String payment = request.getParameter("confPayment");
        String start = request.getParameter("startTime");
        String end = request.getParameter("endTime");
        String error;
        Cart theShoppingCart;

        if (productCode != null && (start == "" || end == "")) {
            error = "Enter dates properly";
            request.setAttribute("dateError", error);
            request.setAttribute("product", ProductDB.getProduct(productCode));
            url = "/item.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } else if (session.getAttribute("theShoppingCart") != null && productCode != null) {
            System.out.println(session.getAttribute("cartList"));
            theShoppingCart = (Cart) session.getAttribute("theShoppingCart");
            theShoppingCart.addItem(pDB.getProduct(productCode), 1, start, end);
            session.setAttribute("theShoppingCart", theShoppingCart);
            request.setAttribute("cartList", theShoppingCart.getItems());
            url = "/cart.jsp";
            productCode = null;
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } else if (productCode != null && session.getAttribute("theShoppingCart") == null) {
            theShoppingCart = new Cart();
            theShoppingCart.addItem(pDB.getProduct(productCode), 1, start, end);
            session.setAttribute("theShoppingCart", theShoppingCart);
            session.setAttribute("cartList", theShoppingCart.getItems());
            request.setAttribute("cartList", theShoppingCart.getItems());
            url = "/cart.jsp";
            productCode = null;
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } else if (ifUpdate != null && ifUpdate.equals("upadteCart") && productCode == null) {
            ArrayList<OrderItem> orderitems = new ArrayList<OrderItem>();
            ArrayList<Product> deleteProducts = new ArrayList<Product>();
            theShoppingCart = (Cart) session.getAttribute("theShoppingCart");
            orderitems = theShoppingCart.getItems();

            for (OrderItem o : orderitems) {
                String pc = o.getProduct().getProductCode();
                int a = Integer.parseInt(request.getParameter(pc));
                if (request.getParameter(pc) == null) {
                    int quant = o.getQuantity() + 1;
                    theShoppingCart.addItem(o.getProduct(), quant, start, end);
                }
                if (a != o.getQuantity()) {
                    if (a < 1) {
                        deleteProducts.add(o.getProduct());
                    } else {
                        theShoppingCart.updateItem(o.getProduct(), a);
                    }
                }
            }
            for (Product p : deleteProducts) {
                theShoppingCart.removeItem(p);
            }
            session.setAttribute("theShoppingCart", theShoppingCart);
            request.setAttribute("cartList", theShoppingCart.getItems());
            url = "/cart.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } else if (ifCheckOut != null && ifCheckOut.equals("checkOut") && productCode == null) {
            if (request.getRemoteUser() != null) {
                url = "/customer/order.jsp";
            } else {
                url = "/checkoutChoice.jsp";
            }
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } else if (payment != null && payment.equals("confPayment")) {
            Orders order = (Orders) session.getAttribute("currentOrder");
            Cart cart = (Cart) session.getAttribute("theShoppingCart");
            List<OrderItem> orderItems = cart.getItems();
            order.setPaid(true);
            OrdersDB.addOrders(order);
            OrderItemDB.addOrderItems(orderItems, OrdersDB.getCurrentOrderNumber());
            Email.sendMail(request.getRemoteUser(), cart, order);
            session.removeAttribute("theShoppingCart");
            session.removeAttribute("cartList");
            url = "/customer/payment_success.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } else {
            if (session.getAttribute("theShoppingCart") == null) {
                theShoppingCart = new Cart();
                theShoppingCart.addItem(pDB.getProduct(productCode), 1, start, end);
                session.setAttribute("theShoppingCart", theShoppingCart);
                session.setAttribute("cartList", theShoppingCart.getItems());
                request.setAttribute("cartList", theShoppingCart.getItems());
                url = "/cart.jsp";
                productCode = null;
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url;
        String orderNumber = request.getParameter("orderNumber");
        if (orderNumber != null) {
            request.setAttribute("orderNumber", orderNumber);
            url = "/customer/invoice.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);

        }

    }

}
