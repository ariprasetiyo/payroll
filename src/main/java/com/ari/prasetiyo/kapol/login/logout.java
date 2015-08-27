/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.kapol.login;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arprast
 */
public class logout extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        try {
            HttpSession session = req.getSession(true);
            session.setAttribute("useridariprasetiyo", null);
            session.invalidate();
            res.sendRedirect("../index.jsp");
        } catch (IOException ex) {
            Logger.getLogger(logout.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(logout.class.getName(), ex);
        }
    }
    
}
