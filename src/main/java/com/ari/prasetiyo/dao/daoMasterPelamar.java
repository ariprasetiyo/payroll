/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.sistem.connectDb;
import com.ari.prasetiyo.domain.domainMasterPelamar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ari.prasetiyo.sistem.tanggalSistem;
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
public class daoMasterPelamar {
    
    /*
    editYesOrNo = 0 = simapan
    editYesOrNo = 1 = update
    insert data pelamar
    */
    public void Simpan(domainMasterPelamar m, int editYesOrNo){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query;
            //save
            if (editYesOrNo == 0 ){
                query = "insert into  payroll_master_pelamar "
                        + "(id, nama, ibu, kelahiran_tanggal, kelahiran_tempat, jabatan, jenis_kelamin, status_nikah, "
                        + "agama,darah,kewarganegaraan,no_ktp,no_sim,alamat,alamat_asal,kode_pos,no_telphone, email,status_tempat_tinggal,"
                        + "hobby, status_pelamar, riwayat_pendidikan, pendidikan_non_formal, periode_bulan, tanggal_update, tanggal_dibuat, key_no, tahun, user_created) "
                        + " values (?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?, now(),now(), 1, year(now()),? ); ";
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                setDataSimpan(ps,m);
                ps.execute();
            }
            //edit
            else if ( editYesOrNo == 1 ) {
                query = "update payroll_master_pelamar set " +             
                        "nama=? ,"+//1     
                        "ibu=? ,"+//2 
                        "kelahiran_tanggal=? ,"+//3
                        "kelahiran_tempat=? ,"+//4
                        "jabatan=? ,"+//5
                        "jenis_kelamin=? ,"+//6
                        "status_nikah=? ,"+//7
                        "agama=? ,"+//8
                        "darah=? , "+//9
                        "kewarganegaraan =? ,"+//10
                        "no_ktp=? ,"+//11
                        "no_sim =? ,"+//12
                        "alamat =? ,"+//13
                        "alamat_asal=?,"+//14
                        "kode_pos =? ,"+//15
                        "no_telphone =? ,"+//16
                        "email=? ,"+//17
                        "status_tempat_tinggal=? ,"+//18
                        "hobby=? ,"+//19
                        "status_pelamar=? ,"+//20
                        "riwayat_pendidikan=? ,"+//21
                        "pendidikan_non_formal=? ,"+//22
                        "tanggal_update=now(), " +
                        "user_updated=?,"+//23
                        "key_no=1 where id=?;";//24
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                dbMysql.koneksi.setAutoCommit(true);
                setDataUpdate(ps,m);
                ps.executeBatch();
               
                //int[] count = ps.executeBatch();
                //proses simpan dijalan jika status pelamar ( diterima ) db payroll_master_karyawan
                // 1  = karyawan diterima
                // 3 = karyawan resign
                if (Integer.valueOf(m.getStatusPelamar()) == 1 || Integer.valueOf(m.getStatusPelamar()) == 3 ) {
                    try {
                        /*query =   " insert into payroll_master_karyawan ( id,area, nama_cabang, cuti,user_created, user_updated,tanggal_dibuat, tanggal_update )  "
                        + "values (?,'-','-',0,?,?,now(),now() );";
                        */
                        query =
                        "insert into payroll_master_karyawan " +
                        "	( id_karyawan, user_created, user_updated, tanggal_dibuat, tanggal_update, " +
                        "	id_pelamar, nama, ibu, kelahiran_tanggal, kelahiran_tempat, jabatan,  jenis_kelamin, " +
                        "	status_nikah, agama, darah, kewarganegaraan, no_ktp, no_sim, alamat, alamat_asal, kode_pos," +
                        "	no_telphone, email, status_tempat_tinggal, hobby, status_karyawan, riwayat_pendidikan, pendidikan_non_formal," +
                        "	key_no, periode_bulan, tahun)" +
                        "select " +
                        "       ?, ?, ?, now(), now()," +
                        "       id, nama, ibu ,kelahiran_tanggal, kelahiran_tempat, jabatan, jenis_kelamin," +
                        "	status_nikah, agama, darah, kewarganegaraan, no_ktp, no_sim, alamat, alamat_asal, kode_pos, " +
                        "	no_telphone, email, status_tempat_tinggal, hobby, status_pelamar, riwayat_pendidikan, pendidikan_non_formal, " +
                        "	key_no, periode_bulan, tahun " +
                        "from payroll_master_pelamar where id = ? ";
                        ps = dbMysql.koneksi.prepareStatement(query);
                        setDataSimpanKaryawan(ps, m, 1);
                        ps.executeBatch();
                        
                    } catch (SQLException ex){
                        if (ex.getMessage().contains("Duplicate")){
                             // jika duplicate akan diupdated
                            query ="UPDATE payroll_master_karyawan mk," +
                                    "( select nama,ibu,kelahiran_tanggal,kelahiran_tempat, jabatan, "
                                    + "jenis_kelamin, status_nikah, agama, darah,kewarganegaraan , "
                                    + "no_ktp , no_sim, alamat, alamat_asal, kode_pos, no_telphone, email, "
                                    + "status_tempat_tinggal , hobby, status_pelamar, riwayat_pendidikan, "
                                    + "pendidikan_non_formal, user_updated "
                                  + " from payroll_master_pelamar where id = ? ) mp SET " +
                                    "mk.nama=mp.nama," +
                                    "mk.ibu=mp.ibu," +
                                    "mk.kelahiran_tanggal=mp.kelahiran_tanggal," +
                                    "mk.kelahiran_tempat=mp.kelahiran_tempat," +
                                    "mk.jabatan=mp.jabatan," +
                                    "mk.jenis_kelamin=mp.jenis_kelamin," +
                                    "mk.status_nikah=mp.status_nikah," +
                                    "mk.agama=mp.agama," +
                                    "mk.darah=mp.darah," +
                                    "mk.kewarganegaraan=mp.kewarganegaraan," +
                                    "mk.no_ktp=mp.no_ktp," +
                                    "mk.no_sim=mp.no_sim," +
                                    "mk.alamat=mp.alamat," +
                                    "mk.alamat_asal=mp.alamat_asal," +
                                    "mk.kode_pos=mp.kode_pos," +
                                    "mk.no_telphone=mp.no_telphone," +
                                    "mk.email=mp.email," +
                                    "mk.status_tempat_tinggal=mp.status_tempat_tinggal," +
                                    "mk.hobby=mp.hobby," +
                                    "mk.status_karyawan=mp.status_pelamar," +
                                    "mk.riwayat_pendidikan=mp.riwayat_pendidikan," +
                                    "mk.pendidikan_non_formal=mp.pendidikan_non_formal," +
                                    "mk.user_updated=mp.user_updated," +
                                    "mk.tanggal_update=now()" +
                                    "where mk.id_pelamar = ? ";
                            ps = dbMysql.koneksi.prepareStatement(query);
                            setDataSimpanKaryawanUpdated(ps, m, 1);
                            ps.executeBatch();
                        }
                        else {
                            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
                            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
                        }
                    }
                    //proses simpan dijalan jika status pelamar  (diterima) db payroll_master_karyawan_detail
                    try {
                        //query = " insert into payroll_master_karyawan_detail "+ 
                        //" ( id,user_created, user_updated,tanggal_dibuat, tanggal_update ) values ( ?,?,?, now(), now() );  ";
                        /*
                        sampel query :
                        
                        insert into payroll_master_karyawan_detail  ( id,  sts_insert_or_not,user_created, user_updated,tanggal_dibuat, tanggal_update ) 
                        select 'MP20158681',  case 
			when  exists ( select id from payroll_master_karyawan_detail where id = 'MP20158681'  and sts_insert_or_not = 0 and gaji = 0 ) then '1'  else '0' end
                        ,'1','1', now(), now() from payroll_master_karyawan where id = 'MP20158681'
                        */
                        query = "insert into payroll_master_karyawan_detail  " 
                        + "( id_karyawan,area, nama_cabang, jabatan,  sts_insert_or_not,user_created, user_updated,tanggal_dibuat, tanggal_update, e_periode, s_periode ) "
                        + "select ?,'','',jabatan,  case " 
                        + "when  exists ( select id_karyawan from payroll_master_karyawan_detail where id_karyawan = ?  and sts_insert_or_not = 0 and gaji = 0 ) then '1'  else '0' end " 
                        + " ,?,?, now(), now(), now(), now() from payroll_master_karyawan where id_karyawan = ? ;";
                        ps = dbMysql.koneksi.prepareStatement(query);
                        setDataSimpanKaryawanDetail(ps, m, 1);
                        ps.executeBatch();
                        
                    } catch (SQLException ex){
                        if (ex.getMessage().contains("Duplicate")){
                             // jika duplicate tidak apa, tidak disimpan
                        }
                        else {
                            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
                            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
                        }
                    }
                   
                }
                
            }
            dbMysql.disconnectDbMysql();
            //jika status pelamar adalah diterima maka sistem akan save ke tabel karyawan dan karywanan_detail
           
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
    }
    
