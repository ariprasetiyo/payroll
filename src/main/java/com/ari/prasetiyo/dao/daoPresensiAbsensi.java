/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.domain.domainPresensiAbsensi;
import com.ari.prasetiyo.sistem.connectDb;
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
public class daoPresensiAbsensi {
    /*
    Untuk simpan dan update data
    editYesOrNo = 0 = simapan
    editYesOrNo = 1 = update
    insert data pelamar
    */
    public void Simpan(domainPresensiAbsensi m, int editYesOrNo){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query;
            //save
            if (editYesOrNo == 0 ){
                for (int a = 0; a < m.getIdKar().length; a++){
                    query = " INSERT INTO presensi_absensi(" +
                            " id_absensi, id_karyawan, nama, jabatan, area, " +
                            " cabang, status_pegawai, status_karyawan, masuk, absen, " +
                            " masuk_terlambat, pulang_lebih_awal, sakit, cuti, lembur, " +
                            " periode, user_created, user_updated, tanggal_dibuat, tanggal_update" +
                            " )  select" +
                            " ?, ? , mk.nama, mkd.jabatan, mkd.area, " +
                            " mkd.nama_cabang, mkd.sts_pegawai, mk.status_karyawan, ?, ?, " +
                            " ?,?," +
                            " ifnull((  select  sum(jum_cuti) from presensi_izin where id_karyawan = ? and  jenis_izin  = 1 and date_format(tanggal_dimulai_cuti , '%Y-%m') = date_format(now() , '%Y-%m') ),0 ), " +
                            " ifnull(( select  sum(jum_cuti) from presensi_izin where id_karyawan = ? and  jenis_izin  = 0 and date_format(tanggal_dimulai_cuti , '%Y-%m') = date_format(now() , '%Y-%m')),0 )," +
                            " ifnull(( select sum(jum_lembur) from presensi_lembur where id_karyawan = ?  and date_format(tanggal_dimulai_lembur , '%Y-%m') = date_format(now() , '%Y-%m') ),0 ) ," +
                            " now(), ?,?, now(), now()" +
                            " from payroll_master_karyawan mk, payroll_master_karyawan_detail mkd " +
                            " where mk.id_karyawan = mkd.id_karyawan and mk.id_karyawan = ? " +
                            " and NOT EXISTS (select id_karyawan from presensi_absensi where id_karyawan = ? "+
                            "and date_format(tanggal_dibuat , '%Y-%m') = date_format(now() , '%Y-%m') )" +
                            " order by mk.no desc limit 1";
                    PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                    //setDataSimpanDua(ps,m);
                    ps.setString(1, "kosong");
                    ps.setString(2, m.getIdKar()[a]);
                    if(m.getMasuk()[a].equals("") || m.getMasuk()[a] == null || m.getMasuk()[a].equals("null")){
                        ps.setInt(3, 0);
                    }
                    else{
                        if (Integer.valueOf(m.getMasuk()[a]) <32){
                            ps.setInt(3, Integer.valueOf(m.getMasuk()[a]));
                        }
                        else {
                            ps.setInt(3, 0);
                        }
                    }
                    if(m.getAbsen()[a].equals("") || m.getAbsen()[a] == null || m.getAbsen()[a].equals("null")){
                        ps.setInt(4, 0);
                    }
                    else{
                        if (Integer.valueOf(m.getAbsen()[a]) < 32){
                             ps.setInt(4, Integer.valueOf(m.getAbsen()[a]));
                        }
                        else{
                             ps.setInt(4, 0);
                        }
                    }
                    if(m.getMT()[a].equals("") || m.getMT()[a] == null || m.getMT()[a].equals("null")){
                        ps.setInt(5, 0);
                    }
                    else{
                        if (Integer.valueOf(m.getMT()[a]) < 32){
                              ps.setInt(5, Integer.valueOf(m.getMT()[a]));
                        }
                        else{
                             ps.setInt(5, 0);
                        }
                    }
                    if(m.getPLA()[a].equals("") || m.getPLA()[a] == null || m.getPLA()[a].equals("null")){
                        ps.setInt(6, 0);
                    }
                    else{
                        if (Integer.valueOf(m.getPLA()[a]) < 32){
                              ps.setInt(6, Integer.valueOf(m.getPLA()[a]));
                        }
                        else{
                             ps.setInt(6, 0);
                        }
                    }
                    ps.setString(7, m.getIdKar()[a]);
                    ps.setString(8, m.getIdKar()[a]);
                    ps.setString(9, m.getIdKar()[a]);
                    //ps.setInt(3, Integer.valueOf(m.gets()[a]));
                    ps.setString(10, m.getUserCreated());
                    ps.setString(11, m.getUserCreated());
                    ps.setString(12, m.getIdKar()[a]);
                    ps.setString(13, m.getIdKar()[a]);
                    ps.execute(); 
                }
            }
            //edit
            else if ( editYesOrNo == 1 ) {
            }
            dbMysql.disconnectDbMysql();
           
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
    }
    /*
    ambil data new absensi
    */
    public ArrayList<domainPresensiAbsensi> tampilDataNew(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            sql = " SELECT  mkd.id_karyawan  , mkd.sts_pegawai as status_pegawai, mk.nama, mk.jenis_kelamin, mk.status_karyawan, mkd.jabatan, mk.no_telphone, " +
                    "mkd.area, mkd.nama_cabang as cabang "+
                    " from ( select id_karyawan,max(tanggal_update) tanggal_update from payroll_master_karyawan_detail group by id_karyawan) A " +
                    " INNER JOIN payroll_master_karyawan_detail mkd " +
                    " on A.id_karyawan = mkd.id_karyawan and A.tanggal_update = mkd.tanggal_update " +
                    " inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan " +
                    " order by mk.no desc  limit ?,? ";

                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setInt(1, limitBawah);
                ps.setInt(2, limitAtas);
                rs = ps.executeQuery();
            
            ArrayList<domainPresensiAbsensi> listHasil = new  ArrayList<domainPresensiAbsensi>();
            while(rs.next()){                
                domainPresensiAbsensi p = konversiResultSetNew(rs);
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
     private domainPresensiAbsensi konversiResultSetNew(ResultSet rs) {
        try {
            domainPresensiAbsensi p = new domainPresensiAbsensi();
            com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
                p.setId(rs.getString("id_karyawan"));
                p.setSts_pegawai(convertAll.convertPegawai(rs.getInt("status_pegawai")));
                p.setArea(convertAll.convertArea(rs.getString("area")));
                p.setNama_cabang(rs.getString("cabang"));
                p.setNama(rs.getString("nama"));
                p.setStatusPelamar(convertAll.convertStatusKaryawan(rs.getInt("status_karyawan")));
                p.setJabatan(rs.getString("jabatan"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }

    /*
    ambil list data absensi yang tersimpan
    */
    public ArrayList<domainPresensiAbsensi> tampilData(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            //jika ada data filter
             if (dMA.isLanjut()){
                if (dMA.getfPeriodeCreate1() != null ||  dMA.getfPeriodeCreate2() != null ){
                    if ( !dMA.getfPeriodeCreate1().equals("") || !dMA.getfPeriodeCreate2().equals("") ){
                        sql =  " SELECT  id_karyawan, nama, jabatan, area, cabang, "
                         + "status_pegawai, status_karyawan, masuk, absen, masuk_terlambat, "
                         + "pulang_lebih_awal, sakit, cuti, lembur, periode, "
                         + "user_created, tanggal_dibuat "
                         + "from presensi_absensi where " +
                         "  id_karyawan like ? and status_pegawai like ? "
                            + "and jabatan like ? and area like ? "
                            + "and status_karyawan like ? and nama like ? "
                                + " and date_format(tanggal_dibuat, '%Y-%m') = date_format(?, '%Y-%m')"
                            + "order by no desc  limit ?,? ;";
                        ps = dbMysql.koneksi.prepareStatement(sql);
                        //System.out.println("2." + dMA.getfStatPlmr() + " dan " + dMA.getfStatusPegawai());
                        ps.setString(1, "%"+dMA.getfId()+"%" );
                        ps.setString(2, "%"+dMA.getfStatusPegawai()+"%" );
                        ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                        ps.setString(4, "%"+dMA.getfArea()+"%" );
                        ps.setString(5, "%"+dMA.getfStatPlmr()+"%" );
                        ps.setString(6, "%"+dMA.getfNama()+"%");
                        ps.setDate(7,  new  java.sql.Date(dMA.getfPeriodeCreate1().getTime()) );
                        ps.setInt(8, limitBawah);
                        ps.setInt(9, limitAtas);
                        rs = ps.executeQuery();
                    }
                }
                //filter tanpa periode\
                // date_format(tanggal_dibuat, '%Y-%m') = date_format(now() karena data absensi tiap bulan itu ada jadi tdk boleh di ambil semua
                else {

                    sql =  " SELECT  id_karyawan, nama, jabatan, area, cabang, "
                         + "status_pegawai, status_karyawan, masuk, absen, masuk_terlambat, "
                         + "pulang_lebih_awal, sakit, cuti, lembur, periode, "
                         + "user_created, tanggal_dibuat "
                         + "from presensi_absensi where date_format(tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')" +
                         " and  id_karyawan like ? and status_pegawai like ? "
                            + "and jabatan like ? and area like ? "
                            + "and status_karyawan like ? and nama like ? "
                            + "order by no desc  limit ?,? ;";
                    ps = dbMysql.koneksi.prepareStatement(sql);
                    ps.setString(1, "%"+dMA.getfId() +"%");
                    ps.setString(2, "%"+dMA.getfStatusPegawai()+"%" );
                    ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                    ps.setString(4, "%"+dMA.getfArea()+"%" );
                    ps.setString(5, "%"+dMA.getfStatPlmr()+"%" );
                    ps.setString(6, "%"+dMA.getfNama()+"%");
                    ps.setInt(7, limitBawah);
                    ps.setInt(8, limitAtas);
                    rs = ps.executeQuery();
                }
            }
            //ambil data tanpa filter
            else{
                 sql =  " SELECT  id_karyawan, nama, jabatan, area, cabang, "
                         + "status_pegawai, status_karyawan, masuk, absen, masuk_terlambat, "
                         + "pulang_lebih_awal, sakit, cuti, lembur, periode, "
                         + "user_created, tanggal_dibuat "
                         + "from presensi_absensi where date_format(tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')" +
                         "  order by no desc  limit ?,? ;";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setInt(1, limitBawah);
                ps.setInt(2, limitAtas);
                rs = ps.executeQuery();
            }
            ArrayList<domainPresensiAbsensi> listHasil = new  ArrayList<domainPresensiAbsensi>();
            while(rs.next()){                
                domainPresensiAbsensi p = konversiResultSet(rs);
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
    private domainPresensiAbsensi konversiResultSet(ResultSet rs) {
        try {
            domainPresensiAbsensi p = new domainPresensiAbsensi();
            com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
                p.setId(rs.getString("id_karyawan"));
                p.setSts_pegawai(convertAll.convertPegawai(rs.getInt("status_pegawai")));
                p.setArea(convertAll.convertArea(rs.getString("area")));
                p.setNama_cabang(rs.getString("cabang"));
                p.setNama(rs.getString("nama"));
                p.setStatusPelamar(convertAll.convertStatusKaryawan(rs.getInt("status_karyawan")));
                p.setJabatan(rs.getString("jabatan"));
                p.setMasukInt(rs.getInt("masuk"));
                p.setAbsenInt(rs.getInt("absen"));
                p.setMasukTerlambat(rs.getInt("masuk_terlambat"));
                p.setPulangLebihAwal(rs.getInt("pulang_lebih_awal"));
                p.setSakit(rs.getInt("sakit"));
                p.setCuti(rs.getInt("cuti"));
                p.setLembur(rs.getInt("lembur"));
                p.setTanggalDibuat(rs.getDate("tanggal_dibuat"));
                p.setUser_created(rs.getString("user_created"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }

}
