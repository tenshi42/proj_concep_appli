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
}
