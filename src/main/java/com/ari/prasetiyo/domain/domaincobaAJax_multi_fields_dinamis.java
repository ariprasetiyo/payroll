/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.domain;

import java.util.List;

/**
 *
 * @author arprast
 */
public class domaincobaAJax_multi_fields_dinamis {
     String userName, password;
    int countLogin, statusAktiv, userLevel;
    private List<String> categories;
    
    public List<String> getCategories(){
        return categories;
    }
    
    public void setCategories(List<String>  Data){
        this.categories = Data;
    }

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
