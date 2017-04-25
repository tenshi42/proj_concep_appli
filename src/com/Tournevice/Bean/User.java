package com.Tournevice.Bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * Created by mercier on 13/04/2017.
 */
public class User {
    private Integer id;
    private Integer roleId;
    private String email;
    private String username;
    private String lastName;
    private String firstName;
    private String addr;
    private String addr2;
    private String zipCode;
    private String city;
    private String phone;
    private String birthDate;
    private String state;

    public User(Integer id, String username, String email, Integer roleId, String lastName, String firstName, String addr, String addr2, String zipCode, String city, String phone, String birthDate, String state) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roleId = roleId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.addr = addr;
        this.addr2 = addr2;
        this.zipCode = zipCode;
        this.city = city;
        this.phone = phone;
        this.birthDate = birthDate;
        this.state = state;

    }

    public User(String username, String email, Integer roleId){
        this.username = username;
        this.email = email;
        this.roleId = roleId;
    }

    public User(){

    }

    public static User GetUser(String email) throws Exception {
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
            String zipCode = results.getString("ZipCode");
            String city = results.getString("City");
            String phone = results.getString("Phone");
            String birthDate = results.getString("BirthDate");
            String state = results.getString("State");
            results.close();
            statement.close();
            db.close();
            return new User(id, user, mail, role, lastName, firstName, addr, addr2, zipCode, city, phone, birthDate, state);
        }
        return new User();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
