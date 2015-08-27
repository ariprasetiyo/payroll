/*
 * dimamik item 
 */
$(document).ready(function() {
    //difungsikan untuk combo search box data karyawan
    //tampilan
    $(".js-data-example-ajaxs").select2({
        minimumInputLength: 3,
        quietMillis: 10,
        allowClear : true,
        //panjang select2
        width: "100%",
        ajax: {
            //menuju ke cobaAjax_multi_fields_dinamis2.java
            url: "presensi_izin_lembur.ari?sta=01&xcv=5",
            dataType: 'json',
            delay: 250,
            data: function (params) {

                return {
                  q: params.term, // search term
                  page: params.page
                };
              },
            processResults: function (data, page) {
                return { results: data, text: 'client' };
            } 
        },
        id: function(object) {
            return object.text;
        },
        error: function(){
            alert('error');
        }
    });
    //pencarian karyawan untuk izin cuti
    $('#search_select_karyawan').on("select2:select", function (e) { 
        var id      = $('#search_select_karyawan').val();
        var n = $("select#jenis_izin_cuti_ari").val();
        var user    = $("b#usernya").text();
        $.post("presensi_izin_lembur.ari?xcv=5", {id_karyawan: id, usernya : user, sta: '01', pil_izin_cuti: n} ,function(data) { 
             $("input#jabatan_ari_izin_cuti").val(data.dataJabatan.jabatan );
             $("input#sisa_izin_cuti").val(data.dataJabatan.sisaCutiTahunan );
        });
    });
    $('#jenis_izin_cuti_ari').on('change', function(e){
        var n = $(this).val();
        var user    = $("b#usernya").text();
        var id = $('#search_select_karyawan').val();
        $.post("presensi_izin_lembur.ari?xcv=6", {pil_izin_cuti: n,id_karyawan: id, usernya : user, sta:'01'}, function(data){
            $("input#sisa_izin_cuti").val(data.dataSisaCuti.sisaCutiTahunan );
        });
    });
    $('input#jum_izin_cuti').keyup(function( event ) {
        var sisa_cuti = $('input#sisa_izin_cuti').val();
          var sisa =  sisa_cuti - $("input#jum_izin_cuti").val() ;
          if (sisa >= 0){}
          else {
              alert("Sisa cuti hanya " + sisa_cuti);
              $("input#jum_izin_cuti").val(sisa_cuti) ;
          }
   });
   
   //bagian izin sakit
    $('#search_select_karyawan_sakit').on("select2:select", function (e) { 
        var id      = $('#search_select_karyawan_sakit').val();
        var user    = $("b#usernya").text();
        $.post("presensi_izin_lembur.ari?xcv=7", {id_karyawan: id, usernya : user, sta: '01'} ,function(data) { 
             $("input#jabatan_ari_izin_sakit").val(data.dataJabatan.jabatan );
        });
    });
    
     //bagian lembur
    $('#search_select_karyawan_lembur').on("select2:select", function (e) { 
        var id      = $('#search_select_karyawan_lembur').val();
        var user    = $("b#usernya").text();
        $.post("presensi_izin_lembur.ari?xcv=7", {id_karyawan: id, usernya : user, sta: '01'} ,function(data) { 
             $("input#jabatan_ari_lembur").val(data.dataJabatan.jabatan );
        });
    });
  
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
                +"&f_id_kar="+$(".f_id_kar").val()
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
            url: "presensi_izin_lembur.ari?xcv="+pintu+"",
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
                         var data_table ="<tr> <td class='col-xs-1 text-center' ><a href='#' class='info tbl-edit' id='"+data.dataTable[i].refCode +"'> "+data.dataTable[i].refCode+"</a></td>"
                                        +"<td class='text-center' nowrap> "+data.dataTable[i].idKaryawan+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].nama+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].jabatan+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].statusPresensi+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].tanggalMulai+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].tanggalSelesai+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].ket+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].tanggalDibuat+"</td>"
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
        // window.action_save = function dari master_pelamar_action.js
        action_save();
         var tab_home = $("#home_detection").attr("class");
         var tab_izin_sakit = $("#izin_sakit_detection").attr("class");
         var tab_izin_lembur = $("#form_lembur_decetion").attr("class");
         var id_kar,ref_code, jab, tglA, tglB, jenisIzinCuti, ket, katLembur, jum, user;
         var sta = $("#status_edit").html();
         if (tab_home === 'active'){
             id_kar = $("select#search_select_karyawan").val();
             jab = $("input#jabatan_ari_izin_cuti").val();
             jenisIzinCuti = $("select#jenis_izin_cuti_ari").val();
             jum = $("input#jum_izin_cuti").val();
             tglA = $("input#tgl_cuti_mulai").val();
             tglB = $("input#tgl_cuti_selesai").val();
             ket = $("textarea#ket_izin_cuti").val();
             user           = $("b#usernya").text();
             ref_code = $("input#ref_izin_cuti").val();
             var dataString = "id_kar="+ id_kar+"&jab="+jab+"&jenisIzinCuti="
                     +jenisIzinCuti+"&jum="+jum+"&tglA="+tglA+"&tglB="+tglB+"&ket="+ket+"&jenis_presensi=0"+"&usernya="+user+"&ref_code="+ ref_code ;
             save_data("&sta="+sta, dataString);
         }
         else if (tab_izin_sakit === 'active'){
             id_kar = $("select#search_select_karyawan_sakit").val();
             jab = $("input#jabatan_ari_izin_sakit").val();
             jum = $("input#jum_izin_sakit").val();
             tglA = $("input#tgl_izin_sakit_mulai").val();
             tglB = $("input#tgl_izin_sakit_selesai").val();
             ket = $("textarea#ket_izin_sakit").val();
             ref_code = $("input#ref_code_izin_sakit").val();
             user           = $("b#usernya").text();
             var dataString = "id_kar="+ id_kar+"&jab="+jab+"&jum="+jum+"&tglA="+tglA+"&tglB="+tglB+"&ket="+ket+"&jenis_presensi=1"+"&usernya="+user +"&ref_code="+ ref_code ;
             save_data("&sta="+sta, dataString);
         }
         else if (tab_izin_lembur === 'active'){
             id_kar = $("select#search_select_karyawan_lembur").val();
             jab = $("input#jabatan_ari_lembur").val();
             jum = $("input#jum_lembur").val();
             katLembur = $("select#katagori_form_lembur").val();
             tglA = $("input#tgl_lembur_mulai").val();
             tglB = $("input#tgl_lembur_selsai").val();
             ket = $("textarea#ket_form_lembur").val();
             user           = $("b#usernya").text();
             ref_code = $("input#ref_code_form_lembur").val();
             var dataString = "id_kar="+ id_kar+"&jab="+jab+"&katLembur="
                     +katLembur+"&jum="+jum+"&tglA="+tglA+"&tglB="+tglB+"&ket="+ket +"&jenis_presensi=2"+"&usernya="+user+"&ref_code="+ ref_code ;
             save_data("&sta="+sta, dataString);
         }
        else{
            $("#ajaxResponseError").text("tidak ada pilihan tab " );
        }
        //ubah url
        //window.history.pushState(data, "Title", "master_pelamar.ari");
    });
    function save_data(sta, dataString){
            //make the AJAX request, dataType is set to json
            //meaning we are expecting JSON data in response from the server
            $.ajax({
                type: "POST",
                url: "presensi_izin_lembur.ari?xcv=01"+sta,
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
        var id;
        var tab_home = $("#home_detection").attr("class");
        var tab_izin_sakit = $("#izin_sakit_detection").attr("class");
        var tab_izin_lembur = $("#form_lembur_decetion").attr("class");
        if (tab_home === 'active'){
            id = $("#ref_izin_cuti").val();
            id += "&jenis_presensi=0";
        }
        else if (tab_izin_sakit === 'active'){
            id = $("#ref_code_izin_sakit").val();
             id += "&jenis_presensi=1";
        }
        else if (tab_izin_lembur === 'active'){
            id = $("#ref_code_form_lembur").val();
             id += "&jenis_presensi=2";
        }
        else{
            $("#ajaxResponseError").text("tidak ada pilihan tab " );
        }
       
        $.ajax({
                type: "POST",
                url: "presensi_izin_lembur.ari?xcv=01&sta=2",
                data: "ref_code="+id,
                //dataType: "json",
               
                beforeSend: function() {
                    //function location on all.js
                     alert(id);
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
                url: "presensi_izin_lembur.ari?xcv=0",
                data:dataString,
                dataType: "json",
                //if received a response from the server
                beforeSend: function(){
                    ajaxindicatorstart('loading data.. please wait..');
                    window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
                },
                success: function( data, textStatus, jqXHR) {
                    //cuti
                    if (data.detailview.jenisIzinCutiOrSakit === "0"){
                        /*
                         * You can set the class (regardless of what it was) by using .attr(), like this:
                        $("#td_id").attr('class', 'newClass');
                        If you want to add a class, use .addclass() instead, like this:
                        $("#td_id").addClass('newClass');
                        Or a short way to swap classes using .toggleClass():
                        $("#td_id").toggleClass('change_me newClass');
                         */
                        $("#home_detection").removeClass().addClass("active");
                        $("#home").addClass("active");
                        $("#izin_sakit_detection").removeClass("active");
                        $("#izin_sakit").removeClass("active");
                        $("#form_lembur_decetion").removeClass("active");
                        $("#form_lembur").removeClass("active");
                        $("input#ref_izin_cuti").val(data.detailview.refCode );
                        $("input#tanggal_buat_izin_cuti").val(data.detailview.tanggalDibuat);
                        //satu paket
                        $("#select2ValueAriIzin").val(data.detailview.idKaryawan);
                        $("#select2-search_select_karyawan-container").html(data.detailview.nama + " ( " +data.detailview.idKaryawan+ " )" );
                        
                        $("input#jabatan_ari_izin_cuti").val(data.detailview.jabatan );
                        $("select#jenis_izin_cuti_ari").val(data.detailview.jenisIzinCuti);
                        $("input#jum_izin_cuti").val(data.detailview.jumlahIzinCuti);
                        $("input#tgl_cuti_mulai").val(data.detailview.tanggalMulai);
                        $("input#tgl_cuti_selesai").val(data.detailview.tanggalSelesai);
                        $("textarea#ket_izin_cuti").val(data.detailview.ket);
                    }
                     //sakit
                    else if (data.detailview.jenisIzinCutiOrSakit === "1"){             
                        $("#home_detection").removeClass("active");
                        $("#home").removeClass("active");
                        $("#izin_sakit_detection").removeClass().addClass("active");
                        $("#izin_sakit").addClass("active");
                        $("#form_lembur_decetion").removeClass("active");
                        $("#form_lembur").removeClass("active");
                        $("input#ref_code_izin_sakit").val(data.detailview.refCode );
                        $("input#tanggal_buat_izin_sakit").val(data.detailview.tanggalDibuat);
                        //satu paket
                        $("#select2ValueAriSakit").val(data.detailview.idKaryawan);
                        $("#select2-search_select_karyawan_sakit-container").html(data.detailview.nama + " ( " +data.detailview.idKaryawan+ " )" );
                        
                        $("input#jabatan_ari_izin_sakit").val(data.detailview.jabatan );
                        //$("select#jenis_izin_cuti_ari").val(data.detailview.jenisIzinCuti);
                        $("input#jum_izin_sakit").val(data.detailview.jumlahIzinCuti);
                        $("input#tgl_izin_sakit_mulai").val(data.detailview.tanggalMulai);
                        $("input#tgl_izin_sakit_selesai").val(data.detailview.tanggalSelesai);
                        $("textarea#ket_izin_sakit").val(data.detailview.ket);
                        
                    }
                    //lembur
                    else {
                        $("#home_detection").removeClass("active");
                        $("#home").removeClass("active");
                        $("#izin_sakit_detection").removeClass("active")
                        $("#izin_sakit").removeClass("active");
                        $("#form_lembur_decetion").removeClass().addClass("active");
                        $("#form_lembur").addClass("active");
                        $("input#ref_code_form_lembur").val(data.detailview.refCode );
                        $("input#tanggal_buat_form_lembur").val(data.detailview.tanggalDibuat);
                        //satu paket
                        $("#select2ValueAriLembur").val(data.detailview.idKaryawan);
                        $("#select2-search_select_karyawan_lembur-container").html(data.detailview.nama + " ( " +data.detailview.idKaryawan+ " )" );
                        
                        $("input#jabatan_ari_lembur").val(data.detailview.jabatan );
                        $("select#katagori_form_lembur").val(data.detailview.jenisIzinCuti);
                        $("input#jum_lembur").val(data.detailview.jumlahIzinCuti);
                        $("input#tgl_lembur_mulai").val(data.detailview.tanggalMulai);
                        $("input#tgl_lembur_selsai").val(data.detailview.tanggalSelesai);
                        $("textarea#ket_form_lembur").val(data.detailview.ket);

                    }
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
        //$("#select").select2("val"); //get the value
        //satu pakets
        $(".removeSelect2").val("-");
        $('.js-data-example-ajaxs').select2("val", "-");
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
    //jika class sama dan id beda maka akan terhitung beda
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
 * end
 */


