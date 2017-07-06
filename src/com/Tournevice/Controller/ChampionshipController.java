package com.Tournevice.Controller;

import com.Tournevice.Bean.Championship;
import com.Tournevice.Bean.Database;


import javax.swing.text.StyledEditorKit;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by quentin on 25/04/2017.
 */
public class ChampionshipController {

    public ArrayList<Championship> GetChampionships() throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM championship");
        ArrayList<Championship> tabNomChampionship = new ArrayList<Championship>();
        while(results.next()) {
            tabNomChampionship.add(new Championship(results.getInt("Id"), results.getString("Name"), results.getInt("Country_id"), results.getInt("PointsOnWin"), results.getInt("PointsOnNul"), results.getInt("PointsOnLose")));
        }
        results.close();
        statement.close();
        db.close();
        return tabNomChampionship;
    }

    public Championship GetChampionship(int championshipId) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM championship WHERE Id = " + String.valueOf(championshipId));
        results.next();
        Championship tmpChampionship = new Championship(results.getInt("Id"), results.getString("Name"), results.getInt("Country_id"), results.getInt("PointsOnWin"), results.getInt("PointsOnNul"), results.getInt("PointsOnLose"));
        results.close();
        statement.close();
        db.close();
        return tmpChampionship;
    }

    public HashMap<Integer, int[]> GetChampionshipScore(int championshipId) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        HashMap<Integer, int[]> classement = new HashMap<Integer, int[]>();
        ResultSet results0 = statement.executeQuery("SELECT Id FROM teams WHERE Championship_id = " + championshipId);
        while (results0.next()){
            int tI = results0.getInt("Id");
            if(!classement.containsKey(tI))
                classement.put(tI, new int[]{0,0,0,0});
        }
        results0.close();
        ResultSet results = statement.executeQuery("SELECT TeamExt_id, TeamDom_id, ScoreExt, ScoreDom FROM `match` WHERE Championship_id = " + championshipId);
        Championship championship = GetChampionship(championshipId);
        while (results.next()){
            int tE = results.getInt("TeamExt_id");
            int tD = results.getInt("TeamDom_id");
            int sE = results.getInt("ScoreExt");
            int sD = results.getInt("ScoreDom");

            classement.get(tE)[0] += ((sE>sD)?1:0);
            classement.get(tE)[1] += ((sE==sD)?1:0);
            classement.get(tE)[2] += ((sE<sD)?1:0);
            classement.get(tE)[3] += ((sE>sD)?championship.getPointsOnWin():0) + ((sE==sD)?championship.getPointsOnNul():0) + ((sE<sD)?championship.getPointsOnLose():0);

            classement.get(tD)[0] += ((sE<sD)?1:0);
            classement.get(tD)[1] += ((sE==sD)?1:0);
            classement.get(tD)[2] += ((sE>sD)?1:0);
            classement.get(tD)[3] += ((sE<sD)?championship.getPointsOnWin():0) + ((sE==sD)?championship.getPointsOnNul():0) + ((sE>sD)?championship.getPointsOnLose():0);
        }
        results.close();
        statement.close();
        db.close();
        return classement;
    }

    public HashMap<Integer, String[]> GetTeamsInfos(Set<Integer> teamIds) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        String strTeamIds = Arrays.toString(teamIds.toArray());
        strTeamIds = strTeamIds.substring(1, strTeamIds.length()-1);
        ResultSet results = statement.executeQuery("SELECT Id, Name FROM teams WHERE Id IN (" + strTeamIds + ")");
        HashMap<Integer, String[]> ret = new HashMap<Integer, String[]>();
        while(results.next()){
            ret.put(results.getInt("Id"), new String[]{results.getString("Name")});
        }
        results.close();
        statement.close();
        db.close();
        return ret;
    }

    public Boolean UpdateChampionship(int id, String name, int countryId, int pointsOnWin, int pointsOnNul, int pointsOnLose) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        int rows = statement.executeUpdate("UPDATE championship SET Name = \"" + name + "\", Country_id = " + String.valueOf(countryId) + ", PointsOnWin = " + String.valueOf(pointsOnWin) + ", PointsOnLose = " + String.valueOf(pointsOnLose) + ", PointsOnNul = " + String.valueOf(pointsOnNul) + " WHERE Id = " + String.valueOf(id));
        statement.close();
        db.close();
        return rows > 0;
    }

    public int InsertChampionship(String name, int countryId, int pointsOnWin, int pointsOnNul, int pointsOnLose) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        boolean res = statement.execute("INSERT INTO championship (Name, Country_id, PointsOnWin, PointsOnNul, PointsOnLose) VALUE (\"" + name + "\"," + String.valueOf(countryId) + "," + String.valueOf(pointsOnWin) + "," + String.valueOf(pointsOnNul) + "," + String.valueOf(pointsOnLose) + ")");
        ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() as id FROM championship");
        result.next();
        int id = result.getInt("id");
        result.close();
        statement.close();
        db.close();
        return id;
    }

    public Boolean DeleteChampionship(int id) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        Boolean res = statement.execute("DELETE FROM championship WHERE Id = " + String.valueOf(id));
        statement.close();
        db.close();
        return res;
    }
}
