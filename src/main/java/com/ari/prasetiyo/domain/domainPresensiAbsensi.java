/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.domain;
import java.util.Date;
/**
 *
 * @author arprast
 */
public class domainPresensiAbsensi {
     String[] masuk, absen, idKar, MT, PLA;
     String userCreated, refCode, id, sts_pegawai, area, nama_cabang, nama, jenisKelamin, statusPelamar, jabatan, user_created,  periode ;
     Date tanggalDibuat;
     int masukInt, absenInt, masukTerlambat, pulangLebihAwal, sakit, cuti, lembur;

    public int getMasukInt() {
        return masukInt;
    }

    public void setMasukInt(int masukInt) {
        this.masukInt = masukInt;
    }

    public int getAbsenInt() {
        return absenInt;
    }

    public void setAbsenInt(int absenInt) {
        this.absenInt = absenInt;
    }

    public int getMasukTerlambat() {
        return masukTerlambat;
    }

    public void setMasukTerlambat(int masukTerlambat) {
        this.masukTerlambat = masukTerlambat;
    }

    public int getPulangLebihAwal() {
        return pulangLebihAwal;
    }

    public void setPulangLebihAwal(int pulangLebihAwal) {
        this.pulangLebihAwal = pulangLebihAwal;
    }

    public int getSakit() {
        return sakit;
    }

    public void setSakit(int sakit) {
        this.sakit = sakit;
    }

    public int getCuti() {
        return cuti;
    }

    public void setCuti(int cuti) {
        this.cuti = cuti;
    }

    public int getLembur() {
        return lembur;
    }

    public void setLembur(int lembur) {
        this.lembur = lembur;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSts_pegawai() {
        return sts_pegawai;
    }

    public void setSts_pegawai(String sts_pegawai) {
        this.sts_pegawai = sts_pegawai;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getStatusPelamar() {
        return statusPelamar;
    }

    public void setStatusPelamar(String statusPelamar) {
        this.statusPelamar = statusPelamar;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUser_created() {
        return user_created;
    }

    public void setUser_created(String user_created) {
        this.user_created = user_created;
    }

    

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public String[] getMasuk() {
        return masuk;
    }

    public void setMasuk(String[] masuk) {
        this.masuk = masuk;
    }

    public String[] getAbsen() {
        return absen;
    }

    public void setAbsen(String[] absen) {
        this.absen = absen;
    }

    public String[] getIdKar() {
        return idKar;
    }

    public void setIdKar(String[] idKar) {
        this.idKar = idKar;
    }

    public String[] getMT() {
        return MT;
    }

    public void setMT(String[] MT) {
        this.MT = MT;
    }

    public String[] getPLA() {
        return PLA;
    }

    public void setPLA(String[] PLA) {
        this.PLA = PLA;
    }
}
