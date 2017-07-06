package com.Tournevice.Servlet;

import com.Tournevice.Bean.Stadium;
import com.Tournevice.Bean.Team;
import com.Tournevice.Controller.ChampionshipController;
import com.Tournevice.Controller.StadiumController;
import com.Tournevice.Controller.TeamController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mercier on 05/07/2017.
 */
@WebServlet(name = "Admin")
public class Admin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] requestUrl = request.getRequestURI().split("/");
        ChampionshipController cc = new ChampionshipController();

        System.out.println(String.valueOf(requestUrl.length));

        if(requestUrl.length == 2) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);
        }
        else if(requestUrl.length == 3){
            System.out.println(requestUrl[2]);
        }
        else {
            System.out.println(requestUrl[2]);
            if(requestUrl[2].equals("Team")){
                try {
                    teamDispatcher(requestUrl,request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void teamDispatcher(String[] url, HttpServletRequest request, HttpServletResponse response) throws Exception {
        TeamController tc = new TeamController();
        StadiumController sc = new StadiumController();
        if (url[3].equals("View")){
            ArrayList<Team> teams = tc.GetTeams();
            HashMap<Integer, Stadium> stadiums  = sc.GetStadiums();
            request.setAttribute("teams", teams);
            request.setAttribute("stadiums", stadiums);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/View.jsp").forward(request, response);
        }
        else if(url[3].equals("Modify")){
            Team team = tc.GetTeam(Integer.valueOf(url[4]));
            HashMap<Integer, Stadium> stadiums = sc.GetStadiums();
            request.setAttribute("team", team);
            request.setAttribute("stadiums", stadiums);
            request.setAttribute("teamId", Integer.valueOf(url[4]));
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/Form.jsp").forward(request, response);
        }
        else if(url[3].equals("Add")){
            HashMap<Integer, Stadium> stadiums = sc.GetStadiums();
            request.setAttribute("stadiums", stadiums);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/Form.jsp").forward(request, response);
        }
    }
}
