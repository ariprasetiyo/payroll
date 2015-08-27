<%-- 
    Document   : index.jsp
    Created on : Feb 25, 2015, 4:36:29 PM
    Author     : arprast
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %> 
<!DOCTYPE html>
<html lang="en" id="content">
        <%
            if ((session.getAttribute("useridariprasetiyo") == null) || (session.getAttribute("useridariprasetiyo") == "")) {
                response.sendRedirect("../");
      %>    
       
        <%} else {
        %>
<head>
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
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/main.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
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
                <a class="navbar-brand" href="index.html">SB Admin</a>
            </div>
            
            <!-- Top Menu Items -->
            <ul class="nav navbar-left top-nav">
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
            <ul class="nav navbar-right top-nav ">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smasith <b class="caret"></b></a>
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
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
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
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="fa fa-info-circle"></i>  <strong>Like SB Admin?</strong> Try out <a href="http://startbootstrap.com/template-overviews/sb-admin-2" class="alert-link">SB Admin 2</a> for additional features!
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">26</div>
                                        <div>New Comments!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">12</div>
                                        <div>New Tasks!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">124</div>
                                        <div>New Orders!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-support fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">13</div>
                                        <div>Support Tickets!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Area Chart</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i> Donut Chart</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                                <div class="text-right">
                                    <a href="#">View Details <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-clock-o fa-fw"></i> Tasks Panel</h3>
                            </div>
                            <div class="panel-body">
                                <div class="list-group">
                                    <a href="#" class="list-group-item">
                                        <span class="badge">just now</span>
                                        <i class="fa fa-fw fa-calendar"></i> Calendar updated
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">4 minutes ago</span>
                                        <i class="fa fa-fw fa-comment"></i> Commented on a post
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">23 minutes ago</span>
                                        <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">46 minutes ago</span>
                                        <i class="fa fa-fw fa-money"></i> Invoice 653 has been paid
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">1 hour ago</span>
                                        <i class="fa fa-fw fa-user"></i> A new user has been added
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">2 hours ago</span>
                                        <i class="fa fa-fw fa-check"></i> Completed task: "pick up dry cleaning"
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">yesterday</span>
                                        <i class="fa fa-fw fa-globe"></i> Saved the world
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">two days ago</span>
                                        <i class="fa fa-fw fa-check"></i> Completed task: "fix error on sales page"
                                    </a>
                                </div>
                                <div class="text-right">
                                    <a href="#">View All Activity <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Transactions Panel</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Order #</th>
                                                <th>Order Date</th>
                                                <th>Order Time</th>
                                                <th>Amount (USD)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>3326</td>
                                                <td>10/21/2013</td>
                                                <td>3:29 PM</td>
                                                <td>$321.33</td>
                                            </tr>
                                            <tr>
                                                <td>3325</td>
                                                <td>10/21/2013</td>
                                                <td>3:20 PM</td>
                                                <td>$234.34</td>
                                            </tr>
                                            <tr>
                                                <td>3324</td>
                                                <td>10/21/2013</td>
                                                <td>3:03 PM</td>
                                                <td>$724.17</td>
                                            </tr>
                                            <tr>
                                                <td>3323</td>
                                                <td>10/21/2013</td>
                                                <td>3:00 PM</td>
                                                <td>$23.71</td>
                                            </tr>
                                            <tr>
                                                <td>3322</td>
                                                <td>10/21/2013</td>
                                                <td>2:49 PM</td>
                                                <td>$8345.23</td>
                                            </tr>
                                            <tr>
                                                <td>3321</td>
                                                <td>10/21/2013</td>
                                                <td>2:23 PM</td>
                                                <td>$245.12</td>
                                            </tr>
                                            <tr>
                                                <td>3320</td>
                                                <td>10/21/2013</td>
                                                <td>2:15 PM</td>
                                                <td>$5663.54</td>
                                            </tr>
                                            <tr>
                                                <td>3319</td>
                                                <td>10/21/2013</td>
                                                <td>2:13 PM</td>
                                                <td>$943.45</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="text-right">
                                    <a href="#">View All Transactions <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Morris Charts JavaScript 
    <script src="admin/js/plugins/morris/raphael.min.js"></script>
    <script src="admin/js/plugins/morris/morris.min.js"></script>
    <script src="admin/js/plugins/morris/morris-data.js"></script>

    <!--  v2.1.1  
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    -->
    <script src="js/jquery.min.js"></script>
   
    <!--<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>-->
    <!-- Bootstrap Core JavaScript v3.3.2 -->
    <script src="js/bootstrap.min.js"></script>

    <!--
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    -->
    <script src="js/jquery-ui.min.js"></script>
    <script>

        
    </script>
   
    

</body>
      <%} 
        %>
</html>
