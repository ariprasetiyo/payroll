/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.domain;

/**
 *
 * @author arprast
 */
public class domainLogin {
    String userName, password;
    int countLogin, statusAktiv, userLevel;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String data){
        this.userName = data;
    }
    
    public String getPassowrd(){
        return password;
    }
    public void setPassword(String data){
        this.password = data;
    }
    
    public int getCountLogin(){
        return countLogin;
    }
    public void setCountLogin(int data){
        this.countLogin = data;
    }
    
     public int getStatusAktiv(){
        return statusAktiv;
    }
    public void setStatusAktiv(int data){
        this.statusAktiv = data;
    }
    
    public int getUserLevel(){
        return userLevel;
    }
    public void setUserLevel(int data){
        this.userLevel = data;
    }
}
