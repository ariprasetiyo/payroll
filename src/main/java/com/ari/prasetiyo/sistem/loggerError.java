/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.sistem;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
Example using loggerError
new com.arprast.sistem.loggerError(servletDaftarMahasiswa.class.getName(), ex);
*/

public class loggerError{
    public loggerError(String nameClass, Exception x){
        try{
            /*
            membuat directory
            */
            createFolder();
            
            tanggalSistem tgl = new tanggalSistem();
            String data =
                    tgl.getTanggal_HHmmss()+" arprast log error :"
                    +"\n" + nameClass 
                    +"\n" + printTraceError(x)+"\n"
                    +"\n====================================\n";
            
            File file =new File("arprastLogger"+memilahJenisOS()+
                    tgl.GetThnNow()+""+tgl.GetBlnNow()+""+tgl.GetTglNow()+"arprast.log");
            if(!file.exists()){
                    file.createNewFile();
            }
            /*
            create file
            true = append file
            */
            FileWriter fileWritter = new FileWriter(file,true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(data);
            bufferWritter.close();
            
            tampilkanErrorGUI(file.getAbsoluteFile().toString());
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    public loggerError(String nameClass, String Error){
        try{
            /*
            membuat directory
            */
            createFolder();
            
            tanggalSistem tgl = new tanggalSistem();
            String data =
                    tgl.getTanggal_HHmmss()+" arprast log error **** no error from try catch: ****"
                    +"\n" + nameClass 
                    +"\n" + Error+"\n"
                    +"\n====================================\n";
            File file =new File("arprastLogger"+memilahJenisOS()+
                    tgl.GetThnNow()+""+tgl.GetBlnNow()+""+tgl.GetTglNow()+"arprast.log");
            if(!file.exists()){
                    file.createNewFile();
            }
            /*
            create file
            true = append file
            */
            FileWriter fileWritter = new FileWriter(file,true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(data);
            bufferWritter.close();
            tampilkanErrorGUI(file.getAbsoluteFile().toString());
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    private String printTraceError(Exception x){
        StringWriter errors = new StringWriter();
        x.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }
    private void  tampilkanErrorGUI(String data){
        /*
        membuat text area untuk memperlihatkan error
        */
        JTextArea textArea= new JTextArea();
        textArea.setSize(200, 200);
        textArea.setLineWrap(true);
        textArea.setText(data);
        Object[] Object ={
            "Error have saved in : " , textArea,
        };
        JOptionPane.showMessageDialog(null, Object , "Log Error", JOptionPane.ERROR_MESSAGE, null);
    }
    private String memilahJenisOS(){
        /*
        memilih platform os untuk menentukan format directory
        */
        String pathLogger =  null;
        sys_Status os = new sys_Status();
        if (os.isWindows()){
            return pathLogger = "\\";
        }
        else if (os.isSolaris()){
            return pathLogger = "/";
        }
        else if (os.isUnix()){
            return pathLogger = "/";
        }
        else if (os.isMac()){
            return pathLogger = "/";
        }
        return null;
    }
    
    private void createFolder(){
         File directory = new File("arprastLogger");
            if (!directory.exists()) {
                    if (directory.mkdirs()) {
                       /*
                        Berhasil dibuat
                        */
                    } else {
                            System.out.println("Failed to create directory!");
                    }
            }
    }
    
    /*
    ini adsalah bawaannya
    bikin logger automatis
    
    public static void main(String[] args)  {  
        
        int i;
                
        Scanner sc = new Scanner(System.in);
        System.out.print("Jumlah data = ");
        try{
            i = sc.nextInt();
            i  = i * 100;
        }
        catch(Exception x){
            System.out.print("lokasi");
        }
        
        
        Logger logger = Logger.getLogger("MyLog");  
        FileHandler fh;  

        try {  
            TanggalSistem tgl = new TanggalSistem();
            // This block configure the logger with handler and formatter  
            fh = new FileHandler( tgl.GetThnNow()+""+tgl.GetBlnNow()+""+tgl.GetTglNow()+".log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  

            // the following statement is used to log any messages  
            logger.info("My first log");  

        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

        logger.info("Hi How r u?");  
        
    } */

}
