package com.Tournevice.Controller;

import com.Tournevice.Bean.Database;
import com.Tournevice.Bean.User;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by mercier on 25/04/2017.
 */
public class AccountController {
    public User GetUser(String email) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("SELECT `Id`, `RoleId`, `Mail`, `Username`, `FirstName`, `LastName`, `Address`, `Address2`, `ZipCode`, `City`, `Phone`, `BirthDate`, `State` FROM `user` WHERE Mail = \"" + email + "\"");
        if(results.next()) {
            Integer id = results.getInt("Id");
            String user = results.getString("Username");
            String mail = results.getString("Mail");
            Integer role = results.getInt("RoleId");
            String firstName = results.getString("FirstName");
            String lastName = results.getString("LastName");
            String addr = results.getString("Address");
            String addr2 = results.getString("Address2");
            int zipCode = results.getInt("ZipCode");
            String city = results.getString("City");
            String phone = results.getString("Phone");
            String birthDate = results.getString("BirthDate");
            String state = results.getString("State");
            results.close();
            statement.close();
            db.close();
            return new User(id, user, mail, role, lastName, firstName, addr, addr2, zipCode, city, phone, birthDate, state);
        }
        return null;
    }
    public void UpdateUser(User user) throws Exception {
        java.sql.Connection db = Database.GetConnection();
        Statement statement = db.createStatement();
        statement.executeUpdate("UPDATE User SET LastName = \"" + user.getLastName() + "\", FirstName = \"" + user.getFirstName() + "\", Address = \"" + user.getAddr() + "\", Address2 = \"" + user.getAddr2() +
                "\", ZipCode = " + user.getZipCode() + ", City = \"" + user.getCity() + "\", Phone = \"" + user.getPhone() + /*"\", BirthDate = \"" + user.getBirthDate() +*/ "\", State = \"" + user.getState() +
                "\" WHERE Id = " + user.getId());
    }

    public void insertUser(){

    }
}
