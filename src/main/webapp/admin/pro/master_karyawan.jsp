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
    <link href="css/main_master_karyawan.css" rel="stylesheet">
    
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
    
    <!-- autocomplate -
    <link href="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0-beta.3/css/select2.min.css" rel="stylesheet" />
    -->
    <!-- <link href="css/select2.min.css" rel="stylesheet" /> -->
    <link rel="stylesheet" type="text/css" href="css/jquery.confirm.css" />
    
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
            <!-- tidak digunakan dulu difungsikan untuk ambil menu AJAX low prioritas -->
            <!-- 
            <script  type="text/javascript">
            $.get("master_pelamar.ari?xcv=m", {ambil_data_id:id} ,function(data) {
                 $("input#ref_code_ari").val(data.topMenu.refCode );
            });
            </script>
            -->
            
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
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            
            <!-- /.navbar-collapse -->
        </nav>

        <div id="gb">
        <div class="gbtab" onclick="showHideGB()"> </div>
        <div class="gbcontent">
                    <ul class="nav">
                    <li class="active">
                        <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="charts.html"><i class="fa fa-fw fa-bar-chart-o"></i> Charts</a>
                    </li>
                    <li>
                        <a href="tables.html"><i class="fa fa-fw fa-table"></i> Tables</a>
                    </li>
                    <li>
                        <a href="forms.html"><i class="fa fa-fw fa-edit"></i> Forms</a>
                    </li>
                    <li>
                        <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
                    </li>
                    <li>
                        <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> Blank Page</a>
                    </li>
                    <li>
                        <a href="index-rtl.html"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a>
                    </li>
                </ul>
   
            <div style="text-align:right">
            <a><font size="1">...</font></a><a href="javascript:showHideGB()">
            [close]
            </a>
            </div>
        </div>
        </div>
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
                            Data Karyawan
                        </h4>                       
                    </div>
                </div>
                <!-- /.row -->
                
                <!-- data input karyawan -->
                <div class="row">                   

                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            
 
                            <div class="panel-body">
                                          <!-- tombol filter -->
                                        <div class="col-sm-12">
                                            <div class="form-group bag-filter-affix" data-spy="affix" data-offset-top="20">
                                                <div class="col-sm-1" >
                                                    <input type="text" style="width: 100%" class="padding_left f_id" placeholder="Ref no"  > 
                                                </div>
                                                <div class="col-sm-2">
                                                    <input  type="text" style="width: 100%" class="padding_left f_nama" placeholder="Nama"> 
                                                </div>
                                                <div class="col-sm-2">  
                                                    <input  type="text" style="width: 100%" class="padding_left f_jabatan" placeholder="Jabatan"> 
                                                </div>
                                                <select class="col-sm-1 f_area" >
                                                    <option disabled selected value="" >Area</option>
                                                    <option value="">All</option>
                                                    <option value="0">Jakarta</option>
                                                    <option value="1">Semarang</option>
                                                    <option value="2">Jogjakarta</option>
                                                    <option value="3">Bali</option>
                                                </select>
                                                <div class="col-sm-2"> 
                                                    <input  type="text" style="width: 100%" id="filterRange" class="padding_left f_tgl_buat" placeholder="Tanggal buat"> 
                                                </div>
                                                
                                                <!--
                                                <div class="col-sm-2"> 
                                                    <input  type="text" style="width: 100%" class="padding_left f_status_pelamar" placeholder="Status Pelamar"> 
                                                </div>
                                                -->
                                                <select class="col-sm-1 f_s_plmr" >
                                                    <option disabled selected value="" >Status Pekerja</option>
                                                    <option value="">All</option>
                                                    <option value="1">Karyawan</option>
                                                    <option value="3">Resign</option>
                                                </select>
                                                <select class="col-sm-1 f_s_karyawan" >
                                                    <option disabled selected>Status Karyawan</option>
                                                    <option value="">All</option>
                                                    <option value="0">Training</option>
                                                    <option value="1">Kontrak</option>
                                                    <option value="2">Tetap</option>
                                                </select>
                                                <div class="col-sm-1" style="width:0%"> 
                                                    <button type="submit" class="btn btn-primary b_filter">Filter</button>
                                                </div>                                                                             
                                            </div>
                                        <div class="panel panel-default" >
                                           
                                              <div class="table-responsive">
                                             
                                                  <table id="table-pagination" class="table table-bordered table-hover table-striped" style="overflow: auto; ">
                                                        <thead  class='alert alert-info alert-dismissable'>
                                                        <tr>
                                                            <th class="col-xs-1 text-center" nowrap>Id Karyawan</th>
                                                            <th class="col-xs-1 text-center" nowrap>Id Pelamar</th>
                                                            <th class="col-xs-1 text-center" nowrap>Nama</th>
                                                            <th class="col-xs-1 text-center" nowrap>Jabatan</th>
                                                            <th class="text-center" nowrap>L/P</th>
                                                            <th class="col-xs-1 text-center" nowrap>No Hp</th>
                                                            <th class="col-xs-1 text-center" nowrap>Area</th>
                                                            <th class="col-xs-2 text-center" nowrap>Cabang</th>
                                                            <th class="col-xs-1 text-center" nowrap>Sts Pegawai</th>
                                                            <th class="col-xs-1 text-center" nowrap>Sts Karyawan</th>
                                                            <th class="col-xs-1 text-center" nowrap>Created</th>
                                                            <th class="text-center" nowrap>Action</th>
                                                            </tr>
                                                        </thead> 
                                                        <tbody  id="ariDataTablePelamar" >
                                                        </tbody>                                                       
                                                    </table>
                                              </div>

                                            <!-- paging data table -->
                                            <input type="text" value="10" id="batasAwal" hidden >
                                            <input type="text" value="0" id="halKe" hidden >
                                            <input type="text" value="0" id="totalPage" hidden >
                                            <input type="text" value="0" id="jmlhRow" hidden >
                                            <div class="panel-heading-ari fixedBottomDiv">
                                                  <div class="row">
                                                      <div class="col-lg-5">
                                                          <div class="pangingDataList" style="margin-bottom:-5px; margin-left: 5px">
                                                          </div>
                                                      </div>
                                                      <div class="col-xs-2">
                                                           <div id="ketHal" style="margin:3% 1%;  " ></div>
                                                      </div>
                                                  </div>
                                            </div>
                                            
                                            
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
                                    <a href="#"  >View Details <i class="fa fa-arrow-circle-right"></i></a>
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
                  
