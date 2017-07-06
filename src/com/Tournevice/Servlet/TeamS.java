package com.Tournevice.Servlet;

import com.Tournevice.Bean.Team;
import com.Tournevice.Controller.TeamController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mercier on 06/07/2017.
 */
@WebServlet(name = "TeamS")
public class TeamS extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] requestUrl = request.getRequestURI().split("/");
        TeamController tc = new TeamController();

        if(requestUrl.length == 2) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/View.jsp").forward(request, response);
        }
        else if(requestUrl.length == 3){
            try {
                Team team = tc.GetTeam(Integer.valueOf(requestUrl[2]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/ViewOne.jsp").forward(request, response);
        }
    }
}
