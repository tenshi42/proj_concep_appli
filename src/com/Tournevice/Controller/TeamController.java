package com.Tournevice.Controller;

import com.Tournevice.Bean.Database;
import com.Tournevice.Bean.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mercier on 06/07/2017.
 */
public class TeamController {
    public ArrayList<Team> GetTeams() throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM Teams");
        ArrayList<Team> ret = new ArrayList<Team>();
        while(results.next()){
            Team tmpTeam = new Team(results.getInt("Id"), results.getString("Name"), results.getString("City"), results.getString("TrainingOfficer"), results.getInt("Stadium_id"));
            ret.add(tmpTeam);
        }
        results.close();
        statement.close();
        db.close();
        return ret;
    }

    public Team GetTeam(int id) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM Teams WHERE Id = " + String.valueOf(id));
        results.next();
        Team tmpTeam = new Team(results.getInt("Id"), results.getString("Name"), results.getString("City"), results.getString("TrainingOfficer"), results.getInt("Stadium_id"));
        results.close();
        statement.close();
        db.close();
        return tmpTeam;
    }

    public Boolean UpdateTeam(int id, String name, String city, String trainingOfficer, int stadiumId) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        int rows = statement.executeUpdate("UPDATE teams SET Name = \"" + name + "\", City = \"" + city + "\", TrainingOfficer = \"" + trainingOfficer + "\", Stadium_id = " + String.valueOf(stadiumId) + " WHERE Id = " + String.valueOf(id));
        statement.close();
        db.close();
        return rows > 0;
    }

    public int InsertTeam(String name, String city, String trainingOfficer, int stadiumId) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        boolean res = statement.execute("INSERT INTO teams (Name, City, TrainingOfficer, Stadium_id) VALUE (\"" + name + "\", \"" + city + "\", \"" + trainingOfficer + "\", " + String.valueOf(stadiumId) + ")");
        ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() as id FROM teams");
        result.next();
        int id = result.getInt("id");
        result.close();
        statement.close();
        db.close();
        return id;
    }

    public Boolean DeleteTeam(int id) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        Boolean res = statement.execute("DELETE FROM teams WHERE Id = " + String.valueOf(id));
        statement.close();
        db.close();
        return res;
    }
}
