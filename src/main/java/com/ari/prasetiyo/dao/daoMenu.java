/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.sistem.connectDb;
import com.ari.prasetiyo.domain.domainMenu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arprast
 */
public class daoMenu {
    
    /*
    untuk mengambil data menu
    ArrayList<domainLogin> tampilMenu()
    */
    public List tampilMenu(){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            
            sql = "select * from sys_menu order by menu_by_asc";
            ps = dbMysql.koneksi.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            ArrayList hasil = new ArrayList();
            while(rs.next()){
                domainMenu p = konversiResultSet(rs);
                
                hasil.add(p);
            }
            dbMysql.disconnectDbMysql();
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoMenu.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMenu.class.getName(), ex);
        }
        return null;
    }
    private domainMenu konversiResultSet(ResultSet rs) {
        try {
            domainMenu p = new domainMenu();
            p.setId(rs.getInt("id"));
            p.setLevelUser(rs.getInt("level_user"));
            p.setAktiv(rs.getInt("aktiv"));
            p.setSubLink(rs.getInt("sub_link"));
            p.setLevelMenu(rs.getInt("level_menu"));

            p.setNamaMenu(rs.getString("nama_menu"));
            p.setHref(rs.getString("href"));
            p.setMenuByAsc(rs.getString("menu_by_asc"));
            p.setTag(rs.getString("tag"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMenu.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMenu.class.getName(), ex);
        }
        return null;
    }
    
}
