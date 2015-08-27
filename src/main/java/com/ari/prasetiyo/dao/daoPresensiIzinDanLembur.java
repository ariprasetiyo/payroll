/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.sistem.connectDb;
import com.ari.prasetiyo.domain.domainPresensiIzinDanLembur;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 *
 * @author arprast
 * sampel batch prosessing https://my.vertica.com/docs/5.0/HTML/Master/14878.htm
 * http://www.tutorialspoint.com/jdbc/jdbc-batch-processing.htm
 * http://backme80.blogspot.com/2010/02/setautocommit.html
 */
public class daoPresensiIzinDanLembur {
    
    /*
    editYesOrNo = 0 = simapan
    editYesOrNo = 1 = update
    insert data pelamar
    */
    public void Simpan(domainPresensiIzinDanLembur m, int editYesOrNo, int jenisIzin){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query = null;
            //save
            if (editYesOrNo == 0 ){
                //0 adalah jenis izin cuti
                if (jenisIzin == 0){
                    query = "insert into  presensi_izin "
                        + "(id_cuti, id_karyawan, jabatan, jenis_izin_cuti, jum_cuti, "
                        + "tanggal_dimulai_cuti, tanggal_selesai_cuti, jenis_izin, keterangan, user_created, "
                        + "user_updated, tanggal_dibuat, tanggal_update) "
                        + " values (?,?,?,?,?,"
                        + "?,?,0,?,?,"
                        + "?, now(),now() ); ";
                }
                //1 adalah jenis izin sakit
                else if(jenisIzin == 1){
                    query = "insert into  presensi_izin "
                        + "(id_cuti, id_karyawan, jabatan, jenis_izin_cuti, jum_cuti, "
                        + "tanggal_dimulai_cuti, tanggal_selesai_cuti, jenis_izin, keterangan, user_created, "
                        + "user_updated, tanggal_dibuat, tanggal_update) "
                        + " values (?,?,?,?,?,"
                        + "?,?,1,?,?,"
                        + "?, now(),now() ); ";
                }
                else {System.out.println("tidak ada pilihan jenis izin");}
                
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                setDataSimpan(ps,m, jenisIzin);
                ps.execute();
            }
            //edit
            else if ( editYesOrNo == 1 ) {
                //0 adalah jenis izin cuti
                if (jenisIzin == 0){
                    query = "UPDATE presensi_izin SET "
                            + "jenis_izin_cuti=?,"
                            + "jum_cuti=?,"
                            + "tanggal_dimulai_cuti=?,"
                            + "tanggal_selesai_cuti=?,"
                            + "keterangan=?,"
                            + "user_updated=?,"
                            + "tanggal_update=now() "
                            + "WHERE id_cuti = ?";
                    PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                    setDataSimpanEdit(ps,m, jenisIzin);
                    ps.execute();
                }
                //1 adalah jenis izin sakit
                else if(jenisIzin == 1){
                   query = "UPDATE presensi_izin SET "
                            + "jum_cuti=?,"
                            + "tanggal_dimulai_cuti=?,"
                            + "tanggal_selesai_cuti=?,"
                            + "keterangan=?,"
                            + "user_updated=?,"
                            + "tanggal_update=now() "
                            + "WHERE id_cuti = ?";
                    PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                    setDataSimpanEdit(ps,m, jenisIzin);
                    ps.execute();
                }
                else {System.out.println("tidak ada pilihan jenis izin");}
            }
            dbMysql.disconnectDbMysql();
            //jika status pelamar adalah diterima maka sistem akan save ke tabel karyawan dan karywanan_detail
           
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
    }
     private void setDataSimpanEdit(PreparedStatement ps,domainPresensiIzinDanLembur m, int jenisIzin){
        try {
            int n = 0;
            if (jenisIzin == 0){
                ps.setInt( n += 1, Integer.valueOf(m.getJenisIzinCuti()));
            }
           ps.setInt(n += 1, Integer.valueOf(m.getJumlahIzinCuti()));
           ps.setDate(n += 1, new java.sql.Date(m.getTanggalIzinCutiMulai().getTime()));
           ps.setDate(n += 1, new java.sql.Date(m.getTanggalIzinCutiSelsai().getTime()));
           ps.setString(n += 1, m.getKet());
           ps.setString(n += 1, m.getUserUpdated());
           ps.setString(n += 1, m.getRefCode());
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setDataSimpan(PreparedStatement ps,domainPresensiIzinDanLembur m, int jenisIzin){
        try {
            com.ari.prasetiyo.sistem.transNo transNo = new com.ari.prasetiyo.sistem.transNo();
            // membuat transno dengan kode awal ICT
            if (jenisIzin ==0){
                String sql = "select id_cuti as id from presensi_izin  where year(tanggal_dibuat) = year(now()) and  jenis_izin = 0 order by no desc limit 1 ";
                m.setRefCode(transNo.setGetTransNo("ICT", sql));
            }
            else if (jenisIzin == 1){
                String sql = "select id_cuti as id from presensi_izin  where year(tanggal_dibuat) = year(now()) and jenis_izin = 1 order by no desc limit 1 ";
                m.setRefCode(transNo.setGetTransNo("IS", sql));
            }
            int urut =0;
            ps.setString(urut += 1, m.getRefCode());
            ps.setString(urut += 1, m.getIdKaryawan());
            ps.setString(urut += 1, m.getJabatan());
            //0 = jenis izin cuti
            if (jenisIzin ==0){
                ps.setInt(urut += 1, Integer.valueOf(m.getJenisIzinCuti()));
            }
            else {
                // 111 artinya bukan izin cuti 5 tahunan atau izin cuti tahunan tp izin sakit 
                ps.setInt(urut += 1, 9);
            }
            ps.setInt(urut += 1, Integer.valueOf(m.getJumlahIzinCuti()));
            ps.setDate(urut += 1, new  java.sql.Date(m.getTanggalIzinCutiMulai().getTime()));
            ps.setDate(urut += 1, new  java.sql.Date(m.getTanggalIzinCutiSelsai().getTime()));
            //ps.setString(8, m.getJenisIzinCutiOrSakit());
            ps.setString(urut += 1, m.getKet());
            ps.setString(urut += 1, m.getUserCreated());
            ps.setString(urut += 1, m.getUserCreated());

        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SimpanLembur(domainPresensiIzinDanLembur m, int editYesOrNo){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query;
            //save
            if (editYesOrNo == 0 ){
                query = "insert into  presensi_lembur "
                        + "(id_lembur, id_karyawan, jabatan, katagori_lembur,  	jum_lembur, "
                        + "tanggal_dimulai_lembur, tanggal_selesai_lembur, keterangan, user_created, "
                        + "user_updated, tanggal_dibuat, tanggal_update) "
                        + " values (?,?,?,?,?,"
                        + "?,?,?,?,"
                        + "?, now(),now() ); ";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                setDataSimpanLembur(ps,m);
                ps.execute();
            }
            //edit
            else if ( editYesOrNo == 1 ) {
                 //0 adalah jenis izin cuti
                query = "UPDATE presensi_lembur SET "
                        + "katagori_lembur=?,"
                        + "jum_lembur=?,"
                        + "tanggal_dimulai_lembur=?,"
                        + "tanggal_selesai_lembur=?,"
                        + "keterangan=?,"
                        + "user_updated=?,"
                        + "tanggal_update=now() "
                        + "WHERE id_lembur = ?";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                setDataSimpanLemburEdit(ps,m);
                ps.execute();
               
            }
            dbMysql.disconnectDbMysql();
            //jika status pelamar adalah diterima maka sistem akan save ke tabel karyawan dan karywanan_detail
           
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
    }
    private void setDataSimpanLembur(PreparedStatement ps,domainPresensiIzinDanLembur m){
        try {
            com.ari.prasetiyo.sistem.transNo transNo = new com.ari.prasetiyo.sistem.transNo();
            // membuat transno dengan kode awal ICT
            String sql = "select id_lembur as id from presensi_lembur  where year(tanggal_dibuat) = year(now())  order by no desc limit 1 ";
            m.setRefCode(transNo.setGetTransNo("LEM", sql));
            ps.setString(1, m.getRefCode());
            ps.setString(2, m.getIdKaryawan());
            ps.setString(3, m.getJabatan());
            ps.setInt(4, Integer.valueOf(m.getKatagoriLembur()));
            ps.setInt(5, Integer.valueOf(m.getJumlahLembur()));
            ps.setDate(6, new  java.sql.Date(m.getTanggalLemburMulai().getTime()));
            ps.setDate(7, new  java.sql.Date(m.getTanggalLemburSelesai().getTime()));
            //ps.setString(8, m.getJenisIzinCutiOrSakit());
            ps.setString(8, m.getKet());
            ps.setString(9, m.getUserCreated());
            ps.setString(10, m.getUserCreated());
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void setDataSimpanLemburEdit(PreparedStatement ps,domainPresensiIzinDanLembur m){
        try {
            ps.setInt(1, Integer.valueOf(m.getKatagoriLembur()));
            ps.setInt(2, Integer.valueOf(m.getJumlahLembur()));
            ps.setDate(3, new  java.sql.Date(m.getTanggalLemburMulai().getTime()));
            ps.setDate(4, new  java.sql.Date(m.getTanggalLemburSelesai().getTime()));
            //ps.setString(8, m.getJenisIzinCutiOrSakit());
            ps.setString(5, m.getKet());
            ps.setString(6, m.getUserUpdated());
            ps.setString(7, m.getRefCode());

        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    ambil list data pencarian karyawan
    */
    public ArrayList<domainPresensiIzinDanLembur> tampilDataPencarian(String dataYgDicari,  com.ari.prasetiyo.domain.domainPresensiIzinDanLembur dMA ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            sql = "select id_karyawan as id, nama from payroll_master_karyawan where nama like ? or id_karyawan like ? ";
            ps = dbMysql.koneksi.prepareStatement(sql);
            ps.setString(1, "%"+dataYgDicari+"%");
            ps.setString(2, "%"+dataYgDicari+"%");
            rs = ps.executeQuery();
            
            ArrayList<domainPresensiIzinDanLembur> listHasil = new  ArrayList<domainPresensiIzinDanLembur>();
            while(rs.next()){                
                domainPresensiIzinDanLembur p = konversiResultSet(rs);
                listHasil.add(p);
            }
            //rs.close();
            dbMysql.disconnectDbMysql();
            
            return listHasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
        return null;
    }
    private domainPresensiIzinDanLembur konversiResultSet(ResultSet rs) {
        try {
            domainPresensiIzinDanLembur p = new domainPresensiIzinDanLembur();
                p.setId(rs.getString("id"));
                p.setText(rs.getString("nama") + " ( " + rs.getString("id") + " )");
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
        return null;
    }
     // ambil data detail karyawan dan cuti ( hanya jabatan )
      public domainPresensiIzinDanLembur tampilDataSisaCuti( String id, int jenisIzinCuti ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            //jenis izin cuti = 0 adalah cuti tahunan
            //jenis izin cuti = 1 adalah cuti 5 tahunan
            //jenis_izin = 0 adalah izin cuti
            //jenis_izin = 1 adalah izin sakit
            if (jenisIzinCuti == 0){
                 sql = " select  cuti_tahunan -  ifnull ( (select sum(jum_cuti) as jum_cuti from presensi_izin " +
                        "where id_karyawan = ? and jenis_izin_cuti = 0 and jenis_izin = 0 and " +
                        "year(tanggal_dibuat) = year(now()) ), 0) as sisa_cuti from payroll_master_karyawan_detail " +
                        "where id_karyawan = ? order by tanggal_update desc limit 1";
            }
            else if (jenisIzinCuti == 1){
                 sql = " select  ( case when ( DATEDIFF (  now(), s_periode ) > 366 ) " +
                        "then " +
                        "(cuti_5_tahunan -  ifnull ( (select sum(jum_cuti) as jum_cuti from presensi_izin " +
                        "where " +
                        "id_karyawan = ? and jenis_izin_cuti = 1 and jenis_izin = 0 and year(tanggal_dibuat) = year(now())  ) , 0) )\n" +
                        "else " +
                        "'0'  end ) as sisa_cuti " +
                        "from payroll_master_karyawan_detail " +
                        "where id_karyawan = ? order by tanggal_update desc limit 1";
            }
            else {
                System.out.println("tidak ada jenis izin cuti");
            }
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, id);
                rs = ps.executeQuery();         
            domainPresensiIzinDanLembur listHasil = new  domainPresensiIzinDanLembur();
            while(rs.next()){                
                listHasil.setSisaCutiTahunan(rs.getString("sisa_cuti"));
            }
            //rs.close();
            //ps.close();
            dbMysql.disconnectDbMysql();
            return listHasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
        return null;
    }
       // ambil data detail jabatan saja ( hanya jabatan )
      public domainPresensiIzinDanLembur tampilDataJabatanSaja( String id ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            //jenis cuti = 0 adalah cuti tahunan
            //jenis cuti = 1 adalah cuti 5 tahunan
            //jenis_izin = 0 adalah izin cuti
            //jenis_izin = 1 adalah izin sakit
            sql = " select  jabatan from payroll_master_karyawan_detail " +
                  "where id_karyawan = ? order by tanggal_update desc limit 1 ";
            ps = dbMysql.koneksi.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();         
            domainPresensiIzinDanLembur listHasil = new  domainPresensiIzinDanLembur();
            while(rs.next()){                
                listHasil.setJabatan(rs.getString("jabatan"));
            }
            //rs.close();
            //ps.close();
            dbMysql.disconnectDbMysql();
            return listHasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
        return null;
    }
    // ambil data detail karyawan dan cuti ( hanya jabatan )
      public domainPresensiIzinDanLembur tampilDataJabatanDanCuti( String id, int jenisIzinCuti ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            //jenis cuti = 0 adalah cuti tahunan
            //jenis cuti = 1 adalah cuti 5 tahunan
            //jenis_izin = 0 adalah izin cuti
            //jenis_izin = 1 adalah izin sakit
            if (jenisIzinCuti == 0){
            sql = " select  jabatan, cuti_tahunan -  ifnull ( (select sum(jum_cuti) as jum_cuti from presensi_izin " +
                    "where id_karyawan = ? and jenis_izin_cuti = 0 and jenis_izin = 0 and " +
                    "year(tanggal_dibuat) = year(now()) ), 0) as sisa_cuti from payroll_master_karyawan_detail " +
                    "where id_karyawan = ? order by tanggal_update desc limit 1";
            }
            else if (jenisIzinCuti == 1){
                 sql = " select jabatan, ( case when ( DATEDIFF (  now(), s_periode ) > 366 ) " +
                        "then " +
                        "(cuti_5_tahunan -  ifnull ( (select sum(jum_cuti) as jum_cuti from presensi_izin " +
                        "where " +
                        "id_karyawan = ? and jenis_izin_cuti = 1 and jenis_izin = 0 and year(tanggal_dibuat) = year(now())  ) , 0) )\n" +
                        "else " +
                        "'0'  end ) as sisa_cuti " +
                        "from payroll_master_karyawan_detail " +
                        "where id_karyawan = ? order by tanggal_update desc limit 1";
            }
            else {
                System.out.println("tidak ada jenis izin cuti");
            }
            ps = dbMysql.koneksi.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, id);
            rs = ps.executeQuery();         
            domainPresensiIzinDanLembur listHasil = new  domainPresensiIzinDanLembur();
            while(rs.next()){                
                listHasil = konversiResultSetDetil(rs);
            }
            //rs.close();
            //ps.close();
            dbMysql.disconnectDbMysql();
            return listHasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
        return null;
    }
     private domainPresensiIzinDanLembur konversiResultSetDetil (ResultSet rs) {
        try {
            domainPresensiIzinDanLembur p = new domainPresensiIzinDanLembur();
                p.setJabatan(rs.getString("jabatan"));
                p.setSisaCutiTahunan(rs.getString("sisa_cuti"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoPresensiIzinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoPresensiIzinDanLembur.class.getName(), ex);
        }
        return null;
    }
   /*
    ambil list data cuti dan lembur
    */
    public ArrayList<domainPresensiIzinDanLembur> tampilDataListPresensi(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            //jika ada data filter
             if (dMA.isLanjut()){
                //jika filter periode 1 dan periode 2 ada 
                if (dMA.getfPeriodeCreate1() != null ||  dMA.getfPeriodeCreate2() != null ){
                    if ( !dMA.getfPeriodeCreate1().equals("") || !dMA.getfPeriodeCreate2().equals("") ){
                        //izin cuti
                        if (dMA.getfStatPlmr().equals("0")){
                            sql =  " select  piz.id_cuti as ref_code ,piz. id_karyawan as  id_karyawann,  mk.nama, piz.jabatan as jabatann,  'izin cuti tahunan'  as status, " +
                                   " piz.tanggal_dimulai_cuti as mulai, piz.tanggal_selesai_cuti as selesai,"+
                                    "case " +
                                    "when (length (piz.keterangan) > 50 ) then concat (substring(piz.keterangan, 1, 50), ' ...') " +
                                    "else piz.keterangan " +
                                    "end as ket, "+
                                   " piz.tanggal_dibuat as tanggal_dibuatt  from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan and " +
                                   " piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 0 and date_format(piz.tanggal_dibuat , '%Y-%m-%d') between ? and ? " 
                                    + "order by piz.no desc  limit ?,? ";
                        }
                        //izin sakit
                        else if  (dMA.getfStatPlmr().equals("1")){
                            sql = " select  piz.id_cuti as ref_code ,piz.id_karyawan as  id_karyawann ,  mk.nama, piz.jabatan as jabatann,  'izin cuti 5 tahunan'  as status, " +
                                   " piz.tanggal_dimulai_cuti as mulai , piz.tanggal_selesai_cuti as selesai,"+
                                    "case " +
                                    "when (length (piz.keterangan) > 50 ) then concat (substring(piz.keterangan, 1, 50), ' ...') " +
                                    "else piz.keterangan " +
                                    "end as ket, "+
                                   " piz.tanggal_dibuat as tanggal_dibuatt  from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan and " +
                                   " piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 1 and date_format(piz.tanggal_dibuat , '%Y-%m-%d') between ? and ? " 
                                    + "order by piz.no desc  limit ?,?  ";
                        }
                        //lembur
                        else  if (dMA.getfStatPlmr().equals("2")){
                            sql = " select  piz.id_lembur as ref_code ,piz.id_karyawan as  id_karyawann,  mk.nama, piz.jabatan as jabatann,  concat ('lembur katagori ', katagori_lembur )  as status, " +
                                " piz.tanggal_dimulai_lembur as mulai, piz.tanggal_selesai_lembur as selesai,"+
                                "case " +
                                "when (length (piz.keterangan) > 50 ) then concat (substring(piz.keterangan, 1, 50), ' ...') " +
                                "else piz.keterangan " +
                                "end as ket, "+
                                " piz.tanggal_dibuat as tanggal_dibuatt   from presensi_lembur piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan and " +
                                " piz.id_lembur like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and date_format(piz.tanggal_dibuat , '%Y-%m-%d') between ? and ? " 
                              + "order by piz.no desc  limit ?,?";
                        }
                        else {
                            sql ="select ref_code ,  id_karyawann, mk.nama, jabatann, status, mulai, selesai,ket, tanggal_dibuatt from ( " +
                                "select  id_cuti as ref_code,  id_karyawan as id_karyawann, jabatan as jabatann,  " +
                                "case " +
                                "when (jenis_izin_cuti = 0 ) then 'izin cuti tahunan' " +
                                "when (jenis_izin_cuti = 1)  then 'izin cuti 5 tahunan' " +
                                "when (jenis_izin = 1)  then 'izin sakit'  " +
                                "end as status, tanggal_dimulai_cuti as mulai, tanggal_selesai_cuti as selesai, " +
                                "case " +
                                "when (length (keterangan) > 50 ) then concat (substring(keterangan, 1, 50), ' ...') " +
                                "else keterangan " +
                                "end as ket," +
                                "tanggal_dibuat as tanggal_dibuatt " +
                                "from presensi_izin  where id_cuti like ? and id_karyawan like ? and jabatan like ? "+
                                " and date_format(tanggal_dibuat , '%Y-%m-%d') between ? and ? " +
                                "union  " +
                                "select id_lembur, id_karyawan , jabatan, concat ('lembur katagori ', katagori_lembur ), " +
                                "tanggal_dimulai_lembur, tanggal_selesai_lembur," +
                                "case " +
                                "when (length (keterangan) > 50 ) then concat (substring(keterangan, 1, 50), ' ...') " +
                                "else keterangan " +
                                "end as ket,  tanggal_dibuat  " +
                                "from presensi_lembur  where id_lembur like ? and id_karyawan like ? and jabatan like ?  " +
                                "and date_format(tanggal_dibuat , '%Y-%m-%d') between ? and ? " +
                                ") b inner join payroll_master_karyawan mk on b.id_karyawann = mk.id_karyawan and mk.nama like ? order by b.tanggal_dibuatt desc limit ?,?";
                        }
                        ps = dbMysql.koneksi.prepareStatement(sql);
                         if (dMA.getfPilihan().equals("tanpaStatus")){
                            ps.setString(1, "%"+dMA.getfId() +"%");
                            ps.setString(2, "%"+dMA.getfIdKaryawan()+"%");
                            ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                            ps.setDate(4,  new  java.sql.Date(dMA.getfPeriodeCreate1().getTime()) );
                            ps.setDate(5, new  java.sql.Date(dMA.getfPeriodeCreate2().getTime())  );
                            ps.setString(6, "%"+dMA.getfId()+"%" );
                            ps.setString(7, "%"+dMA.getfIdKaryawan()+"%" );
                            ps.setString(8, "%"+dMA.getfJabatan()+"%" );
                            ps.setDate(9, new  java.sql.Date(dMA.getfPeriodeCreate1().getTime()) );
                            ps.setDate(10, new  java.sql.Date(dMA.getfPeriodeCreate2().getTime())  );
                            ps.setString(11, "%"+dMA.getfNama()+"%" );
                            ps.setInt(12, limitBawah);
                            ps.setInt(13, limitAtas);
                        }
                        else{
                            ps.setString(1, "%"+dMA.getfId() +"%");
                            ps.setString(2, "%"+dMA.getfIdKaryawan()+"%");
                            ps.setString(3, "%"+dMA.getfNama()+"%");
                            ps.setString(4, "%"+dMA.getfJabatan()+"%" );
                            ps.setDate(5,  new  java.sql.Date(dMA.getfPeriodeCreate1().getTime()) );
                            ps.setDate(6, new  java.sql.Date(dMA.getfPeriodeCreate2().getTime())  );
                            ps.setInt(7, limitBawah);
                            ps.setInt(8, limitAtas);
                        }
                        rs = ps.executeQuery();
                    }
                }
                //filter tanpa periode
                else {
                    //izin cuti
                    if (dMA.getfStatPlmr().equals("0")){
                        sql =  " select  piz.id_cuti as ref_code ,piz. id_karyawan as  id_karyawann,  mk.nama, piz.jabatan as jabatann,  'izin cuti tahunan'  as status, " +
                               " piz.tanggal_dimulai_cuti as mulai, piz.tanggal_selesai_cuti as selesai,"+
                                "case " +
                                "when (length (piz.keterangan) > 50 ) then concat (substring(piz.keterangan, 1, 50), ' ...') " +
                                "else piz.keterangan " +
                                "end as ket, "+
                               " piz.tanggal_dibuat as tanggal_dibuatt  from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan and " +
                               " piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 0 order by piz.no desc  limit ?,? ";
                    }
                    //izin sakit
                    else if  (dMA.getfStatPlmr().equals("1")){
                        sql = " select  piz.id_cuti as ref_code ,piz.id_karyawan as  id_karyawann ,  mk.nama, piz.jabatan as jabatann,  'izin cuti 5 tahunan'  as status, " +
                               " piz.tanggal_dimulai_cuti as mulai , piz.tanggal_selesai_cuti as selesai,"+
                                "case " +
                                "when (length (piz.keterangan) > 50 ) then concat (substring(piz.keterangan, 1, 50), ' ...') " +
                                "else piz.keterangan " +
                                "end as ket, "+
                               " piz.tanggal_dibuat as tanggal_dibuatt  from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan and " +
                               " piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 1 order by piz.no desc  limit ?,?  ";
                    }
                    //lembur
                    else  if (dMA.getfStatPlmr().equals("2")){
                        sql = " select  piz.id_lembur as ref_code ,piz.id_karyawan as  id_karyawann,  mk.nama, piz.jabatan as jabatann,  concat ('lembur katagori ', katagori_lembur )  as status, " +
                            " piz.tanggal_dimulai_lembur as mulai, piz.tanggal_selesai_lembur as selesai,"+
                            "case " +
                            "when (length (piz.keterangan) > 50 ) then concat (substring(piz.keterangan, 1, 50), ' ...') " +
                            "else piz.keterangan " +
                            "end as ket, "+
                            " piz.tanggal_dibuat as tanggal_dibuatt   from presensi_lembur piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan and " +
                            " piz.id_lembur like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? order by piz.no desc  limit ?,?";
                    }
                    else {
                        sql ="select ref_code ,  id_karyawann, mk.nama, jabatann, status, mulai, selesai,ket, tanggal_dibuatt from ( " +
                            "select  id_cuti as ref_code,  id_karyawan as id_karyawann, jabatan as jabatann, " +
                            "case " +
                            "when (jenis_izin_cuti = 0 ) then 'izin cuti tahunan' " +
                            "when (jenis_izin_cuti = 1)  then 'izin cuti 5 tahunan' " +
                            "when (jenis_izin = 1)  then 'izin sakit' " +
                            "end as status, tanggal_dimulai_cuti as mulai, tanggal_selesai_cuti as selesai, "+
                            "case " +
                            "when (length (keterangan) > 50 ) then concat (substring(keterangan, 1, 50), ' ...') " +
                            "else keterangan " +
                            "end as ket, "+
                            " tanggal_dibuat as tanggal_dibuatt " +
                            "from presensi_izin  where id_cuti like ? and id_karyawan like ? and jabatan like ? " +
                            "union " +
                            "select id_lembur, id_karyawan , jabatan, concat ('lembur katagori ', katagori_lembur ), " +
                            "tanggal_dimulai_lembur, tanggal_selesai_lembur,"+
                            "case " +
                            "when (length (keterangan) > 50 ) then concat (substring(keterangan, 1, 50), ' ...') " +
                            "else keterangan " +
                            "end as ket,  tanggal_dibuat  " +
                            "from presensi_lembur  where id_lembur like ? and id_karyawan like ? and jabatan like ? " +
                            ") b inner join payroll_master_karyawan mk on b.id_karyawann = mk.id_karyawan and mk.nama like ? order by b.tanggal_dibuatt desc limit ?,?";
                    }
                    ps = dbMysql.koneksi.prepareStatement(sql);
                    if (dMA.getfPilihan().equals("tanpaStatus")){
                        ps.setString(1, "%"+dMA.getfId() +"%");
                        ps.setString(2, "%"+dMA.getfIdKaryawan()+"%");
                        ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                        ps.setString(4, "%"+dMA.getfId()+"%" );
                        ps.setString(5, "%"+dMA.getfIdKaryawan()+"%" );
                        ps.setString(6, "%"+dMA.getfJabatan()+"%" );
                        ps.setString(7, "%"+dMA.getfNama()+"%" );
                        ps.setInt(8, limitBawah);
                        ps.setInt(9, limitAtas);
                    }
                    else{
                        ps.setString(1, "%"+dMA.getfId() +"%");
                        ps.setString(2, "%"+dMA.getfIdKaryawan()+"%");
                        ps.setString(3, "%"+dMA.getfNama()+"%");
                        ps.setString(4, "%"+dMA.getfJabatan()+"%" );
                        ps.setInt(5, limitBawah);
                        ps.setInt(6, limitAtas);
                    }
                    rs = ps.executeQuery();
                }
            }
            //ambil data tanpa filter
            else{
                 sql ="select ref_code, id_karyawann, mk.nama, jabatann, status, mulai, selesai,ket, tanggal_dibuatt from ( " +
                    "select id_cuti as ref_code,  id_karyawan as id_karyawann, jabatan as jabatann, " +
                    "case " +
                    "when (jenis_izin_cuti = 0 ) then 'izin cuti tahunan' " +
                    "when (jenis_izin_cuti = 1)  then 'izin cuti 5 tahunan' " +
                    "when (jenis_izin = 1)  then 'izin sakit' " +
                    "end as status, tanggal_dimulai_cuti as mulai, tanggal_selesai_cuti as selesai, " +
                    "case " +
                    "when (length (keterangan) > 50 ) then concat (substring(keterangan, 1, 50), ' ...') " +
                    "else keterangan " +
                    "end as ket, "+
                    "tanggal_dibuat as tanggal_dibuatt " +
                    "from presensi_izin  " +
                    "union " +
                    "select id_lembur, id_karyawan , jabatan, concat ('lembur katagori ', katagori_lembur ), " +
                    "tanggal_dimulai_lembur, tanggal_selesai_lembur, " +
                    "case " +
                    "when ( length (keterangan) > 50 ) then concat (substring(keterangan, 1, 50), '...') " +
                    "else keterangan " +
                    "end as ket, " +
                    "tanggal_dibuat " +
                    "from presensi_lembur  " +
                    ") b inner join payroll_master_karyawan mk on b.id_karyawann = mk.id_karyawan order by b.tanggal_dibuatt desc limit ?,?";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setInt(1, limitBawah);
                ps.setInt(2, limitAtas);
                rs = ps.executeQuery();
            }
            ArrayList<domainPresensiIzinDanLembur> listHasil = new  ArrayList<domainPresensiIzinDanLembur>();
            while(rs.next()){                
                domainPresensiIzinDanLembur p = konversiResultSetList(rs);
                listHasil.add(p);
            }
            //rs.close();
            dbMysql.disconnectDbMysql();
            
            return listHasil;
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
    
    private domainPresensiIzinDanLembur konversiResultSetList(ResultSet rs) {
        try {
            domainPresensiIzinDanLembur p = new domainPresensiIzinDanLembur();
                p.setRefCode(rs.getString("ref_code"));
                p.setIdKaryawan(rs.getString("id_karyawann"));
                p.setNama(rs.getString("nama"));
                p.setJabatan(rs.getString("jabatann"));
                p.setStatusPresensi(rs.getString("status"));
                p.setTanggalMulai(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("mulai")));
                p.setTanggalSelesai(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("selesai")));
                p.setKet(rs.getString("ket"));
                p.setTanggalDibuat(rs.getDate("tanggal_dibuatt"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
    // ambil data detail
      public domainPresensiIzinDanLembur tampilDetilPresensi( String id ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;

            if (id.matches("(ICT.+)||(IS.+)")){
                sql ="select piz.id_cuti as ref_code, piz.id_karyawan, mk.nama, piz.jabatan, piz.jenis_izin_cuti as jenis, " +
                    "piz.jum_cuti as jum, piz.tanggal_dimulai_cuti as mulai, piz.tanggal_selesai_cuti as selesai, piz.jenis_izin, piz.keterangan, " +
                    "piz.tanggal_dibuat, piz.user_created " +
                    "from payroll_master_karyawan mk, presensi_izin piz where mk.id_karyawan = piz.id_karyawan and piz.id_cuti = ? ";
            }
            else if (id.matches("(LEM.+)")){
                sql ="select piz.id_lembur as ref_code, piz.id_karyawan, mk.nama, piz.jabatan, piz.katagori_lembur as jenis, " +
                    "piz.jum_lembur as jum, piz.tanggal_dimulai_lembur as mulai, piz.tanggal_selesai_lembur as selesai, piz.keterangan, " +
                    "piz.tanggal_dibuat, piz.user_created " +
                    "from payroll_master_karyawan mk, presensi_lembur piz where mk.id_karyawan = piz.id_karyawan and piz.id_lembur = ? ";
            }
            else {
                System.out.println("Tidak ditemukan regex " + this.getClass().getName());
            }
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();         
            domainPresensiIzinDanLembur listHasil = new  domainPresensiIzinDanLembur();
            while(rs.next()){                
                listHasil = konversiResultSetDetilPresensi(rs);
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
     private domainPresensiIzinDanLembur konversiResultSetDetilPresensi (ResultSet rs) {
        try {
            domainPresensiIzinDanLembur p = new domainPresensiIzinDanLembur();
                p.setRefCode(rs.getString("ref_code"));
                p.setIdKaryawan(rs.getString("id_karyawan"));
                p.setNama(rs.getString("nama"));
                p.setJabatan(rs.getString("jabatan"));
                p.setJenisIzinCuti(String.valueOf(rs.getInt("jenis")));
                p.setJumlahIzinCuti(String.valueOf(rs.getInt("jum")));
                p.setTanggalMulai(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("mulai")));
                p.setTanggalSelesai(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("selesai")));
                try{
                    //difungsikan untuk presensi izin, presensi lembur tidak
                    p.setJenisIzinCutiOrSakit(rs.getString("jenis_izin"));
                }
                catch (Exception x){ }
                p.setKet(rs.getString("keterangan"));
                p.setUserCreated(rs.getString("user_created"));
                p.setTanggalDibuat(rs.getDate("tanggal_dibuat"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
}

