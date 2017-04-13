package com.Tournevice.Bean;

import java.util.Objects;

/**
 * Created by mercier on 13/04/2017.
 */
public class User {
    private String username;
    private String email;

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public User(){

    }

    public static User GetUser(String email){
        if(Objects.equals(email, "a@a.a"))
            return new User("testUser", "a@a.a");
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
}
