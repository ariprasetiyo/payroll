/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ari.prasetiyo.payroll;

import com.ari.prasetiyo.dao.daoMenu;
import com.ari.prasetiyo.dao.daoPresensiIzinDanLembur;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ari.prasetiyo.domain.domainPresensiIzinDanLembur;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.PrintWriter;

/**
 * @author arprast
 * catatan
 * http://www.codepolitan.com/cc-tak-sebatas-untuk-kuliah/
 */
public class presensiIZinDanLembur extends HttpServlet {
    com.ari.prasetiyo.domain.domainMasterPelamarAll dMA = new com.ari.prasetiyo.domain.domainMasterPelamarAll();
    com.ari.prasetiyo.domain.domainPresensiIzinDanLembur dPIL = new  com.ari.prasetiyo.domain.domainPresensiIzinDanLembur();
    int editOrDel = 0;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        //xcv = 3 adalah print
        //xcv = 5 untuk search item select2
        //sta - 01 untuk pelengkap saja
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
                
                req.getRequestDispatcher("pro/presensi_izin_lembur.jsp").forward(req, res);
            } catch (ServletException ex) {
                Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        //pmbuatan filter dan ambil data pelamar
        else if (id.equals("2")) {
            res.setHeader("REQUIRES_AUTH", "1");
            String batasBawah = req.getParameter("limitBawah");
            String batasAtas = req.getParameter("limitAtas");
            String[] filter = {
                req.getParameter("f_id"),
                req.getParameter("f_id_kar"),
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
                dMA.setfIdKaryawan(filter[1]);
                dMA.setfNama(filter[2]);
                dMA.setfJabatan(filter[3]);
                dMA.setfStatPlmr(filter[4]);
                // validation date
                if (convertTgl.isValidationDate(filter[5]) && convertTgl.isValidationDate(filter[6])){
                    dMA.setfPeriodeCreate1(convertTgl.tglUtil(filter[5], "dd/MM/yyyy"));
                    dMA.setfPeriodeCreate2(convertTgl.tglUtil(filter[6], "dd/MM/yyyy"));
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
        //difungsikan untuk list data karyawan pencarian
        else if (id.equals("5")){
            String searchTerm = req.getParameter("q");
            searchDataKaryawan(res, searchTerm);
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
         // sta = 01 adalah tidak difungsikan apa - apa
         // xcv = 01 adalah tidak berfungsi apa -apa
         String pintu = req.getParameter("xcv");
         //save or edit or delete
         String sta = req.getParameter("sta");
         String uSer = req.getParameter("usernya");
         //view detail data
         if (pintu.equals("0")){
             detailAmbilDataPelamar(req, res, 0);
         }
         //ambil data dari hasil pencarian karyawan
         else if (pintu.equals("5")){
             /*
             0 = jenis izin cuti tahunan
             1 = jenis izin cuti 5 tahunan
             */
             int jenisCuti = Integer .valueOf(req.getParameter("pil_izin_cuti"));
             kirimDataAjaxViewJabatanDanCuti(res, req.getParameter("id_karyawan"), jenisCuti);
         }
          //ambil data sisa cuti
         else if (pintu.equals("6")){
             /*
             0 = jenis izin cuti tahunan
             1 = jenis izin cuti 5 tahunan
             */
             int jenisCuti = Integer .valueOf(req.getParameter("pil_izin_cuti"));
             String id_kar = req.getParameter("id_karyawan");
             kirimDataAjaxViewSisaCutiSaja(res,id_kar, jenisCuti );
         }
         //ambil data jabatan saja
         else if (pintu.equals("7")){
             String id_kar = req.getParameter("id_karyawan");
             kirimDataAjaxViewJabatanSaja(res,id_kar );
         }
         //save
         else if (sta.equalsIgnoreCase("0")) {
             // jenis_presensi = 0, izin cuti
             // jenis_presensi = 1, izin sakit
             // jenis_presensi = 2, lembur
             int jenisPresensi = Integer.valueOf(req.getParameter("jenis_presensi"));
             if (jenisPresensi == 0){
                  editOrDel = 0;
                 //jenis izin cuti
                 saveDataIzinCuti(req,res, 0);
             }
             else if (jenisPresensi == 1){
                  editOrDel = 0;
                  //jenis izin sakit
                  saveDataIzinCuti(req,res, 1);
             }
             else if (jenisPresensi == 2){
                  editOrDel = 0;
                 saveDataLembur(req,res);
             }
         }
         //edit
         else if (sta.equalsIgnoreCase("1")){
             //saveDataPelamar(req, res, 1);
             int jenisPresensi = Integer.valueOf(req.getParameter("jenis_presensi"));
             if (jenisPresensi == 0){
                 //jenis izin cuti
                 editOrDel = 1;
                 saveDataIzinCuti(req,res, 0);
             }
             else if (jenisPresensi == 1){
                  //jenis izin sakit
                  editOrDel = 1;
                  saveDataIzinCuti(req,res, 1);
             }
             else if (jenisPresensi == 2){
                 editOrDel = 1;
                 saveDataLembur(req,res);
             }
         }
         //delete
         else if (sta.equalsIgnoreCase("2")){
             int jenisPresensi = Integer.valueOf(req.getParameter("jenis_presensi"));
             String refCode = req.getParameter("ref_code");
             if (jenisPresensi == 0){
                 //jenis izin cuti
                 hapusIzin(refCode);
             }
             else if (jenisPresensi == 1){
                  //jenis izin sakit
                 hapusIzin(refCode);
             }
             else if (jenisPresensi == 2){
                 hapusLembur(refCode);
             }
         }
         //print
         //else if (sOrE.equalsIgnoreCase("3")){
            //String refCode = req.getParameter("ref_code");
            //printData(res, refCode); 
        // }
         else {
             new com.ari.prasetiyo.sistem.loggerError(presensiIZinDanLembur.class.getName(), "bukan save atau edit, pelaku"  + uSer);
         }
    }
     private void saveDataLembur(HttpServletRequest req, HttpServletResponse res){
        com.ari.prasetiyo.domain.domainPresensiIzinDanLembur dPIDL = new com.ari.prasetiyo.domain.domainPresensiIzinDanLembur();
        dPIDL.setIdKaryawan(req.getParameter("id_kar"));
        dPIDL.setJabatan(req.getParameter("jab"));
        dPIDL.setJumlahLembur(req.getParameter("jum"));
        dPIDL.setKatagoriLembur(req.getParameter("katLembur"));
        com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
        dPIDL.setTanggalLemburMulai(convertTgl.tglUtil(req.getParameter("tglA"), "dd/MM/yyyy"));
        dPIDL.setTanggalLemburSelesai(convertTgl.tglUtil(req.getParameter("tglB"), "dd/MM/yyyy"));
        //Integer.valueOf(req.getParameter(""));
        dPIDL.setKet(req.getParameter("ket"));
    
        com.ari.prasetiyo.dao.daoPresensiIzinDanLembur Save = new com.ari.prasetiyo.dao.daoPresensiIzinDanLembur();
        //save
        if (editOrDel == 0){
           dPIDL.setUserCreated(req.getParameter("usernya"));
           Save.SimpanLembur(dPIDL, 0);
        }
        //edit
        else if (editOrDel == 1) {
           dPIDL.setRefCode(req.getParameter("ref_code"));
           dPIDL.setUserUpdated(req.getParameter("usernya")); 
           Save.SimpanLembur(dPIDL, 1);
        }
        res.setHeader("REQUIRES_AUTH", "1");
        // data ditampilkan setelah dilakukan save
        kirimDataAjax(res, 0, 19, dMA);
     }
     
     private void saveDataIzinCuti (HttpServletRequest req, HttpServletResponse res, int jenisIzin){
        com.ari.prasetiyo.domain.domainPresensiIzinDanLembur dPIDL = new com.ari.prasetiyo.domain.domainPresensiIzinDanLembur();
        dPIDL.setIdKaryawan(req.getParameter("id_kar"));
        dPIDL.setJabatan(req.getParameter("jab"));
        //tambahan untuk izin cuti
        if (jenisIzin == 0 ){
             dPIDL.setJenisIzinCuti(req.getParameter("jenisIzinCuti"));
        }
        dPIDL.setJumlahIzinCuti(req.getParameter("jum"));
        com.ari.prasetiyo.sistem.tanggalSistem convertTgl = new  com.ari.prasetiyo.sistem.tanggalSistem();
        dPIDL.setTanggalIzinCutiMulai(convertTgl.tglUtil(req.getParameter("tglA"), "dd/MM/yyyy"));
        dPIDL.setTanggalIzinCutiSelsai(convertTgl.tglUtil(req.getParameter("tglB"), "dd/MM/yyyy"));
        dPIDL.setKet(req.getParameter("ket"));
        //Integer.valueOf(req.getParameter(""));
        com.ari.prasetiyo.dao.daoPresensiIzinDanLembur Save = new com.ari.prasetiyo.dao.daoPresensiIzinDanLembur();
        //save
        if (editOrDel == 0){
           dPIDL.setUserCreated(req.getParameter("usernya"));
           Save.Simpan(dPIDL, 0,jenisIzin);
        }
        //edit
        else if (editOrDel == 1) {
           dPIDL.setRefCode(req.getParameter("ref_code"));
           dPIDL.setUserUpdated(req.getParameter("usernya")); 
           Save.Simpan(dPIDL, 1, jenisIzin) ;
        }
        res.setHeader("REQUIRES_AUTH", "1");
        // data ditampilkan setelah dilakukan save
        kirimDataAjax(res, 0, 19, dMA);
     }
     private void kirimDataAjaxViewSisaCutiSaja (HttpServletResponse res, String iD, int jenisCuti){
        try {
             /*
            0 = jenis izin cuti tahunan
            1 = jenis izin cuti 5 tahunan
            0 = jenis izin cuti
            1 = jenis izin sakit
             */
            // kirim data ajax
            Gson gson = new Gson();
            daoPresensiIzinDanLembur dMp  = new daoPresensiIzinDanLembur();
            JsonElement jE = gson.toJsonTree(dMp.tampilDataSisaCuti(iD, jenisCuti));
            //JsonArray jA = jE.getAsJsonArray();
            JsonObject jO = new JsonObject();
            jO.add("dataSisaCuti", jE);
            res.setContentType("application/json");
            res.getWriter().print(jO);
        } catch (IOException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      private void kirimDataAjaxViewJabatanDanCuti (HttpServletResponse res, String iD, int jenisIzinCuti){
        try {
            // kirim data ajax
            Gson gson = new Gson();
            daoPresensiIzinDanLembur dMp  = new daoPresensiIzinDanLembur();
            JsonElement jE = gson.toJsonTree(dMp.tampilDataJabatanDanCuti(iD, jenisIzinCuti));
            //JsonArray jA = jE.getAsJsonArray();
            JsonObject jO = new JsonObject();
            jO.add("dataJabatan", jE);
            res.setContentType("application/json");
            res.getWriter().print(jO);
        } catch (IOException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      private void kirimDataAjaxViewJabatanSaja (HttpServletResponse res, String iD){
        try {
            // kirim data ajax
            Gson gson = new Gson();
            daoPresensiIzinDanLembur dMp  = new daoPresensiIzinDanLembur();
            JsonElement jE = gson.toJsonTree(dMp.tampilDataJabatanSaja(iD));
            //JsonArray jA = jE.getAsJsonArray();
            JsonObject jO = new JsonObject();
            jO.add("dataJabatan", jE);
            res.setContentType("application/json");
            res.getWriter().print(jO);
        } catch (IOException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     private void searchDataKaryawan(HttpServletResponse res, String searchTerm){
         try {
            PrintWriter out  = res.getWriter();

            Gson gson = new Gson();
            daoPresensiIzinDanLembur daoPresensiIzinDanLembur = new daoPresensiIzinDanLembur();
            JsonElement element = gson.toJsonTree(daoPresensiIzinDanLembur.tampilDataPencarian(searchTerm, dPIL), new TypeToken<List<domainPresensiIzinDanLembur>>() {}.getType());           
            // jika hanya satu data saja yang akan dikirim jsonArray langsung response.getWriter().print(jsonArray);
            JsonArray jsonArray = element.getAsJsonArray();

            res.setContentType("text/html");
            res.setContentType("application/json");
            res.getWriter().print(jsonArray);

             // http://json.org/example
             // https://select2.github.io/examples.html
             /*
             json format for select2 below was run 
             example format
             */
             //out.println( "[{\"id\":\"blah\",\"text\":\"blah text\"},{\"id\":\"blah2\",\"text\":\"Blah2 text\"}]");
             //System.out.println(myObj.toString());
             out.close();

        } catch (IOException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    private void printDataFormat( HttpServletRequest req, HttpServletResponse res){
        try {
            req.getRequestDispatcher("print/master_pelamar_print.html").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void printData( HttpServletResponse res, String iD){
        try {
            com.ari.prasetiyo.printout.masterPelamar_printDataDetail p = new  com.ari.prasetiyo.printout.masterPelamar_printDataDetail();
            res.setContentType("text/html");
            res.getWriter().write(p.printOut(iD));
        } catch (IOException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void detailAmbilDataPelamar(HttpServletRequest req, HttpServletResponse res, int eOrS){
        String id = req.getParameter("ambil_data_id");
        kirimDataAjaxViewDetail(res, id);
    }
    private void hapusIzin(String iD){
        com.ari.prasetiyo.sistem.connectDb hPs= new com.ari.prasetiyo.sistem.connectDb();
        hPs.connectDbMysql();
        hPs.hapusDbMysql("presensi_izin","id_cuti", iD);
        hPs.disconnectDbMysql();
    }
     private void hapusLembur(String iD){
        com.ari.prasetiyo.sistem.connectDb hPs= new com.ari.prasetiyo.sistem.connectDb();
        hPs.connectDbMysql();
        hPs.hapusDbMysql("presensi_lembur","id_lembur", iD);
        hPs.disconnectDbMysql();
    }

     
     /*
     limitBawah dan limitAtas difungsikan pada query limit x,x
     */
     private void kirimDataAjax (HttpServletResponse response, int LimitBawah, int LimitAtas,  com.ari.prasetiyo.domain.domainMasterPelamarAll dMA ){
        try {
            Gson gson = new Gson();
            /* Membuat  Paging */
            String sql = null;
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
                 //izin cuti
                if (dMA.getfStatPlmr().equals("0")){
                    // dMA.setfPilihan("x") adalah agar tidak masuk di  dMA.setfPilihan("tanpaStatus")
                    dMA.setfPilihan("x");
                    sql =  "  select count(piz.id_cuti) as id from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan " +
                        " and piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 0 "
                            + "and date_format(piz.tanggal_dibuat , '%Y-%m-%d') between ? and ?";
                }
                //izin sakit
                else if  (dMA.getfStatPlmr().equals("1")){
                    dMA.setfPilihan("x");
                    sql = "  select count(piz.id_cuti) as id from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan " +
                          "  and piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 1 "
                            + "and date_format(piz.tanggal_dibuat , '%Y-%m-%d') between ? and ?";
                }
                //izin lembur
                else  if (dMA.getfStatPlmr().equals("2")){
                    dMA.setfPilihan("x");
                    sql = " select count(piz.id_lembur) as id from presensi_lembur piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan " +
                          " and piz.id_lembur like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ?"
                            + "and date_format(piz.tanggal_dibuat , '%Y-%m-%d') between ? and ?";
                }
                //jika status tidak ada tp field filter terisi
                else {
                    dMA.setfPilihan("tanpaStatus");
                    sql = "  select count(ref_code) as id from ( " +
                            "select id_cuti as ref_code, id_karyawan as id_karyawann " +
                            "from presensi_izin  where id_cuti like ? and id_karyawan like ? and jabatan like ? " +
                            "and date_format(tanggal_dibuat , '%Y-%m-%d') between ? and ?"+
                            "union " +
                            "select id_lembur as ref_code , id_karyawan as id_karyawann " +
                            "from presensi_lembur  where id_lembur like ? and id_karyawan like ? and jabatan like ? " +
                            "and date_format(tanggal_dibuat , '%Y-%m-%d') between ? and ?"+
                            ") b inner join payroll_master_karyawan mk on b.id_karyawann = mk.id_karyawan and mk.nama like ? ";
                       
                }
                
            }
            //filter jika tanpa date 
            else if (dMA.isLanjut() && dMA.getfPeriodeCreate1() == null ) {
                //izin cuti
                if (dMA.getfStatPlmr().equals("0")){
                    // dMA.setfPilihan("x") adalah agar tidak masuk di  dMA.setfPilihan("tanpaStatus")
                    dMA.setfPilihan("x");
                    sql =  "  select count(piz.id_cuti) as id from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan " +
                        " and piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 0 ";
                }
                //izin sakit
                else if  (dMA.getfStatPlmr().equals("1")){
                    dMA.setfPilihan("x");
                    sql = "  select count(piz.id_cuti) as id from presensi_izin piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan " +
                          "  and piz.id_cuti like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ? and piz.jenis_izin = 1 ";
                }
                //izin lembur
                else  if (dMA.getfStatPlmr().equals("2")){
                    dMA.setfPilihan("x");
                    sql = " select count(piz.id_lembur) as id from presensi_lembur piz, payroll_master_karyawan mk where piz.id_karyawan = mk.id_karyawan " +
                          " and piz.id_lembur like ? and piz.id_karyawan like ? and mk.nama like ? and piz.jabatan like ?";
                }
                //jika status tidak ada tp field filter terisi
                else {
                    dMA.setfPilihan("tanpaStatus");
                    sql = "  select count(ref_code) as id from ( " +
                            "select id_cuti as ref_code, id_karyawan as id_karyawann " +
                            "from presensi_izin  where id_cuti like ? and id_karyawan like ? and jabatan like ? " +
                            "union " +
                            "select id_lembur as ref_code , id_karyawan as id_karyawann " +
                            "from presensi_lembur  where id_lembur like ? and id_karyawan like ? and jabatan like ? " +
                            ") b inner join payroll_master_karyawan mk on b.id_karyawann = mk.id_karyawan and mk.nama like ? ";
                }
               
            }
             // jumlah row seluruh data
            else{
                sql = " select ( count(id_cuti) + (select count(id_lembur) as id from presensi_lembur where  date_format(tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')) ) as id from presensi_izin " +
                      "  where  date_format(tanggal_dibuat, '%Y-%m') = date_format(now(), '%Y-%m')";
            }
            jumlahRow = daoQueryAll.jumlahRow(sql, dMA, "filterPresensi");
            // kirim data dalam format JSON
            // String PagingData =  "[{'jumlahRow':'"+ jumlahRow + "'}]";
            JsonElement PagingData = gson.toJsonTree(jumlahRow);
            /* pagging end */

            /* Data table */
            daoPresensiIzinDanLembur  dPIDL = new daoPresensiIzinDanLembur();
            JsonElement element = gson.toJsonTree(dPIDL.tampilDataListPresensi(LimitBawah, LimitAtas, dMA), new TypeToken<List<domainPresensiIzinDanLembur>>() {}.getType());           
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
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     private void kirimDataAjaxViewDetail (HttpServletResponse res, String iD){
        try {
            // kirim data ajax
            Gson gson = new Gson();
            daoPresensiIzinDanLembur dPIDL  = new daoPresensiIzinDanLembur();
            JsonElement jE = gson.toJsonTree(dPIDL.tampilDetilPresensi(iD));
            //JsonArray jA = jE.getAsJsonArray();
            JsonObject jO = new JsonObject();
            jO.add("detailview", jE);
            res.setContentType("application/json");
            res.getWriter().print(jO);
        } catch (IOException ex) {
            Logger.getLogger(presensiIZinDanLembur.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}

