package com.Tournevice.Controller;

import java.util.Objects;

/**
 * Created by mercier on 13/04/2017.
 */
public class ConnectionController {
    public ConnectionController(){

    }

    public boolean connection(String email, String password){
        return (Objects.equals(email, "a@a.a") && Objects.equals(password, "test"));
    }
}
