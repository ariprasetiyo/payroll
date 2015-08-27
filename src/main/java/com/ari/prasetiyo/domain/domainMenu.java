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
public class domainMenu {

    int id,aktiv, levelUser, subLink, levelMenu;
    String namaMenu, menuByAsc,menuTag, href;
    
    public int getId(){
        return id; 
    }
    public void setId(int Data){
        this.id = Data;
    }
    
    public int getSubLink(){
        return subLink; 
    }
    public void setSubLink(int Data){
        this.subLink = Data;
    }
    
    public int getLevelMenu(){
        return levelMenu; 
    }
    public void setLevelMenu(int Data){
        this.levelMenu = Data;
    }
    
    public int getAktiv (){
        return aktiv;
    }
    public void setAktiv(int Data){
        this.aktiv = Data;
    }
    
    public int getLevelUser (){
        return levelUser;
    }
    public void setLevelUser(int Data){
        this.levelUser = Data;
    }
    
    public String getNamaMenu (){
        return namaMenu;
    }
    public void setNamaMenu(String Data){
        this.namaMenu = Data;
    }
    
    public String getMenuByAsc (){
        return menuByAsc;
    }
    public void setMenuByAsc(String Data){
        this.menuByAsc = Data;
    }
    
    public String getTag (){
        return menuTag;
    }
    public void setTag(String Data){
        this.menuTag = Data;
    }
    
    public String getHref (){
        return href;
    }
    public void setHref(String Data){
        this.href = Data;
    }
}
