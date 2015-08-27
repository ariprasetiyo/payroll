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
public class daoMasterKaryawan {
    /*
    Untuk simpan dan update data
    editYesOrNo = 0 = simapan
    editYesOrNo = 1 = update
    insert data pelamar
    */
    public void Simpan(domainMasterKaryawan m, int editYesOrNo){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query;
            //save
            if (editYesOrNo == 0 ){
                //insert data payroll_master_karyawan_detail
                query = "insert into payroll_master_karyawan_detail ( "
                        + "id_karyawan, area, nama_cabang, cuti_tahunan, cuti_5_tahunan, "
                        + "sts_pegawai, jabatan, gaji, t_kerajinan, t_operational, "
                        + "t_bpjs_ketenagakerjaan, t_bpjs_kesehatan, t_lainnya, t_kesehatan, t_penepatan, "
                        + "t_transport, t_makan, t_jabatan, p_pinjaman_karyawan, p_bpjs_ketenagakerjaan, "
                        + "p_bpjs_kesehatan, p_asr_kesehatan, p_denda_kedisiplinan, p_pajak, e_periode, "
                        + "s_periode, user_created, user_updated, tanggal_dibuat, tanggal_update, "
                        + "sts_insert_or_not " +
                        " ) values "
                        + "(?,?,?,?,?,?,?,?,?,?, "
                        + " ?,?,?,?,?,?,?,?,?,?, "
                        + " ?,?,?,?,?,?,?,?,?,now(),"
                        + " 1) ";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                dbMysql.koneksi.setAutoCommit(true);
                setDataSimpanDua(ps,m);
                ps.executeBatch();
            }
            //edit
            else if ( editYesOrNo == 1 ) {
                //update data payroll_master_karyawan_detail
                query = "update payroll_master_karyawan_detail set " +
                        "area = ?,"+
                        "nama_cabang = ?,"+
                        "cuti_tahunan = ?,"+
                        "cuti_5_tahunan = ?,"+
                        "sts_pegawai=? ,"+//1   
                        "jabatan = ?,"+
                        "gaji=? ,"+//2 
                        "t_kerajinan=? ,"+//3
                        "t_operational=? ,"+//4
                        "t_bpjs_ketenagakerjaan=? ,"+//5
                        "t_bpjs_kesehatan=? ,"+//6
                        "t_lainnya=? ,"+//7
                        "t_kesehatan=? ,"+//8
                        "t_penepatan=? , "+//9
                        "t_transport =? ,"+//10
                        "t_makan=? ,"+//11
                        "t_jabatan =? ,"+//12
                        "p_pinjaman_karyawan =? ,"+//13
                        "p_bpjs_ketenagakerjaan =? ,"+//14
                        "p_bpjs_kesehatan =? ,"+//15
                        "p_asr_kesehatan=? ,"+//16
                        "p_denda_kedisiplinan=? ,"+//17
                        "p_pajak=? ,"+//18
                        "e_periode=? ,"+//19
                        "s_periode=? ,"+//20
                        "user_updated=? ,"+//21
                        "tanggal_update=now(), " +
                        "sts_insert_or_not=1 "+
                        "where id_karyawan=? ORDER BY tanggal_update DESC LIMIT 1 ;";//22
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                dbMysql.koneksi.setAutoCommit(true);
                setDataUpdateDua(ps,m);
                ps.executeBatch();
            }
            dbMysql.disconnectDbMysql();
           
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
    }
    //simpan payroll_master_karyawan_detail
    private void setDataSimpanDua(PreparedStatement ps,domainMasterKaryawan m){
        try {
            ps.setString(1, m.getId());
            //System.out.println(m.getSts_pegawai() + " dan " +m.getGaji());
            ps.setString(2, m.getArea());
            ps.setString(3, m.getNama_cabang());
            ps.setInt(4, Integer.valueOf(m.getCutiTahunan()));
            ps.setInt(5, Integer.valueOf(m.getCuti5Tahunan()));
            ps.setInt(6, Integer.valueOf(m.getSts_pegawai()));
            ps.setString(7, m.getJabatan());
            ps.setInt(8, Integer.valueOf(m.getGaji()));
            ps.setInt(9, Integer.valueOf(m.getT_kerajinan()));
            ps.setInt(10, Integer.valueOf(m.getT_operational()));
            ps.setInt(11, Integer.valueOf(m.getT_bpjs_ketenagakerjaan()));
            ps.setInt(12, Integer.valueOf(m.getT_bpjs_kesehatan()));
            ps.setInt(13, Integer.valueOf(m.getT_lainnya()));
            ps.setInt(14, Integer.valueOf(m.getT_kesehatan()));
            ps.setInt(15, Integer.valueOf(m.getT_penepatan()));
            ps.setInt(16, Integer.valueOf(m.getT_transport()));
            ps.setInt(17, Integer.valueOf(m.getT_makan()));
            ps.setInt(18, Integer.valueOf(m.getT_jabatan()));
            ps.setInt(19, Integer.valueOf(m.getP_pinjaman_karyawan()));
            ps.setInt(20, Integer.valueOf(m.getP_bpjs_ketenagakerjaan()));
            ps.setInt(21, Integer.valueOf(m.getP_bpjs_kesehatan()));
            ps.setInt(22, Integer.valueOf(m.getP_asr_kesehatan()));
            ps.setInt(23, Integer.valueOf(m.getP_denda_kedisiplinan()));
            ps.setInt(24, Integer.valueOf(m.getP_pajak()));
             // convert string to util
            com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
            ps.setDate(25, new  java.sql.Date(convertTgl.tglUtil(m.getE_periode(), "dd/MM/yyyy").getTime()) );
            ps.setDate(26, new  java.sql.Date(convertTgl.tglUtil(m.getS_periode(), "dd/MM/yyyy").getTime()) );
            ps.setString(27, m.getUser_created());
            ps.setString(28, m.getUser_updated());
            ps.setDate(29, new  java.sql.Date( convertTgl.tglUtil(m.getTanggal_dibuat(), "dd/MM/yyyy").getTime()));
            ps.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //update data payroll_master_karyawan_detail
    private void setDataUpdateDua(PreparedStatement ps,domainMasterKaryawan m){
        try {
            ps.setString(1, m.getArea());
            ps.setString(2, m.getNama_cabang());
            ps.setInt(3, Integer.valueOf(m.getCutiTahunan()));
            ps.setInt(4, Integer.valueOf(m.getCuti5Tahunan()));
            ps.setString(5, m.getSts_pegawai());
            ps.setString(6, m.getJabatan());
            ps.setString(7, m.getGaji());
            ps.setString(8, m.getT_kerajinan());
            ps.setString(9, m.getT_operational());
            ps.setString(10, m.getT_bpjs_ketenagakerjaan());
            ps.setString(11, m.getT_bpjs_kesehatan());
            ps.setString(12, m.getT_lainnya());
            ps.setString(13, m.getT_kesehatan());
            ps.setString(14, m.getT_penepatan());
            ps.setString(15, m.getT_transport());
            ps.setString(16, m.getT_makan());
            ps.setString(17, m.getT_jabatan());
            ps.setString(18, m.getP_pinjaman_karyawan());
            ps.setString(19, m.getP_bpjs_ketenagakerjaan());
            ps.setString(20, m.getP_bpjs_kesehatan());
            ps.setString(21, m.getP_asr_kesehatan());
            ps.setString(22, m.getP_denda_kedisiplinan());
            ps.setString(23, m.getP_pajak());
            // convert string to util
            com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
            ps.setDate(24,new  java.sql.Date(convertTgl.tglUtil(m.getE_periode(), "dd/MM/yyyy").getTime()) ); 
            ps.setDate(25,new  java.sql.Date(convertTgl.tglUtil(m.getS_periode(), "dd/MM/yyyy").getTime()) );
            ps.setString(26, m.getUser_updated());
            ps.setString(27, m.getId());
            ps.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    ambil list data karwayan
    */
    public ArrayList<domainMasterKaryawan> tampilDataKarywan(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        connectDb dbMysql = new connectDb();
        try {
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
                        /*sql =   "select mp.id, mp.nama, mp.jenis_kelamin,mp.status_pelamar, mp.jabatan, mp.no_telphone, mp.tanggal_dibuat, mp.user_created, mp.user_updated, mk.area, mk.nama_cabang "
                        + "from payroll_master_pelamar mp inner join payroll_master_karyawan mk on mp.id = mk.id where "
                        + "mp.id like ? and mp.nama like ? and mp.jabatan like ? and mp.status_pelamar like ? and "
                        + "date_format(mk.tanggal_dibuat , '%Y-%m-%d') between ? and ? "
                        + "order by mp.no desc limit ?,? ";
                        */
                        /*
                        keterangan 
                        convertPegawai = payroll_master_karyawan_detail
                        0 = Training
                        1 = Kontrak
                        2 = Tetap
                        3 = Resign
                        
                        convertStatusKaryawan = payroll_master_pelamar
                        1 = Karyawan
                        2 = ditolak
                        3 = Resign

                        */
                        /*sql = " SELECT  mkd.id_karyawan , mkd.sts_pegawai, mp.nama, mp.jenis_kelamin,mp.status_pelamar, mp.jabatan, mp.no_telphone, " +
                        "mp.tanggal_dibuat, mp.user_created, mp.user_updated, mk.area, mk.nama_cabang , " +
                        "mk.area, mk.nama_cabang , mkd.tanggal_update " +
                        "from ( select id,max(tanggal_update) tanggal_update from payroll_master_karyawan_detail group by id_karyawan) A " +
                        "INNER JOIN payroll_master_karyawan_detail mkd "
                      + "on A.id_karyawan = mkd.id_karyawan and A.tanggal_update = mkd.tanggal_update and mkd.id_karyawan like ? and mkd.sts_pegawai like ? " +
                        "inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan " +
                        "inner join payroll_master_pelamar mp "
                      + "on mk.id_karyawan = mp.id_karyawan and mp.nama like ? and mp.jabatan like ? and mp.status_pelamar like ? "
                      + "and date_format(mk.tanggal_dibuat, '%Y-%m-%d') between ? and ? order by mk.id_karyawan desc limit ?,?; ";
                        */
                        sql = "SELECT   mk.id_pelamar, mkd.id_karyawan as id , mkd.sts_pegawai, mk.nama, mk.jenis_kelamin,mk.status_karyawan, mkd.jabatan, mk.no_telphone,    " +
                            " mkd.tanggal_dibuat,  mkd.tanggal_update, mkd.user_created, mkd.user_updated, mkd.area, mkd.nama_cabang " +
                            " from ( select id_karyawan,max(tanggal_update) as tanggal_update from payroll_master_karyawan_detail group by id_karyawan) a " +
                            " INNER JOIN payroll_master_karyawan_detail mkd " +
                            " on a.id_karyawan = mkd.id_karyawan  and  " +
                            " CONVERT(DATE_FORMAT(a.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) = " +
                            " CONVERT(DATE_FORMAT(mkd.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) " +
                            " and mkd.id_karyawan like ? " +
                            " and mkd.sts_pegawai like ?  " +
                            " and mkd.jabatan like ? " +
                            " and mkd.area like ? " +
                            " and date_format(mkd.tanggal_update, '%Y-%m-%d') between ? and ? " +
                            " inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan  " +
                            " and mk.status_karyawan like ? " +
                            " and mk.nama like ? " +
                            " order by mk.tanggal_dibuat desc limit ?,?;";
                        ps = dbMysql.koneksi.prepareStatement(sql);
                        //System.out.println("2." + dMA.getfStatPlmr() + " dan " + dMA.getfStatusPegawai());
                        ps.setString(1, "%"+dMA.getfId()+"%" );
                        ps.setString(2, "%"+dMA.getfStatusPegawai()+"%" );
                        ps.setString(3, "%"+dMA.getfJabatan()+"%" );
                        ps.setString(4, "%"+dMA.getfArea()+"%" );
                        ps.setDate(5,  new  java.sql.Date(dMA.getfPeriodeCreate1().getTime()) );
                        ps.setDate(6, new  java.sql.Date(dMA.getfPeriodeCreate2().getTime())  );
                        ps.setString(7, "%"+dMA.getfStatPlmr()+"%" );
                        ps.setString(8, "%"+dMA.getfNama()+"%");
                        ps.setInt(9, limitBawah);
                        ps.setInt(10, limitAtas);
                        rs = ps.executeQuery();
                    }
                }
                //filter tanpa periode
                else {
                    sql = "    SELECT   mk.id_pelamar, mkd.id_karyawan as id , mkd.sts_pegawai, mk.nama, mk.jenis_kelamin,mk.status_karyawan, mkd.jabatan, mk.no_telphone, " +
                        " mkd.tanggal_dibuat, mkd.tanggal_update, mkd.user_created, mkd.user_updated, mkd.area, mkd.nama_cabang " +
                        " from ( select id_karyawan,max(tanggal_update) as tanggal_update from payroll_master_karyawan_detail group by id_karyawan) a " +
                        " INNER JOIN payroll_master_karyawan_detail mkd " +
                        " on a.id_karyawan = mkd.id_karyawan  and  " +
                        " CONVERT(DATE_FORMAT(a.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) = " +
                        " CONVERT(DATE_FORMAT(mkd.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) " +
                        " and mkd.id_karyawan like ? " +
                        " and mkd.sts_pegawai like ?  " +
                        " and mkd.jabatan like ? " +
                        " and mkd.area like ?" +
                        " inner join  payroll_master_karyawan mk on  mkd.id_karyawan = mk.id_karyawan  " +
                        " and mk.status_karyawan like ? " +
                        " and mk.nama like ? " +
                        " order by mk.tanggal_dibuat desc limit ?,? ;";
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
                 sql =  " SELECT  mk.id_pelamar, mkd.id_karyawan as id , mkd.sts_pegawai, mk.nama, mk.jenis_kelamin, mk.status_karyawan, mkd.jabatan, mk.no_telphone, mk.status_karyawan,  " +
                        " mkd.tanggal_dibuat, mkd.tanggal_update, mkd.user_created, mkd.user_updated, mkd.area, mkd.nama_cabang ,  " +
                        " mkd.area, mkd.nama_cabang " +
                        " from ( select id_karyawan,max(tanggal_update) tanggal_update from payroll_master_karyawan_detail group by id_karyawan) A  " +
                        " INNER JOIN payroll_master_karyawan_detail mkd " +
                        " on A.id_karyawan = mkd.id_karyawan and A.tanggal_update = mkd.tanggal_update " +
                        " inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan " +
                        "  order by mk.tanggal_dibuat desc  limit ?,? ;";
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
                p.setIdPelamar(rs.getString("id_pelamar"));
                p.setId(rs.getString("id"));
                p.setSts_pegawai(convertAll.convertPegawai(rs.getInt("sts_pegawai")));
                p.setTanggal_update(rs.getString("tanggal_update"));
                p.setArea(convertAll.convertArea(rs.getString("area")));
                p.setNama_cabang(rs.getString("nama_cabang"));
                p.setNama(rs.getString("nama"));
                p.setJenisKelamin(convertAll.convertJenisKelaminString(rs.getInt("jenis_kelamin")));
                p.setStatusPelamar(convertAll.convertStatusKaryawan(rs.getInt("status_karyawan")));
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
    
    // ambil data detail karyawan dan gaji
      public domainMasterKaryawan tampilDetilDataKaryawan( String id ){
        connectDb dbMysql = new connectDb();
        try {
 
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            sql = "SELECT  mk.nama, mk.id_karyawan as id, mpd.area, mpd.nama_cabang, mpd.cuti_tahunan, mpd.cuti_5_tahunan ,  " +
                "mpd.jabatan, " +
                "mpd.sts_pegawai, mpd.gaji, mpd.t_kerajinan, mpd.t_operational, mpd.t_bpjs_ketenagakerjaan,  " +
                "mpd.t_bpjs_kesehatan, mpd.t_lainnya, mpd.t_kesehatan, mpd.t_penepatan, mpd.t_transport,  " +
                "mpd.t_makan, mpd.t_jabatan, mpd.p_pinjaman_karyawan, mpd.p_bpjs_ketenagakerjaan,  " +
                "mpd.p_bpjs_kesehatan, mpd.p_asr_kesehatan, mpd.p_denda_kedisiplinan, mpd.p_pajak, mpd.e_periode,  " +
                "mpd.s_periode, mpd.user_created, mpd.user_updated, mpd.tanggal_dibuat, mpd.tanggal_update  " +
                "from payroll_master_karyawan mk " +
                "inner join payroll_master_karyawan_detail mpd on mk.id_karyawan = mpd.id_karyawan " +
                "where mk.id_karyawan = ? order by mpd.tanggal_dibuat asc limit 1 ";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();         
            domainMasterKaryawan listHasil = new  domainMasterKaryawan();
            while(rs.next()){                
                listHasil = konversiResultSetDetil(rs);
            }
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
                p.setArea(rs.getString("area"));
                p.setNama_cabang(rs.getString("nama_cabang"));
                p.setCutiTahunan(String.valueOf(rs.getInt("cuti_tahunan")));
                p.setCuti5Tahunan(String.valueOf(rs.getInt("cuti_5_tahunan")));
                p.setJabatan(rs.getString("jabatan"));
                p.setSts_pegawai(String.valueOf(rs.getInt("sts_pegawai")));
                p.setGaji(String.valueOf(rs.getInt("gaji")));
                p.setT_kerajinan(String.valueOf(rs.getInt("t_kerajinan")));
                p.setT_operational(String.valueOf(rs.getInt("t_operational")));
                p.setT_bpjs_ketenagakerjaan(String.valueOf(rs.getInt("t_bpjs_ketenagakerjaan")));
                p.setT_bpjs_kesehatan(String.valueOf(rs.getInt("t_bpjs_kesehatan")));
                p.setT_lainnya(String.valueOf(rs.getInt("t_lainnya")));
                p.setT_kesehatan(String.valueOf(rs.getInt("t_kesehatan")));
                p.setT_penepatan(String.valueOf(rs.getInt("t_penepatan")));
                p.setT_transport(String.valueOf(rs.getInt("t_transport")));
                p.setT_makan(String.valueOf(rs.getInt("t_makan")));
                p.setT_jabatan(String.valueOf(rs.getInt("t_jabatan")));
                p.setP_pinjaman_karyawan(String.valueOf(rs.getInt("p_pinjaman_karyawan")));
                p.setP_bpjs_ketenagakerjaan(String.valueOf(rs.getInt("p_bpjs_ketenagakerjaan")));
                p.setP_bpjs_kesehatan(String.valueOf(rs.getInt("p_bpjs_kesehatan")));
                p.setP_asr_kesehatan(String.valueOf(rs.getInt("p_asr_kesehatan")));
                p.setP_denda_kedisiplinan(String.valueOf(rs.getInt("p_denda_kedisiplinan")));
                p.setP_pajak(String.valueOf(rs.getInt("p_pajak")));
                p.setE_periode( new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("e_periode")));
                p.setS_periode(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("s_periode")));
                p.setTanggal_dibuat(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("s_periode")));
                //p.setTanggalLahirString( new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("kelahiran_tanggal")));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
        }
        return null;
    }
}
