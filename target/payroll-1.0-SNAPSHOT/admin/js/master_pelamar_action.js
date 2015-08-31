/*
 * dimamik item 
 */
$(document).ready(function() {
    //print data detail
    $("a#pelamar_print_data").on("click", function(e){
        //$("#pelamar_print").attr("href", "master_pelamar.ari?sta=3&xcv=3"); atau 
        var a = document.getElementById('pelamar_print_data'); //or grab it by tagname etc
        a.href = "master_pelamar.ari?sta=3&xcv=3&f_id="+ $('#ref_code_ari').val();
    });
    $("a#pelamar_print_data").printPage();
    $("a#pelamar_print").printPage();
    /*
    * about text editor alamat tinggal
    */
    $("#txtEditor").Editor(); 
    /*
    * about text editor alamat asal
    */
    $("#almtAsal").Editor();
    /*
     * ===================================================================
     * @returns {undefined}
     * bagian Validation
     * ===================================================================
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
    validationUI();
    function validationUI(){
        $("#form-ari").validate(
            {
            rules: {
                nama_ari:{
                    required: true,
                    minlength:3,
                    maxlength:50
                },
                nama_ibu:{
                    required: true,
                    minlength:3,
                    maxlength:12
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
                    required: true,
                    maxlength:30
                },
                tanggal_lahir_ari:{
                    required: true,
                    maxlength:15
                },
                kewarganegaraan_ari:{
                    required: true,
                    maxlength:30
                },
                no_ktp_ari:{
                    required: true,
                    digits: true,
                    minlength:10,
                    maxlength:30
                },
                   no_sim_ari:{
                    digits: true,
                    maxlength:30
                },
                 email_ari : {
                    required: true,
                    email: true,
                    maxlength:50
                },
                alamat_ari:{
                    required: true
                },
                kode_pos_ari:{
                    digits: true,
                    maxlength:7
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
                    minlength:"Minimal 3 huruf",
                    maxlength:"Max 50 karakter"
                },
                nama_ibu:{
                    required: "harus diisi",
                    minlength:"Minimal 3 huruf",
                    maxlength:"Max 50 karakter"
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
                    required: "Tempat lahir harus diisi",
                    maxlength:"Max 30 karakter"
                },
                tanggal_lahir_ari:{
                    required: "Tanggal lahir harus diisi",
                    maxlength:"Max 15 digit"
                },
                 kewarganegaraan_ari:{
                    required: "kewarganegaraan lahir harus diisi",
                    maxlength:"Max 50 digit"
                },
                no_ktp_ari:{
                    required: "Harus diisi",
                    digits: "Harus angka",
                    minlength:"Minimal 10 digit",
                    maxlength:"Max 30 digit"
                },
                  no_sim_ari:{
                    digits: "Harus angka",
                    maxlength:"Max 30 digit"
                },
                email_ari : {
                    required: "Harus diisi",
                    email: "Format email salah",
                    maxlength:"Max 50 karakter"
                },
                alamat_ari:{
                    required: "Alamat harus diisi"
                },
                kode_pos_ari:{
                    digits: "Harus angka",
                    maxlength:"Max 7 digit"
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
     /*
     * ===================================================================
     * @returns {undefined}
     * bagian ajax
     * ===================================================================
     */
   
    // menampilkan perubahan data setiap 10 detik
    // tidak difunsgikan dulu 6/5/2015
    // auto refresh ambil data
    /*
    var auto_refresh = setInterval(function () {
       ambilDataListPelamar(1,20);
    }, 10000); // refresh every 10000 milliseconds
    */
  /*
   * filter data
   */
    var b_filter_stat = false;
    $(".b_filter").on("click", function(e){
        //alert("1");
        b_filter_stat = true;
        $("#halKe").val(0);
        ambilDataListPelamar( 0,  20);
    });
    function ambilDataListPelamar( limitBawah,  limitAtas){
        //jika 1 maka edit
        //set nilai 0
        $("#status_edit").html(0);
        // difungsikan buat gerbang akses pada server side
        // pintu = 1 ( normal )
        var pintu = 2;
        dataString = "limitBawah="+limitBawah
                +"&limitAtas="+limitAtas;
        // jika tombol filter diklik       
        if (b_filter_stat === true){
            // pemisah tanggal
            var periode = $(".f_tgl_buat").val().split(" - ");
            var tgl1 = periode[0];
            var tgl2 = periode[1];
            dataString += "&f_id="+$(".f_id").val()
                +"&f_nama="+$(".f_nama").val()
                +"&f_jabatan="+$(".f_jabatan").val()
                +"&f_s_plmr="+$(".f_s_plmr").val()
            //alert(f_tgl_buat1+"dan"+f_tgl_buat2);
           // if (typeof periode[1] !== 'undefined'){
                +"&f_tgl_buat1="+tgl1
                +"&f_tgl_buat2="+tgl2;
           // }
        }
        
        $.ajax({
            type: "GET",
            url: "master_pelamar.ari?xcv="+pintu+"",
            data:dataString,
            dataType: "json",
            //if received a response from the server
            beforeSend: function(){
                    ajaxindicatorstart('loading data.. please wait..');
                    window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
            },
            success: function( data, textStatus, jqXHR) {
                var dataTableLengt =  data.dataTable.length;
                if ( dataTableLengt > 0){
                    $(".no_result").remove();
                    $("#ariDataTablePelamar tr:has(td)").remove();
                    for (var i=0; i< dataTableLengt ; i++){
                         var data_table ="<tr> <td class='text-center'><a href='#' class='info tbl-edit' id='"+data.dataTable[i].refCode +"'> "+data.dataTable[i].refCode+"</a></td>"
                                        +"<td class='text-center' nowrap> "+data.dataTable[i].nama+"</td>"
                                        +"<td class='col-xs-2 text-center' nowrap>"+data.dataTable[i].jabatan+"</td>"
                                        +"<td class='col-xs-1 text-center' nowrap>"+data.dataTable[i].jenisKelamin+"</td>"
                                        +"<td class='col-xs-2'nowrap >"+data.dataTable[i].noHP+"</td>"
                                        +"<td class='col-xs-1 text-center' nowrap>"+data.dataTable[i].statusPelamar+"</td>"
                                        +"<td class='col-xs-2 text-center' nowrap>"+data.dataTable[i].tanggal+"</td>"
                                        +"</tr>";
                        //$(msg_data).appendTo("#content");
                        $('#ariDataTablePelamar').append(data_table);  
                    }
                }
                else {
                    $('#ariDataTablePelamar').html("<div class='no_result text-center'><b>no result</b></div>");
                }
                // membuat paggination
                // pagingDataList(jmlhRow)
                $("#jmlhRow").val(data.dataIndependent);
                setPaggination();
            },
            complete: function(){
                    timeout = setTimeout(ajaxindicatorstop(), 9000);
                    clearTimeout(timeout);  
                     //window.setTimeout( ajaxindicatorstop(), 5000 );   
                },
            //If there was no resonse from the server
            error: function(jqXHR, textStatus, errorThrown){
                //alert ("hallo 5" +textStatus);
                console.log("Something really bad happened " + textStatus);
                $("#ajaxResponseError").html(jqXHR.responseText);
            }
        }); 
        // disable button 
    }
    function setPaggination(){
        var jmlhRow =  $("#jmlhRow").val();
        var totPage = pagingDataList(jmlhRow);
        $("#totalPage").val(totPage);
        //$("batasAwal").val(10);
        if (jmlhRow > 0 && loadPaging === true && $("#halKe").val() <= 10){
            //$(".page").remove();
            var hal = "<div class='page'><ul class='pagination'> <li id='previous'><a href='#' >&laquo;</a></li>";
                for (var i = 1; i < totPage + 1; i++ ){
                    var dataNya = "<li id='"+ i+"' class='pagination' ><a href='#' >"+ i + "</a></li>";               
                    hal += dataNya;
                    if (i === 10){
                        break;
                    }
                }
            hal +=  "<li id='next'><a href='#'>&raquo;</a></li></ul></div>";
            $("#ketHal").html("Total Hal : " + totPage);
            $('.pangingDataList').html(hal);
        }
    }
    // menampilkan data pelamar
    ambilDataListPelamar(0,20);    
    /*
     * save data pelamar
     */
    $("#pelamar_save").on("click", function(e){
        //trigger validation
        $("#form-ari").submit(); 
        // window.action_save = function dari master_pelamar_action.js
        action_save();
        //function declaration on master_pelamar_validation.js
        var stat_sav = $("div#status_save").text();
        //get the form data and then serialize that
        //dataString = $("#form-ari").serialize();
        //get the form data using another method
        var ref_code = $("input#ref_code_ari").val();
        var nama = $("input#nama_ari").val();
        var ibu = $("input#nama_ibu").val();
        var jabatan = $("select#jabatan_ari").val();
        var tempat_lahir = $("input#tempat_lahir_ari").val();
        var tanggal_lahir = $("input#tanggal_lahir_ari").val();
        var jenis_kelamin = $("select#jenis_kelamin_ari").val();
        var status_nikah = $("select#status_nikah_ari").val();
        var agama = $("select#agama_ari").val();
        var darah = $("select#gol_Darah").val();
        var kewarganegaraan = $("input#kewarganegaraan_ari").val();
        var no_ktp = $("input#no_ktp_ari").val();
        var no_sim = $("input#no_sim_ari").val();
        var alamat = $("textarea#alamat_ari").val();
        var asal = $("textarea#alamat_ari_asal").val();
        var kode_pos = $("input#kode_pos_ari").val();
        var no_tlpn = $("input#no_tlpn_ari").val();
        var email = $("input#email_ari").val();
        var status_tempat_tinggal = $("select#status_tempat_tinggal_ari").val();
        var hobby = $("input#hoby_ari").val();
        var status_pelamar = $("select#status_pelamar_ari").val();
        var editor_riwayat = $("div.almt_tgl > div.Editor-container > div.Editor-editor").html();
        var pdikan_non_formal = $("div.almt_asl > div.Editor-container > div.Editor-editor").html();
        var user           = $("b#usernya").text();
        var edit = $("#status_edit").html();
        var dataString =    "ref_code=" + ref_code + "&nama=" + nama +  "&ibu=" + ibu + 
                            "&jabatan=" + jabatan + "&tempat_lahir=" + tempat_lahir +
                            "&tanggal_lahir=" + tanggal_lahir + "&jenis_kelamin=" + jenis_kelamin +
                            "&status_nikah=" + status_nikah + "&agama=" + agama + "&darah="+ darah +
                            "&kewarganegaraan=" + kewarganegaraan + "&no_ktp=" + no_ktp +
                            "&o_sim=" + no_sim + "&alamat=" + alamat + "&asal=" + asal +
                            "&kode_pos=" + kode_pos + "&no_tlpn=" + no_tlpn +
                            "&email=" + email + "&status_tempat_tinggal=" + status_tempat_tinggal +
                            "&hoby=" + hobby + "&status_pelamar="+ status_pelamar + "&editor_riwayat=" + editor_riwayat + "&non_formal="+ pdikan_non_formal +
                            "&usernya=" + user;       
        //save
        if (stat_sav == 1 && ( nama !="" && no_ktp != "" && tempat_lahir != "" && tanggal_lahir != ""
                && alamat != "" && no_tlpn != "" && email != ""  && kewarganegaraan != ""  && jabatan != ""
                && editor_riwayat !="" && user !="") && ( edit == 0 )  ) {
                     save_data("&sta=0", dataString);
        } 
        //edit
        else if (stat_sav == 1 && ( nama !="" && no_ktp != "" && tempat_lahir != "" && tanggal_lahir != ""
                && alamat != "" && no_tlpn != "" && email != ""  && kewarganegaraan != ""  && jabatan != ""
                && editor_riwayat !="" && user !="") && ( edit == 1 ) ){
                    save_data("&sta=1", dataString);
        }
        else{
            $("#ajaxResponseError").text("Data tidak komplit " );
        }
        //ubah url
        //window.history.pushState(data, "Title", "master_pelamar.ari");
    });
    function save_data(sta, dataString){
            //make the AJAX request, dataType is set to json
            //meaning we are expecting JSON data in response from the server
            $.ajax({
                type: "POST",
                url: "master_pelamar.ari?xcv=1"+sta,
                data: dataString,
                //dataType: "json",
                beforeSend: function() {
                    //function location on all.js
                     ajaxindicatorstart('loading data.. please wait..');
                     window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
                     
                    //$("#ajaxResponseError").html('Sending....'); // change submit button text
                },
                success: function( data, textStatus, jqXHR) {
                    //reset
                    var form = $('form');  form.trigger('reset');
                    ambilDataListPelamar(0,20);
                },
                error: function(jqXHR, textStatus, errorThrown){
                     //alert ("hallo 5" +textStatus);
                     console.log("Something really bad happened " + textStatus);
                      $("#ajaxResponseError").html(jqXHR.responseText);
                },
                complete: function(jqXHR, textStatus){
                    timeout = setTimeout(ajaxindicatorstop(), 9000);
                    clearTimeout(timeout); 
                    //$("#ajaxResponseError").html('Success');
                    $('#buttonLogin').attr("disabled", false);
                    rst();
                }
            });       
    }
  
    //hapus
     $('#pelamar_delete').on('click', function (e) {
        e.preventDefault();
        var elem = $(this).closest('.item');
         $.confirm({
            'title'	: 'Delete Confirmation',
            'message'	: 'Anda yakin ingin menghapusnya ?',
            'buttons'	: {
                'Yes'	: {
                    'class'	: 'blue',
                    'action': function(){
                        elem.slideUp();
                        hapus();
                        dis_button("pelamar_save", "disabled","pelamar_edit", "enabled","pelamar_delete", "enabled","pelamar_new", "enabled");
                    }
                },
                'No'	: {
                    'class'	: 'gray',
                    'action': function(){
                        elem.slideUp();
                        dis_button("pelamar_save", "disabled","pelamar_edit", "enabled","pelamar_delete", "enabled","pelamar_new", "enabled");
                    }	
                }
            }
        });
   });
    function hapus(){
        var id = $("#ref_code_ari").val();
        $.ajax({
                type: "POST",
                url: "master_pelamar.ari?xcv=1&sta=2",
                data: "ref_code="+id,
                //dataType: "json",
                beforeSend: function() {
                    //function location on all.js
                     ajaxindicatorstart('loading data.. please wait..');
                     window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
                    //$("#ajaxResponseError").html('Sending....'); // change submit button text
                },
                success: function( data, textStatus, jqXHR) {
                    //reset
                    var form = $('form');  form.trigger('reset');
                    ambilDataListPelamar(0,20);
                },
                error: function(jqXHR, textStatus, errorThrown){
                     //alert ("hallo 5" +textStatus);
                     console.log("Something really bad happened " + textStatus);
                      $("#ajaxResponseError").html(jqXHR.responseText);
                },
                complete: function(jqXHR, textStatus){
                    timeout = setTimeout(ajaxindicatorstop(), 9000);
                    clearTimeout(timeout); 
                    //$("#ajaxResponseError").html('Success');
                    $('#buttonLogin').attr("disabled", false);
                }
            });       
    }
    
    /*
    var auto_refresh = setInterval(function () {
            $('#load_tweets').load('record_count.php').fadeIn("slow");
     }, 10000); // refresh every 10000 milliseconds
    $("#showTable").on("click", function(e){
    }); */
    
    /*
     * Membuat paging
     */
    //rumusan pembagian halaman
    var jumlahDataTampil = 20;
    function pagingDataList( jumlahRow){
       jumlahRow =  jumlahRow / jumlahDataTampil;
       //pembulatan ke atas
       //math.floor() pembulatan kebawah
       return Math.ceil(jumlahRow );
    }
    //menentukan batas atas dan bawah untuk query limit
    function batasAtasLimit(batasAtas){
       return  batasAtas * 20;
    }
    function batasBawahLimit(batasAtas){
        return batasAtas - 20;
    }
    // difungsikan load paging atau tidak
    var loadPaging = true;
    //menampilkan data detail pelamar
    $("#ariDataTablePelamar").on("click", function(e){
        $(".tbl-edit").on("click", function(e){
            rst();
            var id = this.id;
            dataString = "ambil_data_id="+ id;
            $.ajax({
                type: "POST",
                url: "master_pelamar.ari?xcv=0",
                data:dataString,
                dataType: "json",
                //if received a response from the server
                beforeSend: function(){
                    ajaxindicatorstart('loading data.. please wait..');
                    window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
                },
                success: function( data, textStatus, jqXHR) {
                   $("input#ref_code_ari").val(data.detailviewpelamar.refCode );
                   $("input#nama_ari").val(data.detailviewpelamar.nama );
                   $("input#nama_ibu").val(data.detailviewpelamar.ibu );
                   $("select#jabatan_ari").val(data.detailviewpelamar.jabatan );
                   $("input#tempat_lahir_ari").val(data.detailviewpelamar.tempatLahir );
                   $("input#tanggal_lahir_ari").val(data.detailviewpelamar.tanggalLahirString);
                   $("select#jenis_kelamin_ari").val(data.detailviewpelamar.jenisKelamin);
                   $("select#status_nikah_ari").val(data.detailviewpelamar.statusNikah);
                   $("select#agama_ari").val(data.detailviewpelamar.agama);
                   $("select#gol_Darah").val(data.detailviewpelamar.darah);
                   $("input#kewarganegaraan_ari").val(data.detailviewpelamar.kewarganegaraan);
                   $("input#no_ktp_ari").val(data.detailviewpelamar.noKtp);
                   $("input#no_sim_ari").val(data.detailviewpelamar.noSim);
                   $("textarea#alamat_ari").val(data.detailviewpelamar.alamat);
                   $("textarea#alamat_ari_asal").val(data.detailviewpelamar.asal);
                   $("input#kode_pos_ari").val(data.detailviewpelamar.kodePos);
                   $("input#no_tlpn_ari").val(data.detailviewpelamar.noHP);
                   $("input#email_ari").val(data.detailviewpelamar.email);
                   $("select#status_tempat_tinggal_ari").val(data.detailviewpelamar.statusTempatTinggal);
                   $("input#tanggal_buat").val(data.detailviewpelamar.tanggal);
                   $("input#hoby_ari").val(data.detailviewpelamar.hoby);
                   $("select#status_pelamar_ari").val(data.detailviewpelamar.statusPelamar);
                   $("div.almt_tgl > div.row-fluid > div.Editor-editor").html(data.detailviewpelamar.editorRiwayat);
                   $("div.almt_asl > div.row-fluid > div.Editor-editor").html(data.detailviewpelamar.nonFormal);
                   action_klik_item();
                },
                complete: function(){
                    // 0 = status tidak bisa di save proses ajax 
                    // 1 = status bisa di save
                    $("div#status_save").text("1");
                    timeout = setTimeout(ajaxindicatorstop(), 9000);
                    clearTimeout(timeout);  
                    //window.setTimeout( ajaxindicatorstop(), 5000 );   
                },
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
                    //alert ("hallo 5" +textStatus);
                    console.log("Something really bad happened " + textStatus);
                    $("#ajaxResponseError").html(jqXHR.responseText);
                }
            });
            /*
            $.post("master_pelamar.ari?xcv=0", {ambil_data_id: id} ,function(data) { 
                $("input#ref_code_ari").val(data.detailviewpelamar.refCode );
                $("input#nama_ari").val(data.detailviewpelamar.nama );
                $("input#jabatan_ari").val(data.detailviewpelamar.jabatan );
                $("input#tempat_lahir_ari").val(data.detailviewpelamar.tempatLahir );
                $("input#tanggal_lahir_ari").val(data.detailviewpelamar.tanggalLahirString);
                $("select#jenis_kelamin_ari").val(data.detailviewpelamar.jenisKelamin);
                $("select#status_nikah_ari").val(data.detailviewpelamar.statusNikah);
                $("select#agama_ari").val(data.detailviewpelamar.agama);
                $("input#kewarganegaraan_ari").val(data.detailviewpelamar.kewarganegaraan);
                $("input#no_ktp_ari").val(data.detailviewpelamar.noKtp);
                $("input#no_sim_ari").val(data.detailviewpelamar.noSim);
                $("textarea#alamat_ari").val(data.detailviewpelamar.alamat);
                $("input#kode_pos_ari").val(data.detailviewpelamar.kodePos);
                $("input#no_tlpn_ari").val(data.detailviewpelamar.noHP);
                $("input#email_ari").val(data.detailviewpelamar.email);
                $("select#status_tempat_tinggal_ari").val(data.detailviewpelamar.statusTempatTinggal);
                $("input#tanggal_buat").val(data.detailviewpelamar.tanggal);
                $("input#hoby_ari").val(data.detailviewpelamar.hoby);
                $("select#status_pelamar_ari").val(data.detailviewpelamar.statusPelamar);
                $("div.Editor-editor").html(data.detailviewpelamar.editorRiwayat);
            });
            */
        });
    });
    //difungsikan menganti selector aktiv paging
    //$(".pangingDataList").text()
    //ul.pagination > li
    //https://arifnd.wordpress.com/2013/06/07/pagination-dan-searcing-menggunakan-php-jquery-dan-twitter-bootstrap/
    $(".pangingDataList").on("click", function(e){
        e.preventDefault();
        $("ul.pagination > li.pagination").on("click", function(e){
            e.preventDefault();
             // difungsikan load paging atau tidak
             // hanya tambahan saja, dihilangkan juga tidak apa2
             loadPaging = true;
             $("ul.pagination > li.active").removeClass("active");
             $("ul.pagination > li#"+this.id).toggleClass("active");
             //menampilkan data dengan query limit batasbawah, batasatas
             //alert("bawah "+ batasBawahLimit(batasAtasLimit(this.id)) + " atas:" +batasAtasLimit(this.id));
             ambilDataListPelamar(batasBawahLimit(batasAtasLimit(this.id))  ,20);
             //agar paging static
             $("#halKe").val(this.id);
        });
    });

    /*
     * ========================================================
     * @returns {undefined}
     * bagian Action
     * =========================================================
     */
    
    //Awal pertama kali load form
    //$("#pelamar_edit")
    /*
    $("#pelamar_new").on("click", function(e){
        var resetForm = ["hoby_ari","email_ari"];
        for (var a = 0; a < resetForm.length; a++){
            $("#"+resetForm[a]).val("");
        }
    });
    */
   
   // tutorial metods/ function javascript http://javascript.info/tutorial/arguments
   /*
    You can set the class (regardless of what it was) by using .attr(), like this:
    $("#td_id").attr('class', 'newClass');
    If you want to add a class, use .addclass() instead, like this:
    $("#td_id").addClass('newClass');
    Or a short way to swap classes using .toggleClass():
    $("#td_id").toggleClass('change_me newClass');
    */
   //location : 
   // functtion(id1, disable_true, id2, disabled_false, id3, disabled_false);
    window.dis_button = function (){
        var mId, mStatus;
        var bts = 0;
        for(var i=0; i<= arguments.length; i++ ) {
            if (( i % 2 ) === 0 || i === 0){
                //difungsikan untuk mengabungkan value dari array => var arr = new Array(); next => arr.push(arguments[i]);
                mId = arguments[i];
            }
            else {
                if(arguments[i] ==="enabled"){
                    $("#"+mId).removeClass("disabled");
                }else if(arguments[i] ==="disabled") {
                    $("#"+mId).removeClass("disabled");
                    $("#"+mId).toggleClass("disabled");
                }
                else {
                    alert("error 129937, master_pelamar_action");
                }
            } 
        }
    };
    $("#pelamar_edit").on("click", function(e){
        e.preventDefault();
        dis_button("pelamar_save", "enabled","pelamar_edit", "disabled","pelamar_delete", "disabled","pelamar_new", "enabled");
        $("#status_edit").html(1);
    });
   
   $('#pelamar_new').on('click', function (e) {
        e.preventDefault();
        document.getElementById("form-ari").reset();
        rst();
        dis_button("pelamar_save", "enabled","pelamar_edit", "disabled","pelamar_delete", "disabled","pelamar_new", "enabled");
   });
   function rst(){
        $(".Editor-editor").empty();
        $("label.error").remove();
        $("input.padding_left_error, textarea.padding_left_error").removeClass("padding_left_error");
        $("#status_edit").html(0);
        $("#ajaxResponseError").empty();
   }
   window.action_save = function(){
       dis_button("pelamar_save", "disabled","pelamar_edit", "disabled","pelamar_delete", "disabled","pelamar_new", "enabled");
   };
   window.action_klik_item = function(){
       dis_button("pelamar_save", "disabled","pelamar_edit", "enabled","pelamar_delete", "enabled","pelamar_new", "enabled");
   };
    function pindahHalaman(){
         try {
            pageurl =  $(this).attr('name');
            //difungsikan untuk merubah address bar
            if(pageurl!==window.location){
                window.history.pushState({path:pageurl},'',pageurl);
            }
            $.ajax({
                url:pageurl,
                beforeSend: function(){
                    //function location on all.js
                     ajaxindicatorstart('loading data.. please wait..');
                     window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
                },
                success: function(data){    
                    $('#content').html(data);
                    /* tidak digunakan
                    $("#content").load("http://localhost:8080/payroll/admin/charts.html", function(responseTxt, statusTxt, xhr){
                        if(statusTxt == "success")
                            //alert("External content loaded successfully!");
                        if(statusTxt == "error")
                            alert("Error: " + xhr.status + ": " + xhr.statusText);
                    });
                    // lebih cepat ini dalam load data
                    $("#content").load("http://localhost:8080/payroll/admin/charts.html",function(){
                        $.getScript("http://localhost:8080/payroll/admin/js/jquery.js"); 
                        $.getScript("http://localhost:8080/payroll/admin/js/bootstrap.min.js");     
                    });
                   */
                },
                 complete: function(){
                     //function location on all.js
                     timeout = setTimeout(ajaxindicatorstop(), 9000);
                     clearTimeout(timeout);  
                     //window.setTimeout( ajaxindicatorstop(), 5000 );   
                }
            });
            //stop refreshing to the page given in
            return false;
        }
        catch(err) {
           $('#catch_error_message').empty();
           alert.html(err);
           $('#catch_error').show();
        }
      /*
       * cara ke 1
       * bisa jalan dengan baik
       try{
                  var url = $(this).attr('name');
                  //$('#content').hide();
                  //$('#content').empty();
                  //$('#loading').delay(50).show('fast');
                  $.ajax({url:url,success:function(data){
                         //$('#loading').delay(1500).fadeOut("fast");
                         //$('#content').delay(2000).fadeIn();
                         //$('#content').empty();
                         window.history.pushState(data, "Title", url);
                         //$('#content').fadeIn(1000).html(data);
                         //alert(result);

                      }});
              }
           catch(err) {
           $('#catch_error_message').empty();
           $('#catch_error_message').html(err);
           $('#catch_error').show();
      }
    */   
    }
    // paggination scoll
    // pagin Next dan Previous
    $(".pangingDataList").on("click", function(e){
        $("#previous").on("click", function(e){
            e.preventDefault();
            pagingPrevious();
        });
        $("#next").on("click", function(e){
            e.preventDefault();
            pagingNext();
        });
    });
    function pagingNext(){
        var totPage = $("#totalPage").val();
        var btsAwl = $("#batasAwal").val();
        var jumlah = 10;
        var btsAkhir = jumlah + eval(btsAwl) ;
        var hal = "<div class='page'><ul class='pagination'> <li id='previous'><a href='#' >&laquo;</a></li>";
            for (var i = eval(btsAwl) + 1 ; i < btsAkhir + 1; i++ ){
                var dataNya = "<li id='"+ i+"' class='pagination' ><a href='#' >"+ i + "</a></li>";               
                hal += dataNya;
                if (btsAkhir === i){
                    $("#batasAwal").val(btsAkhir);
                }
                //jika i lebih besar dari total row maka break 
                if(i >= totPage ){
                    break;
                }
            }
        hal +=  "<li id='next'><a href='#'>&raquo;</a></li></ul></div>";
        $('.pangingDataList').html(hal);
    }
    function pagingPrevious(){
        var jumlah = 10;
        var totPage = $("#totalPage").val();
        var btsAkhir = $("#batasAwal").val() ;
        var btsAwl = eval(btsAkhir) - eval(jumlah );
        var hal = "<div class='page'><ul class='pagination'> <li id='previous'><a href='#' >&laquo;</a></li>";
        //menangulangi pagging minus
        if (btsAwl >= 0 && btsAwl <= totPage ){
            btsAkhir = eval(btsAkhir); 
            for (var i = btsAwl ; i < btsAkhir + 1; i++ ){
                if (i === 0 ){continue}
                var dataNya = "<li id='"+ i+"' class='pagination' ><a href='#' >"+ i + "</a></li>";               
                hal += dataNya;
                //update data
                if (i === btsAkhir){
                    $("#batasAwal").val(btsAwl);
                }
            }
            hal +=  "<li id='next'><a href='#'>&raquo;</a></li></ul></div>";
            $('.pangingDataList').html(hal);
        }   
    }

    /*
     * Tanggal
     */
     //tanggal filter range periode
     $('#filterRange').datepick({ 
        dateFormat: 'dd/mm/yyyy' ,
        rangeSelect: true, monthsToShow: 2, showTrigger: '#calImg'

    });
    //tanggal lahir
    $(".datepicker").datepicker({
        dateFormat: 'dd/mm/yy' 
    }).val();
   
    var data = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];
    $(".js-example-data-array-selected").select2({
        width: 'resolve',
        data: data
     });
        
    $(".js-example-basic-multiple").select2({
          width: "100%",
          height: 5,
          data :data
    });
    
    /*
     * change navbar-left top-nav ke navbar-nav side-nav
     * next time oprek
     * 
     * You can set the class (regardless of what it was) by using .attr(), like this:

        $("#td_id").attr('class', 'newClass');
        If you want to add a class, use .addclass() instead, like this:

        $("#td_id").addClass('newClass');
        Or a short way to swap classes using .toggleClass():

        $("#td_id").toggleClass('change_me newClass');
        http://stackoverflow.com/questions/3452778/jquery-change-class-name
     */
    //difungsikan jika tampilan dikecilkan maka desain menu berubah
    $("#menu-utama").click(function(e){
           $("#menu-change").toggleClass('nav navbar-left top-nav nav navbar-nav side-nav');
    });
    
    /*
    $( window ).resize(function() {
        //$( "#log" ).append( "<div>Handler for .resize() called.</div>" );
        $("#menu-change").toggleClass('nav navbar-nav side-nav nav navbar-left top-nav');
        
      });
    */
});
/*
 * 
 * @type Number
 * end document function of 
 */
    
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    var x = 0; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        // dapatkan item name dan qty
        var item = $(".js-data-example-ajaxs").val();
        var qty  = $(".valueQtyAri").val();
        if(x <= max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append(
            '<div><div style="margin-top: 5px">'+
            '<div class="line-item-index">'+x+'</div>'+
            '<div class="line-item-product"><input  type="text" value="'+ item +'" name="mytext['+x+']" class="form-control valueAri" style="width: 400px;"  disabled>  </div>'+
            '<div class="store-qty-label" >1</div>'+
            '<span class="integer required sale_sale_lines_item_quantity"><input  class="input-quantity" style="width: 40px;" value="'+ qty +'" id="sale_sale_lines_attributes_0_item_quantity" type="text" disabled /></span> '+
            '<div class="price-label"></div>'+
            '<div class="discount-label"></div>'+
            '<div class="amount-label"></div>'+
            '<input id="sale_sale_lines_attributes_0_company_id" name="sale[sale_lines_attributes][0][company_id]" type="hidden" value="1" />'+
            '<a href="#" class="remove_field glyphicon glyphicon-remove col-md-offset-10"></a></div>'+
    '</div></div>'); //add input box
        }
    });
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    });
        
    // PICK THE VALUES FROM EACH TEXTBOX WHEN "SUBMIT" BUTTON IS CLICKED.
    var divValue, values = '';
    function GetTextValueDinamik1() {
        /*
         * alert("Selected value is: "+$(".js-data-example-ajaxs").select2("val"));
         * OR
         * get value from select2 basic regular, BELOW
         */
        //alert("Selected value is: "+$(".js-data-example-ajaxs").val());
        //alert("Selected value is: "+$(".js-data-example-ajaxs").select2("val"));

        var theID = $(test).select2('val').id;
            var theSelection = $(test).select2('val').text;
            //alert(theID +"hahaha");
            $('#selectedID').text(theID);
            $('#selectedText').text(theSelection);

        $(divValue).empty(); 
        $(divValue).remove(); values = '';

        $('.valueAri').each(function() {
            divValue = $(document.createElement('div')).css({
                padding:'5px', width:'200px'
            });
            values += this.value + '<br/>'
        });

        $(divValue).append('<p><b>Your selected values</b></p>' + values);
        $('body').append(divValue);
    }

/*
 * end
 */


