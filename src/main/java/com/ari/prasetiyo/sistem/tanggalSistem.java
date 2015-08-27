/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.sistem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author LANTAI3
 * Jika Convert tanggal dari kazao atau datechooose
 * Maka format harus bulan/tangal/tahun
 */
public class tanggalSistem {
            int TanggalSis;
            int BulanSis;
            int TahunSis;
            int TglIndo;
            int BlnIndo;
            int ThnIndo;
            int TglSql;
            int BlnSql;
            int ThnSql;
            int IntDateTgl;
            int IntDateBln;
            int IntDateTahun;
            
            String StrDateTgl;
            String StrDateBln;
            String StrDateThn;
            String StrTglIndo;
            String StrBlnIndo;
            String StrThnIndo;
            String StrTglSql;
            String StrBlnSql;
            String StrThnSql;
            String StrTglSistem;
            String StrBlnSistem;
            String StrThnSistem;
            
            
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date SqlDate1 = new java.sql.Date(utilDate.getTime());
            String SqlDate = SqlDate1.toString();
                        
            protected int GetTanggalSis (){
                return TanggalSis;
            }
            protected int GetBulanSis (){
                return BulanSis;
            }
            protected int GetTahunSis(){
                return TahunSis;
            }
            
            protected String GetTanggalSisString (){
                return StrTglSistem ;
            }
            protected String GetBulanSisString (){
                return StrBlnSistem;
            }
            protected String GetTahunSisString(){
                return StrThnSistem;
            }
            
            protected int GetTglIndoIntKazao(){
                return TglIndo;
            }
            protected int GetBulIndoIntKaza0 (){
                return BlnIndo;
            }
            protected int GetThnIndoIntKazao (){
                return ThnIndo;
            }
            
            protected String GetTglIndoStrKazao (){
                return StrTglIndo;
            }
            protected String GetBlnIndoStrKazao(){
                return StrBlnIndo;
            }
            protected String GetThnIndoStKazao(){
                return StrThnIndo;
            }
            
            protected int GetTglIndoIntSql(){
                return TglSql;
            }
            protected int GetBulIndoIntSql (){
                return BlnSql;
            }
            protected int GetThnIndoIntSql (){
                return ThnSql;
            }
            
            protected String GetTglIndoStrSql (){
                return StrTglSql;
            }
            protected String GetBlnIndoStrSql(){
                return StrBlnSql;
            }
            protected String GetThnIndoStrSql(){
                return StrThnSql;
            }
            
            /*
             * DateTanggalAll
             */
            protected int GetTanggalIntDate(){
                return IntDateTgl;
            }
            protected int GetBulanIntDate() {
                return IntDateBln;
            }
            protected int GetTahunIntDate(){
                return IntDateTahun;
            }
            protected  String GetTanggalStrDate(){
                return StrDateTgl;
            }
            protected String GetBulanStrDate() {
                return StrDateBln;
            }
            protected String GetTahunStrDate(){
                return StrDateThn;
            }
            
            /*
             * Langsung pangil dan dapatkan nilainya
             */
            public int GetTglNow(){
                SetTanggalSis ();
                return GetTanggalSis ();
            }
            public int GetBlnNow(){
                SetBulanSis ();
                return GetBulanSis ();
            }
            public int GetThnNow(){
                SetTahunSis ();
                return GetTahunSis ();
            }
            
            
            protected void SetTanggalSis (){
                String RegexTanggal = "[2-9][0-9][0-9][0-9]-[0-9][0-9]-";
                String DataTanggalSis = SqlDate.replaceAll(RegexTanggal, ""); 
                this.StrTglSistem = DataTanggalSis;
                int Tanggal = Integer.valueOf(DataTanggalSis).intValue();
                this.TanggalSis = Tanggal;
            }
            protected void SetBulanSis (){
                String RegexBulan1 = "[2-9][0-9][0-9][0-9]-";
                String RegexBulan2 = "-[0-9][0-9]";
                String DataBulan1Sis = SqlDate.replaceAll(RegexBulan1, "");
                String DataBulanSis = DataBulan1Sis.replaceAll(RegexBulan2, "");
                this.StrBlnSistem = DataBulanSis;
                int Bulan = Integer.valueOf(DataBulanSis).intValue();
                this.BulanSis = Bulan;
            }
            protected void SetTahunSis (){
                String RegexTahun = "-[0-9][0-9]-[0-9][0-9]";
                String DataTahunSis = SqlDate.replaceAll(RegexTahun, "");
                this.StrThnSistem = DataTahunSis;
                int Thn = Integer.valueOf(DataTahunSis).intValue();
                this.TahunSis = Thn;
            }
            
