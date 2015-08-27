package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html  id=\"content\" >\n");
      out.write("        ");

            if ((session.getAttribute("useridariprasetiyo") == null) || (session.getAttribute("useridariprasetiyo") == "")) {
        
      out.write("\n");
      out.write("        <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"admin/css/bootstrap.css\" rel=\"stylesheet\"> \n");
      out.write("        <link href=\"admin/css/main.css\" rel=\"stylesheet\">\n");
      out.write(" \n");
      out.write("        <!--\n");
      out.write("        <link href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        -->\n");
      out.write("        <link href=\"admin/css/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("    <div id=\"login-overlay\" class=\"modal-dialog\">\n");
      out.write("      <div class=\"modal-content\">\n");
      out.write("          <div class=\"modal-header\">\n");
      out.write("              <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">×</span><span class=\"sr-only\">Close</span></button>\n");
      out.write("              <h4 class=\"modal-title\" id=\"myModalLabel\">Login to admin</h4>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"modal-body\">\n");
      out.write("                      <div class=\"well\">\n");
      out.write("                          <form id=\"loginForm\"  novalidate=\"novalidate\">\n");
      out.write("                              <div class=\"form-group\">\n");
      out.write("                                  <label for=\"username\" class=\"control-label\">Username</label>\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" value=\"\" required=\"\" placeholder=\"example@gmail.com\">\n");
      out.write("                                  <span class=\"help-block\"></span>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group\">\n");
      out.write("                                  <label for=\"password\" class=\"control-label\">Password</label>\n");
      out.write("                                  <input name=\"password\" id=\"password\" class=\"form-control\" type=\"password\"  placeholder=\"password\" />\n");
      out.write("                                  \n");
      out.write("                                  <input id=\"methods\" type=\"checkbox\" class=\"form-inline\" disabled/> <label class=\"form-inline\"> Show password</label>\n");
      out.write("                                  <span class=\"help-block\"></span>\n");
      out.write("                                  \n");
      out.write("                              </div>\n");
      out.write("                              <div id=\"ajaxResponse\"></div>\n");
      out.write("                              <!--\n");
      out.write("                              <div id=\"loginErrorMsg\" class=\"alert alert-error hide\">Wrong username og password</div>\n");
      out.write("                              <div class=\"checkbox\">\n");
      out.write("                                  <label>\n");
      out.write("                                      <input type=\"checkbox\" name=\"remember\" id=\"remember\"> Remember login\n");
      out.write("                                  </label>\n");
      out.write("                                  <p class=\"help-block\">(if this is a private computer)</p>\n");
      out.write("                              </div>\n");
      out.write("                              -->\n");
      out.write("                              <button type=\"submit\" class=\"btn btn-success btn-block\" id=\"buttonLogin\">Login</button>\n");
      out.write("                              <a href=\"/forgot/\" class=\"btn btn-default btn-block\">Help to login</a>               \n");
      out.write("                          </form>\n");
      out.write("                      </div>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write(" <script src=\"admin/js/jquery.min.js\"></script>\n");
      out.write("<script src=\"admin/js/jquery.validate.min.js\"></script>\n");
      out.write("<script src=\"admin/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("-->\n");
      out.write("<script src=\"admin/js/jquery-ui.min.js\"></script>        \n");
      out.write(" \n");
      out.write("<script src=\"admin/js/password.js\"></script> \n");
      out.write("<!-- <script src=\"../BOOTSTRAP/js/ValidationFormScript.js\"></script> -->\n");
      out.write("<script src=\"admin/ajax/seteru.js\"></script>\n");
      out.write("<script>\n");
      out.write("    \n");
      out.write("$(function() {\n");
      out.write("    $('#password').password().on('show.bs.password', function(e) {\n");
      out.write("        $('#methods').prop('checked', true);\n");
      out.write("    }).on('hide.bs.password', function(e) {\n");
      out.write("        $('#methods').prop('checked', false);\n");
      out.write("    });\n");
      out.write("    $('#methods').click(function() {\n");
      out.write("    });\n");
      out.write("});\n");
      out.write("\n");
      out.write("    \n");
      out.write("$(document).ready(function() {\n");
      out.write("    $(\"#methods\").click(function() {\n");
      out.write("        // this function will get executed every time the #home element is clicked (or tab-spacebar changed)\n");
      out.write("        if($(this).is(\":checked\")) // \"this\" refers to the element that fired the event\n");
      out.write("        {\n");
      out.write("            field.attr('type', 'text');\n");
      out.write("        }\n");
      out.write("        else{\n");
      out.write("             field.attr('type', 'password');\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("});\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("    </body>    \n");
      out.write("       \n");
      out.write("        ");
} else {
                 response.sendRedirect("admin/ari.ari");
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
}
