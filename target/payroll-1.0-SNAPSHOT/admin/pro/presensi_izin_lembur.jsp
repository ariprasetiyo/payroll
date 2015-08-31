<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %> 
<!DOCTYPE html>
<html lang="en" >
    <% if ((session.getAttribute("useridariprasetiyo") == null) || (session.getAttribute("useridariprasetiyo") == "")) { response.sendRedirect("../");%>    
    <%} else { %>
<head >
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Bootstrap Admin Template</title>
    
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
   <!--<link href="css/plugins/morris.css" rel="stylesheet"> -->
   
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> 
    
    <!--<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" -->
    <link href="css/jquery-ui.css" rel="stylesheet" type="text/css">
    
    <!-- customize css -->
    <link href="css/main.css" rel="stylesheet">
    
     <!-- tabel css -->
    <!-- <link href="css/bootstrap-table.css" rel="stylesheet"> -->
    
    <!-- text editor -->
     <link href="css/editor.css" rel="stylesheet">
     
    <!-- date range  http://eternicode.github.io/bootstrap-datepicker/? -->
    <link rel="stylesheet" type="text/css" href="css/jquery.datepick.css"> 

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- autocomplate --->
    <link href="css/select2.min.css" rel="stylesheet" />
    <!--<link href="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css" rel="stylesheet" />
    <!-- <link href="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0-beta.3/css/select2.min.css" rel="stylesheet" /> -->
    
    <!-- <link href="css/select2.min.css" rel="stylesheet" /> -->
    <!-- validation confirmation 
    <link rel="stylesheet" type="text/css" href="css/jquery.confirm.css" />
    -->
    <style type="text/css">
        #gb{
            position:fixed;
            top:50px;
            z-index:+1000;
        }
        * html #gb{position:relative;}
        .gbtab{
            height:120px;
            width:40px;
            float:left;
            cursor:pointer;
            background:url('../admin/gambar/chat-box.png')
            no-repeat; 
        }
        .gbcontent{
            float:left;
            border:2px solid #444444;
            background:#F5F5F5;
            padding:10px;
        }
       
    </style>
<script type="text/javascript">
    function showHideGB(){
        var gb = document.getElementById("gb");
        var w = gb.offsetWidth;
        gb.opened ? moveGB(0, 30-w) : moveGB(20-w, 0);
        gb.opened = !gb.opened;
    }
    function moveGB(x0, xf){
        var gb = document.getElementById("gb");
        var dx = Math.abs(x0-xf) > 10 ? 5 : 1;
        var dir = xf>x0 ? 1 : -1;
        var x = x0 + dx * dir;
        gb.style.right = x.toString() + "px";
        if(x0!=xf){setTimeout("moveGB("+x+", "+xf+")", 10);}
    }
