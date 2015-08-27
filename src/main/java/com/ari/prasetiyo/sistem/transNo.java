/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.sistem;
import com.ari.prasetiyo.dao.daoLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author LANTAI3
 * cara penggunaan
 * Kode Transaksi selalu 2 digit ( Harus ) dan huruf besaR
 */
public class transNo {
    String transNo;
    public String getTransNo(){
        return transNo;
    }
    public String setGetTransNo(String tableName, String columnName, String kodeTransaksi){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            String transNo = null;
            int id = 0;
           // int intTransNo =0,count =0 ;
            
            tanggalSistem tglSistem = new tanggalSistem();
            
            /*
            select max(item_code) from payroll_master_pelamar;
            select id from payroll_master_pelamar order by id desc limit 1; 
            SELECT convert(substring(id,3,10),UNSIGNED INTEGER) as id, tanggal_dibuat 
            FROM `payroll_master_pelamar` where tanggal_dibuat = now() order by id desc limit 1
            
            select id from payroll_master_pelamar where tahun = year(now())  order by tanggal_dibuat desc limit 1
            dengan cara ini select query lebih cepat
            */
            sql = "SELECT   " +columnName +
                  " FROM "+ tableName + " where year(tanggal_dibuat) = year(now()) order by no desc limit 1 " ;
            ps = dbMysql.koneksi.prepareStatement(sql);
            ///ps.setString(1, tableName);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                transNo = rs.getString(columnName);
            }
            dbMysql.disconnectDbMysql();
            
            /*
            jika transaksi tidak null
            */
            if (transNo != null ){
                transNo = transNo.replaceAll("^[A-Z][A-Z][A-Z]?[0-9][0-9][0-9][0-9]", "");
                id  = Integer.parseInt(transNo);
            }

            id = id + 1;
            tglSistem.SetTahunSis();
            transNo = kodeTransaksi + tglSistem.GetTahunSis()+ id;
            this.transNo = transNo;
            return transNo;
            
        } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
            return null;
        }
        
    }
    /*
    Sampel query
    String sql = "select id_cuti as id from presensi_izin  
    where year(tanggal_dibuat) = year(now()) and jenis_izin_cuti = 0 order by no desc limit 1 ";
    */
     public String setGetTransNo( String kodeTransaksi, String queryBebas){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            PreparedStatement ps;
            ResultSet rs = null;
            String transNo = null;
            int id = 0;
           // int intTransNo =0,count =0 ;
            
            tanggalSistem tglSistem = new tanggalSistem();
            
            /*
            select max(item_code) from payroll_master_pelamar;
            select id from payroll_master_pelamar order by id desc limit 1; 
            SELECT convert(substring(id,3,10),UNSIGNED INTEGER) as id, tanggal_dibuat 
            FROM `payroll_master_pelamar` where tanggal_dibuat = now() order by id desc limit 1
            
            select id from payroll_master_pelamar where tahun = year(now())  order by tanggal_dibuat desc limit 1
            dengan cara ini select query lebih cepat
            */
            ps = dbMysql.koneksi.prepareStatement(queryBebas);
            ///ps.setString(1, tableName);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                transNo = rs.getString("id");
            }
            dbMysql.disconnectDbMysql();
            
            /*
            jika transaksi tidak null
            */
            if (transNo != null ){
                transNo = transNo.replaceAll("^[A-Z][A-Z][A-Z]?[0-9][0-9][0-9][0-9]", "");
                id  = Integer.parseInt(transNo);
            }
            id = id + 1;
            tglSistem.SetTahunSis();
            transNo = kodeTransaksi + tglSistem.GetTahunSis()+ id;
            this.transNo = transNo;
            return transNo;
            
        } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
            return null;
        }
     }

}
