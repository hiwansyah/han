/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.entity;

/**
 *
 * @author iwansy
 */
public class ThisUser {
    private String username;
    private String password;
    private String roles;

    public String getUsernamel() {
        return username;
    }

    public void setUsernamel(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public ThisUser(String usernamel, String password, String roles) {
        this.username= username;
        this.password = password;
        this.roles = roles;
    }
    
      
}
