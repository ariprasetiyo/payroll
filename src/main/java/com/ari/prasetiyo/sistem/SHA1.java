/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.sistem;

/**
 *
 * @author arprast
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SHA1 {
    public String Enkripsi (String password){
        try {
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            DigestOutputStream dOut = new DigestOutputStream( new ByteArrayOutputStream(), hash);
            dOut.write(encrypt(password));
            dOut.close();
            return  new String(dOut.getMessageDigest().digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(SHA1.class.getName(), ex);
            
        } catch (IOException ex) {
            Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(SHA1.class.getName(), ex);
        } catch (Exception ex) {
            Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(SHA1.class.getName(), ex);
        }
        return null;
    }
    private static byte[] encrypt(String x) {
        try {
            java.security.MessageDigest d = null;
            d = java.security.MessageDigest.getInstance("SHA-1");
            d.reset();
            d.update(x.getBytes());
            return d.digest();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(SHA1.class.getName(), ex);
        }
        return null;
    }
}