    private void setDataSimpan(PreparedStatement ps,domainMasterPelamar m){
        try {
            tanggalSistem tgl = new  tanggalSistem ();
            com.ari.prasetiyo.sistem.transNo transNo = new com.ari.prasetiyo.sistem.transNo();
            // membuat transno dengan kode awal MP
            m.setRefCode(transNo.setGetTransNo("payroll_master_pelamar", "id","MP"));
            ps.setString(1, m.getRefCode());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getIbu());
            // convert java.util ke java.sql dengan format dd/MMM/YYYY
            ps.setDate(4, new  java.sql.Date(m.getTanggalLahir().getTime()));
            ps.setString(5, m.getTempatLahir());
            ps.setString(6, m.getJabatan());
            ps.setInt(7, Integer.valueOf(m.getJenisKelamin()));
            ps.setInt(8, Integer.valueOf(m.getStatusNikah()));
            ps.setInt(9, Integer.valueOf(m.getAgama()));
            ps.setInt(10, Integer.valueOf(m.getDarah()));
            ps.setString(11, m.getKewarganegaraan());
            ps.setString(12, m.getNoKtp());
            ps.setString(13, m.getNoSim());
            ps.setString(14, m.getAlamat());
            ps.setString(15, m.getAsal());
            ps.setInt(16, Integer.valueOf(m.getKodePos()));// erropr
            ps.setString(17, m.getNoHP());
            ps.setString(18, m.getEmail());
            ps.setInt(19, Integer.valueOf(m.getStatusTempatTinggal()));
            ps.setString(20, m.getHoby());
            ps.setInt(21, Integer.valueOf(m.getStatusPelamar()));
            ps.setString(22, m.getEditorRiwayat());
            ps.setString(23, m.getNonFormal());
            ps.setString(24,tgl.GetBlnNow()+""+tgl.GetThnNow());
            ps.setString(25, m.getUserCreated());
             //jika diedit pelamar diterima
            //if (Integer.valueOf(m.getStatusPelamar()) == 1){
            //    SimpanKaryawan();
           // }
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // updated data karyawan dari form pelamar
     private void setDataSimpanKaryawanUpdated(PreparedStatement ps,domainMasterPelamar m, int startPreparedStatement){
        try {
            ps.setString(startPreparedStatement, m.getRefCode());
            ps.setString(startPreparedStatement += 1, m.getRefCode());
            ps.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // simpan kedua
    private void setDataSimpanKaryawan(PreparedStatement ps,domainMasterPelamar m, int startPreparedStatement){
        try {
            com.ari.prasetiyo.sistem.transNo transNo = new com.ari.prasetiyo.sistem.transNo();
            // membuat transno dengan kode awal BSP
            m.setIdKaryawan(transNo.setGetTransNo("payroll_master_karyawan","id_karyawan", "BSP"));
            ps.setString(startPreparedStatement, m.getIdKaryawan());
            ps.setString(startPreparedStatement += 1, m.getUserCreated());
            ps.setString(startPreparedStatement += 1, m.getUserUpdated());
            ps.setString(startPreparedStatement += 1, m.getRefCode());
            ps.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // simpan ketiga
    private void setDataSimpanKaryawanDetail(PreparedStatement ps,domainMasterPelamar m, int startPreparedStatement){
        try {
            ps.setString(startPreparedStatement, m.getIdKaryawan());
            ps.setString(startPreparedStatement += 1, m.getIdKaryawan());
            ps.setString(startPreparedStatement += 1, m.getUserCreated());  
            ps.setString(startPreparedStatement += 1, m.getUserUpdated());
            ps.setString(startPreparedStatement += 1, m.getIdKaryawan());  
            ps.addBatch();
        } catch (SQLException ex) {
            
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setDataUpdate(PreparedStatement ps,domainMasterPelamar m){
        try {
            //tanggalSistem tgl = new  tanggalSistem ();
            //com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
            ps.setString(1, m.getNama());
            ps.setString(2, m.getIbu());
            ps.setDate(3, new  java.sql.Date(m.getTanggalLahir().getTime()));
            ps.setString(4, m.getTempatLahir());
            ps.setString(5, m.getJabatan());
            ps.setInt(6, Integer.valueOf(m.getJenisKelamin()));
            ps.setInt(7, Integer.valueOf(m.getStatusNikah()));
            ps.setInt(8, Integer.valueOf(m.getAgama()));
            ps.setInt(9, Integer.valueOf(m.getDarah()));
            ps.setString(10, m.getKewarganegaraan());
            ps.setString(11, m.getNoKtp());
            ps.setString(12, m.getNoSim());
            ps.setString(13, m.getAlamat());
            ps.setString(14, m.getAsal());
            ps.setInt(15, Integer.valueOf(m.getKodePos()));
            ps.setString(16, m.getNoHP());
            ps.setString(17, m.getEmail());
            ps.setInt(18,  Integer.valueOf(m.getStatusTempatTinggal()));
            ps.setString(19, m.getHoby());
            ps.setInt(20, Integer.valueOf(m.getStatusPelamar()));
            ps.setString(21, m.getEditorRiwayat());
            ps.setString(22, m.getNonFormal());
            ps.setString(23,m.getUserUpdated());
            ps.setString(24, m.getRefCode());
            ps.addBatch();
             //jika diedit pelamar diterima
           // if (Integer.valueOf(m.getStatusPelamar()) == 1){
             //   setDataSimpanKaryawan(ps,m, 25);
            //}
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    ambil list data pelamar
    */
    public ArrayList<domainMasterPelamar> tampilDataPelamar(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
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
                        sql =   "select id, nama, jenis_kelamin,status_pelamar, jabatan, no_telphone, tanggal_dibuat, user_created, user_updated "
                        + "from payroll_master_pelamar where "
                        + "id like ? and nama like ? and jabatan like ? and status_pelamar like ? and "
                        + "date_format(tanggal_dibuat , '%Y-%m-%d') between ? and ? "
                        + "order by no desc limit ?,? ";
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
                    sql = "select id, nama, jenis_kelamin,status_pelamar, jabatan, no_telphone, tanggal_dibuat, user_created, user_updated "
                        + "from payroll_master_pelamar where "
                        + "id like ? and nama like ? and jabatan like ? and status_pelamar like ? "
                        + "order by no desc  limit ?,? ";
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
                sql = "select id, nama, jenis_kelamin,status_pelamar, jabatan, no_telphone, tanggal_dibuat, user_created, user_updated "
                + "from payroll_master_pelamar order by no desc limit ?,? ";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setInt(1, limitBawah);
                ps.setInt(2, limitAtas);
                rs = ps.executeQuery();
            }
            ArrayList<domainMasterPelamar> listHasil = new  ArrayList<domainMasterPelamar>();
            while(rs.next()){                
                domainMasterPelamar p = konversiResultSet(rs);
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
    private domainMasterPelamar konversiResultSet(ResultSet rs) {
        try {
            domainMasterPelamar p = new domainMasterPelamar();
            com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
                p.setRefCode(rs.getString("id"));
                p.setNama(rs.getString("nama"));
                p.setJenisKelamin(convertAll.convertJenisKelaminString(rs.getInt("jenis_kelamin")));
                p.setStatusPelamar(convertAll.convertStatusPelamarString(rs.getInt("status_pelamar")));
                p.setJabatan(rs.getString("jabatan"));
                p.setNoHP(rs.getString("no_telphone"));
                p.setTanggal(rs.getDate("tanggal_dibuat"));
                p.setUserCreated(rs.getString("user_created"));
                p.setUserUpdated(rs.getString("user_updated"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
    // ambil data detail
      public domainMasterPelamar tampilDetilDataPelamar( String id ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
                sql = "SELECT id, nama, ibu, kelahiran_tanggal,"
                        + " kelahiran_tempat, jabatan, jenis_kelamin, status_nikah, agama,darah,"
                        + " kewarganegaraan, no_ktp, no_sim, alamat,alamat_asal, kode_pos, no_telphone, "
                        + " email, status_tempat_tinggal, hobby, status_pelamar, riwayat_pendidikan, pendidikan_non_formal,"
                        + " tanggal_dibuat, tanggal_update, user_created, user_updated"
                        + " from payroll_master_pelamar where id = ?";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();         
            domainMasterPelamar listHasil = new  domainMasterPelamar();
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
     private domainMasterPelamar konversiResultSetDetil (ResultSet rs) {
        try {
            domainMasterPelamar p = new domainMasterPelamar();
                p.setRefCode(rs.getString("id"));
                p.setNama(rs.getString("nama"));
                p.setIbu(rs.getString("ibu"));
                p.setTanggalLahirString( new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("kelahiran_tanggal")));
                p.setTempatLahir(rs.getString("kelahiran_tempat"));
                p.setJabatan(rs.getString("jabatan"));
                p.setJenisKelamin(String.valueOf(rs.getInt("jenis_kelamin")));
                p.setStatusNikah(String.valueOf(rs.getInt("status_nikah")));
                p.setAgama(String.valueOf(rs.getInt("agama")));
                p.setDarah(String.valueOf(rs.getInt("darah")));
                p.setKewarganegaraan(rs.getString("kewarganegaraan"));
                p.setNoKtp(rs.getString("no_ktp"));
                p.setNoSim(rs.getString("no_sim"));
                p.setAlamat(rs.getString("alamat"));
                p.setAsal(rs.getString("alamat_asal"));
                p.setKodePos(String.valueOf(rs.getInt("kode_pos")));
                p.setNoHP(rs.getString("no_telphone"));
                p.setEmail(rs.getString("email"));
                p.setStatusTempatTinggal(String.valueOf(rs.getInt("status_tempat_tinggal")));
                p.setHoby(rs.getString("hobby"));
                p.setStatusPelamar(String.valueOf(rs.getInt("status_pelamar")));
                p.setEditorRiwayat(rs.getString("riwayat_pendidikan"));
                p.setNonFormal(rs.getString("pendidikan_non_formal"));
                p.setTanggal(rs.getDate("tanggal_dibuat"));
                p.setTanggalUpate(rs.getDate("tanggal_update"));
                p.setUserCreated(rs.getString("user_created"));
                p.setUserUpdated(rs.getString("user_updated"));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }
}


