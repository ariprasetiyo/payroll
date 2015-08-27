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
 */
public class daoMasterPelamar_backup {
    
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
                        + "?,?,?,?,?,?,?,?,?,?, ?,"
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
                ps.execute(); 
            }
            dbMysql.disconnectDbMysql();
            //jika status pelamar adalah diterima maka sistem akan save ke tabel karyawan dan karywanan_detail
             if (Integer.valueOf(m.getStatusPelamar()) == 1){
                   SimpanKaryawan(m);
                   SimpanKaryawanDetail(m);
             }
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar_backup.class.getName(), ex);
        }
    }
    
    private void setDataSimpan(PreparedStatement ps,domainMasterPelamar m){
        try {
            tanggalSistem tgl = new  tanggalSistem ();
            com.ari.prasetiyo.sistem.transNo transNo = new com.ari.prasetiyo.sistem.transNo();
            com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
            // membuat transno dengan kode awal MP
            m.setRefCode(transNo.setGetTransNo("payroll_master_pelamar", "MP"));
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
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void SimpanKaryawan(domainMasterPelamar mo){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query;
            query =   " insert into payroll_master_karyawan ( id,area, nama_cabang, cuti,user_created, user_updated,tanggal_dibuat, tanggal_update )  "
                    + "values (?,'-','-',0,?,?,now(),now() );";
            PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
            setDataSimpanKaryawan(ps, mo, 1);
            ps.execute(); 
            dbMysql.disconnectDbMysql();
        } catch (SQLException ex) {     
            if (ex.getMessage().contains("Duplicate")){
                // jika duplicate tidak apa, tidak disimpan
            }
            else {
                Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
                new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar_backup.class.getName(), ex);
            }   
        }
    }
     private void SimpanKaryawanDetail(domainMasterPelamar mo){
        try {
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query;
            query = " insert into payroll_master_karyawan_detail "+ 
                    " ( id,user_created, user_updated,tanggal_dibuat, tanggal_update ) values ( ?,?,?, now(), now() );  ";
            PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
            setDataSimpanKaryawanDetail(ps, mo, 1);
            ps.execute(); 
            dbMysql.disconnectDbMysql();
        } catch (SQLException ex) {
            //antisipasi jika multi insert tabel salah satu tidak jalan
            connectDb dbMysql = new connectDb();
            dbMysql.hapusDbMysql("payroll_master_karyawan", mo.getRefCode());
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar_backup.class.getName(), ex);
        }
    }
    // simpan kedua
    private void setDataSimpanKaryawan(PreparedStatement ps,domainMasterPelamar m, int startPreparedStatement){
        try {
            ps.setString(startPreparedStatement, m.getRefCode());
            ps.setString(startPreparedStatement += 1, m.getUserCreated());
            ps.setString(startPreparedStatement += 1, m.getUserUpdated());
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // simpan ketiga
    private void setDataSimpanKaryawanDetail(PreparedStatement ps,domainMasterPelamar m, int startPreparedStatement){
        try {
            ps.setString(startPreparedStatement, m.getRefCode());
            ps.setString(startPreparedStatement += 1, m.getUserCreated());
            ps.setString(startPreparedStatement += 1, m.getUserUpdated());  
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
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
                    sql =   "select id, nama, jenis_kelamin,status_pelamar, jabatan, no_telphone, tanggal_dibuat, user_created, user_updated "
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
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar_backup.class.getName(), ex);
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
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar_backup.class.getName(), ex);
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
                sql = "SELECT  id, nama, ibu, kelahiran_tanggal,"
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
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar_backup.class.getName(), ex);
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
            Logger.getLogger(daoMasterPelamar_backup.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar_backup.class.getName(), ex);
        }
        return null;
    }
}


/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
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
 *
public class daoMasterPelamar {
    
