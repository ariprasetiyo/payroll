/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.dao;

import com.ari.prasetiyo.domain.domainPayrollData;
import com.ari.prasetiyo.domain.domainPayrollData_printSlipGaji;
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
public class daoPayrollData {
    /*
    Untuk simpan dan update data
    editYesOrNo = 0 = simapan
    editYesOrNo = 1 = update
    insert data pelamar
    */

    public void Simpan(domainPayrollData m, int editYesOrNo){
        try {
            //com.ari.prasetiyo.sistem.transNo transNo = new com.ari.prasetiyo.sistem.transNo();
            //String sql = "select id_absensi as id from presensi_absensi  where year(tanggal_dibuat) = year(now()) order by no desc limit 1 ";
            //m.setRefCode(transNo.setGetTransNo("ABS", sql));
            connectDb dbMysql = new connectDb();
            dbMysql.connectDbMysql();
            String query;
            //save
            if (editYesOrNo == 0 ){
                    for (int a = 0; a < m.getIdKaryawanArray().length ; a++){
                         /*query = 
                            "set @no_id_data_gaji = substring(( ifnull((select id_gaji as id from data_gaji  where year(tanggal_created) = year(now())  order by no desc limit 1 ), '0')),7, 10 ); " +
                            "set @idnya = concat ( 'DG', (date_format(now(), '%Y')),@no_id_data_gaji + 1  ); " +
                            "set @id_karyawan_history = (select nomor from payroll_master_karyawan_detail where id_karyawan = ? order by tanggal_update desc limit 1 ); " +
                            "set @id_absensi = (select no  from presensi_absensi where id_karyawan = ? and date_format(tanggal_dibuat , '%Y-%m') = date_format(now() , '%Y-%m') ); " +
                            "insert into data_gaji (id_gaji, id_karyawan, id_karyawan_history,  id_absensi, user_created, user_updated, tanggal_updated, tanggal_created ) values " +
                            "( concat ( 'DG', (date_format(now(), '%Y')),@no_id_data_gaji + 1  )  , ? ,@id_karyawan_history,@id_absensi , ?,?,now(), now() ); ";
                            */
                        query = "insert into data_gaji (id_gaji, id_karyawan, id_karyawan_history,  id_absensi, user_created, user_updated, tanggal_updated, tanggal_created ) select " +
                                "(concat ( 'DG', (date_format(now(), '%Y')), " +
                                "substring( " +
                                "( case when exists(select id_gaji from data_gaji  where year(tanggal_created) = year(now())  order by no desc limit 1) then (select id_gaji from data_gaji  where year(tanggal_created) = year(now())  order by no desc limit 1 )else 'DG20150' end ) " +
                                ",7, 10 )  + 1  ) ) , " +
                                "?, " +
                                "nomor , " +
                                "(select no  from presensi_absensi where id_karyawan = ? and date_format(tanggal_dibuat , '%Y-%m') = date_format(now() , '%Y-%m') ), " +
                                "?,?,now(),now() from payroll_master_karyawan_detail  where id_karyawan = ? "+
                                "and NOT EXISTS (select id_gaji from data_gaji where id_karyawan = ? "+
                                "and date_format(tanggal_created , '%Y-%m') = date_format(now() , '%Y-%m') )" +
                                " order by nomor desc limit 1";
                    PreparedStatement ps = dbMysql.koneksi.prepareStatement(query);
                    //setDataSimpanDua(ps,m);
                    ps.setString(1, m.getIdKaryawanArray()[a]);
                    ps.setString(2, m.getIdKaryawanArray()[a]);
                    ps.setString(3, m.getUserCreated());
                    ps.setString(4, m.getUserCreated());
                    ps.setString(5, m.getIdKaryawanArray()[a]);
                    ps.setString(6, m.getIdKaryawanArray()[a]);
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
    ambil data new gaji
    ambil data berdasarkan jumlah karyawan dan pembuatan absensi pada bulan bersangkutan
    */
    public ArrayList<domainPayrollData> tampilDataNew(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        connectDb dbMysql = new connectDb();
        try {
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            sql = "SELECT  mkd.id_karyawan  , mkd.sts_pegawai as status_pegawai, mk.nama, mk.status_karyawan, mkd.jabatan, " +
                    "mkd.area, mkd.gaji, " +
                    "(case when ( " +
                    "select (pa.absen + pa.masuk_terlambat + pa.pulang_lebih_awal + sakit) as jum from presensi_absensi pa where pa.id_karyawan = mkd.id_karyawan   and date_format(pa.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m') " +
                    ") = 0 then t_kerajinan else 0 end  ) + t_operational + t_bpjs_ketenagakerjaan + t_bpjs_kesehatan + t_lainnya + t_kesehatan + t_penepatan + t_transport + t_makan + t_jabatan as tunjangan  , " +
                    "ifnull(( select sum( jum_lembur * katagori_lembur ) * 10000 as coba from presensi_lembur l where l.id_karyawan = mkd.id_karyawan   and date_format(l.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m') ), 0) as lembur, " +
                    "p_pinjaman_karyawan + p_bpjs_ketenagakerjaan + p_bpjs_kesehatan + p_asr_kesehatan + p_pajak as potongan " +
                    "from ( select id_karyawan,max(tanggal_update) as tanggal_update from payroll_master_karyawan_detail group by id_karyawan order by tanggal_update desc ) A " +
                    "INNER JOIN payroll_master_karyawan_detail mkd  " +
                    "on A.id_karyawan = mkd.id_karyawan " +
                    "and  CONVERT(DATE_FORMAT(A.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) =  CONVERT(DATE_FORMAT(mkd.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime)  " +
                    "inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan  " +
                    "inner join presensi_absensi pa on date_format(pa.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')  and  mkd.id_karyawan = pa.id_karyawan "+
                    "order by mk.no desc  limit ?,?"  ;

                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setInt(1, limitBawah);
                ps.setInt(2, limitAtas);
                rs = ps.executeQuery();
            
            ArrayList<domainPayrollData> listHasil = new  ArrayList<domainPayrollData>();
            while(rs.next()){                
                domainPayrollData p = konversiResultSetNew(rs, 1);
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
    com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
     private domainPayrollData konversiResultSetNew(ResultSet rs, int a) {
        try {
            domainPayrollData p = new domainPayrollData();
                // 0 = jika data bukan new dan berasal dari filter
                if (a == 0){
                    p.setId(rs.getString("id_gaji"));
                }
                p.setIdKaryawan(rs.getString("id_karyawan"));
                p.setStatusPegawai(convertAll.convertPegawai(rs.getInt("status_pegawai")));
                p.setArea(convertAll.convertArea(rs.getString("area")));
                p.setNama(rs.getString("nama"));
                p.setStatusPekerja(convertAll.convertStatusKaryawan(rs.getInt("status_karyawan")));
                p.setJabatan(rs.getString("jabatan"));
                String gaji =  rs.getString("gaji");
                p.setGajiPokok( convertAll.FormatIndonesia_BigInteger(gaji) );
                String tunjangan = rs.getString("tunjangan");
                p.setTunjangan( convertAll.FormatIndonesia_BigInteger( tunjangan));
                String lembur = rs.getString("lembur");
                p.setLembur( convertAll.FormatIndonesia_BigInteger( lembur));
                String potongan =  rs.getString("potongan");
                p.setPotongan( convertAll.FormatIndonesia_BigInteger(potongan));
                int total = Integer.valueOf(gaji) + Integer.valueOf(tunjangan) + Integer.valueOf(lembur) - Integer.valueOf(potongan);
                p.setGajiBersih(  convertAll.FormatIndonesia_BigInteger( String.valueOf(total)));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoMasterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoMasterPelamar.class.getName(), ex);
        }
        return null;
    }

    /*
    ambil list data karwayan untuk gaju
    */
    public ArrayList<domainPayrollData> tampilData(int limitBawah, int limitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
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
                         sql =  "  SELECT  dg.id_gaji, mkd.id_karyawan  , mkd.sts_pegawai as status_pegawai, mk.nama, mk.status_karyawan, mkd.jabatan,  " +
                            "mkd.area, mkd.gaji,  " +
                            "(case when (  " +
                            "select (pa.absen + pa.masuk_terlambat + pa.pulang_lebih_awal + sakit) as jum from presensi_absensi pa where pa.id_karyawan = mkd.id_karyawan   and date_format(pa.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')  " +
                            ") = 0 then t_kerajinan else 0 end  ) + t_operational + t_bpjs_ketenagakerjaan + t_bpjs_kesehatan + t_lainnya + t_kesehatan + t_penepatan + t_transport + t_makan + t_jabatan as tunjangan  ,  " +
                            "ifnull(( select sum( jum_lembur * katagori_lembur ) * 10000 as coba from presensi_lembur l where l.id_karyawan = mkd.id_karyawan   and date_format(l.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m') ), 0) as lembur,  " +
                            "p_pinjaman_karyawan + p_bpjs_ketenagakerjaan + p_bpjs_kesehatan + p_asr_kesehatan + p_pajak as potongan  " +
                            "from ( select id_karyawan,max(tanggal_update) as tanggal_update from payroll_master_karyawan_detail group by id_karyawan order by tanggal_update desc ) A  " +
                            "INNER JOIN payroll_master_karyawan_detail mkd  " +
                            "on A.id_karyawan = mkd.id_karyawan  " +
                            "and  CONVERT(DATE_FORMAT(A.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) =  CONVERT(DATE_FORMAT(mkd.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime)   " +
                            "inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan  " +
                            "inner join data_gaji dg on mk.id_karyawan = dg.id_karyawan " +
                            "where " +
                            "mkd.id_karyawan like ? " +
                            "and mkd.sts_pegawai like ? " +
                            "and mkd.jabatan like ? " +
                            "and area like ? " +
                            "and mk.status_karyawan like ? " +
                            "and mk.nama like ? " +
                            "and date_format(tanggal_created, '%Y-%m') = date_format(?, '%Y-%m') "+
                            "order by dg.no desc  limit ?,?  ";
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
                //filter tanpa periode
                //filter data hanya data bulan sekarang
                else {
                    sql =  "  SELECT  dg.id_gaji, mkd.id_karyawan  , mkd.sts_pegawai as status_pegawai, mk.nama, mk.status_karyawan, mkd.jabatan,  " +
                            "mkd.area, mkd.gaji,  " +
                            "(case when (  " +
                            "select (pa.absen + pa.masuk_terlambat + pa.pulang_lebih_awal + sakit) as jum from presensi_absensi pa where pa.id_karyawan = mkd.id_karyawan   and date_format(pa.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')  " +
                            ") = 0 then t_kerajinan else 0 end  ) + t_operational + t_bpjs_ketenagakerjaan + t_bpjs_kesehatan + t_lainnya + t_kesehatan + t_penepatan + t_transport + t_makan + t_jabatan as tunjangan  ,  " +
                            "ifnull(( select sum( jum_lembur * katagori_lembur ) * 10000 as coba from presensi_lembur l where l.id_karyawan = mkd.id_karyawan   and date_format(l.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m') ), 0) as lembur,  " +
                            "p_pinjaman_karyawan + p_bpjs_ketenagakerjaan + p_bpjs_kesehatan + p_asr_kesehatan + p_pajak as potongan  " +
                            "from ( select id_karyawan,max(tanggal_update) as tanggal_update from payroll_master_karyawan_detail group by id_karyawan order by tanggal_update desc ) A  " +
                            "INNER JOIN payroll_master_karyawan_detail mkd  " +
                            "on A.id_karyawan = mkd.id_karyawan  " +
                            "and  CONVERT(DATE_FORMAT(A.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) =  CONVERT(DATE_FORMAT(mkd.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime)   " +
                            "inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan  " +
                            "inner join data_gaji dg on mk.id_karyawan = dg.id_karyawan " +
                            "where date_format(dg.tanggal_created, '%Y-%m') = date_format(now(), '%Y-%m')" +
                            "and mkd.id_karyawan like ? " +
                            "and mkd.sts_pegawai like ? " +
                            "and mkd.jabatan like ? " +
                            "and area like ? " +
                            "and mk.status_karyawan like ? " +
                            "and mk.nama like ? " +
                            "order by dg.no desc  limit ?,?  ";
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
                 sql =  "SELECT  dg.id_gaji, mkd.id_karyawan  , mkd.sts_pegawai as status_pegawai, mk.nama, mk.status_karyawan, mkd.jabatan,  " +
                        "mkd.area, mkd.gaji,  " +
                        "(case when (  " +
                        "select (pa.absen + pa.masuk_terlambat + pa.pulang_lebih_awal + sakit) as jum from presensi_absensi pa where pa.id_karyawan = mkd.id_karyawan   and date_format(pa.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')  " +
                        ") = 0 then t_kerajinan else 0 end  ) + t_operational + t_bpjs_ketenagakerjaan + t_bpjs_kesehatan + t_lainnya + t_kesehatan + t_penepatan + t_transport + t_makan + t_jabatan as tunjangan  ,  " +
                        "ifnull(( select sum( jum_lembur * katagori_lembur ) * 10000 as coba from presensi_lembur l where l.id_karyawan = mkd.id_karyawan   and date_format(l.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m') ), 0) as lembur,  " +
                        "p_pinjaman_karyawan + p_bpjs_ketenagakerjaan + p_bpjs_kesehatan + p_asr_kesehatan + p_pajak as potongan  " +
                        "from ( select id_karyawan,max(tanggal_update) as tanggal_update from payroll_master_karyawan_detail group by id_karyawan order by tanggal_update desc ) A  " +
                        "INNER JOIN payroll_master_karyawan_detail mkd  " +
                        "on A.id_karyawan = mkd.id_karyawan  " +
                        "and  CONVERT(DATE_FORMAT(A.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime) =  CONVERT(DATE_FORMAT(mkd.tanggal_update,'%Y-%m-%d-%H:%i:00'),datetime)   " +
                        "inner join  payroll_master_karyawan mk on   mkd.id_karyawan = mk.id_karyawan   inner join data_gaji dg on mk.id_karyawan = dg.id_karyawan "+
                        "and date_format(dg.tanggal_created, '%Y-%m') = date_format(now(), '%Y-%m') " +
                        "order by dg.no desc  limit ?,?  ;";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setInt(1, limitBawah);
                ps.setInt(2, limitAtas);
                rs = ps.executeQuery();
            }
            ArrayList<domainPayrollData> listHasil = new  ArrayList<domainPayrollData>();
            while(rs.next()){                
                domainPayrollData p = konversiResultSetNew(rs, 0);
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
     // ambil data detail gaji
      public domainPayrollData_printSlipGaji tampilDetilDataGaji( String id ){
        connectDb dbMysql = new connectDb();
        try {
 
            dbMysql.connectDbMysql();
            String sql = null;
            PreparedStatement ps;
            ResultSet rs = null;
            sql = "         SELECT  mk.nama, mk.id_karyawan as id, mpd.area, mpd.nama_cabang, " +
                    "                mpd.jabatan, " +
                    "                mpd.sts_pegawai, mpd.gaji," +
                    "                     (case when (  " +
                    "                    select (pa.absen + pa.masuk_terlambat + pa.pulang_lebih_awal + sakit) as jum from presensi_absensi pa where pa.id_karyawan = mpd.id_karyawan   and date_format(pa.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')  " +
                    "                    ) = 0 then t_kerajinan else 0 end  ) as tun_kerajinan," +
                    "                 ifnull(( select sum( jum_lembur * katagori_lembur ) * 10000 as coba from presensi_lembur l where l.id_karyawan = mpd.id_karyawan   and date_format(l.tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m') ), 0) as lembur," +
                    "                mpd.t_operational, mpd.t_bpjs_ketenagakerjaan,  " +
                    "                mpd.t_bpjs_kesehatan, mpd.t_lainnya, mpd.t_kesehatan, mpd.t_penepatan, mpd.t_transport,  " +
                    "                mpd.t_makan, mpd.t_jabatan, mpd.p_pinjaman_karyawan, mpd.p_bpjs_ketenagakerjaan,  " +
                    "                mpd.p_bpjs_kesehatan, mpd.p_asr_kesehatan, mpd.p_denda_kedisiplinan, mpd.p_pajak" +
                    "                from payroll_master_karyawan mk " +
                    "                inner join payroll_master_karyawan_detail mpd on mk.id_karyawan = mpd.id_karyawan " +
                    "                where mk.id_karyawan = ? order by mpd.tanggal_dibuat asc limit 1";
                ps = dbMysql.koneksi.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();         
            domainPayrollData_printSlipGaji listHasil = new  domainPayrollData_printSlipGaji();
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
     private domainPayrollData_printSlipGaji konversiResultSetDetil (ResultSet rs) {
        try {
            domainPayrollData_printSlipGaji p = new domainPayrollData_printSlipGaji();
            com.ari.prasetiyo.sistem.tanggalSistem tgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
              
                p.setId(rs.getString("id"));
                p.setNama(rs.getString("nama"));
                p.setArea(rs.getString("area"));
                p.setJabatan(rs.getString("jabatan"));
                p.setStatusPegawai(String.valueOf(rs.getInt("sts_pegawai")));
                int gaji, tKerajinan, tOperational, tBjsKes, tBpjsKetenaga, tLain,tKes,tPen, tTrans, tMakan, tJab,
                        pPinjamanKar, pBpjsKetenaga, pBpjsKes, pAsrKes,pDenda, pPajak, lembur, tot, totPot;
                gaji = rs.getInt("gaji");
                tKerajinan = rs.getInt("tun_kerajinan");
                tOperational = rs.getInt("t_operational");
                tBjsKes =rs.getInt("t_bpjs_kesehatan");
                tBpjsKetenaga= rs.getInt("t_bpjs_ketenagakerjaan");
                tLain =rs.getInt("t_lainnya");
                tKes = rs.getInt("t_kesehatan");
                tPen=rs.getInt("t_penepatan");
                tTrans=rs.getInt("t_transport");
                tMakan=rs.getInt("t_makan");
                tJab=rs.getInt("t_jabatan");
                pPinjamanKar=rs.getInt("p_pinjaman_karyawan");
                pBpjsKetenaga=rs.getInt("p_bpjs_ketenagakerjaan");
                pBpjsKes=rs.getInt("p_bpjs_kesehatan");
                pAsrKes=rs.getInt("p_asr_kesehatan");
                pDenda=rs.getInt("p_denda_kedisiplinan");
                pPajak=rs.getInt("p_pajak");
                lembur=rs.getInt("lembur");
                tot = gaji +tKerajinan+tOperational+tBjsKes+tBpjsKetenaga+ tLain+ tKes+ tPen+ tTrans + tMakan + tJab+ lembur;
                p.setTotalPendapatan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tot)));
                totPot = pPinjamanKar + pBpjsKetenaga+ pBpjsKes + pAsrKes + pDenda + pPajak;
                p.setTotalPotongan(convertAll.FormatIndonesia_BigInteger(String.valueOf(totPot)));
                p.setTotalPendapatan2(convertAll.FormatIndonesia_BigInteger(String.valueOf(tot - totPot)));
                p.setTakeHomePay(convertAll.FormatIndonesia_BigInteger(String.valueOf(tot - totPot - tBjsKes - tBpjsKetenaga)));
                
                p.setGaji(convertAll.FormatIndonesia_BigInteger(String.valueOf(gaji)));
                p.setT_kerajinan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tKerajinan)));
                p.setT_operational(convertAll.FormatIndonesia_BigInteger(String.valueOf(tOperational)));
                p.setT_bpjs_ketenagakerjaan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tBpjsKetenaga)));
                p.setT_bpjs_kesehatan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tBjsKes)));
                p.setT_lainnya(convertAll.FormatIndonesia_BigInteger(String.valueOf(tLain)));
                p.setT_kesehatan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tKes)));
                p.setT_penepatan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tPen)));
                p.setT_transport(convertAll.FormatIndonesia_BigInteger(String.valueOf(tTrans)));
                p.setT_makan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tMakan)));
                p.setT_jabatan(convertAll.FormatIndonesia_BigInteger(String.valueOf(tJab)));
                p.setP_pinjaman_karyawan(convertAll.FormatIndonesia_BigInteger(String.valueOf(pPinjamanKar)));
                p.setP_bpjs_ketenagakerjaan(convertAll.FormatIndonesia_BigInteger(String.valueOf(pBpjsKetenaga)));
                p.setP_bpjs_kesehatan(convertAll.FormatIndonesia_BigInteger(String.valueOf(pBpjsKes)));
                p.setP_asr_kesehatan(convertAll.FormatIndonesia_BigInteger(String.valueOf(pAsrKes)));
                p.setP_denda_kedisiplinan(convertAll.FormatIndonesia_BigInteger(String.valueOf(pDenda)));
                p.setP_pajak(convertAll.FormatIndonesia_BigInteger(String.valueOf(pPajak)));
                p.setLembur(convertAll.FormatIndonesia_BigInteger(String.valueOf(lembur)));
                p.setTanggal_dibuat(tgl.GetTglNow() + " / "+tgl.GetBlnNow()+" / "+ tgl.GetThnNow());
               // p.setTanggal_dibuat(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("s_periode")));
                //p.setTanggalLahirString( new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("kelahiran_tanggal")));
            return p;
         } catch (SQLException ex) {
            Logger.getLogger(daoLogin.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(daoLogin.class.getName(), ex);
        }
        return null;
    }
}
