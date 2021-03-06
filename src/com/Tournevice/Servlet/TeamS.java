package com.Tournevice.Servlet;

import com.Tournevice.Bean.Stadium;
import com.Tournevice.Bean.Team;
import com.Tournevice.Controller.StadiumController;
import com.Tournevice.Controller.TeamController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<Team> teams = new ArrayList<Team>();

        if(requestUrl.length == 2) {
            try {
                teams = tc.GetTeams();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("teams", teams);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/View.jsp").forward(request, response);
        }
        else if(requestUrl.length == 3){
            Team team = new Team();
            StadiumController sc = new StadiumController();
            String stadiumName = "";
            try {
                team = tc.GetTeam(Integer.valueOf(requestUrl[2]));
                stadiumName = sc.GetStadium(team.getStadiumId()).getName();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("team", team);
            request.setAttribute("stadiumName", stadiumName);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/ViewOne.jsp").forward(request, response);
        }
    }
}
