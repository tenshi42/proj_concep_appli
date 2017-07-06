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
import java.util.HashMap;

/**
 * Created by mercier on 06/07/2017.
 */
@WebServlet(name = "StadiumS")
public class StadiumS extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] requestUrl = request.getRequestURI().split("/");
        StadiumController sc = new StadiumController();
        HashMap<Integer, Stadium> stadiums = new HashMap<Integer, Stadium>();

        if(requestUrl.length == 2) {
            try {
                stadiums = sc.GetStadiums();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("teams", stadiums);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Stadium/View.jsp").forward(request, response);
        }
        else if(requestUrl.length == 3){
            Stadium stadium = new Stadium();
            try {
                stadium = sc.GetStadium(Integer.valueOf(requestUrl[2]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("stadium", stadium);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Stadium/ViewOne.jsp").forward(request, response);
        }
    }
}
