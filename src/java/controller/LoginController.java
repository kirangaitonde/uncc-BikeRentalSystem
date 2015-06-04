/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.User;
import data.UserDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author K G
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String logout = request.getParameter("logout");
        String loginMain = request.getParameter("loginMain");
        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");
        String error;
        String url;
        if (logout != null) {
            if (logout.equals("logout")) {
                request.logout();
                url = "/index.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
            }
        }
        if (loginMain != null) {
            if (loginMain.equals("loginMain")) {
                if (uname == "" || pwd == "") {
                    error = "Fields cannont be empty";
                    request.setAttribute("error", error);
                    url = "/index.jsp";
                    getServletContext()
                            .getRequestDispatcher(url)
                            .forward(request, response);
                } else if (UserDB.getUser(uname) == null) {
                    error = "Email id not registered";
                    request.setAttribute("error", error);
                    url = "/index.jsp";
                    getServletContext()
                            .getRequestDispatcher(url)
                            .forward(request, response);
                } else {
                    if (!UserDB.getUser(uname).getPassword().equals(pwd)) {
                        error = "Wrong password";
                        request.setAttribute("error", error);
                        url = "/index.jsp";
                        getServletContext()
                                .getRequestDispatcher(url)
                                .forward(request, response);

                    } else {
                        request.login(uname, pwd);
                        url = "/index.jsp";
                        getServletContext()
                                .getRequestDispatcher(url)
                                .forward(request, response);
                    }
                }

            }

        }
    }

}
