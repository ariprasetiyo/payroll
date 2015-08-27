/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.domain.domainMasterKaryawan;
import com.ari.prasetiyo.sistem.connectDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arprast
 */
public class daoMasterKaryawan_backup {
    /*
    ambil list data karwayan
    */
    public ArrayList<domainMasterKaryawan> tampilDataKarywan(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        connectDb dbMysql = new connectDb();
        try {
            System.out.println("master karyawan");
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            //jika ada data filter
             if (dMA.isLanjut()){
                // sql = "select id, nama, jenis_kelamin,status_pelamar, jabatan, no_telphone, tanggal_dibuat, user_created, user_updated "
                // + "from payroll_master_pelamar where id like ? and nama like ? and jabatan like ? order by tanggal_dibuat desc limit ?,? ";
                //jika filter periode 1 dan periode 2 ada 
                if (dMA.getfPeriodeCreate1() != null ||  dMA.getfPeriodeCreate2() != null ){
                    if ( !dMA.getfPeriodeCreate1().equals("") || !dMA.getfPeriodeCreate2().equals("") ){
                        sql =   "select mp.id, mp.nama, mp.jenis_kelamin,mp.status_pelamar, mp.jabatan, mp.no_telphone, mp.tanggal_dibuat, mp.user_created, mp.user_updated, mk.area, mk.nama_cabang "
                        + "from payroll_master_pelamar mp inner join payroll_master_karyawan mk on mp.id = mk.id where "
                        + "mp.id like ? and mp.nama like ? and mp.jabatan like ? and mp.status_pelamar like ? and "
                        + "mp.date_format(tanggal_dibuat , '%Y-%m-%d') between ? and ? "
                        + "order by mp.no desc limit ?,? ";
                        ps = dbMysql.koneksi.prepareStatement(sql);
                        ps.setString(1, "%"+dMA.getfId() +"%");
                        ps.setString(2, "%"+dMA.getfNama()+"%");
                        ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                        ps.setString(4, "%"+dMA.getfStatPlmr()+"%" );
                        ps.setDate(5,  new  java.sql.Date(dMA.getfPeriodeCreate1().getTime()) );
                        ps.setDate(6, new  java.sql.Date(dMA.getfPeriodeCreate2().getTime())  );
                        ps.setInt(7, limitBawah);
                        ps.setInt(8, limitAtas);
                        rs = ps.executeQuery();
                    }
                }
                //filter tanpa periode
                else {
                    sql =   "select mp.id, mp.nama, mp.jenis_kelamin,mp.status_pelamar, mp.jabatan, mp.no_telphone, mp.tanggal_dibuat, mp.user_created, mp.user_updated, mk.area, mk.nama_cabang  "
                        + "from payroll_master_pelamar mp inner join payroll_master_karyawan mk on mp.id = mk.id where "
                        + "mp.id like ? and mp.nama like ? and mp.jabatan like ? and mp.status_pelamar like ? "
                        + "order by mp.no desc  limit ?,? ";
                    ps = dbMysql.koneksi.prepareStatement(sql);
                    ps.setString(1, "%"+dMA.getfId() +"%");
                    ps.setString(2, "%"+dMA.getfNama()+"%");
                    ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                    ps.setString(4, "%"+dMA.getfStatPlmr()+"%" );
                    ps.setInt(5, limitBawah);
                    ps.setInt(6, limitAtas);
                    rs = ps.executeQuery();
                }
            }
            //ambil data tanpa filter
            else{
                sql = "select mp.id, mp.nama, mp.jenis_kelamin,mp.status_pelamar, mp.jabatan, mp.no_telphone, mp.tanggal_dibuat, mp.user_created, mp.user_updated, mk.area, mk.nama_cabang "
                + "from payroll_master_pelamar mp inner join payroll_master_karyawan mk on mp.id = mk.id order by mp.no desc limit ?,? ";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setInt(1, limitBawah);
                ps.setInt(2, limitAtas);
                rs = ps.executeQuery();
            }
            ArrayList<domainMasterKaryawan> listHasil = new  ArrayList<domainMasterKaryawan>();
            while(rs.next()){                
                domainMasterKaryawan p = konversiResultSet(rs);
                listHasil.add(p);
            }
            //rs.close();
            dbMysql.disconnectDbMysql();
            
            return listHasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
    private domainMasterKaryawan konversiResultSet(ResultSet rs) {
        try {
            domainMasterKaryawan p = new domainMasterKaryawan();
            com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
                p.setId(rs.getString("id"));
                p.setNama(rs.getString("nama"));
                p.setJenisKelamin(convertAll.convertJenisKelaminString(rs.getInt("jenis_kelamin")));
                p.setStatusPelamar(convertAll.convertStatusPelamarString(rs.getInt("status_pelamar")));
                p.setJabatan(rs.getString("jabatan"));
                p.setNoHP(rs.getString("no_telphone"));
                p.setTanggal(rs.getDate("tanggal_dibuat"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
    
    // ambil data detail
      public domainMasterKaryawan tampilDetilDataKaryawan( String id ){
        connectDb dbMysql = new connectDb();
        try {
 
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
                sql = "SELECT  id, nama, ibu, kelahiran_tanggal,"
                        + " kelahiran_tempat, jabatan, jenis_kelamin, status_nikah, agama,darah,"
                        + " kewarganegaraan, no_ktp, no_sim, alamat,alamat_asal, kode_pos, no_telphone, "
                        + " email, status_tempat_tinggal, hobby, status_pelamar, riwayat_pendidikan, pendidikan_non_formal,"
                        + " tanggal_dibuat, tanggal_update, user_created, user_updated"
                        + " from payroll_master_pelamar where id = ?";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();         
            domainMasterKaryawan listHasil = new  domainMasterKaryawan();
            while(rs.next()){                
                listHasil = konversiResultSetDetil(rs);
            }
            //rs.close();
            //ps.close();
            dbMysql.disconnectDbMysql();
            return listHasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
     private domainMasterKaryawan konversiResultSetDetil (ResultSet rs) {
        try {
            domainMasterKaryawan p = new domainMasterKaryawan();
                p.setId(rs.getString("id"));
                p.setNama(rs.getString("nama"));
                //p.setTanggalLahirString( new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("kelahiran_tanggal")));
                p.setTanggal(rs.getDate("tanggal_dibuat"));

            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
        }
        return null;
    }
}