            /*
             * converter tanggal kazao ke indonesia
             * format TanggalPo.getKazaoCalendar().getShortDate();
             * untuk tanggal bulan dan tahun sama formatnya
             */
            protected void SetKazaoToTglIndo (String Data){
                String RegexTgl1 = "/[0-9][0-9][0-9][0-9]";
                String RegexTgl2 = "[0-9][0-9]/";
                Data = Data.replaceAll(RegexTgl1,"");
                String Data2 = Data.replaceAll(RegexTgl2, "");
                this.StrTglIndo = Data2;
                this.TglIndo  = Integer.valueOf(Data2).intValue();
            }
            protected void SetKazaoToBlnIndo ( String Data){
                String RegexBln = "/[0-9][0-9]/[0-9][0-9][0-9][0-9]";
                Data = Data.replaceAll(RegexBln, "");
                this.StrBlnIndo = Data;
                this.BlnIndo = Integer.valueOf(Data).intValue();    
            }
            protected void SetKazaoToThnIndo ( String Data){
                String RegexThn = "[0-9][0-9]/[0-9][0-9]/";
                Data = Data.replaceAll(RegexThn, "");
                this.StrThnIndo = Data;
                this.ThnIndo = Integer.valueOf(Data).intValue();
            } 
            
            /*
             * Convert seluruh tanggal
             * Digunakan untuk set seluruh tanggal di convert ke tangal, bulan, tahun
             */
            protected void SetDate( String Data){
                String RTanggal = "[0-9][0-9][0-9][0-9]-[0-9][0-9]-";
                String RBulan1 = "[0-9][0-9][0-9][0-9]-";
                String RBulan2 = "-[0-9][0-9]";
                String RTahun = "-[0-9][0-9]-[0-9][0-9]";
                
                String Tgl = Data.replaceAll(RTanggal, "");
                String B1 = Data.replaceAll(RBulan1, "");
                String B2 = B1.replaceAll(RBulan2, "");
                String Thn = Data.replaceAll(RTahun, "");
                
                this.StrDateTgl = Tgl;
                this.StrDateBln = B2;
                this.StrDateThn = Thn;
                
                this.IntDateTgl = Integer.valueOf(Tgl).intValue();
                this.IntDateBln = Integer.valueOf(B2).intValue();
                this.IntDateTahun = Integer.valueOf(Thn).intValue();
                
            }
            
            /*
             * Converter Sql date to date indonesia
             */
            protected void SetSqlToTglIndo (String Data){
                String RegexTanggal = "[0-9][0-9][0-9][0-9]-[0-9][0-9]-";
                Data = Data.replaceAll(RegexTanggal, "");   
                this.StrTglSql = Data;
                this.TglSql = Integer.valueOf(Data).intValue();
            }
            protected void SetSqlToBlnIndo ( String Data){
                String RegexBln1 = "[0-9][0-9][0-9][0-9]-";
                String RegexBln2 = "-[0-9][0-9]";
                Data = Data.replaceAll(RegexBln1, "");
                String Data2 = Data.replaceAll(RegexBln2, "");
                this.StrBlnSql = Data2;  
                this.BlnSql = Integer.valueOf(Data2).intValue();
                
            }
            protected void SetSqlToThnIndo ( String Data){
                String RegexThn = "-[0-9][0-9]-[0-9][0-9]";
                Data = Data.replaceAll(RegexThn, "");
                this.StrThnSql = Data;
                this.ThnSql = Integer.valueOf(Data).intValue();
            } 
            
            /*
             * Convert tanggal dengan format tgl-bln-thn di pecah persatuan
             */
            protected int ConvertTglBlnThnToTanggal (String TglBulanTahun){
                TglBulanTahun = TglBulanTahun.replaceAll("-[0-9][0-9]-[0-9][0-9][0-9][0-9]", "");
                return Integer.valueOf(TglBulanTahun).intValue();
            }
            protected int ConvertTglBlnThnToBulan (String TglBulanTahun){;
                String RegexHapusThn    = "-[0-9][0-9][0-9][0-9]";
                String RegexHapusTgl    = "[0-9][0-9]-";
                String TglBul           = TglBulanTahun.replaceAll(RegexHapusThn, "");
                String Data             = TglBul.replaceAll(RegexHapusTgl, "");
                return Integer.valueOf(Data).intValue();
            }
            protected int ConvertTglBlnThnToTahun (String TglBulanTahun){
                TglBulanTahun   = TglBulanTahun.replaceAll("[0-9][0-9]-[0-9][0-9]-", "");
                return Integer.valueOf(TglBulanTahun).intValue();
            }
            
            /*
             * Convert tangal datechooser to pecah dari bulan/tahun
             * Menjadi 
             */
            
            
            /*
             * Convert dari date compuser yg dari database. format tgl/bln/thun 01/12/14
             */
            
            protected int DecomposerDateTanggal(){
                return TanggalSis;
            }
            protected int DecomposerDateTahun(){
                return TahunSis;
            }
            protected int DecomposerDateBulan(){
                return BulanSis;
            }
            
