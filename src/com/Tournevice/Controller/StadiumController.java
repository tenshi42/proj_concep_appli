package com.Tournevice.Controller;

import com.Tournevice.Bean.Database;
import com.Tournevice.Bean.Stadium;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mercier on 06/07/2017.
 */
public class StadiumController {
    public HashMap<Integer, Stadium> GetStadiums() throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM Stadiums");
        HashMap<Integer, Stadium> ret = new HashMap<Integer, Stadium>();
        while(results.next()){
            Stadium tmpStadium = new Stadium(results.getInt("Id"), results.getString("Name"), results.getInt("Capacity"));
            ret.put(results.getInt("Id"), tmpStadium);
        }
        results.close();
        statement.close();
        db.close();
        return ret;
    }

    public Stadium GetStadium(int id) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM Stadiums WHERE Id = " + String.valueOf(id));
        results.next();
        Stadium tmpStadium = new Stadium(results.getInt("Id"), results.getString("Name"), results.getInt("Capacity"));
        results.close();
        statement.close();
        db.close();
        return tmpStadium;
    }

    public Boolean UpdateStadium(int id, String name, String capacity) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        int rows = statement.executeUpdate("UPDATE stadiums SET Name = \"" + name + "\", Capacity = " + capacity + " WHERE Id = " + String.valueOf(id));
        statement.close();
        db.close();
        return rows > 0;
    }

    public int InsertStadium(String name, String capacity) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        boolean res = statement.execute("INSERT INTO stadiums (Name, Capacity) VALUE (\"" + name + "\", " + capacity + ")");
        ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() as id FROM testadiumsams");
        result.next();
        int id = result.getInt("id");
        result.close();
        statement.close();
        db.close();
        return id;
    }

    public Boolean DeleteStadium(int id) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        Boolean res = statement.execute("DELETE FROM stadiums WHERE Id = " + String.valueOf(id));
        statement.close();
        db.close();
        return res;
    }
}
