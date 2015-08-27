/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.sistem;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arprast
 */
public class convertAll {
    
    /*
    bisa digunakan untuk all program
    */
    public BigInteger toBigInteger(String foo)
        {
            return new BigInteger(foo.getBytes());
        }

    public String fromBigInteger(BigInteger bar)
        {
            return new String(bar.toByteArray());
        }
     
     /*
     convert ke bilangan angka
     hanya untuk program payroll saja
     */
     public int convertJenisKelaminInt(String Data){
         if (Data.equalsIgnoreCase("L")){
             return 1;
         }
         else if (Data.equalsIgnoreCase("P")) {
             return 0;
         }
         else {
             return 1992;
         }
     }
     public String convertJenisKelaminString(int Data){
         if (Data == 1){
             return "L";
         }
         else if (Data == 0) {
             return "P";
         }
         else {
             return "error 1992";
         }
     }
     
     public int convertStatusTempatTinggal(String Data){
         /*
        <option>Rumah sendiri</option>
        <option>Kontrak</option>
        <option>Kos</option>
        <option>Tinggal bersama kerabat</option>
        <option>Tinggal bersama orang tua</option>
         */
         if (Data.equalsIgnoreCase("Rumah sendiri")){
             return 0;
         }
         else if (Data.equalsIgnoreCase("Kontrak")) {
             return 1;
         }
         else if (Data.equalsIgnoreCase("Kos")) {
             return 2;
         }
         else if (Data.equalsIgnoreCase("Tinggal bersama kerabat")) {
             return 3;
         }
         else if (Data.equalsIgnoreCase("Tinggal bersama orang tua")) {
             return 4;
         }
         else {
             return 1992;
         }
     }
     public String convertStatusTempatTinggalString(int Data){
         /*
        <option>Rumah sendiri</option>
        <option>Kontrak</option>
        <option>Kos</option>
        <option>Tinggal bersama kerabat</option>
        <option>Tinggal bersama orang tua</option>
         */
         if (Data == 0){
             return "Rumah sendiri";
         }
         else if (Data == 1) {
             return "Kontrak";
         }
         else if (Data == 2) {
             return "Kos";
         }
         else if (Data == 3) {
             return "Tinggal bersama kerabat";
         }
         else if (Data == 4) {
             return "Tinggal bersama orang tua";
         }
         else {
             return "error 1992";
         }
     }
     
     public int convertStatusNikahInt (String Data){
         if (Data.equalsIgnoreCase("BELUM MENIKAH")){
             return 0;
         }
         else if (Data.equalsIgnoreCase("MENIKAH")) {
             return 1;
         }
         else if (Data.equalsIgnoreCase("BERPISAH")) {
             return 2;
         }
         else {
             return 1992;
         }
     }
      public String convertStatusNikahString (int Data){
         if (Data == 0){
             return "BELUM MENIKAH";
         }
         else if (Data == 1) {
             return "MENIKAH";
         }
         else if (Data == 2) {
             return "BERPISAH";
         }
         else {
             return "error 1992";
         }
     }
      
      public int convertAgama (String Data){
         if (Data.equalsIgnoreCase("islam")){
             return 0;
         }
         else if (Data.equalsIgnoreCase("kristen prostestan")) {
             return 1;
         }
         else if (Data.equalsIgnoreCase("kristen katolik")) {
             return 2;
         }
         else if (Data.equalsIgnoreCase("hindu")) {
             return 3;
         }
         else if (Data.equalsIgnoreCase("budha")) {
             return 4;
         }
         else {
             return 1992;
         }
     }
       public String convertAgamaString (int Data){
         if (Data == 0){
             return "Islam";
         }
         else if (Data == 0) {
             return "Kristen prostestan";
         }
         else if (Data == 0) {
             return "Kristen katolik";
         }
         else if (Data == 0) {
             return "Hindu";
         }
         else if (Data == 0) {
             return "Budha";
         }
         else {
             return "error 1992";
         }
     }
      
