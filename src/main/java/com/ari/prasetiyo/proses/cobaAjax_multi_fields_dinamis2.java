/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.proses;

import com.ari.prasetiyo.proses.cobaAjax_multi_fields_dinamis;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arprast
 */
public class cobaAjax_multi_fields_dinamis2 {
    public void doGet(HttpServletRequest req, HttpServletResponse res){

        /*
        return data json must be
        {"items":[{"id":1,"name":"Product1"},{"id":2,"name":"Product2"}]}

        {"success":true,"items":{"userName":"hallo","countLogin":0,"statusAktiv":0,"userLevel":0}}

        {"success":true,"items":{"userName":"hallo","countLogin":0,"statusAktiv":0,"userLevel":0,"categories":["ari","Ira","Hallo"]}}

        jenis jeni create format json servlet
        http://viralpatel.net/blogs/creating-parsing-json-data-with-java-servlet-struts-jsp-json/
        */

        String searchTerm = req.getParameter("term");
        System.out.println(searchTerm);

        try {
           PrintWriter out  = res.getWriter();

           res.setContentType("text/html");

           Gson gson = new Gson();
           JsonObject myObj = new JsonObject();
           com.ari.prasetiyo.domain.domaincobaAJax_multi_fields_dinamis error = new com.ari.prasetiyo.domain.domaincobaAJax_multi_fields_dinamis();
           error.setUserName("hallo");

           List<String> data = new ArrayList<String>();

           data.add("ari");
           data.add("Ira");
           data.add("Hallo");

           error.setCategories(data);
           JsonElement errorInfo = gson.toJsonTree(error);  

            if(error.getUserName() == null){
               myObj.addProperty("success", false);
            }
            else {
               myObj.addProperty("success", true);
            }

            myObj.add("items", errorInfo);
            //out.println(myObj.toString());
            //out.println("{\"items\":[{\"id\":1,\"name\":\"Product1\"},{\"id\":2,\"name\":\"Product2\"}]}");
            out.println("[{\"id\":\"1\",\"name\":\"Derivatives\"}]");
            //System.out.println(myObj.toString());
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(cobaAjax_multi_fields_dinamis.class.getName()).log(Level.SEVERE, null, ex);
        }

 }
}
