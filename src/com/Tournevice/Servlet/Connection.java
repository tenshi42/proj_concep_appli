package com.Tournevice.Servlet;

import com.Tournevice.Bean.User;
import com.Tournevice.Controller.CompteController;
import com.Tournevice.Controller.ConnectionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mercier on 13/04/2017.
 */
@WebServlet(name = "Connection")
public class Connection extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("mdp");
        ConnectionController cc = new ConnectionController();
        CompteController cc2 = new CompteController();
        if(cc.connection(email, password)){
            User tmpUser = null;
            try {
                tmpUser = cc2.GetUser(email);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession();
            session.setAttribute("User", tmpUser);
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("User");
        response.sendRedirect("/");
    }
}
