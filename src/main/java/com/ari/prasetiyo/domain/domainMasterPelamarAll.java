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
 * difungsikan untuk filter saja ( all filter ) 
 */
public class domainMasterPelamarAll {   
    //pilihan digunakan untuk apa saja
    boolean lanjut;
    String fId, fNama, fJabatan, fStatusPlmr, fStatusPegawai, fArea, fIdKaryawan, fPilihan;

    public String getfPilihan() {
        return fPilihan;
    }

    public void setfPilihan(String fPilihan) {
        this.fPilihan = fPilihan;
    }

    public String getfIdKaryawan() {
        return fIdKaryawan;
    }

    public void setfIdKaryawan(String fIdKaryawan) {
        this.fIdKaryawan = fIdKaryawan;
    }

    public String getfArea() {
        return fArea;
    }

    public void setfArea(String fArea) {
        this.fArea = fArea;
    }
    Date fPeriodeCreate1, fPeriodeCreate2;

    public Date getfPeriodeCreate1() {
        return fPeriodeCreate1;
    }

    public void setfPeriodeCreate1(Date fPeriodeCreate1) {
        this.fPeriodeCreate1 = fPeriodeCreate1;
    }

    public Date getfPeriodeCreate2() {
        return fPeriodeCreate2;
    }

    public void setfPeriodeCreate2(Date fPeriodeCreate2) {
        this.fPeriodeCreate2 = fPeriodeCreate2;
    }


    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }
    
     public String getfStatusPegawai() {
        return fStatusPegawai;
    }

    public void setfStatusPegawai(String fStatusPegawai) {
        this.fStatusPegawai = fStatusPegawai;
    }

    public String getfNama() {
        return fNama;
    }

    public void setfNama(String fNama) {
        this.fNama = fNama;
    }

    public String getfJabatan() {
        return fJabatan;
    }

    public void setfJabatan(String fJabatan) {
        this.fJabatan = fJabatan;
    }

    public String getfStatPlmr() {
        return fStatusPlmr;
    }

    public void setfStatPlmr(String fStatusPlmr) {
        this.fStatusPlmr = fStatusPlmr;
    }
   
    public boolean isLanjut() {
        return lanjut;
    }

    public void setLanjut(boolean lanjut) {
        this.lanjut = lanjut;
    }

 
}
