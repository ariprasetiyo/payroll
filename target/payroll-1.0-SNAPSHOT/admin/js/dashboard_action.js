$(document).ready(function() {
    function direct (){
        try{
            var url = "admin/ari.ari";
            $.ajax({url:url,success:function(data){
                $('#content').html(data);
            }});
            var pageurl = 'admin/ari.ari';
             if(pageurl!==window.location){
                window.history.pushState({path:pageurl},'',pageurl);
            }
          }
         catch(err) {
            $('#catch_error_message').empty();
            $('#catch_error_message').html(err);
            $('#catch_error').show();
        }
    }
       $("#buttonLogin").on("click", function(e){
           
       });
});

