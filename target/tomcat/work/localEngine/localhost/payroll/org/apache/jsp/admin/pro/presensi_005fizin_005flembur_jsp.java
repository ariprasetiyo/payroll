package org.apache.jsp.admin.pro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class presensi_005fizin_005flembur_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:substring", org.apache.taglibs.standard.functions.Functions.class, "substring", new Class[] {java.lang.String.class, int.class, int.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" >\n");
      out.write("    ");
 if ((session.getAttribute("useridariprasetiyo") == null) || (session.getAttribute("useridariprasetiyo") == "")) { response.sendRedirect("../");
      out.write("    \n");
      out.write("    ");
} else { 
      out.write("\n");
      out.write("<head >\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>SB Admin - Bootstrap Admin Template</title>\n");
      out.write("    \n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Morris Charts CSS -->\n");
      out.write("   <!--<link href=\"css/plugins/morris.css\" rel=\"stylesheet\"> -->\n");
      out.write("   \n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"> \n");
      out.write("    \n");
      out.write("    <!--<link href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" -->\n");
      out.write("    <link href=\"css/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    \n");
      out.write("    <!-- customize css -->\n");
      out.write("    <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("     <!-- tabel css -->\n");
      out.write("    <!-- <link href=\"css/bootstrap-table.css\" rel=\"stylesheet\"> -->\n");
      out.write("    \n");
      out.write("    <!-- text editor -->\n");
      out.write("     <link href=\"css/editor.css\" rel=\"stylesheet\">\n");
      out.write("     \n");
      out.write("    <!-- date range  http://eternicode.github.io/bootstrap-datepicker/? -->\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.datepick.css\"> \n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("    \n");
      out.write("    <!-- autocomplate --->\n");
      out.write("    <link href=\"css/select2.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <!--<link href=\"//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- <link href=\"http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0-beta.3/css/select2.min.css\" rel=\"stylesheet\" /> -->\n");
      out.write("    \n");
      out.write("    <!-- <link href=\"css/select2.min.css\" rel=\"stylesheet\" /> -->\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.confirm.css\" />\n");
      out.write("    \n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        #gb{\n");
      out.write("            position:fixed;\n");
      out.write("            top:50px;\n");
      out.write("            z-index:+1000;\n");
      out.write("        }\n");
      out.write("        * html #gb{position:relative;}\n");
      out.write("        .gbtab{\n");
      out.write("            height:120px;\n");
      out.write("            width:40px;\n");
      out.write("            float:left;\n");
      out.write("            cursor:pointer;\n");
      out.write("            background:url('../admin/gambar/chat-box.png')\n");
      out.write("            no-repeat; \n");
      out.write("        }\n");
      out.write("        .gbcontent{\n");
      out.write("            float:left;\n");
      out.write("            border:2px solid #444444;\n");
      out.write("            background:#F5F5F5;\n");
      out.write("            padding:10px;\n");
      out.write("        }\n");
      out.write("       \n");
      out.write("    </style>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function showHideGB(){\n");
      out.write("        var gb = document.getElementById(\"gb\");\n");
      out.write("        var w = gb.offsetWidth;\n");
      out.write("        gb.opened ? moveGB(0, 30-w) : moveGB(20-w, 0);\n");
      out.write("        gb.opened = !gb.opened;\n");
      out.write("    }\n");
      out.write("    function moveGB(x0, xf){\n");
      out.write("        var gb = document.getElementById(\"gb\");\n");
      out.write("        var dx = Math.abs(x0-xf) > 10 ? 5 : 1;\n");
      out.write("        var dir = xf>x0 ? 1 : -1;\n");
      out.write("        var x = x0 + dx * dir;\n");
      out.write("        gb.style.right = x.toString() + \"px\";\n");
      out.write("        if(x0!=xf){setTimeout(\"moveGB(\"+x+\", \"+xf+\")\", 10);}\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body id=\"content\">\n");
      out.write("    <div id=\"wrapper\" class=\"main-contents\">\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#menu\" id=\"menu-utama\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                 </button>\n");
      out.write("                <!-- <a class=\"navbar-brand\" href=\"index.html\">Arprast</a> -->\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- Top Menu Items \n");
      out.write("                 display mobile nav navbar-nav side-nav = menu di samping\n");
      out.write("            -->\n");
      out.write("            <div id=\"menu\" class=\"collapse navbar-collapse\">\n");
      out.write("            <div id=\"menu-side\" class=\"navbar-nav side-nav\"></div>\n");
      out.write("            <!-- tidak digunakan dulu difungsikan untuk ambil menu AJAX low prioritas -->\n");
      out.write("            <!-- \n");
      out.write("            <script  type=\"text/javascript\">\n");
      out.write("            $.get(\"master_pelamar.ari?xcv=m\", {ambil_data_id:id} ,function(data) {\n");
      out.write("                 $(\"input#ref_code_ari\").val(data.topMenu.refCode );\n");
      out.write("            });\n");
      out.write("            </script>\n");
      out.write("            -->\n");
      out.write("            \n");
      out.write("            <ul id=\"menu-change\" class=\"nav navbar-left top-nav\" >\n");
      out.write("              <!-- \n");
      out.write("                bagian menu\n");
      out.write("                keterangan tentang tag\n");
      out.write("                Keterangn menu2 dalam database\n");
      out.write("                Tag adalah menentukan posisi <ul> dan </ul>\n");
      out.write("                   0 = menu utama tanpa link\n");
      out.write("                   1 = menu utama dengan link\n");
      out.write("                   2 = sub menu <li>( pertama ) dengan <ul>\n");
      out.write("                   3 = sub menu \n");
      out.write("                   4 = sub menu </li> penutup dengan </ul>\n");
      out.write("                   5 = sub menu sub menu <li> ( pertama dengan < ul>\n");
      out.write("                   6 = sub menu sub menu \n");
      out.write("                   7 = sub menu sub menu <li> ( penutup dengan </ ul>\n");
      out.write("                   8 = sub menu tapi hanya satu dan dengan link sub menu\n");
      out.write("                   9 = sub menu tapi tanpa link sub menu\n");
      out.write("\n");
      out.write("                 kemudian sub_link / subLink adalah menentukan \n");
      out.write("                 ada sub menu lagi atau tidak di bawahnya\n");
      out.write("                     0 = tanpa link / tidak ada sub menu lagi atau tidak ada link lagi\n");
      out.write("                     1 = dengan link / ada menu lagi \n");
      out.write("             -->\n");
      out.write("  \n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("    \n");
      out.write("            \n");
      out.write("            </ul>\n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"nav navbar-right top-nav\">\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-user\"></i><b id=\"usernya\"> Ari Prasetiyo </b><b class=\"caret\"></b></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-fw fa-user\"></i> Profile</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-fw fa-envelope\"></i> Inbox</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-fw fa-gear\"></i> Settings</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"logout.ari\"><i class=\"fa fa-fw fa-power-off\"></i> Log Out</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("            <!-- id=meun -->\n");
      out.write("            </div>\n");
      out.write("            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->\n");
      out.write("            \n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"gb\">\n");
      out.write("        <div class=\"gbtab\" onclick=\"showHideGB()\"> </div>\n");
      out.write("        <div class=\"gbcontent\">\n");
      out.write("              \n");
      out.write("                    <ul class=\"nav\">\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"index.html\"><i class=\"fa fa-fw fa-dashboard\"></i> Dashboard</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"charts.html\"><i class=\"fa fa-fw fa-bar-chart-o\"></i> Charts</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"tables.html\"><i class=\"fa fa-fw fa-table\"></i> Tables</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"forms.html\"><i class=\"fa fa-fw fa-edit\"></i> Forms</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"bootstrap-elements.html\"><i class=\"fa fa-fw fa-desktop\"></i> Bootstrap Elements</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"bootstrap-grid.html\"><i class=\"fa fa-fw fa-wrench\"></i> Bootstrap Grid</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"javascript:;\" data-toggle=\"collapse\" data-target=\"#demo\"><i class=\"fa fa-fw fa-arrows-v\"></i> Dropdown <i class=\"fa fa-fw fa-caret-down\"></i></a>\n");
      out.write("                        <ul id=\"demo\" class=\"collapse\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Dropdown Item</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Dropdown Item</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Dropdown Item</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Dropdown Item</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Dropdown Item</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Dropdown Item</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Dropdown Item</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"blank-page.html\"><i class=\"fa fa-fw fa-file\"></i> Blank Page</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index-rtl.html\"><i class=\"fa fa-fw fa-dashboard\"></i> RTL Dashboard</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("   \n");
      out.write("            <div style=\"text-align:right\">\n");
      out.write("            <a><font size=\"1\">...</font></a><a href=\"javascript:showHideGB()\">\n");
      out.write("            [close]\n");
      out.write("            </a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        var gb = document.getElementById(\"gb\");\n");
      out.write("        gb.style.right = (30-gb.offsetWidth).toString() + \"px\";\n");
      out.write("        </script>\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <!-- Page Heading -->          \n");
      out.write("                <div class=\"row paling_atas\">\n");
      out.write("                    <div class=\"col-lg-16\">\n");
      out.write("                        <h4 class=\"alert alert-info alert-dismissable\">\n");
      out.write("                            Presensi \n");
      out.write("                        </h4>                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("                \n");
      out.write("                <!-- data input karyawan -->\n");
      out.write("                <div class=\"row\">                   \n");
      out.write("                    <div class=\"col-lg-5\">\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <h3 class=\"panel-title\"><i class=\"fa fa-long-arrow-right fa-fw\"></i>Data Izin / Lembur</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body-ari-customize\">\n");
      out.write("                                \n");
      out.write("                               <!--\n");
      out.write("                                <div class=\"col-xs-3 form-input-data-bottom-10\" >\n");
      out.write("                                        <label >Ref code</label>\n");
      out.write("                                </div>                               \n");
      out.write("                                <div class=\"col-xs-8 form-input-data-bottom-10\" >\n");
      out.write("                                    <input  type=\"text\" name=\"ref_code\" style=\"width: 100%\"  disabled>\n");
      out.write("                                </div>                           \n");
      out.write("                            \n");
      out.write("                                <div class=\"col-xs-3 form-input-data-bottom-10\" >\n");
      out.write("                                    <label  >Nama Lengkap</label>\n");
      out.write("                                </div>                               \n");
      out.write("                                <div class=\"col-xs-9 form-input-data-bottom-10\">\n");
      out.write("                                    <input type=\"text\" name=\"ref_code\" style=\"width: 100%\"   disabled>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-xs-3 form-input-data-bottom-10\">\n");
      out.write("                                    <label >Tanggal Lahir</label>\n");
      out.write("                                </div>                               \n");
      out.write("                                <div class=\"col-xs-6 form-input-data-bottom-10\">\n");
      out.write("                                    <input type=\"text\" name=\"ref_code\" style=\"width: 100%\"  disabled>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                <div class=\"col-xs-3 form-input-data-bottom-10\">\n");
      out.write("                                    <label >Tanggal Lahir</label>\n");
      out.write("                                </div>                               \n");
      out.write("                                <div class=\"col-xs-7 form-input-data-bottom-10\">\n");
      out.write("                                    <input type=\"text\" name=\"ref_code\" style=\"width: 100%\"  disabled>\n");
      out.write("                                </div>\n");
      out.write("                                -->\n");
      out.write("                                <div class=\"form-group\" >\n");
      out.write("                                    <form id=\"form-ari\" >\n");
      out.write("                                    <div class=\"panel-body \">\n");
      out.write("                                        \n");
      out.write("                                     <div role=\"tabpanel\">\n");
      out.write("                                        <!-- Nav tabs -->\n");
      out.write("                                        <ul class=\"nav nav-tabs\" role=\"tablist\">\n");
      out.write("                                          <li role=\"presentation\" id=\"home_detection\" class=\"active\" ><a href=\"#home\" aria-controls=\"home\" role=\"tab\" data-toggle=\"tab\">Izin Cuti</a></li>\n");
      out.write("                                          <li role=\"presentation\" id=\"izin_sakit_detection\" ><a href=\"#izin_sakit\" aria-controls=\"izin_sakit\" role=\"tab\" data-toggle=\"tab\">Izin Sakit</a></li>\n");
      out.write("                                          <li role=\"presentation\" id=\"form_lembur_decetion\" ><a href=\"#form_lembur\" aria-controls=\"form_lembur\" role=\"tab\" data-toggle=\"tab\">Lembur</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("\n");
      out.write("                                        <!-- Tab panes -->\n");
      out.write("                                        <div class=\"tab-content\">\n");
      out.write("                                            <div role=\"tabpanel\" class=\"tab-pane active\" id=\"home\">\n");
      out.write("                                                <div data-amount='0' data-tax-rate='0' data-track-inventory='true' data-trade-in-amount='0'>\n");
      out.write("                                                    <table class=\"table\">\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td class=\"col-xs-3\">Ref Code</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"ref_izin_cuti\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td class=\"col-xs-3\">Tanggal Buat</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"tanggal_buat_izin_cuti\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Nama & Id Karyawan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                          <select class=\"js-data-example-ajaxs\" id=\"search_select_karyawan\">\n");
      out.write("                                                                <option value=\"-\" selected=\"selected\" id=\"select2ValueAriIzin\" class=\"removeSelect2\" >-</option>\n");
      out.write("                                                          </select>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Jabatan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"jabatan_ari_izin_cuti\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <!--<input id=\"jabatan_ari\" name='jabatan_ari' type=\"text\" class=\"col-xs-12 padding_left\">-->\n");
      out.write("                                                         </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                     <tr>\n");
      out.write("                                                        <td>Jenis Izin Cuti</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <select id=\"jenis_izin_cuti_ari\" class=\"col-xs-7 padding_left\">\n");
      out.write("                                                                <option value=\"0\">Cuti Tahunan</option>\n");
      out.write("                                                                <option value=\"1\">Cuti 5 Tahunan</option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr> \n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Jumlah Cuti</td>\n");
      out.write("                                                       <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"col-xs-2\">\n");
      out.write("                                                                <input id=\"jum_izin_cuti\" name=\"jum_izin_cuti\" style = \"width:80%\" class=\"padding_left\">\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"col-xs-3 padding_left\">Sisa Cuti</div>\n");
      out.write("                                                            <div class=\"col-xs-2\">\n");
      out.write("                                                                 <input disabled id=\"sisa_izin_cuti\" style = \"width:80%\" name=\"sisa_izin_cuti\" class=\"padding_left\">\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td style=\"width: 90px\">Tgl Mulai Cuti</td>\n");
      out.write("                                                        <td><input id=\"tgl_cuti_mulai\" name=\"tanggal_lahir_ari\"  type=\"text\" data-date-format=\"mm/dd/yyyy\" class=\"col-xs-4 datepicker padding_left\" ></td>\n");
      out.write("                                                        \n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td style=\"width: 120px\">Tgl Selesai Cuti</td>\n");
      out.write("                                                        <td><input id=\"tgl_cuti_selesai\" name=\"tanggal_lahir_ari\"  type=\"text\" data-date-format=\"mm/dd/yyyy\" class=\"col-xs-4 datepicker padding_left\" ></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Keterangan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <textarea style=\"height:50px\" id=\"ket_izin_cuti\" name=\"alamat_ari\"  class=\"col-xs-12 padding_left\" ></textarea>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </table>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        <div role=\"tabpanel\" class=\"tab-pane\" id=\"izin_sakit\">  \n");
      out.write("                                           \n");
      out.write("                                                \n");
      out.write("                                                    <table class=\"table\">\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td class=\"col-xs-3\">Ref Code</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"ref_code_izin_sakit\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td class=\"col-xs-3\">Tanggal Buat</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"tanggal_buat_izin_sakit\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Nama & Id Karyawan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                          <select class=\"js-data-example-ajaxs\" id=\"search_select_karyawan_sakit\">\n");
      out.write("                                                                <option value=\"-\" selected=\"selected\" id=\"select2ValueAriSakit\" class=\"removeSelect2\" >-</option>\n");
      out.write("                                                          </select>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                   \n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Jabatan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"jabatan_ari_izin_sakit\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <!--<input id=\"jabatan_ari\" name='jabatan_ari' type=\"text\" class=\"col-xs-12 padding_left\">-->\n");
      out.write("                                                         </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Jumlah Izin Sakit</td>\n");
      out.write("                                                        <td >\n");
      out.write("                                                            <input id=\"jum_izin_sakit\" name=\"kode_pos_ari\" class=\"col-xs-1 padding_left\">\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    \n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td style=\"width: 90px\">Tgl Mulai Izin Sakit</td>\n");
      out.write("                                                        <td><input id=\"tgl_izin_sakit_mulai\" name=\"tanggal_lahir_ari\"  type=\"text\" data-date-format=\"mm/dd/yyyy\" class=\"col-xs-4 datepicker padding_left\" ></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td style=\"width: 150px\">Tgl Selesai Izin Sakit</td>\n");
      out.write("                                                        <td><input id=\"tgl_izin_sakit_selesai\" name=\"tanggal_lahir_ari\"  type=\"text\" data-date-format=\"mm/dd/yyyy\" class=\"col-xs-4 datepicker padding_left\" ></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                   \n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Keterangan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <textarea style=\"height:50px\" id=\"ket_izin_sakit\" name=\"alamat_ari\"  class=\"col-xs-12 padding_left\" ></textarea>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </table>\n");
      out.write("                                                \n");
      out.write("                                        </div>\n");
      out.write("                                            <!-- class untuk setvalue, id txtEditor untuk getvalue  -->\n");
      out.write("                                          <div role=\"tabpanel\" class=\"tab-pane\" id=\"form_lembur\">  \n");
      out.write("                                                 <table class=\"table\">\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td class=\"col-xs-3\">Ref Code</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"ref_code_form_lembur\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td class=\"col-xs-3\">Tanggal Buat</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"tanggal_buat_form_lembur\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Nama & Id Karyawan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                          <select class=\"js-data-example-ajaxs\" id=\"search_select_karyawan_lembur\">\n");
      out.write("                                                                <option value=\"-\" selected=\"selected\" id=\"select2ValueAriLembur\" class=\"removeSelect2\" >-</option>\n");
      out.write("                                                          </select>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                   \n");
      out.write("                                                    <tr>\n");
      out.write("                                                       <td>Jabatan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <div class=\"form-group has-error\">   \n");
      out.write("                                                                <input id=\"jabatan_ari_lembur\"  type=\"text\" class=\"col-xs-5 padding_left\" disabled>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <!--<input id=\"jabatan_ari\" name='jabatan_ari' type=\"text\" class=\"col-xs-12 padding_left\">-->\n");
      out.write("                                                         </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Katagori Lembur</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <select id=\"katagori_form_lembur\" class=\"col-xs-4 padding_left\">\n");
      out.write("                                                                <option value=\"3\">3 Jam</option>\n");
      out.write("                                                                <option value=\"8\">8 jam</option>\n");
      out.write("                                                                <option value=\"12\">12 jam </option>\n");
      out.write("                                                            </select>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr> \n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Jumlah Lembur</td>\n");
      out.write("                                                        <td >\n");
      out.write("                                                            <input id=\"jum_lembur\" name=\"kode_pos_ari\" class=\"col-xs-1 padding_left\">\n");
      out.write("                                                        </td>\n");
      out.write("                                                        \n");
      out.write("                                                    </tr>\n");
      out.write("                                                    \n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td style=\"width: 90px\">Tgl Mulai Lembur</td>\n");
      out.write("                                                        <td><input id=\"tgl_lembur_mulai\" name=\"tanggal_lahir_ari\"  type=\"text\" data-date-format=\"mm/dd/yyyy\" class=\"col-xs-4 datepicker padding_left\" ></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td style=\"width: 120px\">Tgl Selesai Lembur</td>\n");
      out.write("                                                        <td><input id=\"tgl_lembur_selsai\" name=\"tanggal_lahir_ari\"  type=\"text\" data-date-format=\"mm/dd/yyyy\" class=\"col-xs-4 datepicker padding_left\" ></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                   \n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Keterangan</td>\n");
      out.write("                                                        <td colspan=\"3\">\n");
      out.write("                                                            <textarea style=\"height:50px\" id=\"ket_form_lembur\" name=\"alamat_ari\"  class=\"col-xs-12 padding_left\" ></textarea>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                               \n");
      out.write("                                                </table>\n");
      out.write("                                               \n");
      out.write("                                          </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- tombol save, edit, new ,reset -->\n");
      out.write("                                    <div class=\"panel-ari panel-default\">\n");
      out.write("                                        <div  id=\"status_save\" hidden >0</div>\n");
      out.write("                                        <div  id=\"status_edit\" hidden >0</div>\n");
      out.write("                                        <div id=\"ajaxResponseError\" class=\"error text-center\"></div>\n");
      out.write("                                        <div class=\"panel-heading-ari text-center fixedBottomDiv\">\n");
      out.write("                                            <a id=\"pelamar_save\" class=\"btn btn-primary\" >Save</a>\n");
      out.write("                                            <button id=\"pelamar_edit\" type=\"submit\" class=\"btn btn-primary\">Edit</button>\n");
      out.write("                                            <button id=\"pelamar_delete\" type=\"submit\" class=\"btn btn-primary disabled\">Delete</button>\n");
      out.write("                                            <button id=\"pelamar_new\"  type=\"submit\" class=\"btn btn-primary\">New</button>\n");
      out.write("                                            <a id=\"pelamar_print_data\" class=\"btn btn-primary\" >Print</a>\n");
      out.write("                                            <a id=\"pelamar_print\" href=\"master_pelamar.ari?sta=4&xcv=4\" class=\"btn btn-primary\" >Print Form</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write(" \n");
      out.write("                                    </form> \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-7 \">\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <h3 class=\"panel-title\"><i class=\"fa fa-long-arrow-right fa-fw\"></i>List Data Izin / Lembur</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                          <!-- tombol filter -->\n");
      out.write("                                        <div class=\"col-sm-12 alert alert-info alert-dismissable\">\n");
      out.write("                                            <div class=\"form-group\" style='width:100%'>\n");
      out.write("                                                <div class=\"col-sm-10\" >\n");
      out.write("                                                     <div class=\"col-sm-2\" >\n");
      out.write("                                                    <input type=\"text\" style=\"width: 100%\" class=\"padding_left f_id\" placeholder=\"Ref no\" > \n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"col-sm-2\" >\n");
      out.write("                                                        <input type=\"text\" style=\"width: 100%\" class=\"padding_left f_id_kar\" placeholder=\"Id Karyawan\" > \n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"col-sm-2\">\n");
      out.write("                                                        <input  type=\"text\" style=\"width: 100%\" class=\"padding_left f_nama\" placeholder=\"Nama\"> \n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"col-sm-3\">  \n");
      out.write("                                                        <input  type=\"text\" style=\"width: 100%\" class=\"padding_left f_jabatan\" placeholder=\"Jabatan\"> \n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"col-sm-3\"> \n");
      out.write("                                                        <input  type=\"text\" style=\"width: 100%\" id=\"filterRange\" class=\"padding_left f_tgl_buat\" placeholder=\"Tanggal buat\"> \n");
      out.write("                                                    </div>\n");
      out.write("                                                    <!--\n");
      out.write("                                                    <div class=\"col-sm-2\"> \n");
      out.write("                                                        <input  type=\"text\" style=\"width: 100%\" class=\"padding_left f_status_pelamar\" placeholder=\"Status Pelamar\"> \n");
      out.write("                                                    </div>\n");
      out.write("                                                    -->\n");
      out.write("                                                    <select class=\"col-sm-2 f_s_plmr\" style=\"margin-top:5px\" >\n");
      out.write("                                                        <option disabled selected>Status Presensi</option>\n");
      out.write("                                                        <option value=\"4\">All</option>\n");
      out.write("                                                        <option value=\"0\">Izin Cuti</option>\n");
      out.write("                                                        <option value=\"1\">Izin Sakit</option>\n");
      out.write("                                                        <option value=\"2\">Lembur</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-sm-1\"> \n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-primary b_filter\">Filter</button>\n");
      out.write("                                                </div>\n");
      out.write("                                                                                                                               \n");
      out.write("                                            </div>       \n");
      out.write("                                          </div>\n");
      out.write("                                        <div class=\"col-sm-12\">\n");
      out.write("                                        <div class=\"panel panel-default \">\n");
      out.write("                                                <div class=\"table-responsive\">\n");
      out.write("                                            <!-- <div  style=\"width: 100%; height: 100%x; overflow: auto;\"> -->\n");
      out.write("                                              <!--  <div style=\"display: table; table-layout: fixed; width: 250%;\"> -->\n");
      out.write("                                                  <table id=\"table-pagination\" class=\"table table-bordered table-hover table-striped\">\n");
      out.write("                                                        <thead  class='alert alert-info alert-dismissable'>\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <th class=\"text-center\">Ref No</th>\n");
      out.write("                                                            <th class=\"text-center\">Id Karyawan</th>\n");
      out.write("                                                            <th class=\"text-center\">Nama</th>\n");
      out.write("                                                            <th class=\"text-center\">Jabatan</th>\n");
      out.write("                                                            <th class=\"text-center\">Status Presensi</th>\n");
      out.write("                                                            <th class=\"text-center\">Tgl Mulai</th>\n");
      out.write("                                                            <th class=\"text-center\">Tgl Selesai</th>\n");
      out.write("                                                            <th class=\"text-center\">Keterangan</th>\n");
      out.write("                                                            <th class=\"text-center\">Created</th>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        </thead > \n");
      out.write("                                                        <tbody  id=\"ariDataTablePelamar\" >\n");
      out.write("                                                        </tbody>                                                       \n");
      out.write("                                                    </table>\n");
      out.write("                                                </div>\n");
      out.write("                                              <!--</div>\n");
      out.write("                                            </div>\n");
      out.write("                                              -->\n");
      out.write("                                            <!-- paging data table -->\n");
      out.write("                                            <input type=\"text\" value=\"10\" id=\"batasAwal\" hidden >\n");
      out.write("                                            <input type=\"text\" value=\"0\" id=\"halKe\" hidden >\n");
      out.write("                                            <input type=\"text\" value=\"0\" id=\"totalPage\" hidden >\n");
      out.write("                                            <input type=\"text\" value=\"0\" id=\"jmlhRow\" hidden >\n");
      out.write("                                            <div class=\"pangingDataList\" style=\"margin-bottom:-20px; margin-left: 5px\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div id=\"ketHal\" style=\"margin-left: 10px; margin-bottom:5px; \" ></div>\n");
      out.write("                                            <!-- example\n");
      out.write("                                            <ul class=\"pagination\"\n");
      out.write("                                                <li><a href=\"#\" class=\"\">&laquo;</a></li>\n");
      out.write("                                                 <li class=\"halaman active\" id=\"10\"><a href=\"#\">1</a></li>\n");
      out.write("                                                 <li id=\"2\"><a href=\"#\" id=\"1\">2</a></li>\n");
      out.write("                                                 <li><a href=\"#\"  id=\"1\" >3</a></li>\n");
      out.write("                                                 <li><a href=\"#\">4</a></li>\n");
      out.write("                                                 <li><a href=\"#\">&raquo;</a></li>\n");
      out.write("                                                 <li><a href=\"#\">5</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                            -->                           \n");
      out.write("                                            </div>\n");
      out.write("                                          </div>                                   \n");
      out.write("                                                        \n");
      out.write("                                <div class=\"text-right\">\n");
      out.write("                                    <a href=\"#\">View Details <i class=\"fa fa-arrow-circle-right\"></i></a>\n");
      out.write("                                </div>     \n");
      out.write("                            \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- end <div class=\"col-lg-7 \"> -->\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.container-fluid -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->                 \n");
      out.write("<!-- chart --><!--\n");
      out.write("    <script src=\"js/plugins/morris/raphael.min.js\"></script>\n");
      out.write("    <script src=\"js/plugins/morris/morris.min.js\"></script>\n");
      out.write("    <script src=\"js/plugins/morris/morris-data.js\"></script>\n");
      out.write("    -->\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!--\n");
      out.write("    <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js\"></script>\n");
      out.write("    -->\n");
      out.write("    <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!--<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!--\n");
      out.write("    lib pendukung select2\n");
      out.write("    -->\n");
      out.write("     <!-- autocomplate \n");
      out.write("    <script src=\"http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0-beta.3/js/select2.min.js\"></script>\n");
      out.write("     <script src=\"js/jquery.js\"></script>\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!--\n");
      out.write("    <script src=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js\"></script>\n");
      out.write("    -->\n");
      out.write("    <script src=\"js/jquery.validate.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!-- text editor\n");
      out.write("    https://mindmup.github.io/bootstrap-wysiwyg/\n");
      out.write("    -->\n");
      out.write("     <script src=\"js/editor.js\"></script>\n");
      out.write("    \n");
      out.write("     <!-- date range\n");
      out.write("     http://eternicode.github.io/bootstrap-datepicker/?\n");
      out.write("     -->\n");
      out.write("     <script src=\"js/all_loading.js\" type=\"text/javascript\"></script>\n");
      out.write("     <script type=\"text/javascript\" src=\"js/jquery.plugin.js\"></script> \n");
      out.write("     <script type=\"text/javascript\" src=\"js/jquery.datepick.js\"></script>\n");
      out.write("    <!-- http://tutorialzine.com/2010/12/better-confirm-box-jquery-css3/ -->\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.confirm.js\"></script>\n");
      out.write("     <!-- oprek sendiri -->\n");
      out.write("      <!--<script src=\"js/master_pelamar_validation.js\" type=\"text/javascript\"></script>-->\n");
      out.write("    <!--<script src=\"ajax/master_pelamar_save.js\" type=\"text/javascript\"></script> -->\n");
      out.write("    <!-- <script src=\"js/select2.js\" type=\"text/javascript\"></script> -->\n");
      out.write("    \n");
      out.write("    <!--http://www.position-absolute.com/creation/print/jquery.printPage.js -->\n");
      out.write("    <script src=\"js/jquery.printPage.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- \n");
      out.write("    autocomplite \n");
      out.write("    https://select2.github.io/examples.html\n");
      out.write("    -->\n");
      out.write("    <script src=\"js/select2.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!--<script src=\"http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js\"></script>-->\n");
      out.write("    <script src=\"js/master_presensi.js\" type=\"text/javascript\"></script>\n");
      out.write("     \n");
      out.write("    <!-- http://wenzhixin.net.cn/p/bootstrap-table/docs/examples.html -->\n");
      out.write("    <!-- <script src=\"js/bootstrap-table.js\" type=\"text/javascript\"></script>  -->\n");
      out.write("</body>\n");
      out.write("      ");
} 
        
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /admin/pro/presensi_izin_lembur.jsp(157,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("mnu");
    // /admin/pro/presensi_izin_lembur.jsp(157,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/admin/pro/presensi_izin_lembur.jsp(157,12) '${daftarMenu}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${daftarMenu}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /admin/pro/presensi_izin_lembur.jsp(157,12) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("counter");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                 ");
          if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("             \n");
          out.write("                 ");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /admin/pro/presensi_izin_lembur.jsp(158,17) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("levelMenu0");
    // /admin/pro/presensi_izin_lembur.jsp(158,17) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setScope("session");
    // /admin/pro/presensi_izin_lembur.jsp(158,17) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/admin/pro/presensi_izin_lembur.jsp(158,17) '${fn:substring(mnu.levelMenu, 0, 1)}'",_el_expressionfactory.createValueExpression(new org.apache.jasper.el.ELContextWrapper(_jspx_page_context.getELContext(),_jspx_fnmap_0),"${fn:substring(mnu.levelMenu, 0, 1)}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /admin/pro/presensi_izin_lembur.jsp(159,17) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${levelMenu0 == 1 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    ");
        if (_jspx_meth_c_005fset_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                    ");
        if (_jspx_meth_c_005fchoose_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                 ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /admin/pro/presensi_izin_lembur.jsp(160,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("levelMenu1");
    // /admin/pro/presensi_izin_lembur.jsp(160,20) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setScope("session");
    // /admin/pro/presensi_izin_lembur.jsp(160,20) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/admin/pro/presensi_izin_lembur.jsp(160,20) '${fn:substring(mnu.levelMenu, 1, 2)}'",_el_expressionfactory.createValueExpression(new org.apache.jasper.el.ELContextWrapper(_jspx_page_context.getELContext(),_jspx_fnmap_0),"${fn:substring(mnu.levelMenu, 1, 2)}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_005fotherwise_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /admin/pro/presensi_izin_lembur.jsp(162,24) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${levelMenu1 == 1 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \n");
        out.write("                            ");
        if (_jspx_meth_c_005fset_005f2(_jspx_th_c_005fwhen_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                            ");
        if (_jspx_meth_c_005fchoose_005f1(_jspx_th_c_005fwhen_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("        \n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    // /admin/pro/presensi_izin_lembur.jsp(163,28) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("levelMenu2");
    // /admin/pro/presensi_izin_lembur.jsp(163,28) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setScope("session");
    // /admin/pro/presensi_izin_lembur.jsp(163,28) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/admin/pro/presensi_izin_lembur.jsp(163,28) '${fn:substring(mnu.levelMenu, 2, 3)}'",_el_expressionfactory.createValueExpression(new org.apache.jasper.el.ELContextWrapper(_jspx_page_context.getELContext(),_jspx_fnmap_0),"${fn:substring(mnu.levelMenu, 2, 3)}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    int _jspx_eval_c_005fchoose_005f1 = _jspx_th_c_005fchoose_005f1.doStartTag();
    if (_jspx_eval_c_005fchoose_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                               ");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                               ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                           ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
    // /admin/pro/presensi_izin_lembur.jsp(165,31) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${levelMenu2 == 1 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                  <!-- ketiga -->\n");
        out.write("                                  ");
        if (_jspx_meth_c_005fchoose_005f2(_jspx_th_c_005fwhen_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                               ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f2 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f1);
    int _jspx_eval_c_005fchoose_005f2 = _jspx_th_c_005fchoose_005f2.doStartTag();
    if (_jspx_eval_c_005fchoose_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                       ");
        if (_jspx_meth_c_005fwhen_005f2(_jspx_th_c_005fchoose_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                       ");
        if (_jspx_meth_c_005fwhen_005f5(_jspx_th_c_005fchoose_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                        ");
        if (_jspx_meth_c_005fwhen_005f6(_jspx_th_c_005fchoose_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                   ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f2);
    // /admin/pro/presensi_izin_lembur.jsp(168,39) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 5 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f2 = _jspx_th_c_005fwhen_005f2.doStartTag();
    if (_jspx_eval_c_005fwhen_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                           <!-- opsi pilihan ada sub menu (0 ) atau sub sub menu (1) -->\n");
        out.write("                                           ");
        if (_jspx_meth_c_005fchoose_005f3(_jspx_th_c_005fwhen_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("   \n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f3 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f2);
    int _jspx_eval_c_005fchoose_005f3 = _jspx_th_c_005fchoose_005f3.doStartTag();
    if (_jspx_eval_c_005fchoose_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                ");
        if (_jspx_meth_c_005fwhen_005f3(_jspx_th_c_005fchoose_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                                ");
        if (_jspx_meth_c_005fwhen_005f4(_jspx_th_c_005fchoose_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f3 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f3);
    // /admin/pro/presensi_izin_lembur.jsp(171,48) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.subLink == 0 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f3 = _jspx_th_c_005fwhen_005f3.doStartTag();
    if (_jspx_eval_c_005fwhen_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                     <li> <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fwhen_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f3);
    // /admin/pro/presensi_izin_lembur.jsp(172,80) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f4 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f3);
    // /admin/pro/presensi_izin_lembur.jsp(174,48) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.subLink == 1 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f4 = _jspx_th_c_005fwhen_005f4.doStartTag();
    if (_jspx_eval_c_005fwhen_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                        <li class=\"dropdown-submenu\">\n");
        out.write("                                                        <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fwhen_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a>\n");
        out.write("                                                        <ul class=\"dropdown-menu\">\n");
        out.write("                                                            <li><a href=\"#\">3rd level</a></li>\n");
        out.write("                                                            <li><a href=\"#\">3rd level</a></li>\n");
        out.write("                                                        </ul>\n");
        out.write("                                                        </li>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f4);
    // /admin/pro/presensi_izin_lembur.jsp(176,78) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f5 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f2);
    // /admin/pro/presensi_izin_lembur.jsp(185,39) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 6 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f5 = _jspx_th_c_005fwhen_005f5.doStartTag();
    if (_jspx_eval_c_005fwhen_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <li> <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fwhen_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>\n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f5);
    // /admin/pro/presensi_izin_lembur.jsp(186,71) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f6 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f2);
    // /admin/pro/presensi_izin_lembur.jsp(188,40) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 7 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f6 = _jspx_th_c_005fwhen_005f6.doStartTag();
    if (_jspx_eval_c_005fwhen_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <li> <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fwhen_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>\n");
        out.write("                                            </ul>\n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f6);
    // /admin/pro/presensi_izin_lembur.jsp(189,71) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                   <!-- kedua -->\n");
        out.write("                                   ");
        if (_jspx_meth_c_005fchoose_005f4(_jspx_th_c_005fotherwise_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                               ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f4 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    int _jspx_eval_c_005fchoose_005f4 = _jspx_th_c_005fchoose_005f4.doStartTag();
    if (_jspx_eval_c_005fchoose_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                       ");
        if (_jspx_meth_c_005fwhen_005f7(_jspx_th_c_005fchoose_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                       ");
        if (_jspx_meth_c_005fwhen_005f10(_jspx_th_c_005fchoose_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                        ");
        if (_jspx_meth_c_005fwhen_005f11(_jspx_th_c_005fchoose_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("   \n");
        out.write("                                        ");
        if (_jspx_meth_c_005fwhen_005f12(_jspx_th_c_005fchoose_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("   \n");
        out.write("                                       ");
        if (_jspx_meth_c_005fwhen_005f13(_jspx_th_c_005fchoose_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                   ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f7 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f4);
    // /admin/pro/presensi_izin_lembur.jsp(197,39) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 2 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f7 = _jspx_th_c_005fwhen_005f7.doStartTag();
    if (_jspx_eval_c_005fwhen_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                           <!-- opsi pilihan ada sub menu atau sub sub menu -->\n");
        out.write("                                           ");
        if (_jspx_meth_c_005fchoose_005f5(_jspx_th_c_005fwhen_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f5 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f7);
    int _jspx_eval_c_005fchoose_005f5 = _jspx_th_c_005fchoose_005f5.doStartTag();
    if (_jspx_eval_c_005fchoose_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                ");
        if (_jspx_meth_c_005fwhen_005f8(_jspx_th_c_005fchoose_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                                ");
        if (_jspx_meth_c_005fwhen_005f9(_jspx_th_c_005fchoose_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f8 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f5);
    // /admin/pro/presensi_izin_lembur.jsp(200,48) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.subLink == 0 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f8 = _jspx_th_c_005fwhen_005f8.doStartTag();
    if (_jspx_eval_c_005fwhen_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                     <ul class=\"dropdown-menu multi-level\" role=\"menu\" aria-labelledby=\"dropdownMenu\">\n");
        out.write("                                                     <li> <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fwhen_005f8, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f8);
    // /admin/pro/presensi_izin_lembur.jsp(202,80) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f9 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f5);
    // /admin/pro/presensi_izin_lembur.jsp(204,48) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.subLink == 1 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f9 = _jspx_th_c_005fwhen_005f9.doStartTag();
    if (_jspx_eval_c_005fwhen_005f9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                     <ul class=\"dropdown-menu multi-level\" role=\"menu\" aria-labelledby=\"dropdownMenu\">\n");
        out.write("                                                     <li class=\"dropdown-submenu\">\n");
        out.write("                                                     <a  href=\"#\">");
        if (_jspx_meth_c_005fout_005f5(_jspx_th_c_005fwhen_005f9, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a>\n");
        out.write("                                                     <ul class=\"dropdown-menu\">       \n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f9, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f9);
    // /admin/pro/presensi_izin_lembur.jsp(207,66) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f10 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f4);
    // /admin/pro/presensi_izin_lembur.jsp(212,39) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 3 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f10 = _jspx_th_c_005fwhen_005f10.doStartTag();
    if (_jspx_eval_c_005fwhen_005f10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <li> <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f6(_jspx_th_c_005fwhen_005f10, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>\n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f10);
    // /admin/pro/presensi_izin_lembur.jsp(213,71) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f11 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f4);
    // /admin/pro/presensi_izin_lembur.jsp(215,40) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 4 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f11 = _jspx_th_c_005fwhen_005f11.doStartTag();
    if (_jspx_eval_c_005fwhen_005f11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <li> <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f7(_jspx_th_c_005fwhen_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>\n");
        out.write("                                            </ul>\n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f11);
    // /admin/pro/presensi_izin_lembur.jsp(216,71) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f12 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f4);
    // /admin/pro/presensi_izin_lembur.jsp(219,40) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 8 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f12 = _jspx_th_c_005fwhen_005f12.doStartTag();
    if (_jspx_eval_c_005fwhen_005f12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                       <ul class=\"dropdown-menu multi-level\" role=\"menu\" aria-labelledby=\"dropdownMenu\">\n");
        out.write("                                            <li class=\"dropdown-submenu\">\n");
        out.write("                                            <a  href=\"#\">");
        if (_jspx_meth_c_005fout_005f8(_jspx_th_c_005fwhen_005f12, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a>\n");
        out.write("                                            </li>      \n");
        out.write("                                       </ul>\n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f12, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f12);
    // /admin/pro/presensi_izin_lembur.jsp(222,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f8 = _jspx_th_c_005fout_005f8.doStartTag();
    if (_jspx_th_c_005fout_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f13 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f4);
    // /admin/pro/presensi_izin_lembur.jsp(226,39) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f13.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 9 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f13 = _jspx_th_c_005fwhen_005f13.doStartTag();
    if (_jspx_eval_c_005fwhen_005f13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <ul class=\"dropdown-menu multi-level\" role=\"menu\" aria-labelledby=\"dropdownMenu\">\n");
        out.write("                                            <li> <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f9(_jspx_th_c_005fwhen_005f13, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>     \n");
        out.write("                                            </ul>\n");
        out.write("                                       ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f13.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f13, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f13);
    // /admin/pro/presensi_izin_lembur.jsp(228,71) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f9 = _jspx_th_c_005fout_005f9.doStartTag();
    if (_jspx_th_c_005fout_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f1 = _jspx_th_c_005fotherwise_005f1.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <!-- Pertama -->\n");
        out.write("                            ");
        if (_jspx_meth_c_005fchoose_005f6(_jspx_th_c_005fotherwise_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("       \n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f6 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f1);
    int _jspx_eval_c_005fchoose_005f6 = _jspx_th_c_005fchoose_005f6.doStartTag();
    if (_jspx_eval_c_005fchoose_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_005fwhen_005f14(_jspx_th_c_005fchoose_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_005fwhen_005f15(_jspx_th_c_005fchoose_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f14 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f6);
    // /admin/pro/presensi_izin_lembur.jsp(238,32) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f14.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 0 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f14 = _jspx_th_c_005fwhen_005f14.doStartTag();
    if (_jspx_eval_c_005fwhen_005f14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_005fout_005f10(_jspx_th_c_005fwhen_005f14, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("</a></li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f14.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f14, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f14);
    // /admin/pro/presensi_izin_lembur.jsp(239,62) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f10 = _jspx_th_c_005fout_005f10.doStartTag();
    if (_jspx_th_c_005fout_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f15 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f6);
    // /admin/pro/presensi_izin_lembur.jsp(241,32) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f15.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.tag == 1 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f15 = _jspx_th_c_005fwhen_005f15.doStartTag();
    if (_jspx_eval_c_005fwhen_005f15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                     <li class=\"dropdown\">\n");
        out.write("                                     <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.href}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-expanded=\"false\">");
        if (_jspx_meth_c_005fout_005f11(_jspx_th_c_005fwhen_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("<span class=\"caret\"></span></a>  \n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f15.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f11 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f15);
    // /admin/pro/presensi_izin_lembur.jsp(243,142) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f11.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mnu.namaMenu}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f11 = _jspx_th_c_005fout_005f11.doStartTag();
    if (_jspx_th_c_005fout_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
    return false;
  }
}
