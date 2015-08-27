/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.prasetiyo.printout;

/**
 *
 * @author arprast
 */
public class masterPelamar_printDataDetail {
    public String printOut(String iD){
        com.ari.prasetiyo.dao.daoMasterPelamar dataDb = new com.ari.prasetiyo.dao.daoMasterPelamar();
        com.ari.prasetiyo.sistem.convertAll cov = new com.ari.prasetiyo.sistem.convertAll();
        com.ari.prasetiyo.domain.domainMasterPelamar data = dataDb.tampilDetilDataPelamar(iD);
        String kTp = "", sIm = "";
        if (!data.getNoKtp().equals("null") || data.getNoKtp() != null || !data.getNoKtp().equals("")){
            kTp = "checked";
        }
        else{
            data.setNoKtp("");
        }
        if (!data.getNoSim().equals("null") || data.getNoSim() != null || !data.getNoSim().equals("")){
            sIm = "checked" ;      
        }
        else {
            data.setNoSim("");
        }
        
        return "<!DOCTYPE html>" +
            "<!--" +
            "To change this license header, choose License Headers in Project Properties." +
            "To change this template file, choose Tools | Templates" +
            "and open the template in the editor." +
            "-->" +
            "<html>" +
            "    <head>" +
            "        <title>TODO supply a title</title>" +
            "        <meta charset='UTF-8'>" +
            "        <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
            "       " +
            "    </head>" +
            "    <body>" +
            "         <style>" +
            "            .font_all{" +
            "                font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif;" +
            "                font-size: 13px;" +
            "            }" +
            "            .font_size_header_center{" +
            "                 font-size: 18px;" +
            "                 text-align:center;   " +
            "            }" +
            "            .font_size_header_enter_12px{" +
            "                 font-size: 12px;" +
            "                 text-align:center; " +
            "                 padding-right: 100px;" +
            "            }" +
            "            .font_size_header_left{" +
            "                 font-size: 18px;" +
            "                 text-align:left; " +
            "                 margin-left: 5px;" +
            "            }" +
            "            .font_size_header_left_12px{" +
            "                 font-size: 12px;" +
            "                 text-align:left; " +
            "                 margin-left: 5px;" +
            "            }" +
            "            .box_bagian_atas {" +
            "                padding-bottom: 1px;" +
            "                margin: 0px 15px 5px;" +
            "            }" +
            "            .box_bagian_body {" +
            "                padding-bottom: 1px;" +
            "                margin: 0px 15px 5px;" +
            "                border-bottom: 1px solid #EEE;" +
            "            }" +
            "            .box_bagian_bawah {" +
            "                padding-bottom: 1px;" +
            "                margin: 0px 15px 5px;" +
            "                border-bottom: 1px solid #EEE;" +
            "            }" +
            "            .box_all{" +
            "                padding-left: 1%;" +
            "            }" +
            "            .row {" +
            "                margin-right: 1%;" +
            "                margin-left: 1%;" +
            "            }" +
            "            /* css tabel */" +
            "            td {" +
            "                border: 1px solid #666666;" +
            "                text-align: left;" +
            "                padding: 0px 8px;" +
            "                " +
            "            }" +
            "            .text-center{" +
            "                text-align: center;" +
            "            }" +
            "            .text-left{" +
            "                text-align: left;" +
            "            }" +
            "            table {" +
            "                border-spacing: 0px;" +
            "                border-collapse: collapse;" +
            "                width: 100%;" +
            "            }" +
            "            input[type='checkbox'] {" +
            "                margin: 4px 0px 0px;" +
            "                line-height: normal;" +
            "            }" +
            "        </style>" +
            "        <div id='printable' class='font_all box_all' >" +
            "            <div class='box_bagian_atas'>" +
            "                <div class='font_size_header_left'  >BSP GROUPS</div>" +
            "                <div class='font_size_header_center'  >Formulir Biodata Pelamar</div>" +
            "                <div class='font_size_header_enter_12px'  >No. " + data.getRefCode()+"</div>" +
            "                <div class='font_size_header_left_12px'  >ISILAH DENGAN HURUF CETAK</div>" +
            "            </div>" +
            "            <hr>" +
            "            <div >A. IDENTITAS</div>" +
            "            <table >" +
            "                <tr>" +
            "                    <td style='width: 10px; border-right: 0px'>Nama</td> " +
            "                    <td style='width: 30%;  border-left:  0px'>: "+ data.getNama() +"</td>"+
            "                    <td style=' border-right: 0px; width: 50px'>Nama Ibu Kandung</td> " +
            "                    <td style='width: 30%; border-left:  0px'>: "+ data.getIbu()+"</td>" +
            "                </tr>" +
            "                <tr>" +
            "                    <td style=' border-right: 0px'>Tempat & Tanggal Lahir</td>" +
            "                    <td style='width: 30%;  border-left:  0px'>: "+ data.getTempatLahir()+", "+ data.getTanggalLahirString() +"</td>" +
            "                    <td style=' border-right: 0px; width: 50px'>Agama</td> " +
            "                    <td style='width: 30%; border-left:  0px'>: "+ cov.convertAgamaString(Integer.valueOf(data.getAgama())) +"</td>" +
            "                </tr>" +
            "                 <tr>" +
            "                     <td style='border-right: 0px'>No <input type='checkbox' "+ kTp + " > KTP <input type='checkbox'  "+ sIm + " >  SIM *)</td> " +
            "                     <td style='width: 30%;  border-left:  0px'>: "+ data.getNoKtp()+" /&nbsp;&nbsp;&nbsp; "+ data.getNoSim() + "</td>" +
            "                     <td style=' border-right: 0px; width: 50px'>Gol. Darah</td> " +
            "                     <td style='width: 30%; border-left:  0px'>: "+ cov.convertGolDarahString(Integer.valueOf(data.getDarah()))+" </td>" +
            "                </tr>" +
            "                <tr>" +
            "                     <td style='border-right: 0px'>Jabatan yang diinginkan</td> " +
            "                     <td style='width: 30%;  border-left:  0px'>: "+ data.getJabatan()+"</td>" +
            "                     <td style=' border-right: 0px; width: 50px'>Kewarganegaraan</td> " +
            "                     <td style='width: 30%; border-left:  0px'>: "+ data.getKewarganegaraan() +"</td>" +
            "                </tr>" +
            "                <tr>" +
            "                     <td style='border-right: 0px'>No Telpon</td> " +
            "                     <td style='width: 30%;  border-left:  0px'>: "+ data.getNoHP()+"</td>" +
            "                     <td style=' border-right: 0px; width: 50px'>Jenis Kelamin ( Tulis L/P )</td> " +
            "                     <td style='width: 30%; border-left:  0px'>: "+ cov.convertJenisKelaminString(Integer.valueOf(data.getJenisKelamin()))+"</td>" +
            "                </tr>" +
            "                  <tr>" +
            "                     <td style='border-right: 0px'>Agama</td> " +
            "                     <td style='width: 30%;  border-left:  0px'>: "+ cov.convertAgamaString(Integer.valueOf(data.getAgama()))+"</td>" +
            "                     <td style=' border-right: 0px; width: 50px'>Kode Pos</td> " +
            "                     <td style='width: 30%; border-left:  0px'>: "+ data.getKodePos()+"</td>" +
            "                </tr>" +
            "                <tr>" +
            "                     <td style='border-right: 0px'>Email</td> " +
            "                     <td style='width: 30%;  border-left:  0px'>: "+ data.getEmail()+"</td>" +
            "                     <td style=' border-right: 0px; width: 50px'>Status Tempat Tinggal</td> " +
            "                     <td style='width: 30%; border-left:  0px'>: "+ cov.convertStatusTempatTinggalString(Integer.valueOf(data.getStatusTempatTinggal()))+"</td>" +
            "                </tr>" +
            "                <tr>" +
            "                    <td colspan='2' style='border-bottom: 0px'>Alamat Tinggal ( Alamat Surat ) </td>" +
            "                    <td colspan='2' style='border-bottom: 0px'>Alamat Asal </td>" +
            "                </tr>" +
            "                <tr style='height: 70px'>" +
            "                    <td colspan='2'  style='border-top: 0px; border-bottom: 0px; '>"+ data.getAlamat()+"</td>" +
            "                    <td colspan='2' style='border-top: 0px; border-bottom: 0px'>"+ data.getAsal()+"</td>" +
            "                </tr>" +
            "                <tr>" +
            "                    <td colspan='2' style='border-top: 0px;'>Kota : </td>" +
            "                    <td colspan='2' style='border-top: 0px;'>Kota : </td>" +
            "                </tr>" +
            "            </table>" +
            "            <div style='margin-top: 10px' >B. PENDIDIKAN</div>" +
            "            <div style='margin-top: 5px' >1. Pendidikan Formal</div>" +
            "            <table>" +
            "                <tr>" +
            "                    <td  style='width: 100%;'>"+ data.getEditorRiwayat()+"</td>" +
            "                </tr>" +
            "            </table>" +
            "            <div style='margin-top: 5px' >2. Pendidikan Non Formal</div>" +
            "            <table>" +
            "                <tr>" +
            "                    <td style='width: 100%;' >"+ data.getNonFormal()+"</td>" +
            "                </tr>" +
            "            </table>" +
            "            <div style='margin-top: 10px' >C. PERNYATAAN</div>" +
            "            <table >" +
            "                <tr>" +
            "                    <td style='width: 10%; border-bottom: 0px' colspan='4' class='text-left'>Saya menyatakan dengan kesungguhannya bahwa saya mengisi formulir ini dengan akurat dan sebenar-benarnya. Apabila dikemudian hari ternyata ada hal-hal yang bertentangan, maka saya bersedia dituntut sesuai dengan hukum berlaku.</td>" +
            "                </tr>" +
            "                <tr >" +
            "                    <td   style='width: 40%;border-right: 0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                    <td   style='width: 20%;border: 0px'>Dinyatakan di</td>" +
            "                    <td   style='width: 15%;border: 0px'>:</td>" +
            "                    <td   style='width: 30%;border-left:  0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                </tr>" +
            "                <tr>" +
            "                    <td  style='width: 40%;border-right: 0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                    <td  style='width: 20%;border: 0px'>Pada tanggal </td>" +
            "                    <td  style='width: 15%;border: 0px'>:</td>" +
            "                    <td  style='width: 30%;border-left:  0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                </tr>" +
            "                <tr >" +
            "                    <td  style='width: 40%;border-right: 0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                    <td  style='width: 20%;border: 0px;'>Tanda Tangan</td>" +
            "                    <td  style='width: 15%;border: 0px'>:</td>" +
            "                    <td  style='width: 30%;border-left:  0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                </tr>" +
            "                <tr style='height:100px;'>" +
            "                    <td  style='width: 40%;border-right: 0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                    <td class='cobaa' style='width: 20%;border: 0px;'>&nbsp;</td>" +
            "                    <td  style='width: 15%;border: 0px'>&nbsp;</td>" +
            "                    <td  style='width: 30%;border-left:  0px; border-bottom: 0px; border-top: 0px'>&nbsp;</td>" +
            "                </tr>" +
            "                <tr>" +
            "                    <td  style='width: 40%;border-right: 0px;  border-top: 0px'>&nbsp;</td>" +
            "                    <td  style='width: 20%;border-left:  0px; border-right: 0px;  border-top: 0px'>Nama jelas</td>" +
            "                    <td  style='width: 15%;border-left:  0px; border-right: 0px;  border-top: 0px'>:</td>" +
            "                    <td  style='width: 30%;border-left:  0px;  border-top: 0px'>&nbsp;</td>" +
            "                </tr>" +
            "            </table>" +
            "        </div>" +
            "    </body>" +
            "</html>" +
            "";
          
    }
}