            protected void SetDecomposerDate (String B){

                String RegexTanggal = "/[0-9][0-9]/[0-9][0-9][0-9][0-9]";
                String Tanggal = B.replaceAll(RegexTanggal, "");   
                this.TanggalSis = Integer.valueOf(Tanggal).intValue();

                String RegTahun     = "[0-9][0-9]/[0-9][0-9]/";
                String Tahun = B.replaceAll(RegTahun, "");   
                this.TahunSis = Integer.valueOf(Tahun).intValue();
                
                String RegBulan1    = "^([0-9][0-9]/)";
                String RegBulan2    = "(/[0-9][0-9][0-9][0-9])$";
                String Bulan        = B.replaceAll(RegBulan1, "");  
                Bulan               = Bulan.replaceAll(RegBulan2, "");
                this.BulanSis = Integer.valueOf(Bulan).intValue();
            }
            
            /*
             * Decomposer formt awal 31 12 2014
             */
            protected void SetDecomposerDate (String B, int TglBulanTahun2014 ){

               System.out.println(B +  " s "  );
                String RegexTanggal = "/[0-9][0-9]/[0-9][0-9][0-9][0-9]";
                String Tanggal = B.replaceAll(RegexTanggal, "");   
                this.TanggalSis = Integer.valueOf(Tanggal).intValue();
             
                
                String RegTahun1     = "[0-9][0-9]/[0-9][0-9]/";
                String Tahun = B.replaceAll(RegTahun1, "");  
                String RegTahun2     = "^([0-9][0-9])";
                Tahun = Tahun.replaceAll(RegTahun2, "");
                this.TahunSis = Integer.valueOf(Tahun).intValue();
                
                String RegBulan1    = "^([0-9][0-9]/)";
                String RegBulan2    = "(/[0-9][0-9][0-9][0-9])$";
                String Bulan        = B.replaceAll(RegBulan1, "");  
                Bulan               = Bulan.replaceAll(RegBulan2, "");
                this.BulanSis = Integer.valueOf(Bulan).intValue();
                
                System.out.println(TanggalSis  + " s " + BulanSis + " s " +TahunSis );
            }
            
            /*
             * Convert tanggal dengan format tgl-bln-thn di pecah persatuan
             */
            protected String ConvertTgl_Bln_Thn_To_Tanggal_String (String TglBulanTahun){
                TglBulanTahun = TglBulanTahun.replaceAll("-[0-9][0-9]-[0-9][0-9][0-9][0-9]", "");
                return TglBulanTahun;
            }
            protected String ConvertTgl_Bln_Thn_To_Bulan_String (String TglBulanTahun){;
                String RegexHapusThn    = "-[0-9][0-9][0-9][0-9]";
                String RegexHapusTgl    = "[0-9][0-9]-";
                String TglBul           = TglBulanTahun.replaceAll(RegexHapusThn, "");
                String Data             = TglBul.replaceAll(RegexHapusTgl, "");
                return Data;
            }
            protected String ConvertTgl_Bln_Thn_To_Tahun_String (String TglBulanTahun){
                TglBulanTahun   = TglBulanTahun.replaceAll("[0-9][0-9]-[0-9][0-9]-", "");
                return TglBulanTahun;
            }
            
            /*
            Ari prasetiyo
            20 desember 2014
            */
            protected String getTanggal_YYYYMMDD_HHmmss() {  
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
                Date date = new Date();  
                return dateFormat.format(date);  
            }
            protected String getTanggal_YYYYMMDD() {  
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
                Date date = new Date();  
                return dateFormat.format(date);  
            }
            protected String getTanggal_HHmmss() {  
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  
                Date date = new Date();  
                return dateFormat.format(date);  
            }
            protected String getTanggal_FormatFile() {  
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");  
                Date date = new Date();  
                return dateFormat.format(date);  
            }
            
            /*
            Ari Prasetiyo
            2015/4/7
            Java Servlet Payroll
            Convert String to date agar bisa disimpan di database
            Sql date

            Format source data harus seperti ini
            MM/dd/yyyy = 7-Jun-2013
            dd/MM/yyyy = 09/04/2015
            dd-MM-YYYY = 04-09/2015
            difungsikan  convert java.util.Date ke java.sql.Date dengan format dd/MMM/YYYY
            
            contoh 
            convertTgl.tglUtil(req.getParameter(30/05/2015), "dd/MM/yyyy"))
            ps.setDate(3, new  java.sql.Date(m.getTanggalLahir().getTime()));
            */
            public java.util.Date tglUtil (String strTanggal, String fmtTnggal){
                java.text.SimpleDateFormat formatTgl = new java.text.SimpleDateFormat(fmtTnggal);
                try {
                    return formatTgl.parse(strTanggal);
                } catch (ParseException ex) {
                    getLogger(tanggalSistem.class.getName()).log(Level.SEVERE, null, ex);
                    new com.ari.prasetiyo.sistem.loggerError(tanggalSistem.class.getName(), ex);
                    return null;
                }
            }
            
            /*
            Ari Prasetiyo
            2015/4/7
            Java Servlet Payroll
            validation from string date to sql date or util date
            */
            public boolean isValidationDate(String filter1){
                if (filter1 instanceof String){
                        if (filter1 != null ) {
                            if (!filter1.equals("")  ){
                                return true;
                            }
                        }
                    }
                return false;
            }
}
