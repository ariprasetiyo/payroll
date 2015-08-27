$(document).ready(function() {
/*
 * about text editor
 */
    $("#txtEditor").Editor(); 
/*
 * all about validation
 */
    /*
     *  $.isNumeric( "-10" ); // true
        $.isNumeric( 16 ); // true
        $.isNumeric( 0xFF ); // true
        $.isNumeric( "0xFF" ); // true
        $.isNumeric( "8e5" ); // true (exponential notation string)
        $.isNumeric( 3.1415 ); // true
        $.isNumeric( +10 ); // true
        $.isNumeric( 0144 ); // true (octal integer literal)
        $.isNumeric( "" ); // false
        $.isNumeric({}); // false (empty object)
        $.isNumeric( NaN ); // false
        $.isNumeric( null ); // false
        $.isNumeric( true ); // false
        $.isNumeric( Infinity ); // false
        $.isNumeric( undefined );
     $("ul.pagination > li.active").removeClass("active");
        $("ul.pagination > li#"+this.id).toggleClass("active");
     */
    
    /*
     * Desimal protect
     * 
    $(".allownumericwithdecimal").on("keypress keyup blur",function (event) {
            //this.value = this.value.replace(/[^0-9\.]/g,'');
        $(this).val($(this).val().replace(/[^0-9\.]/g,''));
            if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
                event.preventDefault();
        }
    });
    */
   
   /*
    * source http://jsfiddle.net/techrevolt/Fp4sJ/
    * input hanya angka saja
    */
    $("#no_tlpn_ari, #kode_pos_ari, #no_ktp_ari, #no_sim_ari").on("keypress keyup blur",function (event) {    
        $(this).val($(this).val().replace(/[^\d].+/, ""));
        if ((event.which === 8 ||  (  event.which >= 48 && event.which <= 58 ) ) ) {
            //event.preventDefault();
        }
        else {
            //mencegah
            event.preventDefault();
        }
    });
    // windows function difungsi untuk dipagil dari luar document function
    //master_pelamar_save
   window.validationPelamar = 
    function (){
        $("#form-ari").validate(
        {
        rules: {
            nama_ari:{
                required: true,
                minlength:3
            },
            no_tlpn_ari : {
                required: true,
                digits: true,
                minlength:9,
                maxlength:12
            },
            jabatan_ari : {
                required: true
            },
            tempat_lahir_ari:{
                required: true
            },
            tanggal_lahir_ari:{
                required: true
            },
            kewarganegaraan_ari:{
                required: true
            },
            no_ktp_ari:{
                required: true,
                digits: true,
                minlength:10,
                maxlength:30
            },
             email_ari : {
                required: true,
                email: true
            },
            alamat_ari:{
                required: true
            }

            /*
            tgl: {
                indonesianDate:true
            },
            umur: {
                digits: true,
                range: [0, 100]
            },
            situs: {
                url: true
            },
            pass2: {
                equalTo: "#pass1"
            }*/
        },
        messages: {
             nama_ari:{
                required: "Nama harus diisi",
                minlength:"Minimal 3 huruf"
            },
            agama_ari :{
                required: "Agama harus diisi"
                
            },
             no_tlpn_ari : {
                required: "Harus diisi",
                digits: "Harus angka",
                minlength:"Minimal 9 digit",
                maxlength:"Max 12 digit"
            },
            jabatan_ari :{
                required: "Jabatan harus diisi"
            },
            tempat_lahir_ari:{
                required: "Tempat lahir harus diisi"
            },
            tanggal_lahir_ari:{
                required: "Tanggal lahir harus diisi"
            },
             kewarganegaraan_ari:{
                required: "kewarganegaraan lahir harus diisi"
            },
            no_ktp_ari:{
                required: "Harus diisi",
                digits: "Harus angka",
                minlength:"Minimal 10 digit",
                maxlength:"Max 30 digit"
            },
            email_ari : {
                required: "Harus diisi",
                email: "Format email salah"
            },
            alamat_ari:{
                required: "Alamat harus diisi"
            }

            /*
            email: {
                required: "Alamat email harus diisi",
                email: "Format email tidak valid"
            },
            pass2: {
                equalTo: "Password tidak sama"
            }
            */
        },

        highlight: function(element) {
            $(element).closest('.padding_left').addClass('padding_left_error');
            // 0 = status tidak bisa di save proses ajax 
            // 1 = status bisa di save
            $("div#status_save").text("0");
        },
        unhighlight: function(element) {
            $(element).closest('.padding_left').removeClass('padding_left_error');
            $("div#status_save").text("1");
        }
    } );
    }
    
        
});