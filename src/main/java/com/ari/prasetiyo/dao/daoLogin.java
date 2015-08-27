/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.sistem.connectDb;
import com.ari.prasetiyo.domain.domainLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arprast
 */
public class daoLogin {
    /*
    mengambil data untuk aktivitas cek username dan passowrd
    LoginTrue = false berarti user dan password salah
    */
    boolean LoginTrue = false;
    public boolean getLoginTrue(){
        return LoginTrue;
    }
    public ArrayList<domainLogin> tampilLogin(String username, String password, int loginSalahOrBenar){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            
            if (loginSalahOrBenar == 0 ){
                /*
                    jika user benar dan passowrd salah
                */
                sql = "select username, count_false_login "
                    + "from sys_user where username =? ";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
            }
            else if (loginSalahOrBenar == 1){
                
                /*
                    jika user dan password benar
                */
                sql = "select username, password, status_aktiv, count_false_login,level_user "
                    + "from sys_user where username =? and password =? ";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                
            }
            
            ArrayList<domainLogin> listHasil = new  ArrayList<domainLogin>();
            
            while(rs.next()){                
                domainLogin p = konversiResultSet(rs, loginSalahOrBenar);
                listHasil.add(p);
            }
            dbMysql.disconnectDbMysql();
            
            return listHasil;
        } catch (SQLException ex) {
            /*
                    Logika login
                    untuk aktivitas di login.java
            */
            this.LoginTrue = false;
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
        }
        
        /*
            Logika login
            untuk aktivitas di login.java
        */
        this.LoginTrue = false;
        return null;
    }
    private domainLogin konversiResultSet(ResultSet rs, int loginSalahOrBenar) {
        try {
            domainLogin p = new domainLogin();
            
            if (loginSalahOrBenar == 0 ){
                /*
                    jika user benar dan passd salah
                */
                p.setUserName(rs.getString("username"));
                p.setCountLogin(rs.getInt("count_false_login"));
                /*
                    Logika login
                    untuk aktivitas di login.java
                */
                this.LoginTrue = false;
            }
            else if (loginSalahOrBenar == 1){  
                /*
                    jika user dan password benar
                */
                p.setUserName(rs.getString("username"));
                p.setPassword(rs.getString("password"));

                p.setStatusAktiv(rs.getInt("status_aktiv"));
                p.setCountLogin(rs.getInt("count_false_login"));
                p.setUserLevel(rs.getInt("level_user"));
                
                /*
                    Logika login
                    untuk aktivitas di login.java
                */
                this.LoginTrue = true;
            }
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
        }
        return null;
    }
    
    /*
    aktivitas untuk update data dibawah saat proses login:
    
    pilih = 0 => save or update count login
    pilih = 1 => save or update status aktiv
    
    status_aktive = 0 => non aktive
    status_aktive = 1 => aktive
    
    count_false_login = 6 => lock login
    */
    public void updateLogin(domainLogin m, int countLogin, String syarat, int pilih){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            
            String query;
            
            if (pilih == 0 ){
                query = "update  sys_user set count_false_login =?  where username =?";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                
                ps.setInt(1, countLogin + 1 );
                ps.setString(2,syarat);
                ps.executeUpdate();
            }
            else if (pilih == 1){
                query = "update  sys_user set status_aktiv =? where username =?";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                ps.setInt(1, m.getStatusAktiv());
                ps.setString(2, m.getUserName());
                ps.executeUpdate();
            }
            else {
                /*
                query = "update mhs set npm=?, nama=? where npm=?";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                ps.setString(1, m.getNpm());
                ps.setString(2, m.getNama());
                ps.setString(3, m.getNpm());
                ps.executeUpdate();
                */
            }

            dbMysql.disconnectDbMysql();
        } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
        }
    }
}
