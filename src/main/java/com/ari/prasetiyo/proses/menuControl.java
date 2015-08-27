/*/u
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.proses;

import com.ari.prasetiyo.dao.daoMenu;
import com.ari.prasetiyo.kapol.login.login;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arprast
 */
public class menuControl extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        //kirimDataAjax(res); 
        
        try {
           
            /*
            untuk menu
            */
            daoMenu dao = new daoMenu();
            List hasil = dao.tampilMenu();  
            req.setAttribute("daftarMenu", hasil);

            req.getRequestDispatcher("main.jsp").forward(req, res);
            
        } catch (ServletException ex) {
            Logger.getLogger(menuControl.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(menuControl.class.getName(), ex);
        } catch (IOException ex) {
            Logger.getLogger(menuControl.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(menuControl.class.getName(), ex);
        } 
        
    }
     public void doPost(HttpServletRequest req, HttpServletResponse res){
        
    }
     
     /*
     masukMana = 1 => redirect
     masukMana = 0 => cuma send data saja
     */
     private void kirimDataAjax(HttpServletResponse res){
         try {
             /*
             Ajax send report error json
             
             format data yang dikirim
             {"success":false,"infoError":{}}
             {"success":true,"infoError":"user atau password salah"}
             
              */
             PrintWriter out  = res.getWriter();
            
             res.setContentType("text/html");
             res.setHeader("Cache-control", "no-cache, no-store");
             res.setHeader("Pragma", "no-cache");
             res.setHeader("Expires", "-1");
             res.setHeader("Access-Control-Allow-Origin", "*");
             res.setHeader("Access-Control-Allow-Methods", "POST");
             res.setHeader("Access-Control-Allow-Headers", "Content-Type");
             res.setHeader("Access-Control-Max-Age", "86400");
             
             Gson gson = new Gson();
             JsonObject myObj = new JsonObject();
             
             /*
             jika ambil data satu menggunakan domain langsung
               com.ari.prasetiyo.domain.domainMenu menu = new com.ari.prasetiyo.domain.domainMenu();
             */
           
             
            daoMenu dao = new daoMenu();
            List hasil = dao.tampilMenu();
            
             JsonElement errorInfo = gson.toJsonTree(hasil);
             
             if(dao.tampilMenu() == null){
                 myObj.addProperty("success", false);
             }
             else {
                 myObj.addProperty("success", true);
             }
             
             myObj.add("menu", errorInfo);
             out.println(myObj.toString());
             //System.out.println(myObj.toString());
             out.close();
         } catch (IOException ex) {
             Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
             new com.ari.prasetiyo.sistem.loggerError(menuControl.class.getName(), ex);
         } 
     }
}
