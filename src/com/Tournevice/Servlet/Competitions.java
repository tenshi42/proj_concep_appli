package com.Tournevice.Servlet;

import com.Tournevice.Controller.CompetitionsController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by quent on 25/04/2017. c
 */
@WebServlet(name = "Competitions")
public class Competitions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompetitionsController cc = new CompetitionsController();
        ArrayList<String[]> championshit = new ArrayList<String[]>();
        try {
            championshit = cc.GetChampionship();

            } catch (Exception e1) {
            e1.printStackTrace();
        }
        request.setAttribute("championshit",championshit);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Competitions.jsp").forward(request, response);

    }
}