      public int convertStatusPelamar (String Data){
         if (Data.equalsIgnoreCase("Menunggu")){
             return 0;
         }
         else if (Data.equalsIgnoreCase("Diterima")) {
             return 1;
         }
         else if (Data.equalsIgnoreCase("Ditolak")) {
             return 2;
         }
         else if (Data.equalsIgnoreCase("resign")) {
             return 3;
         }
         else {
             return 1992;
         }
     }
      public String convertStatusPelamarString (int Data){
         if (Data == 0){
             return "Menunggu";
         }
         else if (Data == 1) {
             return "Diterima";
         }
         else if (Data == 2) {
             return "Ditolak";
         }
         else if (Data == 3) {
             return "Resign";
         }
         else {
             return "error 1992";
         }
     }
      public String convertStatusKaryawan (int Data){
         if (Data == 0){
             return "Menunggu";
         }
         else if (Data == 1) {
             return "Karyawan";
         }
         else if (Data == 2) {
             return "Ditolak";
         }
         else if (Data == 3) {
             return "Resign";
         }
         else {
             return "error 1992";
         }
     }
       public String convertPegawai (int Data){
           try {
            if (Data == 0){
             return "Training";
            }
            else if (Data == 1) {
                return "Kontrak";
            }
            else if (Data == 2) {
                return "Tetap";
            }
            else if (Data == 3) {
                return "Resign";
            }
            else {
                    return "tidak ada status pegawai";
             }
           }
           catch(Exception ex){
               Logger.getLogger(convertAll.class.getName()).log(Level.SEVERE, null, ex);
               new com.ari.prasetiyo.sistem.loggerError(convertAll.class.getName(), ex);
               return "tidak ada status pegawai";
           }
     }
       public String convertPegawai (String Data2){
           try {
               int Data = Integer.valueOf(Data2);
            if (Data == 0){
             return "Training";
            }
            else if (Data == 1) {
                return "Kontrak";
            }
            else if (Data == 2) {
                return "Tetap";
            }
            else if (Data == 3) {
                return "Resign";
            }
            else {
                    return "tidak ada status pegawai";
             }
           }
           catch(Exception ex){
               Logger.getLogger(convertAll.class.getName()).log(Level.SEVERE, null, ex);
               new com.ari.prasetiyo.sistem.loggerError(convertAll.class.getName(), ex);
               return "tidak ada status pegawai";
           }
     }
       
       /*
       ~Executive(GM)
        ~Manager
        ~SuperIntendent
        ~Supervisor
        ~Team leader
        ~Operator 
       */
       public String convertJabatan (int Data){
         if (Data == 0){
             return "Presiden Direktur";
         }
         else if (Data == 1) {
             return "Direktur";
         }
         else if (Data == 2) {
             return "General Manager";
         }
         else if (Data == 3) {
             return "Manager";
         }
         else if (Data == 4) {
             return "Supervisor";
         }   
         else if (Data == 5) {
             return "Staff IT";
         }
         else if (Data == 6) {
             return "Staff Administrasi";
         }
         else if (Data == 7) {
             return "Staff Accounting";
         }
         else if (Data == 8) {
             return "Staff Finance";
         }
         else if (Data == 9) {
             return "Staff HRD";
         }
         else if (Data == 10) {
             return "Staff Logistik";
         }
         else if (Data == 11) {
             return "Store Manager";
         }
         else if (Data == 12) {
             return "Store Staff";
         }
         else {
             return "error 1992";
         }
     }
     // convert tanggal 15/05/2015 - 26/06/2015
      public int convertGolDarah (String Data){
         if (Data.equalsIgnoreCase("A")){
             return 0;
         }
         else if (Data.equalsIgnoreCase("B")) {
             return 1;
         }
         else if (Data.equalsIgnoreCase("AB")) {
             return 2;
         }
         else if (Data.equalsIgnoreCase("O")) {
             return 3;
         }
         else {
             return 1992;
         }
     }
      public String convertGolDarahString (int Data){
         if (Data == 0){
             return "A";
         }
         else if (Data == 1) {
             return "B";
         }
         else if (Data == 2) {
             return "AB";
         }
         else if (Data == 3) {
             return "O";
         }
         else {
             return "error 1992";
         }
     }
    public String convertFormat_Rp_ke_Nominal(String data){
          data = data.replaceAll("[Rp\\s\\.A-Za-z]", "");
          return data;
    }
     /*
    Tambahan baru 20/11/2014
    */
    /*
    Merubah dari 10000 menjadi Rp. 10.000,00
    Langsung merubahanya
    */
    public String FormatIndonesia_BigInteger(String Data) {
        BigInteger harga = new BigInteger(Data);
            
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        //System.out.printf("Harga Rupiah: %s %n", kursIndonesia.format(harga));
        return kursIndonesia.format(harga);
    }
    
    public String FormatIndonesia_Integer ( int harga) {

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        //System.out.printf("Harga Rupiah: %s %n", kursIndonesia.format(harga));
        return kursIndonesia.format(harga);
    }
    public String convertArea (String Data){
         if (Data.equals("0")){
             return "-";
         }
         else if (Data.equals("1")) {
             return "Jakarta";
         }
         else if (Data.equals("2")) {
             return "Jawa Barat";
         }
         else if( Data.equals("3")) {
             return "Jawa Tengah";
         }
         else if (Data.equals("4")) {
             return "Jogjakarta";
         }
         else if (Data.equals("5")) {
             return "Bali";
         }
         else if (Data.equals("")) {
             return "-";
         }
         else {
             return "error 1992";
         }
     }
}
