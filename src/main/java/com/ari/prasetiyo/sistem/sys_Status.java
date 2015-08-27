/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.sistem;

/**
 *
 * @author arprast
 * 
     ari prasetiyo
     modify - 1 - 21 desember 2014 by ari prasetiyo
     di sesuaikann dengan java ee
     Memilah milah OS
     
 */
public class sys_Status {
    public sys_Status(){
        
    }
    /*
     * Medapatkan versi OS
     */
     
     public String OSName (){
         String OS;
         OS= System.getProperty("os.name").toLowerCase()
                 +" ("+System.getProperty("os.arch").toLowerCase()
                 +") build "+System.getProperty("os.version").toLowerCase();
         return OS;
     }
     
    /*
     ari prasetiyo
     creted     21 Desember 2014
     Memilah milah OS
     */
    private static String oS (){
        String os = System.getProperty("os.name").toLowerCase();
        return os;
    }
    public  boolean isWindows() {
            return (oS().contains("win"));
    }

    public  boolean isMac() {
            return (oS().contains("mac"));
    }

    public  boolean isUnix() {
            return (oS().contains("nix") || oS ().contains("nux") || oS ().indexOf("aix") > 0 );
    }

    public  boolean isSolaris() {
            return (oS().contains("sunos"));
    }
     
}
