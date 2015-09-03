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


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Hex;

public class SHA1 {
    //http://software.endy.muhardin.com/java/symmetric-encryption-dengan-java/
    public String Enkripsi (String password){
        try {
            MessageDigest hash = MessageDigest.getInstance("SHA1");
           // DigestOutputStream dOut = new DigestOutputStream( new ByteArrayOutputStream(), hash);
            password = new String(Hex.encodeHex(hash.digest()) );
            return  password;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(SHA1.class.getName(), ex);
        } catch (Exception ex) {
            Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, ex);
            new com.ari.prasetiyo.sistem.loggerError(SHA1.class.getName(), ex);
        }
        return null;
    }
}
