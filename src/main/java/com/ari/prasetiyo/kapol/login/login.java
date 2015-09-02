/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.kapol.login;

/**
 *
 * @author arprast
 */
import com.ari.prasetiyo.dao.daoLogin;
import com.ari.prasetiyo.sistem.MD5;
import com.ari.prasetiyo.sistem.SHA1;
import com.ari.prasetiyo.domain.domainLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 *
 * @author arprast
 */
public class login extends HttpServlet {
     int  countLogin;
     @Override
     public void doPost(HttpServletRequest req, HttpServletResponse res){
         try {
             
            daoLogin dao = new daoLogin();
            String userNameWeb, passwordWeb;
            userNameWeb = req.getParameter("username");
            passwordWeb = req.getParameter("password");
            /*
                MD5 dan SHA1
            */
            MD5 md5 = new MD5();
            SHA1 sha1 = new SHA1();
            passwordWeb = md5.Enkripsi(sha1.Enkripsi(passwordWeb));
            //System.out.println(userNameWeb +" dan " + passwordWeb);
            /*
                angka 1 adalah username benar dan password benar
                angka 0 adalah username benar dan password salah
            */
            List<domainLogin> list;
            list = dao.tampilLogin(userNameWeb, passwordWeb, 1);
            System.out.println(passwordWeb);
            if (dao.getLoginTrue()){
                validateLogin(list, userNameWeb, dao, req, res);
            }
            else{
                list.clear();
                list = dao.tampilLogin(userNameWeb, passwordWeb, 0);
                /*jika user dan passowrd salah*/
                for(domainLogin m: list ) {
                    countLogin = m.getCountLogin();
                    /* 0 = update count login */
                    dao.updateLogin(m, countLogin, userNameWeb, 0);
                    break ;    
                }
                System.out.println("hallo");
                kirimDataAjax(res,"User/password salah",0);
                //req.setAttribute("pesanLogin", "user atau passowrd salah");
                //req.getRequestDispatcher("index.jsp").forward(req, res);
            }
         }
         catch(Exception ex){
              Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
             new com.ari.prasetiyo.sistem.loggerError(login.class.getName(), ex);
         }
    }
     /*
        validate count login, user aktiv, user level and create session
        statusAktiv = 1 adalah aktiv
        countLogin  = 6 adalah lock
        userLevel   = 1 adalah admin
     */
     private void validateLogin(List<domainLogin> list,
         String userNameWeb , daoLogin dao, HttpServletRequest req, HttpServletResponse res){
         try {
         for(domainLogin m: list ) {
                String userName, password;               
                int statusAktiv, userLevel;
                userName = m.getUserName();
                password = m.getPassowrd();
                countLogin = m.getCountLogin();
                statusAktiv = m.getStatusAktiv();
                userLevel = m.getUserLevel();
                if (countLogin > 6)  {
                    //req.setAttribute("pesanLogin", "account has been lock");
                    //dao.updateLogin(m, countLogin, userNameWeb, 0);
                    //req.getRequestDispatcher("index.jsp").forward(req, res);
                    kirimDataAjax(res,"account has been lock", 0);
                    break;
                }
                else if (statusAktiv != 1)  {
                    //req.setAttribute("pesanLogin", "account not active");
                    //req.getRequestDispatcher("index.jsp").forward(req, res);
                    kirimDataAjax(res,"account not active", 0);
                    break;
                }
                else if (userLevel != 1)  {
                    //req.setAttribute("pesanLogin", "account not admin");
                    //req.getRequestDispatcher("index.jsp").forward(req, res);
                    kirimDataAjax(res,"account not admin", 0);
                    break;
                }
                else {
                    System.out.println("hallo5"+ userName);
                    /*
                    aktivitas session
                    */
                    HttpSession session = req.getSession(true);
                    session.setAttribute("useridariprasetiyo", userName);
                    kirimDataAjax(res,"admin/ari.ari", 1);
                    break;
                }
            }
         } 
         catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(login.class.getName(), ex);
        }
     }
     /*
     masukMana = 1 => redirect
     masukMana = 0 => cuma send data saja
     */
     private void kirimDataAjax(HttpServletResponse res, String errorMassage, int masukMana){
         try {
             /*
             Ajax send report error json
             
             format data yang dikirim
             {"success":false,"infoError":{}}
             {"success":true,"infoError":"user atau password salah"}
             real format json
             
             {"success":true,"items":{"userName":"hallo","countLogin":0,"statusAktiv":0,"userLevel":0}}
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
             if (masukMana == 1){
                res.setHeader("REQUIRES_AUTH", "1");
             }
             Gson gson = new Gson();
             JsonObject myObj = new JsonObject();
             com.ari.prasetiyo.domain.domainLogin error = new com.ari.prasetiyo.domain.domainLogin();
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
             //System.out.println(myObj.toString());
             out.close();
         } catch (IOException ex) {
             Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
             new com.ari.prasetiyo.sistem.loggerError(login.class.getName(), ex);
         } 
     }
}