    /*
    editYesOrNo = 0 = simapan
    editYesOrNo = 1 = update
    insert data pelamar
    *
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
                        + "?,?,?,?,?,?,?,?,?,?, ?,"
                        + "?,?,?,?,?, now(),now(), 1, year(now()),? ); ";
               
                //jika dipilih pelamar diterima
                System.out.println(m.getStatusPelamar());
                if (Integer.valueOf(m.getStatusPelamar()) == 1){
                    query += "insert into payroll_master_karyawan ( id,area, nama_cabang, cuti,user_created, user_updated,tanggal_dibuat, tanggal_update )  "
                            + "values (?,'-','-',0,?,?,now(),now() );";
                    query += "insert into payroll_master_karyawan "+ 
                        " ( id,user_created, user_updated,tanggal_dibuat, tanggal_update ) values ( ?,?,?, now(), now() ); ";
                }
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                setDataSimpan(ps,m);
                ps.executeUpdate();
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
                //jika diedit pelamar diterima
                System.out.println(m.getStatusPelamar());
                if (Integer.valueOf(m.getStatusPelamar()) == 1){
                    query += "insert into payroll_master_karyawan "

                            + "values (?,'-','-',0,?,?,now(),now() );";
                    query += " insert into payroll_master_karyawan "+ 
                        " ( id,user_created, user_updated,tanggal_dibuat, tanggal_update ) values ( ?,?,?, now(), now() ); ";
                    /*"gaji," +
                        "t_kerajinan," +
                        "t_operational," +
                        "t_bpjs_ketenagakerjaan, " +
                        "t_bpjs_kesehatan," +
                        "t_lainnya," +
                        "t_kesehatan," +
                        "t_penepatan," +
                        "t_transport," +
                        "t_makan," +
                        "t_jabatan," +
                        "p_pinjaman_karyawan," +
                        "p_pinjaman_lainnya," +
                        "p_bpjs_ketenagakerjaan ," +
                        "p_bpjs_kesehatan," +
                        "p_asr_kesehatan," +
                        "p_denda_kedisiplinan," +
                        "p_pajak," +
                        "e_periode," +
                        "s_periode," + 
                        "user_created, " +
                        "user_updated, " +
                        "tanggal_dibuat," +
                        "tanggal_update  ";
                    *
                }
                PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                setDataUpdate(ps,m);
                ps.executeUpdate(); 
            }
            dbMysql.disconnectDbMysql();
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
    }
    
    private void setDataSimpan(PreparedStatement ps,domainMasterPelamar m){
        try {
            tanggalSistem tgl = new  tanggalSistem ();
            com.ari.prasetiyo.sistem.transNo transNo = new com.ari.prasetiyo.sistem.transNo();
            com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
            // membuat transno dengan kode awal MP
            m.setRefCode(transNo.setGetTransNo("payroll_master_pelamar", "MP"));
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
            if (Integer.valueOf(m.getStatusPelamar()) == 1){
                setDataSimpanKaryawan(ps,m, 26);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private int startPreparedStatement;
    // simpan kedua
    private void setDataSimpanKaryawan(PreparedStatement ps,domainMasterPelamar m, int startPreparedStatement){
        try {
            ps.setString(startPreparedStatement, m.getRefCode());
            ps.setString(startPreparedStatement += 1, m.getUserCreated());
            ps.setString(startPreparedStatement += 1, m.getUserUpdated());
            //this.startPreparedStatement = startPreparedStatement +=1 ;
            setDataSimpanKaryawanDetail(ps,m,startPreparedStatement +=1);
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // simpan ketiga
    private void setDataSimpanKaryawanDetail(PreparedStatement ps,domainMasterPelamar m, int startPreparedStatement){
        try {
            ps.setString(startPreparedStatement, m.getRefCode());
            ps.setString(startPreparedStatement += 1, m.getUserCreated());
            ps.setString(startPreparedStatement += 1, m.getUserUpdated());
            this.startPreparedStatement = startPreparedStatement +=1;  
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setDataUpdate(PreparedStatement ps,domainMasterPelamar m){
        try {
            tanggalSistem tgl = new  tanggalSistem ();
            com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
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
             //jika diedit pelamar diterima
            if (Integer.valueOf(m.getStatusPelamar()) == 1){
                setDataSimpanKaryawan(ps,m, 25);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    ambil list data pelamar
    *
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
                    sql =   "select id, nama, jenis_kelamin,status_pelamar, jabatan, no_telphone, tanggal_dibuat, user_created, user_updated "
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
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
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
                sql = "SELECT  id, nama, ibu, kelahiran_tanggal,"
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
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
        }
        return null;
    }
  
   
}

*/