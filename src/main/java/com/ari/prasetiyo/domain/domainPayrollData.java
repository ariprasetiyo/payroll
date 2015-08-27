/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.domain;
import java.sql.Date;

/**
 *
 * @author arprast
 */
public class domainPayrollData {
    String nama, id, idKaryawan, jabatan, area, statusPegawai, statusPekerja, gajiPokok, tunjangan, lembur, potongan, gajiBersih, period, userCreated;
    String[] idKaryawanArray;
    Date tanggalDibuat;

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }

    public String[] getIdKaryawanArray() {
        return idKaryawanArray;
    }

    public void setIdKaryawanArray(String[] idKaryawanArray) {
        this.idKaryawanArray = idKaryawanArray;
    }
    public String getGajiBersih() {
        return gajiBersih;
    }

    public void setGajiBersih(String gajiBersih) {
        this.gajiBersih = gajiBersih;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStatusPegawai() {
        return statusPegawai;
    }

    public void setStatusPegawai(String statusPegawai) {
        this.statusPegawai = statusPegawai;
    }

    public String getStatusPekerja() {
        return statusPekerja;
    }

    public void setStatusPekerja(String statusPekerja) {
        this.statusPekerja = statusPekerja;
    }

    public String getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(String gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public String getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(String tunjangan) {
        this.tunjangan = tunjangan;
    }

    public String getLembur() {
        return lembur;
    }

    public void setLembur(String lembur) {
        this.lembur = lembur;
    }

    public String getPotongan() {
        return potongan;
    }

    public void setPotongan(String potongan) {
        this.potongan = potongan;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }
}
