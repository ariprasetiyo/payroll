$(document).ready(function() {
    //Stops the submit request
    $("#form-ari").submit(function(e){
           e.preventDefault();
    });
 
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
                +"&f_search_now="+$(".f_search_now").val()
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
                                        +"<td class='text-center'> "+data.dataTable[i].nama+"</td>"
                                        +"<td class='col-xs-2 text-center' >"+data.dataTable[i].jabatan+"</td>"
                                        +"<td class='col-xs-1 text-center' >"+data.dataTable[i].jenisKelamin+"</td>"
                                        +"<td class='col-xs-2' >"+data.dataTable[i].noHP+"</td>"
                                        +"<td class='col-xs-1 text-center' >"+data.dataTable[i].statusPelamar+"</td>"
                                        +"<td class='col-xs-2 text-center' >"+data.dataTable[i].tanggal+"</td>"
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
        //function declaration on master_pelamar_validation.js
        validationPelamar();
        var stat_sav = $("div#status_save").text();
        //get the form data and then serialize that
        //dataString = $("#form-ari").serialize();
        //get the form data using another method
        var ref_code = $("input#ref_code_ari").val();
        var nama = $("input#nama_ari").val();
        var jabatan = $("input#jabatan_ari").val();
        var tempat_lahir = $("input#tempat_lahir_ari").val();
        var tanggal_lahir = $("input#tanggal_lahir_ari").val();
        var jenis_kelamin = $("select#jenis_kelamin_ari").val();
        var status_nikah = $("select#status_nikah_ari").val();
        var agama = $("select#agama_ari").val();
        var kewarganegaraan = $("input#kewarganegaraan_ari").val();
        var no_ktp = $("input#no_ktp_ari").val();
        var no_sim = $("input#no_sim_ari").val();
        var alamat = $("textarea#alamat_ari").val();
        var kode_pos = $("input#kode_pos_ari").val();
        var no_tlpn = $("input#no_tlpn_ari").val();
        var email = $("input#email_ari").val();
        var status_tempat_tinggal = $("select#status_tempat_tinggal_ari").val();
        var hobby = $("input#hoby_ari").val();
        var status_pelamar = $("select#status_pelamar_ari").val();
        var editor_riwayat = $("div.Editor-editor").html();
        var user           = $("b#usernya").text();
        var edit = $("#status_edit").html();
        dataString =    "ref_code=" + ref_code + "&nama=" + nama + 
                            "&jabatan=" + jabatan + "&tempat_lahir=" + tempat_lahir +
                            "&tanggal_lahir=" + tanggal_lahir + "&jenis_kelamin=" + jenis_kelamin +
                            "&status_nikah=" + status_nikah + "&agama=" + agama +
                            "&kewarganegaraan=" + kewarganegaraan + "&no_ktp=" + no_ktp +
                            "&o_sim=" + no_sim + "&alamat=" + alamat +
                            "&kode_pos=" + kode_pos + "&no_tlpn=" + no_tlpn +
                            "&email=" + email + "&status_tempat_tinggal=" + status_tempat_tinggal +
                            "&hoby=" + hobby + "&status_pelamar="+ status_pelamar + "&editor_riwayat=" + editor_riwayat +
                            "&usernya=" + user;
        //save
        if (stat_sav == 1 && ( nama !="" && no_ktp != "" && tempat_lahir != "" && tanggal_lahir != ""
                && alamat != "" && no_tlpn != "" && email != ""  && kewarganegaraan != ""  && jabatan != ""
                && editor_riwayat !="" && user !="") && ( edit == 0 )  ) {
                     save_data("&sta=0", dataString);
        } 
        //delete
        else if (stat_sav == 1 && ( nama !="" && no_ktp != "" && tempat_lahir != "" && tanggal_lahir != ""
                && alamat != "" && no_tlpn != "" && email != ""  && kewarganegaraan != ""  && jabatan != ""
                && editor_riwayat !="" && user !="") && ( edit == 1 ) ){
                    save_data("&sta=1", dataString);
        }
        else{
            $("#ajaxResponseError").text("Data tidak komplit " );
        }
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
                }
            });       
    }
    //hapus
     $('#pelamar_delete').on('click', function (e) {
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
    //belum difungsikan
    $(".s").on("click", function(e){
        // mengambil nilai dari inputbox
        //kd_hal = this.id;
        //alert (kd_hal);
        /*
        $.post(main, {halaman: kd_hal} ,function(data) {
            // tampilkan data mahasiswa yang sudah di perbaharui
            // ke dalam <div id="data-mahasiswa"></div>
            $("#data-mahasiswa").html(data).show();
        });
        
          $('#submit').on("click", function(e) {  
                 var username=$('#user').val();
                 
                 $.get('event_master_pelamar_pagging',{user:username},function(responseText) { 
                        $('#welcometext').text(responseText);         
                    });
                });
        */
    });
    //menampilkan data detail pelamar
    $("#ariDataTablePelamar").on("click", function(e){
        $(".tbl-edit").on("click", function(e){
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
        $("ul.pagination > li.pagination").on("click", function(e){
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

});