</script>
</head>
<body id="content">
    <div id="wrapper" class="main-contents">
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu" id="menu-utama">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                 </button>
                <!-- <a class="navbar-brand" href="index.html">Arprast</a> -->
            </div>
            <!-- Top Menu Items 
                 display mobile nav navbar-nav side-nav = menu di samping
            -->
            <div id="menu" class="collapse navbar-collapse">
            <div id="menu-side" class="navbar-nav side-nav"></div>
            <ul id="menu-change" class="nav navbar-left top-nav" >
              <!-- 
                bagian menu
                keterangan tentang tag
                Keterangn menu2 dalam database
                Tag adalah menentukan posisi <ul> dan </ul>
                   0 = menu utama tanpa link
                   1 = menu utama dengan link
                   2 = sub menu <li>( pertama ) dengan <ul>
                   3 = sub menu 
                   4 = sub menu </li> penutup dengan </ul>
                   5 = sub menu sub menu <li> ( pertama dengan < ul>
                   6 = sub menu sub menu 
                   7 = sub menu sub menu <li> ( penutup dengan </ ul>
                   8 = sub menu tapi hanya satu dan dengan link sub menu
                   9 = sub menu tapi tanpa link sub menu

                 kemudian sub_link / subLink adalah menentukan 
                 ada sub menu lagi atau tidak di bawahnya
                     0 = tanpa link / tidak ada sub menu lagi atau tidak ada link lagi
                     1 = dengan link / ada menu lagi 
             -->
            <c:forEach var="mnu" items="${daftarMenu}" varStatus="counter">
                 <c:set var="levelMenu0"  scope="session" value="${fn:substring(mnu.levelMenu, 0, 1)}" />             
                 <c:if test="${levelMenu0 == 1 }">
                    <c:set var="levelMenu1"  scope="session" value="${fn:substring(mnu.levelMenu, 1, 2)}" />
                    <c:choose>
                        <c:when test="${levelMenu1 == 1 }"> 
                            <c:set var="levelMenu2"  scope="session" value="${fn:substring(mnu.levelMenu, 2, 3)}" />
                            <c:choose>
                               <c:when test="${levelMenu2 == 1 }">
                                  <!-- ketiga -->
                                  <c:choose>
                                       <c:when test="${mnu.tag == 5 }">
                                           <!-- opsi pilihan ada sub menu (0 ) atau sub sub menu (1) -->
                                           <c:choose>
                                                <c:when test="${mnu.subLink == 0 }">
                                                     <li> <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>
                                                </c:when>
                                                <c:when test="${mnu.subLink == 1 }">
                                                        <li class="dropdown-submenu">
                                                        <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a>
                                                        <ul class="dropdown-menu">
                                                            <li><a href="#">3rd level</a></li>
                                                            <li><a href="#">3rd level</a></li>
                                                        </ul>
                                                        </li>
                                                </c:when>
                                            </c:choose>   
                                       </c:when>
                                       <c:when test="${mnu.tag == 6 }">
                                            <li> <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>
                                       </c:when>
                                        <c:when test="${mnu.tag == 7 }">
                                            <li> <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>
                                            </ul>
                                       </c:when>
                                   </c:choose>
                               </c:when>
                               <c:otherwise>
                                   <!-- kedua -->
                                   <c:choose>
                                       <c:when test="${mnu.tag == 2 }">
                                           <!-- opsi pilihan ada sub menu atau sub sub menu -->
                                           <c:choose>
                                                <c:when test="${mnu.subLink == 0 }">
                                                     <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                                                     <li> <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>
                                                </c:when>
                                                <c:when test="${mnu.subLink == 1 }">
                                                     <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                                                     <li class="dropdown-submenu">
                                                     <a  href="#"><c:out value="${mnu.namaMenu}"/></a>
                                                     <ul class="dropdown-menu">       
                                                </c:when>
                                            </c:choose>
                                       </c:when>
                                       <c:when test="${mnu.tag == 3 }">
                                            <li> <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>
                                       </c:when>
                                        <c:when test="${mnu.tag == 4 }">
                                            <li> <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>
                                            </ul>
                                       </c:when>   
                                        <c:when test="${mnu.tag == 8 }">
                                       <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                                            <li class="dropdown-submenu">
                                            <a  href="#"><c:out value="${mnu.namaMenu}"/></a>
                                            </li>      
                                       </ul>
                                       </c:when>   
                                       <c:when test="${mnu.tag == 9 }">
                                            <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                                            <li> <a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>     
                                            </ul>
                                       </c:when>
                                   </c:choose>
                               </c:otherwise>
                           </c:choose>        
                        </c:when>
                        <c:otherwise>
                            <!-- Pertama -->
                            <c:choose>
                                <c:when test="${mnu.tag == 0 }">
                                    <li><a href="${mnu.href}"><c:out value="${mnu.namaMenu}"/></a></li>
                                </c:when>
                                <c:when test="${mnu.tag == 1 }">
                                     <li class="dropdown">
                                     <a href="${mnu.href}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><c:out value="${mnu.namaMenu}"/><span class="caret"></span></a>  
                                </c:when>
                            </c:choose>       
                        </c:otherwise>
                    </c:choose>
                 </c:if>
            </c:forEach>    
            
            </ul>
            </ul>
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i><b id="usernya"> Ari Prasetiyo </b><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="logout.ari"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- id=meun -->
            </div>
        </nav>
        <script type="text/javascript">
        var gb = document.getElementById("gb");
        gb.style.right = (30-gb.offsetWidth).toString() + "px";
        </script>
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->          
                <div class="row paling_atas">
                    <div class="col-lg-16">
                        <h4 class="alert alert-info alert-dismissable">
                            Presensi 
                        </h4>                       
                    </div>
                </div>
                <!-- /.row -->
                
                <!-- data input karyawan -->
                <div class="row">                   
                    <div class="col-lg-5">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i>Data Izin / Lembur</h3>
                            </div>
                            <div class="panel-body-ari-customize">
                                <div class="form-group" >
                                    <form id="form-ari" >
                                    <div class="panel-body ">
                                        
                                     <div role="tabpanel">
                                        <!-- Nav tabs -->
                                        <ul class="nav nav-tabs" role="tablist">
                                          <li role="presentation" id="home_detection" class="active" ><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Izin Cuti</a></li>
                                          <li role="presentation" id="izin_sakit_detection" ><a href="#izin_sakit" aria-controls="izin_sakit" role="tab" data-toggle="tab">Izin Sakit</a></li>
                                          <li role="presentation" id="form_lembur_decetion" ><a href="#form_lembur" aria-controls="form_lembur" role="tab" data-toggle="tab">Lembur</a></li>
                                        </ul>

                                        <!-- Tab panes -->
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active" id="home">
                                                <div data-amount='0' data-tax-rate='0' data-track-inventory='true' data-trade-in-amount='0'>
                                                    <table class="table">
                                                    <tr>
                                                        <td class="col-xs-3">Ref Code</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="ref_izin_cuti"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="col-xs-3">Tanggal Buat</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="tanggal_buat_izin_cuti"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Nama & Id Karyawan</td>
                                                        <td colspan="3">
                                                          <select name="select_validation" class="js-data-example-ajaxs" id="search_select_karyawan">
                                                                <option value="-" selected="selected" id="select2ValueAriIzin" class="removeSelect2" >-</option>
                                                          </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Jabatan</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="jabatan_ari_izin_cuti" name="jabatan_ari_izin_cuti" type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                            <!--<input id="jabatan_ari" name='jabatan_ari' type="text" class="col-xs-12 padding_left">-->
                                                         </td>
                                                    </tr>
                                                     <tr>
                                                        <td>Jenis Izin Cuti</td>
                                                        <td colspan="3">
                                                            <select id="jenis_izin_cuti_ari" class="col-xs-7 padding_left">
                                                                <option value="0">Cuti Tahunan</option>
                                                                <option value="1">Cuti 5 Tahunan</option>
                                                            </select>
                                                        </td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Jumlah Cuti</td>
                                                       <td colspan="3">
                                                            <div class="col-xs-2">
                                                                <input id="jum_izin_cuti" name="jum_izin_cuti" style = "width:80%" class="padding_left">
                                                            </div>
                                                            <div class="col-xs-3 padding_left">Sisa Cuti</div>
                                                            <div class="col-xs-2">
                                                                 <input disabled id="sisa_izin_cuti" style = "width:80%" name="sisa_izin_cuti" class="padding_left">
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td style="width: 90px">Tgl Mulai Cuti</td>
                                                        <td><input id="tgl_cuti_mulai" name="tanggal_lahir_ari1"  type="text" data-date-format="mm/dd/yyyy" class="col-xs-4 datepicker padding_left" ></td>
                                                        
                                                    </tr>
                                                    <tr>
                                                        <td style="width: 120px">Tgl Selesai Cuti</td>
                                                        <td><input id="tgl_cuti_selesai" name="tanggal_lahir_ari2"  type="text" data-date-format="mm/dd/yyyy" class="col-xs-4 datepicker padding_left" ></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Keterangan</td>
                                                        <td colspan="3">
                                                            <textarea style="height:50px" id="ket_izin_cuti" name="ket_izin_cuti"  class="col-xs-12 padding_left" ></textarea>
                                                        </td>
                                                    </tr>
                                                </table>
                                                </div>
                                            </div>
                                        <div role="tabpanel" class="tab-pane" id="izin_sakit">  
                                                    <table class="table">
                                                    <tr>
                                                        <td class="col-xs-3">Ref Code</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="ref_code_izin_sakit"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="col-xs-3">Tanggal Buat</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="tanggal_buat_izin_sakit"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Nama & Id Karyawan</td>
                                                        <td colspan="3">
                                                          <select class="js-data-example-ajaxs" id="search_select_karyawan_sakit">
                                                                <option value="-" selected="selected" id="select2ValueAriSakit" class="removeSelect2" >-</option>
                                                          </select>
                                                        </td>
                                                    </tr>
                                                   
                                                    <tr>
                                                        <td>Jabatan</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="jabatan_ari_izin_sakit"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                            <!--<input id="jabatan_ari" name='jabatan_ari' type="text" class="col-xs-12 padding_left">-->
                                                         </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Jumlah Izin Sakit</td>
                                                        <td >
                                                            <input id="jum_izin_sakit" name="jum_izin_sakit" class="col-xs-1 padding_left">
                                                        </td>
                                                    </tr>
                                                    
                                                    <tr>
                                                        <td style="width: 90px">Tgl Mulai Izin Sakit</td>
                                                        <td><input id="tgl_izin_sakit_mulai" name="tgl_izin_sakit_mulai"  type="text" data-date-format="mm/dd/yyyy" class="col-xs-4 datepicker padding_left" ></td>
                                                    </tr>
                                                    <tr>
                                                        <td style="width: 150px">Tgl Selesai Izin Sakit</td>
                                                        <td><input id="tgl_izin_sakit_selesai" name="tgl_izin_sakit_selesai"  type="text" data-date-format="mm/dd/yyyy" class="col-xs-4 datepicker padding_left" ></td>
                                                    </tr>
                                                   
                                                    <tr>
                                                        <td>Keterangan</td>
                                                        <td colspan="3">
                                                            <textarea style="height:50px" id="ket_izin_sakit" name="ket_izin_sakit"  class="col-xs-12 padding_left" ></textarea>
                                                        </td>
                                                    </tr>
                                                </table>
                                                
                                        </div>
                                            <!-- class untuk setvalue, id txtEditor untuk getvalue  -->
                                          <div role="tabpanel" class="tab-pane" id="form_lembur">  
                                                 <table class="table">
                                                    <tr>
                                                        <td class="col-xs-3">Ref Code</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="ref_code_form_lembur"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="col-xs-3">Tanggal Buat</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="tanggal_buat_form_lembur"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Nama & Id Karyawan</td>
                                                        <td colspan="3">
                                                          <select class="js-data-example-ajaxs" id="search_select_karyawan_lembur">
                                                                <option value="-" selected="selected" id="select2ValueAriLembur" class="removeSelect2" >-</option>
                                                          </select>
                                                        </td>
                                                    </tr>
                                                   
                                                    <tr>
                                                       <td>Jabatan</td>
                                                        <td colspan="3">
                                                            <div class="form-group has-error">   
                                                                <input id="jabatan_ari_lembur"  type="text" class="col-xs-5 padding_left" disabled>
                                                            </div>
                                                            <!--<input id="jabatan_ari" name='jabatan_ari' type="text" class="col-xs-12 padding_left">-->
                                                         </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Katagori Lembur</td>
                                                        <td colspan="3">
                                                            <select id="katagori_form_lembur" class="col-xs-4 padding_left">
                                                                <option value="3">3 Jam</option>
                                                                <option value="8">8 jam</option>
                                                                <option value="12">12 jam </option>
                                                            </select>
                                                        </td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Jumlah Lembur</td>
                                                        <td >
                                                            <input id="jum_lembur" name="jum_lembur" class="col-xs-1 padding_left">
                                                        </td>
                                                        
                                                    </tr>
                                                    <tr>
                                                        <td style="width: 90px">Tgl Mulai Lembur</td>
                                                        <td><input id="tgl_lembur_mulai" name="tgl_lembur_mulai"  type="text" data-date-format="mm/dd/yyyy" class="col-xs-4 datepicker padding_left" ></td>
                                                    </tr>
                                                    <tr>
                                                        <td style="width: 120px">Tgl Selesai Lembur</td>
                                                        <td><input id="tgl_lembur_selsai" name="tgl_lembur_selsai"  type="text" data-date-format="mm/dd/yyyy" class="col-xs-4 datepicker padding_left" ></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Keterangan</td>
                                                        <td colspan="3">
                                                            <textarea style="height:50px" id="ket_form_lembur" name="ket_form_lembur"  class="col-xs-12 padding_left" ></textarea>
                                                        </td>
                                                    </tr>
                                                </table>
                                          </div>
                                        </div>
                                    </div>
                                    </div>
                                    <!-- tombol save, edit, new ,reset -->
                                    <div class="panel-ari panel-default">
                                        <div  id="status_save" hidden >0</div>
                                        <div  id="status_edit" hidden >0</div>
                                        <div id="ajaxResponseError" class="error text-center"></div>
                                        <div class="panel-heading-ari text-center fixedBottomDiv">
                                            <a id="pelamar_save" class="btn btn-primary" >Save</a>
                                            <button id="pelamar_edit" type="submit" class="btn btn-primary">Edit</button>
                                            <button id="pelamar_delete" type="submit" class="btn btn-primary disabled">Delete</button>
                                            <button id="pelamar_new"  type="submit" class="btn btn-primary">New</button>
                                            <a id="pelamar_print_data" class="btn btn-primary" >Print</a>
                                            <a id="pelamar_print" href="master_pelamar.ari?sta=4&xcv=4" class="btn btn-primary" >Print Form</a>
                                        </div>
                                    </div>
 
                                    </form> 
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-7 ">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i>List Data Izin / Lembur</h3>
                            </div>
                            <div class="panel-body">
                                          <!-- tombol filter -->
                                        <div class="col-sm-12 alert alert-info alert-dismissable">
                                            <div class="form-group" style='width:100%'>
                                                <div class="col-sm-10" >
                                                     <div class="col-sm-2" >
                                                    <input type="text" style="width: 100%" class="padding_left f_id" placeholder="Ref no" > 
                                                    </div>
                                                    <div class="col-sm-2" >
                                                        <input type="text" style="width: 100%" class="padding_left f_id_kar" placeholder="Id Karyawan" > 
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <input  type="text" style="width: 100%" class="padding_left f_nama" placeholder="Nama"> 
                                                    </div>
                                                    <div class="col-sm-3">  
                                                        <input  type="text" style="width: 100%" class="padding_left f_jabatan" placeholder="Jabatan"> 
                                                    </div>
                                                    <div class="col-sm-3"> 
                                                        <input  type="text" style="width: 100%" id="filterRange" class="padding_left f_tgl_buat" placeholder="Tanggal buat"> 
                                                    </div>
                                                    <!--
                                                    <div class="col-sm-2"> 
                                                        <input  type="text" style="width: 100%" class="padding_left f_status_pelamar" placeholder="Status Pelamar"> 
                                                    </div>
                                                    -->
                                                    <select class="col-sm-2 f_s_plmr" style="margin-top:5px" >
                                                        <option disabled selected>Status Presensi</option>
                                                        <option value="4">All</option>
                                                        <option value="0">Izin Cuti</option>
                                                        <option value="1">Izin Sakit</option>
                                                        <option value="2">Lembur</option>
                                                    </select>
                                                </div>
                                                <div class="col-sm-1"> 
                                                    <button type="submit" class="btn btn-primary b_filter">Filter</button>
                                                </div>
                                                                                                                               
                                            </div>       
                                          </div>
                                        <div class="col-sm-12">
                                        <div class="panel panel-default ">
                                                <div class="table-responsive">
                                            <!-- <div  style="width: 100%; height: 100%x; overflow: auto;"> -->
                                              <!--  <div style="display: table; table-layout: fixed; width: 250%;"> -->
                                                  <table id="table-pagination" class="table table-bordered table-hover table-striped">
                                                        <thead  class='alert alert-info alert-dismissable'>
                                                        <tr>
                                                            <th class="text-center">Ref No</th>
                                                            <th class="text-center">Id Karyawan</th>
                                                            <th class="text-center">Nama</th>
                                                            <th class="text-center">Jabatan</th>
                                                            <th class="text-center">Status Presensi</th>
                                                            <th class="text-center">Tgl Mulai</th>
                                                            <th class="text-center">Tgl Selesai</th>
                                                            <th class="text-center">Keterangan</th>
                                                            <th class="text-center">Created</th>
                                                        </tr>
                                                        </thead > 
                                                        <tbody  id="ariDataTablePelamar" >
                                                        </tbody>                                                       
                                                    </table>
                                                </div>
                                              <!--</div>
                                            </div>
                                              -->
                                            <!-- paging data table -->
                                            <input type="text" value="10" id="batasAwal" hidden >
                                            <input type="text" value="0" id="halKe" hidden >
                                            <input type="text" value="0" id="totalPage" hidden >
                                            <input type="text" value="0" id="jmlhRow" hidden >
                                            <div class="pangingDataList" style="margin-bottom:-20px; margin-left: 5px">
                                            </div>
                                            <div id="ketHal" style="margin-left: 10px; margin-bottom:5px; " ></div>
                                            <!-- example
                                            <ul class="pagination"
                                                <li><a href="#" class="">&laquo;</a></li>
                                                 <li class="halaman active" id="10"><a href="#">1</a></li>
                                                 <li id="2"><a href="#" id="1">2</a></li>
                                                 <li><a href="#"  id="1" >3</a></li>
                                                 <li><a href="#">4</a></li>
                                                 <li><a href="#">&raquo;</a></li>
                                                 <li><a href="#">5</a></li>
                                            </ul>
                                            -->                           
                                            </div>
                                          </div>                                   
                                                        
                                <div class="text-right">
                                    <!-- <a href="#">View Details <i class="fa fa-arrow-circle-right"></i></a>-->
                                </div>     
                            
                            </div>
                        </div>
                        <!-- end <div class="col-lg-7 "> -->
                    </div>
                    
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->                 
<!-- chart --><!--
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>
    -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap-datepicker.min.js"></script>
    
    <!--
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
    -->
    <script src="js/jquery-ui.min.js"></script>
    
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <!--
    lib pendukung select2
    -->
     <!-- autocomplate 
    <script src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0-beta.3/js/select2.min.js"></script>
     <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <!--
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
    -->
    <script src="js/jquery.validate.min.js"></script>
    
    <!-- text editor
    https://mindmup.github.io/bootstrap-wysiwyg/
    -->
     <script src="js/editor.js"></script>
    
     <!-- date range
     http://eternicode.github.io/bootstrap-datepicker/?
     -->
     <script src="js/all_loading.js" type="text/javascript"></script>
     <script type="text/javascript" src="js/jquery.plugin.js"></script> 
     <script type="text/javascript" src="js/jquery.datepick.js"></script>
    <!-- http://tutorialzine.com/2010/12/better-confirm-box-jquery-css3/ 
    digunakan sebagai validation confirmation
    <script type="text/javascript" src="js/jquery.confirm.js"></script> -->
     <!-- oprek sendiri -->
      <!--<script src="js/master_pelamar_validation.js" type="text/javascript"></script>-->
    <!--<script src="ajax/master_pelamar_save.js" type="text/javascript"></script> -->
    <!-- <script src="js/select2.js" type="text/javascript"></script> -->
    <!--http://www.position-absolute.com/creation/print/jquery.printPage.js -->
    <script src="js/jquery.printPage.js" type="text/javascript"></script>
    <!-- 
    autocomplite 
    https://select2.github.io/examples.html
    -->
    <script src="js/select2.js" type="text/javascript"></script>
    <!--<script src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>-->
    <script src="js/master_presensi.js" type="text/javascript"></script>
    <!-- http://wenzhixin.net.cn/p/bootstrap-table/docs/examples.html -->
    <!-- <script src="js/bootstrap-table.js" type="text/javascript"></script>  -->
</body>
      <%} 
        %>
</html>
