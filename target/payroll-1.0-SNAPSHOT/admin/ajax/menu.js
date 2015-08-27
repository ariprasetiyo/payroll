$(document).ready(function() {
  
    //Stops the submit request
    $("#loginForm").submit(function(e){
           e.preventDefault();
    });

    $.ajax({
        type: "GET",
        url: "ari.ari",
        //url: 'http://web-kapol/admin/index.jsp',
        dataType: "json",
        data: {
            format: 'json'
        },
        
        error: function(jqXHR, textStatus, errorThrown){
                     //alert (" error 22 " +textStatus);
                     console.log("Something really bad happened " + textStatus);
                     alert (jqXHR.responseText);
                      $("#ajaxResponse").html(jqXHR.responseText);
                },
       /*
       success: function(data) {
            var $title = $('<h1>').text(data.talks[0].talk_title);
            var $description = $('<p>').text(data.talks[0].talk_description);
            $('#info')
               .append($title)
               .append($description);
       },
       */
       success: function( data, textStatus, jqXHR) {
                     if(data.success){
                         alert (" Berhasil");
                            $("#ajaxResMenu").html("");
                            $("#ajaxResMenu").append("<div>" +data.menu.id+ "</div>");
                          
                     }
                     //display error message
                     else {
                        alert ("error 2 "+textStatus );
                         $("#ajaxResponse").html("<div><b>error</b></div>");
                     }
        }
    });
     
     
    /*
    $.get("index.jsp", function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
   
           /*
            //get the form data and then serialize that
            dataString = $("#loginForm").serialize();
            
            //get the form data using another method
            var userName = $("input#username").val();
            var password = $("input#password").val();
            dataString = "username=" + userName + "&password=" + password;
            
            //make the AJAX request, dataType is set to json
            //meaning we are expecting JSON data in response from the server
            $.ajax({
                type: "POST",
                url: "login.ari",
                data: dataString,
                dataType: "json",
                
                //if received a response from the server
                success: function( data, textStatus, jqXHR) {
                     if(data.success){

                            $("#ajaxResponse").html("");
                            $("#ajaxResponse").append("<div class='alert alert-danger' role='alert'>" +
                            "<span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>"+
                             "<span class='sr-only'>Error:</span>" +
                             data.infoError.userName+
                           "</div>");
                          
                     }
                     //display error message
                     else {
                         // alert ("hallo 3");
                         $("#ajaxResponse").html("<div><b>error</b></div>");
                     }
                },
                
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
                     //alert ("hallo 5" +textStatus);
                     console.log("Something really bad happened " + textStatus);
                      $("#ajaxResponse").html(jqXHR.responseText);
                },
                
                //capture the request before it was sent to server
                beforeSend: function(jqXHR, settings){
                    //alert ("hallo 4");
                    //adding some Dummy data to the request
                    settings.data += "&dummyData=whatever";
                    //disable the button until we get the response
                    $('#buttonLogin').attr("disabled", true);
                },
                
                //this is called after the response or error functions are finsihed
                //so that we can take some action
                complete: function(jqXHR, textStatus){
                    //alert ("hall6");
                    //enable the button
                    $('#buttonLogin').attr("disabled", false);
                }
      
            });       */
   
 
});