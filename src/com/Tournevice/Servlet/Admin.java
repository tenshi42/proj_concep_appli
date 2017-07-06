package com.Tournevice.Servlet;

import com.Tournevice.Bean.Championship;
import com.Tournevice.Bean.Country;
import com.Tournevice.Bean.Stadium;
import com.Tournevice.Bean.Team;
import com.Tournevice.Controller.ChampionshipController;
import com.Tournevice.Controller.CountryController;
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
        PreDispatch(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreDispatch(request, response);
    }

    private void PreDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] requestUrl = request.getRequestURI().split("/");
        if(requestUrl.length == 2) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);
        }
        else if(requestUrl.length == 3){
            System.out.println(requestUrl[2]);
        }
        else {
            if(requestUrl[2].equals("Team")){
                try {
                    teamDispatcher(requestUrl,request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(requestUrl[2].equals("Stadium")){
                try {
                    stadiumDispatcher(requestUrl,request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(requestUrl[2].equals("Championship")){
                try {
                    championshipDispatcher(requestUrl,request, response);
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
            request.setAttribute("admin", 1);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Team/View.jsp").forward(request, response);
        }
        else if(url[3].equals("Modify")){
            System.out.println(String.valueOf(request.getParameterMap().keySet().toArray().length));
            if(request.getParameter("submit") != null){
                System.out.println(request.getParameter("submit"));
                int id = Integer.valueOf(request.getParameter("teamId"));
                String name = request.getParameter("name");
                String city = request.getParameter("city");
                String trainingOfficer = request.getParameter("trainingOfficer");
                int stadiumId = Integer.valueOf(request.getParameter("stadiumId"));
                tc.UpdateTeam(id, name, city, trainingOfficer, stadiumId);
                response.sendRedirect("/Team/" + String.valueOf(id));
            }
            else {
                Team team = tc.GetTeam(Integer.valueOf(url[4]));
                HashMap<Integer, Stadium> stadiums = sc.GetStadiums();
                request.setAttribute("team", team);
                request.setAttribute("stadiums", stadiums);
                request.setAttribute("teamId", Integer.valueOf(url[4]));
                this.getServletContext().getRequestDispatcher("/WEB-INF/Team/Form.jsp").forward(request, response);
            }
        }
        else if(url[3].equals("Add")){
            if(request.getParameter("submit") != null){
                System.out.println(request.getParameter("submit"));
                String name = request.getParameter("name");
                String city = request.getParameter("city");
                String trainingOfficer = request.getParameter("trainingOfficer");
                int stadiumId = Integer.valueOf(request.getParameter("stadiumId"));
                int id = tc.InsertTeam(name, city, trainingOfficer, stadiumId);
                response.sendRedirect("/Team/" + String.valueOf(id));
            }
            else {
                HashMap<Integer, Stadium> stadiums = sc.GetStadiums();
                request.setAttribute("stadiums", stadiums);
                this.getServletContext().getRequestDispatcher("/WEB-INF/Team/Form.jsp").forward(request, response);
            }
        }
        else if(url[3].equals("Delete")){
            tc.DeleteTeam(Integer.valueOf(url[4]));
            response.sendRedirect("/Admin/Team/View");
        }
    }

    private void stadiumDispatcher(String[] url, HttpServletRequest request, HttpServletResponse response) throws Exception{
        StadiumController sc = new StadiumController();
        if (url[3].equals("View")){
            HashMap<Integer, Stadium> stadiums = new HashMap<Integer, Stadium>();
            try {
                stadiums = sc.GetStadiums();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("stadiums", stadiums);
            request.setAttribute("admin", 1);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Stadium/View.jsp").forward(request, response);
        }
        else if(url[3].equals("Modify")){
            if(request.getParameter("submit") != null){
                int id = Integer.valueOf(request.getParameter("stadiumId"));
                String name = request.getParameter("name");
                String capacity = request.getParameter("capacity");
                sc.UpdateStadium(id, name, capacity);
                response.sendRedirect("/Stadium/" + String.valueOf(id));
            }
            else {
                Stadium stadium = sc.GetStadium(Integer.valueOf(url[4]));
                request.setAttribute("stadium", stadium);
                request.setAttribute("stadiumId", Integer.valueOf(url[4]));
                this.getServletContext().getRequestDispatcher("/WEB-INF/Stadium/Form.jsp").forward(request, response);
            }
        }
        else if(url[3].equals("Add")){
            if(request.getParameter("submit") != null){
                String name = request.getParameter("name");
                String capacity = request.getParameter("capacity");
                int id = sc.InsertStadium(name, capacity);
                response.sendRedirect("/Stadium/" + String.valueOf(id));
            }
            else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/Stadium/Form.jsp").forward(request, response);
            }
        }
        else if(url[3].equals("Delete")){
            sc.DeleteStadium(Integer.valueOf(url[4]));
            response.sendRedirect("/Admin/Stadium/View");
        }
    }

    private void championshipDispatcher(String[] url, HttpServletRequest request, HttpServletResponse response) throws Exception{
        ChampionshipController cc = new ChampionshipController();
        if (url[3].equals("View")){
            CountryController cc2 = new CountryController();
            ArrayList<Championship> championships = new ArrayList<Championship>();
            HashMap<Integer, Country> countries = new HashMap<Integer, Country>();
            try {
                championships = cc.GetChampionships();
                countries = cc2.GetCountries();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("championships", championships);
            request.setAttribute("countries", countries);
            request.setAttribute("admin", 1);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Championship/View.jsp").forward(request, response);
        }
        else if(url[3].equals("Modify")){
            if(request.getParameter("submit") != null){
                int id = Integer.valueOf(request.getParameter("championshipId"));
                String name = request.getParameter("name");
                int countryId = Integer.valueOf(request.getParameter("countryId"));
                int pointsOnWin = Integer.valueOf(request.getParameter("pointsOnWin"));
                int pointsOnNul = Integer.valueOf(request.getParameter("pointsOnNul"));
                int pointsOnLose = Integer.valueOf(request.getParameter("pointsOnLose"));
                cc.UpdateChampionship(id, name, countryId, pointsOnWin, pointsOnNul, pointsOnLose);
                response.sendRedirect("/Admin/Championship/ViewOne/" + String.valueOf(id));
            }
            else {
                CountryController cc2 = new CountryController();
                Championship championship = cc.GetChampionship(Integer.valueOf(url[4]));
                HashMap<Integer, Country> countries = cc2.GetCountries();
                String countryName = cc2.GetCountry(championship.getCountryId()).getName();
                request.setAttribute("championship", championship);
                request.setAttribute("countries", countries);
                request.setAttribute("championshipId", Integer.valueOf(url[4]));
                this.getServletContext().getRequestDispatcher("/WEB-INF/Championship/Form.jsp").forward(request, response);
            }
        }
        else if(url[3].equals("Add")){
            if(request.getParameter("submit") != null){
                String name = request.getParameter("name");
                int countryId = Integer.valueOf(request.getParameter("countryId"));
                int pointsOnWin = Integer.valueOf(request.getParameter("pointsOnWin"));
                int pointsOnNul = Integer.valueOf(request.getParameter("pointsOnNul"));
                int pointsOnLose = Integer.valueOf(request.getParameter("pointsOnLose"));
                int id = cc.InsertChampionship(name,countryId,pointsOnWin,pointsOnNul,pointsOnLose);
                response.sendRedirect("/Admin/Championship/ViewOne/" + String.valueOf(id));
            }
            else {
                CountryController cc2 = new CountryController();
                HashMap<Integer, Country> countries = cc2.GetCountries();
                request.setAttribute("countries", countries);
                this.getServletContext().getRequestDispatcher("/WEB-INF/Championship/Form.jsp").forward(request, response);
            }
        }
        else if(url[3].equals("Delete")){
            cc.DeleteChampionship(Integer.valueOf(url[4]));
            response.sendRedirect("/Admin/Championship/View");
        }
        if (url[3].equals("ViewOne")){
            CountryController cc2 = new CountryController();
            Championship championship = new Championship();
            String countryName = "";
            try {
                championship = cc.GetChampionship(Integer.valueOf(url[4]));
                countryName = cc2.GetCountry(championship.getCountryId()).getName();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("championship", championship);
            request.setAttribute("countryName", countryName);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Championship/ViewOne.jsp").forward(request, response);
        }
    }
}
