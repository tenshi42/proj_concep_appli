package com.Tournevice.Servlet;

import com.Tournevice.Bean.Championship;
import com.Tournevice.Controller.ChampionshipController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by quent on 25/04/2017. c
 */
@WebServlet(name = "Competitions")
public class Competitions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] requestUrl = request.getRequestURI().split("/");
        ChampionshipController cc = new ChampionshipController();

        if(requestUrl.length == 2) {
            ArrayList<String[]> championships = new ArrayList<String[]>();
            try {
                championships = cc.GetChampionships();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
            request.setAttribute("championships", championships);

            this.getServletContext().getRequestDispatcher("/WEB-INF/Competitions.jsp").forward(request, response);
        }
        else if(requestUrl.length == 3){
            HashMap<Integer, int[]> classement = new HashMap<Integer, int[]>();
            ArrayList<Integer> sortedClassement = new ArrayList<Integer>();
            HashMap<Integer, String[]> teamInfos = new HashMap<Integer, String[]>();
            Championship championship = new Championship();
            try {
                classement = cc.GetChampionship(Integer.valueOf(requestUrl[2]));
                championship = cc.GetChampoinshipPointsSettings(Integer.valueOf(requestUrl[2]));
                while (sortedClassement.size() != classement.size()){
                    int gt = -1;
                    int key = -1;
                    for(int a : classement.keySet()){
                        if(classement.get(a)[3] > gt && !sortedClassement.contains(a)){
                            gt = classement.get(a)[3];
                            key = a;
                        }
                    }
                    sortedClassement.add(key);
                }

                teamInfos = cc.GetTeamsInfos(classement.keySet());

            } catch (Exception e1) {
                e1.printStackTrace();
            }

            request.setAttribute("classement", classement);
            request.setAttribute("sortedClassement", sortedClassement);
            request.setAttribute("teamInfos", teamInfos);
            request.setAttribute("championship", championship);

            this.getServletContext().getRequestDispatcher("/WEB-INF/CompetitionClassement.jsp").forward(request, response);
        }

    }
}
