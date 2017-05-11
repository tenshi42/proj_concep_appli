package com.Tournevice.Controller;

import com.Tournevice.Bean.Database;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by quentin on 25/04/2017.
 */
public class CompetitionsController {

    public ArrayList<String[]>  GetChampionship () throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM championship ");
        ArrayList<String[]> tabNomChampionship = new ArrayList<String []>();
        while(results.next()) {
           tabNomChampionship.add(new String[]{results.getString("Name"), results.getString("Id")});
        }
        return tabNomChampionship;
    }

}
