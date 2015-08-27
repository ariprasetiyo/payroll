$(document).ready(function() {
    //master_pelamar.jsp
    //master_pelamar_save.js
    //master_pelamar_action.js
    window.ajaxindicatorstart = function (text)
    {
	if(jQuery('body').find('#resultLoading').attr('id') != 'resultLoading'){
	jQuery('body').append('<div id="resultLoading" style="display:none"><div><img src="gambar/ajax-loader.gif"><div>'+text+'</div></div><div class="bg"></div></div>');
	}
        //backgourd warna hitam opacity
	jQuery('#resultLoading').css({
		'width':'25%',
		'height':'15%',
		'position':'fixed',
		'z-index':'10000000',
		'top':'0',
		'left':'0',
		'right':'0',
		'bottom':'0',
		'margin':'auto'
	});
	jQuery('#resultLoading .bg').css({
		'background':'#000000',
		'opacity':'0.7',
		'width':'100%',
		'height':'100%',
		'position':'absolute',
		'top':'0'
	});
	jQuery('#resultLoading>div:first').css({
		'width': '250px',
		'height':'75px',
		'text-align': 'center',
		'position': 'fixed',
		'top':'0',
		'left':'0',
		'right':'0',
		'bottom':'0',
		'margin':'auto',
		'font-size':'16px',
		'z-index':'10',
		'color':'#ffffff'
	});
        jQuery('#resultLoading .bg').height('100%');
        jQuery('#resultLoading').fadeIn(300);
        jQuery('body').css('cursor', 'wait');
    },
    window.ajaxindicatorstop = function () {
        jQuery('#resultLoading .bg').height('100%');
                jQuery('#resultLoading').fadeOut(300);
                jQuery('body').css('cursor', 'default');
        },
    window.directMenu = function (url){
        alert();
        try{
            //var url = "admin/ari.ari";
            $.ajax({url:url,success:function(data){
                //$('#content').remove();
                //alert(data);
                //$('#content').load(data);
                //document.write(data);
                $('#content').html(data);
            }});
            //var pageurl = 'admin/ari.aris';
            var pageurl = url;
            if(pageurl!==window.location){
                window.history.pushState({path:pageurl},'',pageurl);
            }
          }
         catch(err) {
         $('#catch_error_message').empty();
         $('#catch_error_message').html(err);
         $('#catch_error').show();
    }
    /*
            var url = "admin/ari.ari";
            try{
                //var url = $(this).attr('name');
                //$('#content').hide();
                //$('#content').empty();
                //$('#loading').delay(50).show('fast');
                $.ajax({
                    url:url,
                    success:function(data){
                        //alert(data);
                       //$('#loading').delay(1500).fadeOut("fast");
                       //$('#content').delay(2000).fadeIn();
                       $('#content').html(data);
                      // location.reload();
                       //alert(result);
                            
                        //$("#loading").hide();
                        //    document.location.reload();
                        if (data === "refresh"){
                            window.location.reload(); // This is not jQuery but simple plain ol' JS
                          }
                    }});
            }
         catch(err) {
         $('#catch_error_message').empty();
         $('#catch_error_message').html(err);
         $('#catch_error').show();
    }
    */     
    }
});
