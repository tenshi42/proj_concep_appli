package com.Tournevice.Controller;

import com.Tournevice.Bean.Country;
import com.Tournevice.Bean.Database;
import com.Tournevice.Bean.Stadium;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by mercier on 06/07/2017.
 */
public class CountryController {

    public CountryController() {
    }

    public HashMap<Integer, Country> GetCountries() throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM country");
        HashMap<Integer, Country> ret = new HashMap<Integer, Country>();
        while(results.next()){
            Country tmpCountry = new Country(results.getInt("Id"), results.getString("Name"));
            ret.put(results.getInt("Id"), tmpCountry);
        }
        results.close();
        statement.close();
        db.close();
        return ret;
    }

    public Country GetCountry(int id) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM country WHERE Id = " + String.valueOf(id));
        results.next();
        Country tmpCountry = new Country(results.getInt("Id"), results.getString("Name"));
        results.close();
        statement.close();
        db.close();
        return tmpCountry;
    }

    public Boolean DeleteCountry(int id) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        Boolean res = statement.execute("DELETE FROM country WHERE Id = " + String.valueOf(id));
        statement.close();
        db.close();
        return res;
    }
}
