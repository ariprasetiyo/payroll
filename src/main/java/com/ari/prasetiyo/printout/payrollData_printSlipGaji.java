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
public class payrollData_printSlipGaji {
    public String printOut(String iD, String noSlipGaji){
        com.ari.prasetiyo.dao.daoPayrollData dataDb = new com.ari.prasetiyo.dao.daoPayrollData();
        com.ari.prasetiyo.sistem.convertAll cov = new com.ari.prasetiyo.sistem.convertAll();
        com.ari.prasetiyo.domain.domainPayrollData_printSlipGaji data = dataDb.tampilDetilDataGaji(iD);

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
"                width:100%;" +
"            }" +
"            .row {" +
"                margin-right: 1%;" +
"                margin-left: 1%;" +
"            }" +
"            /* css tabel */" +
"            td {" +
"                border: 0px;" +
"                text-align: left;" +
"                padding: 0px 0px;" +
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
"                border: 0px;" +
"            }" +
"            input[type='checkbox'] {" +
"                margin: 4px 0px 0px;" +
"                line-height: normal;" +
"            }" +
"            .margin_left{" +
"                margin-left:  10px;" +
"            }" +
"        </style>" +
"        <div id='printable' class='font_all box_all' >" +
"            <div class='box_bagian_atas'>" +
"                <div class='font_size_header_left'  >BSP GROUPS</div>" +
"                <div class='font_size_header_center'  >Slip Gaji</div>" +
"                <div class='font_size_header_center'  >"+data.getTanggal_dibuat()+"</div>" +
"                <div class='font_size_header_center' style='font-size:12px' >No. "+noSlipGaji+"</div>" +
"            </div>" +
"                 <table >" +
"                    <tr>" +
"                        <td style='width: 1px; ' nowrap>Nama</td> " +
"                        <td style='width: 5px; ' nowrap>:</td>" +
"                        <td style='width: 10px' nowrap>"+data.getNama() +"</td> " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; '>NIK</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getId()+"</td> " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; '>Jabatan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getJabatan() +"</td> " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; '>Area</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+cov.convertArea(data.getArea())+"</td> " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; '>Status Pegawai</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+cov.convertPegawai(data.getStatusPegawai())+"</td> " +
"                    </tr>" +
"                    <tr style='width:10px'>" +
"                        <td colspan='3'>&nbsp </td> " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; ' colspan='3'>Pendapatan</td> " +
"                    </tr>" +
"                     <tr>" +
"                        <td style='width: 1px; '>Gaji Pokok</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getGaji()+"</td> " +
"                    </tr>" +
"                     <tr>" +
"                        <td style='width: 1px; '>Tunjangan Kerajinan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_kerajinan() +"</td> " +
"                    </tr>" +
"                     <tr>" +
"                        <td style='width: 1px; '>Tun Operational</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_operational()+"</td> " +
"                    </tr> <tr>" +
"                        <td style='width: 1px; ' nowrap>Tun Bpjs Ketenagakerjaan *)</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_bpjs_ketenagakerjaan()+"</td> " +
"                    </tr>" +
"                     <tr>" +
"                        <td style='width: 1px; '>Tun Bpjs Kesehatan *)</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_bpjs_kesehatan() +"</td> " +
"                    </tr>" +
"                     <tr>" +
"                        <td style='width: 1px; '>Tun Penempatan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_penepatan()+"</td> " +
"                    </tr>" +
"                      <tr>" +
"                        <td style='width: 1px; '>Tun Transportasi</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_transport() +"</td> " +
"                    </tr>  <tr>" +
"                        <td style='width: 1px; '>Tun Makan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_makan() +"</td> " +
"                    </tr>" +
"                      <tr>" +
"                        <td style='width: 1px; '>Tun Jabatan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_jabatan() +"</td> " +
"                    </tr>" +
"                     <tr>" +
"                        <td style='width: 1px; '>Tun Lainnya</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getT_lainnya() +"</td> " +
"                    </tr>" +
"                        <tr>" +
"                        <td style='width: 1px; '>Lembur </td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getLembur() +"</td> " +
"                    </tr>" +
"                     <tr style='width:10px'>" +
"                         <td colspan='3'><hr> </td> " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; '>Total Pendapatan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getTotalPendapatan()+"</td> " +
"                    </tr>" +
"                    <tr style='width:10px'>" +
"                         <td colspan='3'>&nbsp</td> " +
"                    </tr>" +
"                        <tr>" +
"                        <td style='width: 1px; ' colspan='3'>Potongan</td> " +
"                        " +
"                    </tr>" +
"                      <tr>" +
"                        <td style='width: 1px; '>Pot Pinjaman Karyawan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getP_pinjaman_karyawan() +"</td> " +
"                    </tr>" +
"                        <tr>" +
"                        <td style='width: 1px; '>Pot Bpjs Ketenagakerjaan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getP_bpjs_ketenagakerjaan() +"</td> " +
"                    </tr>" +
"                        <tr>" +
"                        <td style='width: 1px; '>Pot Bpjs Kesehatan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getP_bpjs_kesehatan()+"</td> " +
"                    </tr>" +
"                        <tr>" +
"                        <td style='width: 1px; '>Pot Asr Kesehatan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getP_asr_kesehatan() +"</td> " +
"                    </tr>" +
"                      <tr>" +
"                        <td style='width: 1px; '>Pot Denda Kedisiplinan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getP_denda_kedisiplinan()+"</td> " +
"                    </tr>" +
"                      <tr>" +
"                        <td style='width: 1px; '>Pot Pajak</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getP_pajak()+"</td> " +
"                    </tr>" +
"                     <tr>" +
"                         <td style='width: 1px; ' colspan='3'><hr></td> " +
"                       " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; '>Total Potongan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getTotalPotongan()+"</td> " +
"                    </tr>" +
"                     <tr>" +
"                         <td style='width: 1px; ' colspan='3'><hr></td> " +
"                    </tr>" +
"                     <tr>" +
"                        <td style='width: 1px; '>Total Pendapatan - Potongan</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getTotalPendapatan2()+"</td> " +
"                    </tr>" +
"                      <tr>" +
"                        <td style='width: 1px; '>Take Home Pay</td> " +
"                        <td style='width: 5px; '>:</td>" +
"                        <td style='width: 10px'>"+data.getTakeHomePay()+"</td> " +
"                    </tr>" +
"                    <tr style='width:10px'>" +
"                         <td colspan='3'>&nbsp</td> " +
"                    </tr>" +
"                    <tr>" +
"                        <td style='width: 1px; '>Mengetahui</td> " +
"                        <td style='width: 5px; '></td>" +
"                        <td style='width: 10px'>Penerimaa</td> " +
"                       " +
"                    </tr>" +
"                    <tr style='width:10px'>" +
"                         <td colspan='3'>&nbsp</td> " +
"                    </tr>" +
"                    <tr style='width:10px'>" +
"                         <td colspan='3'>&nbsp</td> " +
"                    </tr>" +
"                    <tr style='width:10px'>" +
"                         <td colspan='3'>&nbsp</td> " +
"                    </tr>" +
"                      <tr>" +
"                         <td style='width: 1px; '>(&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp)</td> " +
"                        <td style='width: 5px; '></td>" +
"                        <td style='width: 10px'>"+data.getNama() +"</td>  " +
"                       " +
"                    </tr>" +
"                 </table>" +
"        </div>" +
"    </body>" +
"</html>" +
            "";
          
    }
}
