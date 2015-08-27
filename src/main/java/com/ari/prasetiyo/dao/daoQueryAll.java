/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.sistem.connectDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 *
 * @author arprast
 */
public class daoQueryAll {
    
    //example query 
    //select count(id)from payroll_master_pelamar 
    public int jumlahRow(String query, com.ari.prasetiyo.domain.domainMasterPelamarAll dMA, String sourceFilter){
        connectDb dbMysql = new connectDb();
        int dataRow = 0;
        try {
            dbMysql.connectDbMysql();
            PreparedStatement ps;
            ResultSet rs = null;
            ps = dbMysql.koneksi.prepareStatement(query);
            // dijalankan jika dari search atau filter data
            if (sourceFilter.equalsIgnoreCase("filterPelamar")){
                filterPelamar( dMA, ps);
            }
            else if (sourceFilter.equalsIgnoreCase("filterKaryawan")){
                filterKaryawan(dMA, ps);
            }
             else if (sourceFilter.equalsIgnoreCase("filterPresensi")){ 
                filterPresensi( dMA, ps);
            }
             else if (sourceFilter.equalsIgnoreCase("filterPresensiAbsensi")){ 
                filterPresensiAbsensi( dMA, ps);
            }
            else{
                System.out.println("tidak ada piliha prosedure");
            }

            rs = ps.executeQuery();
            while(rs.next()){                
                dataRow   = rs.getInt("id");
            }
            dbMysql.disconnectDbMysql();
            return dataRow;
        } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoQueryAll.class.getName(), ex);
        }
        return dataRow;
    }
    private void filterPelamar(com.ari.prasetiyo.domain.domainMasterPelamarAll dMA, PreparedStatement ps){
         if (dMA.isLanjut()){
            try{
                ps.setString(1, "%"+dMA.getfId() +"%");
                ps.setString(2, "%"+dMA.getfNama()+"%");
                ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                ps.setString(4, "%"+dMA.getfStatPlmr()+"%" );
                try{
                    ps.setDate(5, new Date(dMA.getfPeriodeCreate1().getTime()) );
                    ps.setDate(6, new  Date(dMA.getfPeriodeCreate2().getTime())  );
                }
                catch(Exception ex){
                    //Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
                    //new com.ari.prasetiyo.sistem.loggerError(daoQueryAll.class.getName(), ex);
                }
            }
            catch(SQLException ex){                 
                Logger.getLogger(daoQueryAll.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
    } private void filterKaryawan( com.ari.prasetiyo.domain.domainMasterPelamarAll dMA, PreparedStatement ps) {
         if (dMA.isLanjut()){
            try{
                ps.setString(1, "%"+dMA.getfId() +"%");
                ps.setString(2, "%"+dMA.getfNama()+"%");
                ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                ps.setString(4, "%"+dMA.getfStatPlmr()+"%" );
                ps.setString(5, "%"+dMA.getfArea()+"%" );
                ps.setString(6, "%"+dMA.getfStatusPegawai()+"%" );
                try{
                    ps.setDate(7, new Date(dMA.getfPeriodeCreate1().getTime()) );
                    ps.setDate(8, new  Date(dMA.getfPeriodeCreate2().getTime())  );
                }
                catch(Exception ex){
                    //Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
                    //new com.ari.prasetiyo.sistem.loggerError(daoQueryAll.class.getName(), ex);
                }
            }
            catch(SQLException ex){                
                Logger.getLogger(daoQueryAll.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
    }
    private void filterPresensiAbsensi(com.ari.prasetiyo.domain.domainMasterPelamarAll dMA, PreparedStatement ps) {
        if (dMA.isLanjut()){
            try{
                ps.setString(1, "%"+dMA.getfId() +"%");
                ps.setString(2, "%"+dMA.getfStatPlmr()+"%" );
                ps.setString(3, "%"+dMA.getfNama()+"%");
                ps.setString(4, "%"+dMA.getfJabatan()+"%" );
                ps.setString(5, "%"+dMA.getfArea()+"%" );
                ps.setString(6, "%"+dMA.getfStatusPegawai()+"%" );
                try{
                    ps.setDate(7, new Date(dMA.getfPeriodeCreate1().getTime()) );
                }
                catch(Exception ex){
                    //Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
                    //new com.ari.prasetiyo.sistem.loggerError(daoQueryAll.class.getName(), ex);
                }
            }
            catch(SQLException ex){                
                Logger.getLogger(daoQueryAll.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
    }
    private void filterPresensi(com.ari.prasetiyo.domain.domainMasterPelamarAll dMA, PreparedStatement ps) {
         if (dMA.isLanjut()){
            //filter tanpa status dan field lain terisi
            if (dMA.getfPilihan().equals("tanpaStatus")){
                try{
                    int n = 0;
                    ps.setString(n += 1, "%"+dMA.getfId() +"%");
                    ps.setString(n += 1, "%"+dMA.getfIdKaryawan()+"%");
                    ps.setString(n += 1, "%"+dMA.getfJabatan()+"%" );
                    try{
                        ps.setDate(n += 1, new Date(dMA.getfPeriodeCreate1().getTime()) );
                        ps.setDate(n += 1, new  Date(dMA.getfPeriodeCreate2().getTime())  );
                    }
                    catch(Exception ex){
                        n -= 1;
                        //Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
                        //new com.ari.prasetiyo.sistem.loggerError(daoQueryAll.class.getName(), ex);
                    }
                    ps.setString(n += 1, "%"+dMA.getfId()+"%" );
                    ps.setString(n += 1, "%"+dMA.getfIdKaryawan()+"%" );
                    ps.setString(n += 1, "%"+dMA.getfJabatan()+"%" );
                    try{
                        ps.setDate(n += 1, new Date(dMA.getfPeriodeCreate1().getTime()) );
                        ps.setDate(n += 1, new  Date(dMA.getfPeriodeCreate2().getTime())  );
                    }
                    catch(Exception ex){
                         n -= 1;
                        //Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
                        //new com.ari.prasetiyo.sistem.loggerError(daoQueryAll.class.getName(), ex);
                    }
                    ps.setString(n += 1, "%"+dMA.getfNama()+"%" );
                }
                catch(SQLException ex){                    
                    Logger.getLogger(daoQueryAll.class.getName()).log(Level.SEVERE, null, ex); 
                }        
            }
            //filter dengan status dan field lain terisi
            else {
                try{
                    ps.setString(1, "%"+dMA.getfId() +"%");
                    ps.setString(2, "%"+dMA.getfIdKaryawan()+"%");
                    ps.setString(3, "%"+dMA.getfNama()+"%" );
                    ps.setString(4, "%"+dMA.getfJabatan()+"%" );
                    try{
                        ps.setDate(5, new Date(dMA.getfPeriodeCreate1().getTime()) );
                        ps.setDate(6, new  Date(dMA.getfPeriodeCreate2().getTime())  );
                    }
                    catch(Exception ex){
                        //Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
                        //new com.ari.prasetiyo.sistem.loggerError(daoQueryAll.class.getName(), ex);
                    }
                }
                catch(SQLException ex){                    
                    Logger.getLogger(daoQueryAll.class.getName()).log(Level.SEVERE, null, ex);  
                }
            }         
         }
    }
}
