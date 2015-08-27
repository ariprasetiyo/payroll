/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.proses;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import javax.servlet.ServletException;
;

/**
 *
 * @author arprast
 */

public class cobaAjax_multi_fields_dinamis extends HttpServlet {
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) 
             
             /*
             [{"text":"Abhijeet"},{"text":"Abhishek"},{"text":"Anurag"},{"text":"Anuj"},{"text":"Gaurav"},{"text":"Subodh"},{"text":"Phani"}]
             */
            throws ServletException, IOException {

           String userInput = request.getParameter("q");
           System.out.println(userInput);
           // We can get auxiliary parameters sent from select2 like below: 
           // request.getParameter("aux_variable"); 
           String json = ""; 
           List<String> studentList = getStudentList(); 
           List<HashMap<String, String>> listOfMapForJSONConv = new ArrayList<HashMap<String,String>>();
           for(String s : studentList) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("text", s);
            listOfMapForJSONConv.add(map);
           }
           Gson gson = new GsonBuilder().create();
           json = gson.toJson(listOfMapForJSONConv);
           response.setContentType("application/json");
           PrintWriter out = response.getWriter();
           out.print(json);
          }

          private List<String> getStudentList() {
           List<String> studentList = new ArrayList<String>();
           studentList.add("Abhijeet");
           studentList.add("Abhishek");
           studentList.add("Anurag");
           studentList.add("Anuj");
           studentList.add("Gaurav");
           studentList.add("Subodh");
           studentList.add("Phani");
           return studentList;
          } 

     }


