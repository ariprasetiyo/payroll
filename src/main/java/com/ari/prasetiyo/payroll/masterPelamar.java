/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ari.prasetiyo.payroll;

import com.ari.prasetiyo.dao.daoMasterPelamar;
import com.ari.prasetiyo.dao.daoMenu;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ari.prasetiyo.domain.domainMasterPelamar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * @author arprast
 * catatan
 * http://www.codepolitan.com/cc-tak-sebatas-untuk-kuliah/
 */
/*
 public class NewClass {
public static void main(String[] args) {
new Object(){
public void function(){
System.out.println("hello World");
}
}.function();

for (int i = 0; i < 100 ;i= new Object(){
    public int function(int a){
        System.out.println(a+1);return a+1;
    }
}.function(i)) {
//........................................................
}
}
}
*/
public class masterPelamar extends HttpServlet {
    com.ari.prasetiyo.domain.domainMasterPelamarAll dMA = new com.ari.prasetiyo.domain.domainMasterPelamarAll();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        //xcv = 3 adalah print
        String id = req.getParameter("xcv");
        String sOrE = req.getParameter("sta");
        if (id == null  ){
            try {
                /*
                untuk menu
                */
                daoMenu dao = new daoMenu();
                List hasil = dao.tampilMenu();
                req.setAttribute("daftarMenu", hasil);
                
                req.getRequestDispatcher("pro/master_pelamar.jsp").forward(req, res);
            } catch (ServletException ex) {
                Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // tidak difungsikan dulu, kedepan untuk menu  dengan teknik ajax
        /*
        else if (id.equals("m")  ){
            kirimAjaxMenu(res);
            //untuk menu
            //daoMenu dao = new daoMenu();
            //List hasil = dao.tampilMenu();
            //req.setAttribute("daftarMenu", hasil);
            //req.getRequestDispatcher("pro/master_pelamar.jsp").forward(req, res);
        }
        */
        /*
        diaktivkan jika digunakan untuk melihat data json ( harus get pada url master_pelamar.ari?xcv=0 )
        else if (id.equals("0")){
        detailAmbilDataPelamar(req, res);
        }
        */
        //pmbuatan filter dan ambil data pelamar
        else if (id.equals("2")) {
            res.setHeader("REQUIRES_AUTH", "1");
            String batasBawah = req.getParameter("limitBawah");
            String batasAtas = req.getParameter("limitAtas");
            String[] filter = {
                req.getParameter("f_id"),
                req.getParameter("f_nama"),
                req.getParameter("f_jabatan"),
                req.getParameter("f_s_plmr"),
                req.getParameter("f_tgl_buat1"),
                req.getParameter("f_tgl_buat2")
            };
            // jika ini dihilangkan maka data json tidak bisa direct langsung
            if (batasBawah == null ||  batasAtas == null ){
                batasBawah = "0";
                batasAtas = "19";
            }
            // System.out.println("hallo 1 :" + filter[0] + "dan" + filter[1] + "dan" + filter[2] + "dan" + filter[3] + "dan" + filter[4] + "dan" + filter[5]);
            // cek data filter
            boolean lnjt = false;
            for (String filter1 : filter) {
                // filter1 instanceof String difungiskan filter variabel undefined
                if (filter1 instanceof String) {
                    if (filter1 != null) {
                        //hapus spasi
                        filter1.replaceAll("\\s", "");
                        if (!"".equals(filter1) && !filter1.equals("undefined") && !filter1.equals("null")  ) {
                            lnjt = true;
                            break;
                        }
                    }
                }
            }
            // jika lnjt = true, ada data filter periode dari-sampai
            if (lnjt == true){
                com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
                dMA.setfId(filter[0]);
                dMA.setfNama(filter[1]);
                dMA.setfJabatan(filter[2]);
                dMA.setfStatPlmr(filter[3]);
                // validation date
                if (convertTgl.isValidationDate(filter[4]) && convertTgl.isValidationDate(filter[5])){
                    dMA.setfPeriodeCreate1(convertTgl.tglUtil(filter[4], "dd/MM/yyyy"));
                    dMA.setfPeriodeCreate2(convertTgl.tglUtil(filter[5], "dd/MM/yyyy"));
                }
                else {
                    //set null agar pada daoMasterPelamar.tampilDataPelamar tidak masuk pada if pertama
                    dMA.setfPeriodeCreate1(null);
                    dMA.setfPeriodeCreate2(null);
                }
                dMA.setLanjut(true);
            }else{
                dMA.setLanjut(false);
            }
            // data ajax
            kirimDataAjax(res, Integer.valueOf(batasBawah), Integer.valueOf(batasAtas), dMA);
        } 
        //print data
         else if (sOrE.equalsIgnoreCase("3")){
            printData( res, req.getParameter("f_id"));
            
         }
         //print  form
        else if (sOrE.equalsIgnoreCase("4")){
            printDataFormat(req, res);
            
         }
    }
     public void doPost(HttpServletRequest req, HttpServletResponse res){
        /*
        Simpan didatabase
         tanggal format 04/09/2015
        */
         
         // 0 = ambil data untuk di edit, 1 = save
         String pintu = req.getParameter("xcv");
         //save or edit or delete
         String sOrE = req.getParameter("sta");
         String uSer = req.getParameter("usernya");
         //view detail data
         if (pintu.equals("0")){
             detailAmbilDataPelamar(req, res, 0);
         }
         //save
         else if (sOrE.equalsIgnoreCase("0")) {
             saveDataPelamar(req, res, 0);
         }
         //edit
         else if (sOrE.equalsIgnoreCase("1")){
             saveDataPelamar(req, res, 1);
         }
         //delete
         else if (sOrE.equalsIgnoreCase("2")){
            String refCode = req.getParameter("ref_code");
            hapus(refCode);
         }
         //print
         //else if (sOrE.equalsIgnoreCase("3")){
            //String refCode = req.getParameter("ref_code");
            //printData(res, refCode); 
        // }
         else {
             new com.ari.prasetiyo.sistem.loggerError(masterPelamar.class.getName(), "bukan save atau edit, pelaku"  + uSer);
         }
    }

    private void printDataFormat( HttpServletRequest req, HttpServletResponse res){
        try {
            req.getRequestDispatcher("print/master_pelamar_print.html").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void printData( HttpServletResponse res, String iD){
        try {
            com.ari.prasetiyo.printout.masterPelamar_printDataDetail p = new  com.ari.prasetiyo.printout.masterPelamar_printDataDetail();
            res.setContentType("text/html");
            res.getWriter().write(p.printOut(iD));
        } catch (IOException ex) {
            Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void detailAmbilDataPelamar(HttpServletRequest req, HttpServletResponse res, int eOrS){
        String id = req.getParameter("ambil_data_id");
        kirimDataAjaxViewDetail(res, id);
    }
    private void hapus(String iD){
        com.ari.prasetiyo.sistem.connectDb hPs= new com.ari.prasetiyo.sistem.connectDb();
        hPs.connectDbMysql();
        hPs.hapusDbMysql("payroll_master_pelamar", iD);
        hPs.disconnectDbMysql();
    }
    //0 = save, 1 = edit
    private void saveDataPelamar(HttpServletRequest req, HttpServletResponse res, int  SorE){
        //com.ari.prasetiyo.sistem.convertAll convertAll = new  com.ari.prasetiyo.sistem.convertAll();
        domainMasterPelamar domainMsPelamar = new domainMasterPelamar();
        domainMsPelamar.setRefCode(req.getParameter("ref_code"));
        domainMsPelamar.setNama(req.getParameter("nama"));
        System.out.println(req.getParameter("ibu"));
        domainMsPelamar.setIbu(req.getParameter("ibu"));
        /*
        java.text.SimpleDateFormat formatTgl = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String strTanggal = req.getParameter("tanggal_lahir");
        try {
            domainMsPelamar.setTanggalLahir(formatTgl.parse(strTanggal));
        } catch (ParseException ex) {
            Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        // convert string to util
        com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
        domainMsPelamar.setTanggalLahir(convertTgl.tglUtil(req.getParameter("tanggal_lahir"), "dd/MM/yyyy"));
        domainMsPelamar.setJabatan(req.getParameter("jabatan"));
        domainMsPelamar.setTempatLahir(req.getParameter("tempat_lahir"));
        domainMsPelamar.setJenisKelamin( req.getParameter("jenis_kelamin"));
        domainMsPelamar.setStatusNikah(req.getParameter("status_nikah"));
        domainMsPelamar.setAgama( req.getParameter("agama"));
        domainMsPelamar.setDarah( req.getParameter("darah"));
        domainMsPelamar.setKewarganegaraan(req.getParameter("kewarganegaraan"));
        domainMsPelamar.setNoKtp(req.getParameter("no_ktp"));
        domainMsPelamar.setNoSim(req.getParameter("o_sim"));
        domainMsPelamar.setAlamat(req.getParameter("alamat"));
        domainMsPelamar.setAsal(req.getParameter("asal"));
        domainMsPelamar.setKodePos(req.getParameter("kode_pos"));
        domainMsPelamar.setNoHP(req.getParameter("no_tlpn"));
        domainMsPelamar.setEmail(req.getParameter("email"));
        domainMsPelamar.setStatusTempatTinggal(req.getParameter("status_tempat_tinggal"));
        domainMsPelamar.setHoby(req.getParameter("hoby"));
        domainMsPelamar.setStatusPelamar(req.getParameter("status_pelamar"));
        domainMsPelamar.setEditorRiwayat( req.getParameter("editor_riwayat"));
        domainMsPelamar.setNonFormal(req.getParameter("non_formal"));
        com.ari.prasetiyo.dao.daoMasterPelamar Save = new com.ari.prasetiyo.dao.daoMasterPelamar();
        //save
        if (SorE == 0){
           domainMsPelamar.setUserCreated(req.getParameter("usernya"));
           Save.Simpan(domainMsPelamar, 0);
        }
        //edit
        else if (SorE == 1) {
           domainMsPelamar.setUserUpdated(req.getParameter("usernya")); 
           Save.Simpan(domainMsPelamar, 1);
        }
        res.setHeader("REQUIRES_AUTH", "1");
        // data ditampilkan setelah dilakukan save
        kirimDataAjax(res, 0, 19, dMA);
     }

     /*
     masukMana = 1 => redirect
     masukMana = 0 => cuma send data saja
     *
     private void kirimDataAjaxPesan(HttpServletResponse res, String errorMassage, int masukMana){
         try {
             /*
             Ajax send report error json
             
             format data yang dikirim
             {"success":false,"infoError":{}}
             {"succes":true,"infoError":"user atau password salah"}
              *
             PrintWriter out  = res.getWriter();
            
             res.setContentType("text/html");
             res.setHeader("Cache-control", "no-cache, no-store");
             res.setHeader("Pragma", "no-cache");
             res.setHeader("Expires", "-1");
             /*
             difungsi 
             *
             res.setHeader("Access-Control-Allow-Origin", "*");
             res.setHeader("Access-Control-Allow-Methods", "POST");
             res.setHeader("Access-Control-Allow-Headers", "Content-Type");
             res.setHeader("Access-Control-Max-Age", "86400");
             if (masukMana == 1){
                res.setHeader("REQUIRES_AUTH", "1");
             }
              
             Gson gson = new Gson();
             JsonObject myObj = new JsonObject();
             admin.domain.domainLogin error = new admin.domain.domainLogin();
             error.setUserName(errorMassage);
             JsonElement errorInfo = gson.toJsonTree(error);
             
             if(error.getUserName() == null){
                 myObj.addProperty("success", false);
             }
             else {
                 myObj.addProperty("success", true);
             }
             
             myObj.add("infoError", errorInfo);
             out.println(myObj.toString());
             System.out.println(myObj.toString());
             out.close();
         } catch (IOException ex) {
             Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
             //new com.ari.sistem.loggerError(masterPelamar.class.getName(), ex);
         } 
     }
     */
     
     /*
     limitBawah dan limitAtas difungsikan pada query limit x,x
     */
     private void kirimDataAjax (HttpServletResponse response, int LimitBawah, int LimitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        try {
            Gson gson = new Gson();
            /* Membuat  Paging */
            String sql;
            int jumlahRow = 0;
            com.ari.prasetiyo.dao.daoQueryAll daoQueryAll = new com.ari.prasetiyo.dao.daoQueryAll();
            //logika convert status pelamar dengan value null / 4 menjadi kosong ('')
            if (dMA.getfStatPlmr() == null || dMA.getfStatPlmr().equals("null") || dMA.getfStatPlmr().equals("4")){
                dMA.setfStatPlmr("");
            }
            //filter jika period, date, dan status pelamar ada
            //4 = filter status pelamar untuk data all
            //5 = filter status pelamar untuk data all juga
            // (  !dMA.getfStatPlmr().equals("4") && !dMA.getfStatPlmr().equals("null") ;
            if (dMA.isLanjut() && dMA.getfPeriodeCreate1() != null  ){
                sql = "select count(id) as id from payroll_master_pelamar where id like ? and nama like ? and jabatan like ? and status_pelamar like ? " +
                        " and date_format(tanggal_dibuat , '%Y-%m-%d') between ? and ?";
            }
            //filter jika tanpa date 
            else if (dMA.isLanjut() && dMA.getfPeriodeCreate1() == null ) {
                sql = "select count(id) as id from payroll_master_pelamar where id like ? and nama like ? and jabatan like ? and status_pelamar like ?  " ;
            }
             // jumlah row seluruh data
            else{
                sql = "select count(id) as id from payroll_master_pelamar";
            }
            jumlahRow = daoQueryAll.jumlahRow(sql, dMA, "filterPelamar");
            // kirim data dalam format JSON
            // String PagingData =  "[{'jumlahRow':'"+ jumlahRow + "'}]";
            JsonElement PagingData = gson.toJsonTree(jumlahRow);
            /* pagging end */

            /* Data table */
            daoMasterPelamar daoMasterPelamar = new daoMasterPelamar();
            JsonElement element = gson.toJsonTree(daoMasterPelamar.tampilDataPelamar(LimitBawah, LimitAtas, dMA), new TypeToken<List<domainMasterPelamar>>() {}.getType());           
            // jika hanya satu data saja yang akan dikirim jsonArray langsung response.getWriter().print(jsonArray);
            JsonArray jsonArray = element.getAsJsonArray();
            JsonObject myObj = new JsonObject();
            // data yang akan ditampilkan di aplikasi
            myObj.add("dataTable", jsonArray);
            // jumlah row pada database
            myObj.add("dataIndependent", PagingData);
            // out.println(myObj.toString());
            response.setContentType("application/json");
            response.getWriter().print(myObj);
            // response.getWriter().print(PagingData);
        } catch (IOException ex) {
            Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     private void kirimDataAjaxViewDetail (HttpServletResponse res, String iD){
        try {
            // kirim data ajax
            Gson gson = new Gson();
            daoMasterPelamar dMp  = new daoMasterPelamar();
            JsonElement jE = gson.toJsonTree(dMp.tampilDetilDataPelamar(iD));
            //JsonArray jA = jE.getAsJsonArray();
            JsonObject jO = new JsonObject();
            jO.add("detailviewpelamar", jE);
            res.setContentType("application/json");
            res.getWriter().print(jO);
        } catch (IOException ex) {
            Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     private void kirimAjaxMenu(HttpServletResponse res){
         try { 
            // kirim data ajax
            Gson gson = new Gson();
            daoMenu dao = new daoMenu();
            List hasil = dao.tampilMenu();  
            JsonElement jE = gson.toJsonTree(hasil);
            //JsonArray jA = jE.getAsJsonArray();
            JsonObject jO = new JsonObject();
            jO.add("topMenu", jE);
            res.setContentType("application/json");
            res.getWriter().print(jO);
        } catch (IOException ex) {
            Logger.getLogger(masterPelamar.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}