<!-- popup add user -->
<div class="modal fade" id="v_edit" tabindex="-1" role="dialog" aria-labelledby="add" aria-hidden="true">
      <div class="modal-dialog-ari-input">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <div class="panel-primary">View</div>
            </div>
      
              <div class="panel panel-primary">
    
    <div class="panel-body">
  <form accept-charset="UTF-8" class="simple_form form-horizontal" enctype="multipart/form-data" id="data_gaji" method="post" novalidate="novalidate"><div style="display:none"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="lp7W9OMoGAJyeuqwnKqv+ELvU8RNxAatkSp6gJsHa3k=" type="hidden"></div>
      <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> ID</label><div class="col-sm-4"><input id="id" disabled name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Nama</label><div class="col-sm-7"><input id="nama" disabled class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Jumlah Cuti Tahunan</label><div class="col-sm-2"><input id="jum_cut_tahunan" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Jumlah Cuti 5 Tahunan</label><div class="col-sm-2"><input id="jum_cut_5_tahunan" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Jabatan</label><div class="col-sm-7">
       <select  id="jabatan_ari" class="col-xs-8 padding_left">
            <option value="Presiden Direktur">Presiden Direktur</option>
            <option value="Direktur">Direktur</option>
            <option value="General Manager">General Manager</option>
            <option value="Manager IT">Manager IT</option>
            <option value="Manager Logistik">Manager Logistik</option>
            <option value="Manager Accounting">Manager Accounting</option>
            <option value="Manager Finance">Manager Finance</option>
            <option value="Manager Operational">Manager Operational</option>
            <option value="Manager HRD">Manager HRD</option>
            <option value="Manager Marketing">Manager Marketing</option>
            <option value="Supervisor">Supervisor</option>
            <option value="Staff Trainer">Staff Trainer</option>
            <option value="Staff IT">Staff IT</option>
            <option value="Staff Logistik">Staff Logistik</option>
            <option value="staff Accounting">Staff Accounting</option>
            <option value="staff Finance">Staff Finance</option>
            <option value="Staff Operational">Staff Operational</option>
            <option value="Staff HRD">Staff HRD</option>
            <option value="Staff Marketing">Staff Marketing</option>
            <option value="Staff Administration">Staff Administration</option>
            <option value="Outlet Development">Outlet Development</option>
            <option value="Oultet Head">Oultet Head</option>
            <option value="Junior Oultet Head">Junior Oultet Head</option>
            <option value="Mechanic">Mechanic</option>
      </select>
      </div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Area</label><div class="col-sm-7">
        <select class="col-sm-6 f_s_plmr" id="area">
            <option value="0" disabled="" selected="">Area</option>
            <option value="1">Jakarta</option>
            <option value="2">Jawa Barat</option>
            <option value="3">Jawa Tengah</option>
            <option value="4">Jogjakarta</option>
            <option value="5">Bali</option>
        </select>
      </div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Cabang</label><div class="col-sm-7"><input id="cabang" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Gaji Pokok</label><div class="col-sm-5"><input id="g_pkok" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Kerajian</label><div class="col-sm-5"><input id="t_kjinan" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Operational</label><div class="col-sm-5"><input id="t_op" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Bpjs Ketenagakerjaan</label><div class="col-sm-5"><input id="t_bpjs_ktnagakerjaan" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Bpjs Kesehatan</label><div class="col-sm-5"><input id="t_bpjs_kes" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Kesehatan</label><div class="col-sm-5"><input id="t_kes" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Penepatan</label><div class="col-sm-5"><input id="t_pen" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Transportasi</label><div class="col-sm-5"><input id="t_tran" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Makan</label><div class="col-sm-5"><input id="t_makan" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Jabatan</label><div class="col-sm-5"><input id="t_jab" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Tun. Lainnya</label><div class="col-sm-5"><input id="t_lain" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Pot. Pinjaman Karyawan</label><div class="col-sm-5"><input id="p_pin_kar" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Pot. Bpjs Ketenagakerjaan</label><div class="col-sm-5"><input id="p_bpjs_ket" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Pot. Bpjs Kesehatan</label><div class="col-sm-5"><input id="p_bpjs_kes" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Pot. Asr Kesehatan</label><div class="col-sm-5"><input id="p_asr_kes" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Pot. Denda Kedisiplinan</label><div class="col-sm-5"><input id="p_den" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Pot. Pajak</label><div class="col-sm-5"><input id="p_pjk" name="nama_ari" class="col-xs-12 padding_left" type="text"></div></div>
  <input id="tgl_dibuat" name="nama_ari" class="col-xs-12 padding_left" type="text" hidden>
  <div class="form-group2"><label class="col-sm-5 control-label"><abbr title="required">*</abbr> Status Karyawan</label><div class="col-sm-7">
     
        <label class="radio-inline">
            <input name="sts_pegawai" value="0" type="radio">Training
        </label>
        <label class="radio-inline">
            <input name="sts_pegawai" value="1" type="radio">Kontrak
        </label>
        <label class="radio-inline">
            <input name="sts_pegawai" value="2" type="radio">Tetap
        </label>

  </div></div>
  
  <div class="form-group2">
    <label class="col-sm-5 control-label"><abbr title="required">*</abbr> Periode Kontrak</label>
    <div class="col-sm-7 " style="display: inline-block;">
          <div class="col-sm-5">
              <input style="width: 100%" id="p_kontrak_f" class="padding_left" placeholder="From Date" type="text"> <div class="text center" id="date_f">(dd/mm/yyyy)</div>
          </div>
        <div class="col-sm-1">
               -
          </div>
         <div class="col-sm-5">
               <input style="width: 100%" id="p_kontrak_e" class="padding_left " placeholder="End Date" type="text"> <div class="text center" id="date_e">(dd/mm/yyyy)</div>
          </div>
    </div>
  </div>

</form>
    </div>
  </div>
           
           <div class="modal-footer ">
            <button type="button" id="save_data" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Save</button>
            <div id="ajaxResponseError" class="error text-center"></div>
           </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
</div>

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
    <!-- http://tutorialzine.com/2010/12/better-confirm-box-jquery-css3/ -->
    <script type="text/javascript" src="js/jquery.confirm.js"></script>
     <!-- oprek sendiri -->
      <!--<script src="js/master_pelamar_validation.js" type="text/javascript"></script>-->
    <!--<script src="ajax/master_pelamar_save.js" type="text/javascript"></script> -->
    <!-- <script src="js/select2.js" type="text/javascript"></script> -->
        
    <!-- sample http://jsfiddle.net/achmatim/5pfm2Lg4/ -->
    <script src="js/jquery.maskMoney.js" type="text/javascript"></script>
    <script src="js/master_karyawan.js" type="text/javascript"></script>
     
    <!-- http://wenzhixin.net.cn/p/bootstrap-table/docs/examples.html -->
    <!-- <script src="js/bootstrap-table.js" type="text/javascript"></script>  -->
</body>
      <%} 
        %>
</html>
