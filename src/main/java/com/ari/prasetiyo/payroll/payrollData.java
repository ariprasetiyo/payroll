/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ari.prasetiyo.payroll;

import com.ari.prasetiyo.dao.daoMasterKaryawan;
import com.ari.prasetiyo.dao.daoMenu;
import com.ari.prasetiyo.dao.daoPayrollData;
import com.ari.prasetiyo.domain.domainPayrollData;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ari.prasetiyo.domain.domainPresensiAbsensi;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * @author arprast
 * catatan
 * http://www.codepolitan.com/cc-tak-sebatas-untuk-kuliah/
 */

public class payrollData extends HttpServlet {
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
                req.getRequestDispatcher("pro/payroll_data.jsp").forward(req, res);
            } catch (ServletException ex) {
                Logger.getLogger(payrollData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(payrollData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //ambil data karyawan untuk gaji
        else if (id.equals("22")){
            res.setHeader("REQUIRES_AUTH", "1");
            String batasBawah = req.getParameter("limitBawah");
            String batasAtas = req.getParameter("limitAtas");
            // jika ini dihilangkan maka data json tidak bisa direct langsung
            if (batasBawah == null ||  batasAtas == null ){
                batasBawah = "0";
                batasAtas = "19";
            }
            dMA.setfPilihan(id);
            dMA.setLanjut(false);
            kirimDataAjax(res, Integer.valueOf(batasBawah), Integer.valueOf(batasAtas), dMA);
            
        }
        //pmbuatan filter dan ambil data pelamar
        else if (id.equals("2")) {
            dMA.setfPilihan(id);
            res.setHeader("REQUIRES_AUTH", "1");
            String batasBawah = req.getParameter("limitBawah");
            String batasAtas = req.getParameter("limitAtas");
            String[] filter = {
                req.getParameter("f_id"),
                req.getParameter("f_nama"),
                req.getParameter("f_jabatan"),
                req.getParameter("f_area"),
                req.getParameter("f_s_plmr"),
                req.getParameter("f_s_karyawan"),
                req.getParameter("f_tgl_buat1"),
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
                        else {
                            filter1 = "";
                        }
                    }
                    else {
                        filter1 = "";
                    }
                }else{
                    filter1 = "";
                }
            }
             for(int a = 0; a < filter.length ; a++){
                 if (filter[a] instanceof String ){
                     if(filter[a] == null){
                         filter[a] = "";
                     }
                     else if ("".equals(filter[a]) || filter[a].equals("undefined") || filter[a].equals("null")){
                        filter[a] = "";
                    }
                 }
                 else{filter[a] = "";}
             }
            
            // jika lnjt = true, ada data filter periode dari-sampai
            if (lnjt == true){
                com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
                dMA.setfId(filter[0]);
                dMA.setfNama(filter[1]);
                dMA.setfJabatan(filter[2]);
                dMA.setfArea(filter[3]);
                dMA.setfStatPlmr(filter[4]);
                dMA.setfStatusPegawai(filter[5]);
                // validation date
                if (convertTgl.isValidationDate(filter[6]) ){
                    dMA.setfPeriodeCreate1(convertTgl.tglUtil("01/"+filter[6], "dd/MM/yyyy"));
                    //dMA.setfPeriodeCreate2(convertTgl.tglUtil(filter[7], "dd/MM/yyyy"));
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
            printData( req, res, req.getParameter("f_id"));
            
         }
         //print  form
        else if (sOrE.equalsIgnoreCase("4")){
            printDataFormat(req, res);
            
         }
    }
     public void doPost(HttpServletRequest req, HttpServletResponse res){

        // 0 = ambil data untuk di edit, 1 = save, delete, dan update
        String pintu = req.getParameter("xcv");
        //save or edit or delete
        String sOrE = req.getParameter("sta");
        String uSer = req.getParameter("usernya");
        //view detail data
        if (pintu.equals("0")){
            detailAmbilDataPelamar(req, res, 0);
        }
        //save
        else if (sOrE.equalsIgnoreCase("0") && pintu.equals("1")) {
            saveData(req, res, 0);
        }
        //edit
        else if (sOrE.equalsIgnoreCase("1")  && pintu.equals("1")){
            saveData(req, res, 1);
        }
        //delete
        else if (sOrE.equalsIgnoreCase("2") && pintu.equals("1")){
           String id = req.getParameter("id");
           hapus(id);
        }
        //print
        //sta=3&xcv=3&f_id="+data.dataTable[i].idKaryawan +"'
        else if (sOrE.equalsIgnoreCase("3")){
           String refCode = req.getParameter("f_id");
           printData(req, res, refCode); 
       }
        else {
            new com.ari.prasetiyo.sistem.loggerError(payrollData.class.getName(), "bukan save atau edit, pelaku"  + uSer);
        } 
    }

    private void printDataFormat( HttpServletRequest req, HttpServletResponse res){
        try {
            req.getRequestDispatcher("print/master_pelamar_print.html").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(payrollData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(payrollData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void printData(HttpServletRequest req, HttpServletResponse res, String iD){
        try {
            com.ari.prasetiyo.printout.payrollData_printSlipGaji p = new  com.ari.prasetiyo.printout.payrollData_printSlipGaji();
            res.setContentType("text/html");
            String noSlipGaji = req.getParameter("noSlip");
            res.getWriter().write(p.printOut(iD, noSlipGaji));
        } catch (IOException ex) {
            Logger.getLogger(payrollData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void detailAmbilDataPelamar(HttpServletRequest req, HttpServletResponse res, int eOrS){
        String id = req.getParameter("id_nya");
        kirimDataAjaxViewDetail(res, id);
    }
    private void hapus(String iD){
        com.ari.prasetiyo.sistem.connectDb hPs= new com.ari.prasetiyo.sistem.connectDb();
        hPs.connectDbMysql();
        hPs.hapusDbMysql("payroll_master_karyawan", iD);
        hPs.disconnectDbMysql();
    }
        //SorE : 0 = save, 1 = edit
    private void saveData(HttpServletRequest req, HttpServletResponse res, int  SorE){
        Gson gson = new Gson();
        domainPayrollData dPA = new domainPayrollData();
        //fomat json to array
        String sendid_kar = req.getParameter("sendid_kar");

        Type type = new TypeToken<String[]>() {}.getType();
        String[] id_kar = gson.fromJson(sendid_kar, type);
        dPA.setIdKaryawanArray(id_kar);
        dPA.setUserCreated(req.getParameter("usernya"));

        // convert string to util
        //com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
        //domainMsPelamar.setTanggalLahir(convertTgl.tglUtil(req.getParameter("tanggal_lahir"), "dd/MM/yyyy"));
        com.ari.prasetiyo.dao.daoPayrollData Save = new com.ari.prasetiyo.dao.daoPayrollData();
        Save.Simpan(dPA, 0);
        res.setHeader("REQUIRES_AUTH", "1");
        // data ditampilkan setelah dilakukan save
        kirimDataAjax(res, 0, 19, dMA);
     }

     /*
     limitBawah dan limitAtas difungsikan pada query limit x,x
     */
     private void kirimDataAjax (HttpServletResponse response, int LimitBawah, int LimitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        try {
            Gson gson = new Gson();
            /* Membuat  Paging */
            String sql;
            int jumlahRow = 0;
            
            /* pagging end */
            /* Data table */
            daoPayrollData dao = new daoPayrollData();
            JsonElement element = null;
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
                sql = " select count(dg.id_gaji) as id " +
                        "from data_gaji  dg inner join payroll_master_karyawan mk on dg.id_karyawan = mk.id_karyawan inner join payroll_master_karyawan_detail mkd on  mk.id_karyawan = mkd.id_karyawan " +
                        "where mk.id_karyawan like ? and mk.status_karyawan like ? and mk.nama like ? and mkd.jabatan like ? " +
                        "and mkd.area like ? and mkd.sts_pegawai like ?     " 
                      + "and date_format(dg.tanggal_created, '%Y-%m') = date_format(?, '%Y-%m')";
                jumlahRow = daoQueryAll.jumlahRow(sql, dMA,"filterPresensiAbsensi");
            }
            //filter jika tanpa date 
            else if (dMA.isLanjut() && dMA.getfPeriodeCreate1() == null ) {
                sql = " select count(dg.id_gaji) as id " +
                        "from data_gaji  dg inner join payroll_master_karyawan mk on dg.id_karyawan = mk.id_karyawan inner join payroll_master_karyawan_detail mkd on  mk.id_karyawan = mkd.id_karyawan " +
                        "where mk.id_karyawan like ? and mk.status_karyawan like ? and mk.nama like ? and mkd.jabatan like ? " +
                        "and mkd.area like ? and mkd.sts_pegawai like ?     " ;
                jumlahRow = daoQueryAll.jumlahRow(sql, dMA,"filterKaryawan");
            }
            //data new absensi
            else if(dMA.getfPilihan().equals("22")){
                 sql = "select count(id_karyawan) as id from payroll_master_karyawan";
                 jumlahRow = daoQueryAll.jumlahRow(sql, dMA,"filterPresensiAbsensi");
                 element = gson.toJsonTree(dao.tampilDataNew(LimitBawah, LimitAtas, dMA), new TypeToken<List<domainPresensiAbsensi>>() {}.getType());           
            }
            else{
                sql = "select count(id_karyawan) as id from data_gaji where date_format(tanggal_created, '%Y-%m') = date_format(now(), '%Y-%m')";
                jumlahRow = daoQueryAll.jumlahRow(sql, dMA,"filterPresensiAbsensi");
                //element = gson.toJsonTree(dao.tampilData(LimitBawah, LimitAtas, dMA), new TypeToken<List<domainPresensiAbsensi>>() {}.getType());           
            }
            //bukan data new
            if (!dMA.getfPilihan().equals("22")){
                 element = gson.toJsonTree(dao.tampilData(LimitBawah, LimitAtas, dMA), new TypeToken<List<domainPresensiAbsensi>>() {}.getType());           
            }
            // kirim data dalam format JSON
            // String PagingData =  "[{'jumlahRow':'"+ jumlahRow + "'}]";
            JsonElement PagingData = gson.toJsonTree(jumlahRow);
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
            Logger.getLogger(payrollData.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     private void kirimDataAjaxViewDetail (HttpServletResponse res, String iD){
        try {
            // kirim data ajax
            Gson gson = new Gson();
            daoMasterKaryawan dMp  = new daoMasterKaryawan();
            JsonElement jE = gson.toJsonTree(dMp.tampilDetilDataKaryawan(iD));
            //JsonArray jA = jE.getAsJsonArray();
            JsonObject jO = new JsonObject();
            jO.add("detailview", jE);
            res.setContentType("application/json");
            res.getWriter().print(jO);
        } catch (IOException ex) {
            Logger.getLogger(payrollData.class.getName()).log(Level.SEVERE, null, ex);
        }
     } 
}

