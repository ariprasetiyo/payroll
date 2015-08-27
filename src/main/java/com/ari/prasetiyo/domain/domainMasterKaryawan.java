/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools  Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.domain;

import java.util.Date;
/**
 *
 * @author arprast
 */
public class domainMasterKaryawan {
    String id, area, nama, jabatan,statusPelamar, jenisKelamin, noHP,  nama_cabang, gaji,t_kerajinan ,t_operational,t_bpjs_ketenagakerjaan ,t_bpjs_kesehatan , t_lainnya,t_kesehatan ,t_penepatan,
        t_transport,  t_makan,  t_jabatan, p_pinjaman_karyawan,   
    p_bpjs_ketenagakerjaan, p_bpjs_kesehatan,  p_asr_kesehatan ,  p_denda_kedisiplinan, p_pajak,
            user_created,user_updated, cuti, cuti5, sts_pegawai, e_periode, s_periode, tanggal_dibuat, tanggal_update, idPelamar;

    public String getIdPelamar() {
        return idPelamar;
    }

    public void setIdPelamar(String idPelamar) {
        this.idPelamar = idPelamar;
    }
    boolean lanjut;

    public String getSts_pegawai() {
        return sts_pegawai;
    }

    public void setSts_pegawai(String sts_pegawai) {
        this.sts_pegawai = sts_pegawai;
    }
    
     public boolean isLanjut() {
        return lanjut;
    }

    public void setLanjut(boolean lanjut) {
        this.lanjut = lanjut;
    }
    
    Date  tanggal;
    public String getStatusPelamar() {
        return statusPelamar;
    }

    public void setStatusPelamar(String statusPelamar) {
        this.statusPelamar = statusPelamar;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date Tanggal) {
        this.tanggal = Tanggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNama_cabang() {
        return nama_cabang;
    }

    public void setNama_cabang(String nama_cabang) {
        this.nama_cabang = nama_cabang;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getT_kerajinan() {
        return t_kerajinan;
    }

    public void setT_kerajinan(String t_kerajinan) {
        this.t_kerajinan = t_kerajinan;
    }

    public String getT_operational() {
        return t_operational;
    }

    public void setT_operational(String t_operational) {
        this.t_operational = t_operational;
    }

    public String getT_bpjs_ketenagakerjaan() {
        return t_bpjs_ketenagakerjaan;
    }

    public void setT_bpjs_ketenagakerjaan(String t_bpjs_ketenagakerjaan) {
        this.t_bpjs_ketenagakerjaan = t_bpjs_ketenagakerjaan;
    }

    public String getT_bpjs_kesehatan() {
        return t_bpjs_kesehatan;
    }

    public void setT_bpjs_kesehatan(String t_bpjs_kesehatan) {
        this.t_bpjs_kesehatan = t_bpjs_kesehatan;
    }

    public String getT_lainnya() {
        return t_lainnya;
    }

    public void setT_lainnya(String t_lainnya) {
        this.t_lainnya = t_lainnya;
    }

    public String getT_kesehatan() {
        return t_kesehatan;
    }

    public void setT_kesehatan(String t_kesehatan) {
        this.t_kesehatan = t_kesehatan;
    }

    public String getT_penepatan() {
        return t_penepatan;
    }

    public void setT_penepatan(String t_penepatan) {
        this.t_penepatan = t_penepatan;
    }

    public String getT_transport() {
        return t_transport;
    }

    public void setT_transport(String t_transport) {
        this.t_transport = t_transport;
    }

    public String getT_makan() {
        return t_makan;
    }

    public void setT_makan(String t_makan) {
        this.t_makan = t_makan;
    }

    public String getT_jabatan() {
        return t_jabatan;
    }

    public void setT_jabatan(String t_jabatan) {
        this.t_jabatan = t_jabatan;
    }

    public String getP_pinjaman_karyawan() {
        return p_pinjaman_karyawan;
    }

    public void setP_pinjaman_karyawan(String p_pinjaman_karyawan) {
        this.p_pinjaman_karyawan = p_pinjaman_karyawan;
    }
    public String getP_bpjs_ketenagakerjaan() {
        return p_bpjs_ketenagakerjaan;
    }

    public void setP_bpjs_ketenagakerjaan(String p_bpjs_ketenagakerjaan) {
        this.p_bpjs_ketenagakerjaan = p_bpjs_ketenagakerjaan;
    }

    public String getP_bpjs_kesehatan() {
        return p_bpjs_kesehatan;
    }

    public void setP_bpjs_kesehatan(String p_bpjs_kesehatan) {
        this.p_bpjs_kesehatan = p_bpjs_kesehatan;
    }

    public String getP_asr_kesehatan() {
        return p_asr_kesehatan;
    }

    public void setP_asr_kesehatan(String p_asr_kesehatan) {
        this.p_asr_kesehatan = p_asr_kesehatan;
    }

    public String getP_denda_kedisiplinan() {
        return p_denda_kedisiplinan;
    }

    public void setP_denda_kedisiplinan(String p_denda_kedisiplinan) {
        this.p_denda_kedisiplinan = p_denda_kedisiplinan;
    }

    public String getP_pajak() {
        return p_pajak;
    }

    public void setP_pajak(String p_pajak) {
        this.p_pajak = p_pajak;
    }

    public String getUser_created() {
        return user_created;
    }

    public void setUser_created(String user_created) {
        this.user_created = user_created;
    }

    public String getUser_updated() {
        return user_updated;
    }

    public void setUser_updated(String user_updated) {
        this.user_updated = user_updated;
    }

    public String getCutiTahunan() {
        return cuti;
    }

    public void setCutiTahunan(String cuti) {
        this.cuti = cuti;
    }
     public String getCuti5Tahunan() {
        return cuti5;
    }

    public void setCuti5Tahunan(String cuti5) {
        this.cuti5 = cuti5;
    }

    public String getTanggal_dibuat() {
        return tanggal_dibuat;
    }

    public void setTanggal_dibuat(String tanggal_dibuat) {
        this.tanggal_dibuat = tanggal_dibuat;
    }

    public String getTanggal_update() {
        return tanggal_update;
    }

    public void setTanggal_update(String tanggal_update) {
        this.tanggal_update = tanggal_update;
    }

    public String getE_periode() {
        return e_periode;
    }

    public void setE_periode(String e_periode) {
        this.e_periode = e_periode;
    }

    public String getS_periode() {
        return s_periode;
    }

    public void setS_periode(String s_periode) {
        this.s_periode = s_periode;
    }


}

