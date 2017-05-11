package com.Tournevice.Servlet;

import com.Tournevice.Bean.User;
import com.Tournevice.Controller.AccountController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mercier on 25/04/2017.
 */
@WebServlet(name = "Account")
public class Account extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // treat modifications
        AccountController ac = new AccountController();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setAddr(request.getParameter("addr"));
        user.setAddr2(request.getParameter("addr2"));
        user.setPhone(request.getParameter("phone"));
        user.setCity(request.getParameter("city"));
        user.setZipCode(request.getParameter("zipCode"));
//        user.getState(request.getParameter("state"));
        // comment lol

        try {
            ac.UpdateUser(user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("User") != null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/notAuthorised.jsp").forward(request, response);
        }
    }
}