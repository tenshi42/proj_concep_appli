package com.Tournevice.Controller;

import com.Tournevice.Bean.Database;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;
import com.sun.org.apache.xml.internal.security.keys.content.KeyValue;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by quentin on 25/04/2017.
 */
public class CompetitionsController {

    public ArrayList<String[]> GetChampionships() throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM championship");
        ArrayList<String[]> tabNomChampionship = new ArrayList<String[]>();
        while(results.next()) {
            tabNomChampionship.add(new String[]{results.getString("Name"), results.getString("Id")});
        }
        results.close();
        statement.close();
        db.close();
        return tabNomChampionship;
    }

    public int[] GetChampoinshipPointsSettings(int championshipId) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM championship WHERE Id = " + String.valueOf(championshipId));
        results.next();
        int[] ret = new int[]{results.getInt("PointsOnWin"), results.getInt("PointsOnNul"), results.getInt("PointsOnLose")};
        results.close();
        statement.close();
        db.close();
        return ret;
    }

    public HashMap<Integer, int[]> GetChampionship(int championshipId) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT TeamExt_id, TeamDom_id, ScoreExt, ScoreDom FROM `match` WHERE Championship_id = " + championshipId);
        HashMap<Integer, int[]> classement = new HashMap<Integer, int[]>();
        int[] pointsSettings = GetChampoinshipPointsSettings(championshipId);
        while (results.next()){
            int tE = results.getInt("TeamExt_id");
            int tD = results.getInt("TeamDom_id");
            int sE = results.getInt("ScoreExt");
            int sD = results.getInt("ScoreDom");
            if(!classement.containsKey(tE))
                classement.put(tE, new int[]{0,0,0,0});
            if(!classement.containsKey(tD))
                classement.put(tD, new int[]{0,0,0,0});

            classement.get(tE)[0] += ((sE>sD)?1:0);
            classement.get(tE)[1] += ((sE==sD)?1:0);
            classement.get(tE)[2] += ((sE<sD)?1:0);
            classement.get(tE)[3] += ((sE>sD)?pointsSettings[0]:0) + ((sE==sD)?pointsSettings[1]:0) + ((sE<sD)?pointsSettings[2]:0);

            classement.get(tD)[0] += ((sE<sD)?1:0);
            classement.get(tD)[1] += ((sE==sD)?1:0);
            classement.get(tD)[2] += ((sE>sD)?1:0);
            classement.get(tD)[3] += ((sE<sD)?pointsSettings[0]:0) + ((sE==sD)?pointsSettings[1]:0) + ((sE>sD)?pointsSettings[2]:0);
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

}
