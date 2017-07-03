package com.Tournevice.Controller;

import com.Tournevice.Bean.Database;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by mercier on 13/04/2017.
 */
public class ConnectionController {
    public ConnectionController(){

    }

    public boolean connection(String email, String password) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT Passwd FROM user WHERE Mail = \"" + email + "\"");
        results.next();

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(password));
        String md5pass = String.valueOf(String.format("%032x", new BigInteger(1, md5.digest())));

        return results.getString("Passwd").equals(md5pass);
    }
}
