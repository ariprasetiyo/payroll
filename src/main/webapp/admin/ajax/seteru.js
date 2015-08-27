$(document).ready(function() {
 
    //Stops the submit request
    $("#loginForm").submit(function(e){
           e.preventDefault();
    });

    //checks for the button click event
    $("#buttonLogin").on("click", function(e){
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
                 async: true,      
                //if received a response from the server
                success: function( data, textStatus, jqXHR) {
                     if(data.success){
                        if (jqXHR.getResponseHeader('REQUIRES_AUTH') == 1){
                            //window.location.href = data.infoError.userName;
                            //$('#target').load(data.infoError.userName);
                            // alert(data);
                            //$('#content').html(data);
                            //direct ();
                            window.location.href = data.infoError.userName;
                            //alert(jqXHR.getResponseHeader(data.infoError.userName));
                        }
                        else {
                            $("#ajaxResponse").html("");
                            $("#ajaxResponse").append("<div class='alert alert-danger' role='alert'>" +
                            "<span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>"+
                             "<span class='sr-only'>Error:</span>" +
                             data.infoError.userName+
                           "</div>");
                            //$("#ajaxResponse").append("<b>Info: " + data.infoError.userName+ "<b>");
                        }
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
            });       
    });
});