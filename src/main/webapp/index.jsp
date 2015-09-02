<%-- 
    Document   : index.jsp
    Created on : Feb 14, 2015, 2:46:18 PM
    Author     : arprast
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html  id="content" >
        <%
            if ((session.getAttribute("useridariprasetiyo") == null) || (session.getAttribute("useridariprasetiyo") == "")) {
        %>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="admin/css/bootstrap.css" rel="stylesheet"> 
        <link href="admin/css/main.css" rel="stylesheet">
        <!--
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
        --
        <link href="admin/css/jquery-ui.css" rel="stylesheet" type="text/css">
        -->
    </head>
    <body >
    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel">Login to admin</h4>
          </div>
          <div class="modal-body">
            <div class="well">
                <form id="loginForm"  novalidate="novalidate">
                    <div class="form-group">
                        <label for="username" class="control-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" value="" required="" placeholder="example@gmail.com">
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">Password</label>
                        <input name="password" id="password" class="form-control" type="password"  placeholder="password" />
                        <input id="methods" type="checkbox" class="form-inline" disabled/> <label class="form-inline"> Show password</label>
                        <span class="help-block"></span>
                    </div>
                    <div id="ajaxResponse"></div>
                    <!--
                    <div id="loginErrorMsg" class="alert alert-error hide">Wrong username og password</div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="remember" id="remember"> Remember login
                        </label>
                        <p class="help-block">(if this is a private computer)</p>
                    </div>
                    -->
                    <button type="submit" class="btn btn-success btn-block" id="buttonLogin">Login</button>
                    <!-- <a href="/forgot/" class="btn btn-default btn-block">Help to login</a> -->      
                </form>
            </div>
          </div>
      </div>
  </div>
<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/jquery.validate.min.js"></script>
<script src="admin/js/bootstrap.min.js"></script>
<!--
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
-->
<script src="admin/js/jquery-ui.min.js"></script>        
<script src="admin/js/password.js"></script> 
<!-- <script src="../BOOTSTRAP/js/ValidationFormScript.js"></script> -->
<script src="admin/ajax/seteru.js"></script>
<script>
$(function() {
    $('#password').password().on('show.bs.password', function(e) {
        $('#methods').prop('checked', true);
    }).on('hide.bs.password', function(e) {
        $('#methods').prop('checked', false);
    });
    $('#methods').click(function() {
    });
});
$(document).ready(function() {
    $("#methods").click(function() {
        // this function will get executed every time the #home element is clicked (or tab-spacebar changed)
        if($(this).is(":checked")) // "this" refers to the element that fired the event
        {
            field.attr('type', 'text');
        }
        else{
             field.attr('type', 'password');
        }
    });
});
</script>
    </body>    
        <%} else {
                 response.sendRedirect("admin/ari.ari");
       } 
        %>
</html>
