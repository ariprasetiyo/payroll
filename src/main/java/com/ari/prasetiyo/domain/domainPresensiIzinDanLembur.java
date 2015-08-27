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
public class domainPresensiIzinDanLembur {
    //id dan text difungsikan untuk format json select2
     Date tanggalDibuat , tanggalIzinCutiMulai, tanggalIzinCutiSelsai, tanggalIzinSakitMulai, tanggalIzinSakitSelesai, tanggalLemburMulai, tanggalLemburSelesai;
    String  tanggalMulai, tanggalSelesai, statusPresensi, nama,idKaryawan, refIzinCuti, refIzinSakit, refLembur, jabatan, jumlahIzinSakit, jumlahIzinCuti, jumlahLembur, 
             katagoriLembur, jenisIzinCuti, id, text, sisaCutiTahunan, ket, idPresensi, userCreated, userUpdated, refCode, jenisIzinCutiOrSakit;
    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public Date getTanggalLemburMulai() {
        return tanggalLemburMulai;
    }

    public void setTanggalLemburMulai(Date tanggalLemburMulai) {
        this.tanggalLemburMulai = tanggalLemburMulai;
    }

    public Date getTanggalLemburSelesai() {
        return tanggalLemburSelesai;
    }

    public void setTanggalLemburSelesai(Date tanggalLemburSelesai) {
        this.tanggalLemburSelesai = tanggalLemburSelesai;
    }
     

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getStatusPresensi() {
        return statusPresensi;
    }

    public void setStatusPresensi(String statusPresensi) {
        this.statusPresensi = statusPresensi;
    }

    public String getJenisIzinCutiOrSakit() {
        return jenisIzinCutiOrSakit;
    }

    public void setJenisIzinCutiOrSakit(String jenisIzinCutiOrSakit) {
        this.jenisIzinCutiOrSakit = jenisIzinCutiOrSakit;
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

    public String getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(String userUpdated) {
        this.userUpdated = userUpdated;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getIdPresensi() {
        return idPresensi;
    }

    public void setIdPresensi(String idPresensi) {
        this.idPresensi = idPresensi;
    }

    public String getSisaCutiTahunan() {
        return sisaCutiTahunan;
    }

    public void setSisaCutiTahunan(String sisaCutiTahunan) {
        this.sisaCutiTahunan = sisaCutiTahunan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getRefIzinCuti() {
        return refIzinCuti;
    }

    public void setRefIzinCuti(String refIzinCuti) {
        this.refIzinCuti = refIzinCuti;
    }

    public String getRefIzinSakit() {
        return refIzinSakit;
    }

    public void setRefIzinSakit(String refIzinSakit) {
        this.refIzinSakit = refIzinSakit;
    }

    public String getRefLembur() {
        return refLembur;
    }

    public void setRefLembur(String refLembur) {
        this.refLembur = refLembur;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJumlahIzinSakit() {
        return jumlahIzinSakit;
    }

    public void setJumlahIzinSakit(String jumlahIzinSakit) {
        this.jumlahIzinSakit = jumlahIzinSakit;
    }

    public String getJumlahIzinCuti() {
        return jumlahIzinCuti;
    }

    public void setJumlahIzinCuti(String jumlahIzinCuti) {
        this.jumlahIzinCuti = jumlahIzinCuti;
    }

    public String getJumlahLembur() {
        return jumlahLembur;
    }

    public void setJumlahLembur(String jumlahLembur) {
        this.jumlahLembur = jumlahLembur;
    }

    public String getKatagoriLembur() {
        return katagoriLembur;
    }

    public void setKatagoriLembur(String katagoriLembur) {
        this.katagoriLembur = katagoriLembur;
    }

    public String getJenisIzinCuti() {
        return jenisIzinCuti;
    }

    public void setJenisIzinCuti(String jenisIzinCuti) {
        this.jenisIzinCuti = jenisIzinCuti;
    }

    public Date getTanggalIzinCutiMulai() {
        return tanggalIzinCutiMulai;
    }

    public void setTanggalIzinCutiMulai(Date tanggalIzinCutiMulai) {
        this.tanggalIzinCutiMulai = tanggalIzinCutiMulai;
    }

    public Date getTanggalIzinCutiSelsai() {
        return tanggalIzinCutiSelsai;
    }

    public void setTanggalIzinCutiSelsai(Date tanggalIzinCutiSelsai) {
        this.tanggalIzinCutiSelsai = tanggalIzinCutiSelsai;
    }

    public Date getTanggalIzinSakitMulai() {
        return tanggalIzinSakitMulai;
    }

    public void setTanggalIzinSakitMulai(Date tanggalIzinSakitMulai) {
        this.tanggalIzinSakitMulai = tanggalIzinSakitMulai;
    }

    public Date getTanggalIzinSakitSelesai() {
        return tanggalIzinSakitSelesai;
    }

    public void setTanggalIzinSakitSelesai(Date tanggalIzinSakitSelesai) {
        this.tanggalIzinSakitSelesai = tanggalIzinSakitSelesai;
    }
}
