/*
 * dimamik item 
 */
$(document).ready(function() {
    //currency number format indonesia
    $('#g_pkok,#t_kjinan,#t_op,#t_bpjs_ktnagakerjaan,#t_bpjs_kes,#t_kes,#t_pen,#t_tran,#t_makan,#t_jab,#t_lain,#p_pin_kar,#p_bpjs_ket,#p_bpjs_kes'+
    ',#p_asr_kes,#p_den,#p_pjk,#p_bpjs_ket').maskMoney({prefix:'Rp. ', thousands:'.', decimal:',', precision:0, allowZero:true});
    
    //only number
    /*
    * source http://jsfiddle.net/techrevolt/Fp4sJ/
    * input hanya angka saja
    */
    $("#jum_cut").on("keypress keyup blur",function (event) {    
        $(this).val($(this).val().replace(/[^\d].+/, ""));
        if ((event.which === 8 ||  (  event.which >= 48 && event.which <= 58 ) ) ) {
            //event.preventDefault();
        }
        else {
            //mencegah
            event.preventDefault();
        }
    });
    $("#data_gaji").validate(
        {
        rules: {
            nama_ari:{
                required: true,
                minlength:1,
                maxlength:15
            }
        },
        messages: {
             nama_ari:{
                required: "Harus diisi",
                minlength:"Min diisi 1 digit",
                maxlength:"max 15 digit"
            }
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
                +"&f_area="+$(".f_area").val()
                +"&f_s_plmr="+$(".f_s_plmr").val()
                +"&f_s_karyawan="+$(".f_s_karyawan").val()
            //alert(f_tgl_buat1+"dan"+f_tgl_buat2);
           // if (typeof periode[1] !== 'undefined'){
                +"&f_tgl_buat1="+tgl1
                +"&f_tgl_buat2="+tgl2;
           // }
        }
        //menampilkan data  ( listing data )
        $.ajax({
            type: "GET",
            url: "master_karyawan.ari?xcv="+pintu+"",
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
                         var data_table ="<tr> <td class='text-center'><a href='#' class='info tbl-edit' id='"+data.dataTable[i].id +"'> "+data.dataTable[i].id+"</a></td>"
                                        +"<td class='text-center' nowrap> <a href='#' class='info tbl-edit' id='"+data.dataTable[i].idPelamar +"'> "+data.dataTable[i].idPelamar+"</a></td>"
                                        +"<td class='text-center' nowrap> "+data.dataTable[i].nama+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].jabatan+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].jenisKelamin+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].noHP+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].area+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].nama_cabang+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].sts_pegawai+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].statusPelamar+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].tanggal+"</td>"
                                        +"<td class='text-center' nowrap><a id='"+data.dataTable[i].id +"' data-toggle='modal' data-target='#v_edit' class='btn btn-primary kryw_edit'><div class='glyphicon glyphicon-edit'></div></a> <a id='kryw_del' class='btn btn-primary'><div class='glyphicon glyphicon-remove'></div></a></td>"
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
    /*
     * save data pegawai
     */
    $("#save_data").on("click", function(e){
        //var stat_sav = $("div#status_save").text();
        var id = $("input#id").val();
        var jum_cut_tahunan = $("input#jum_cut_tahunan").val();
        var jum_cut_5_tahunan = $("input#jum_cut_5_tahunan").val();
        var jabatan_ari = $("select#jabatan_ari").val();
        var area = $("select#area").val();
        var cabang = $("input#cabang").val();
        var g_pkok = $("input#g_pkok").val();
        var t_kjinan = $("input#t_kjinan").val();
        var t_op = $("input#t_op").val();
        var t_bpjs_ktnagakerjaan = $("input#t_bpjs_ktnagakerjaan").val();
        var t_bpjs_kes = $("input#t_bpjs_kes").val();
        var t_kes = $("input#t_kes").val();
        var t_pen = $("input#t_pen").val();
        var t_tran = $("input#t_tran").val();
        var t_makan = $("input#t_makan").val();
        var t_jab = $("input#t_jab").val();
        var t_lain = $("input#t_lain").val();
        var p_pin_kar = $("input#p_pin_kar").val();
        var p_bpjs_ket = $("input#p_bpjs_ket").val();
        var p_bpjs_kes = $("input#p_bpjs_kes").val();
        var p_asr_kes = $("input#p_asr_kes").val();
        var p_den = $("input#p_den").val();
        var p_pjk = $("input#p_pjk").val();
        var sts_pegawai = $("input:radio[name=sts_pegawai]:checked").val();
        var p_kontrak_f = $("input#p_kontrak_f").val();
        var p_kontrak_e = $("input#p_kontrak_e").val();
        var user           = $("b#usernya").text();
        var tgl_dibuat  = $("input#tgl_dibuat").val();
        //var edit = $("#status_edit").html();
        var dataString =    "id=" + id + "&jum_cut_tahunan=" + jum_cut_tahunan + "&jum_cut_5_tahunan=" + jum_cut_5_tahunan + 
                            "&area=" + area + "&jabatan_ari="+jabatan_ari+
                            "&cabang=" + cabang + "&g_pkok=" + g_pkok +
                            "&t_kjinan=" + t_kjinan + "&t_op=" + t_op +
                            "&t_bpjs_ktnagakerjaan=" + t_bpjs_ktnagakerjaan + "&t_bpjs_kes=" + t_bpjs_kes + "&t_kes="+ t_kes +
                            "&t_pen=" + t_pen + "&t_tran=" + t_tran +
                            "&t_makan=" + t_makan + "&t_jab=" + t_jab + "&t_lain=" + t_lain +
                            "&p_pin_kar=" + p_pin_kar + "&p_bpjs_ket=" + p_bpjs_ket +
                            "&p_bpjs_kes=" + p_bpjs_kes + "&p_asr_kes=" + p_asr_kes +
                            "&p_den=" + p_den + "&p_pjk="+ p_pjk + "&sts_pegawai=" + sts_pegawai + "&p_kontrak_f="+ p_kontrak_f +
                            "&p_kontrak_e="+ p_kontrak_e +"&usernya=" + user+"&tgl_dibuat="+ tgl_dibuat;       
        //save
        if (id != "" && ( jum_cut_tahunan !="" && jum_cut_5_tahunan !="" && area != "" && cabang != "" && g_pkok != "")  ) {
            saveNewHistoryOrUpdate(dataString);
        }
        else{
            $("#ajaxResponseError").text("Data tidak komplit " );
        }
        //ubah url
        //window.history.pushState(data, "Title", "master_pelamar.ari");
    });
    //validation save data gaji pegawai
    function saveNewHistoryOrUpdate(dataString){
        var elem = $(this).closest('.item');
        $.confirm({
            'title'	: 'Save Confirmation',
            'message'	: 'Save New Data Or Update Data ?',
            'buttons'	: {
                'Save'	: {
                    'class'	: 'blue',
                    'action': function(){
                        save_data("&sta=0", dataString);
                    }
                },
                'Update'	: {
                    'class'	: 'gray',
                    'action': function(){
                         save_data("&sta=1", dataString);
                    }	
                },
                'Cancel'	: {
                    'class'	: 'close2',
                    'action': function(){
                        //<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        //elem.slideUp();
                        //$(".close2").attr("aria-hidden", true).attr("data-dismiss","modal");
                        //$("#content").attr("class","");
                        //$(".modal-backdrop").empty();       
                    
                    }	
                    
                }
            }
        });
    }
    function save_data(sta, dataString){
            $.ajax({
                type: "POST",
                //0 = simpan, 1 = update
                url: "master_karyawan.ari?xcv=1"+sta,
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
    //ambil data gaji, tunjangan, dan potongan untuk di edit
   $("#ariDataTablePelamar").on("click",".kryw_edit", function(){
        var id = this.id;
        dataString = "id_nya="+ id;
        $.ajax({
            type: "POST",
            url: "master_karyawan.ari?xcv=0",
            data:dataString,
            dataType: "json",
            //if received a response from the server
            beforeSend: function(){
                ajaxindicatorstart('loading data.. please wait..');
                window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
            },
            success: function( data, textStatus, jqXHR) {
               var rp= "Rp. ";
               $("input#id").val(data.detailview.id );
               $("input#nama").val(data.detailview.nama );
               $("input#jum_cut_tahunan").val(data.detailview.cuti );
               $("input#jum_cut_5_tahunan").val(data.detailview.cuti5 );
               $("select#area").val(data.detailview.area );
               $("select#jabatan_ari").val(data.detailview.jabatan );
               $("input#cabang").val(data.detailview.nama_cabang );
               $("input#g_pkok").val(rp+data.detailview.gaji);
               $("input#t_kjinan").val(rp+data.detailview.t_kerajinan);
               $("input#t_op").val(rp+data.detailview.t_operational);       
               $("input#t_bpjs_ktnagakerjaan").val(rp+data.detailview.t_bpjs_ketenagakerjaan);
               $("input#t_bpjs_kes").val(rp+data.detailview.t_bpjs_kesehatan);
               $("input#t_kes").val(rp+data.detailview.t_kesehatan);
               $("input#t_pen").val(rp+data.detailview.t_penepatan);
               $("input#t_tran").val(rp+data.detailview.t_transport);
               $("input#t_makan").val(rp+data.detailview.t_makan);
               $("input#t_jab").val(rp+data.detailview.t_jabatan);
               $("input#t_lain").val(rp+data.detailview.t_lainnya);
               $("input#p_pin_kar").val(rp+data.detailview.p_pinjaman_karyawan);
               $("input#p_bpjs_ket").val(rp+data.detailview.p_bpjs_ketenagakerjaan);
               $("input#p_bpjs_kes").val(rp+data.detailview.p_bpjs_kesehatan);
               $("input#p_asr_kes").val(rp+data.detailview.p_asr_kesehatan);
               $("input#p_den").val(rp+data.detailview.p_denda_kedisiplinan);
               $("input#p_pjk").val(rp+data.detailview.p_pajak);
               $('input:radio[name=sts_pegawai]')[data.detailview.sts_pegawai].checked = true;
               $("input#p_kontrak_f").val(data.detailview.s_periode);
               $("input#p_kontrak_e").val(data.detailview.e_periode);
               $("input#tgl_dibuat").val(data.detailview.tanggal_dibuat);
               
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
    
    function setPaggination(){
        var jmlhRow =  $("#jmlhRow").val();
        var totPage = pagingDataList(jmlhRow);
        $("#totalPage").val(totPage);
        //$("batasAwal").val(10);
        if (jmlhRow > 0 && loadPaging === true && $("#halKe").val() <= 10){
            //$(".page").remove();
            var hal = "<div class='page'><ul class='pagination' style='margin: 0px 0px;'> <li id='previous'><a href='#' >&laquo;</a></li>";
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

    function hapus(){
        var id = $("#ref_code_ari").val();
        $.ajax({
                type: "POST",
                url: "master_karyawan.ari?xcv=1&sta=2",
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
                    alert("error 129937, master_karyawan_action");
                }
            } 
        }
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
        var hal = "<div class='page'><ul class='pagination' style='margin: 0px 0px;' > <li id='previous'><a href='#' >&laquo;</a></li>";
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
        var hal = "<div class='page'><ul class='pagination' style='margin: 0px 0px;' > <li id='previous' ><a href='#' >&laquo;</a></li>";
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
    
    $('input#p_kontrak_f' ).keyup(function() {
        /*
         * var dateFormat = $(this).val();
        var dateFormat = $.datepicker.formatDate('dd/MM/yyyy', new Date(dateFormat));
        //alert(dateFormat);
        $(this).html(dateFormat + "<br>");
        */
        var txtVal =  $(this).val();
        validDateMassage(txtVal,"#date_f");
    });
    $('input#p_kontrak_e' ).keyup(function() {
        var txtVal =  $(this).val();
        validDateMassage(txtVal, "#date_e");
        
    });
    function validDateMassage(txtVal, id){
        if(isDate(txtVal))
              $(id).text("Valid Date");
          else
              $(id).text("Invalid Date");
    };
    function isDate(txtDate)
      {
          var currVal = txtDate;
          if(currVal == '')
              return false;
          var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/; //Declare Regex
          var dtArray = currVal.match(rxDatePattern); // is format OK?

          if (dtArray == null) 
              return false;

          //Checks for mm/dd/yyyy format.
          dtMonth = dtArray[1];
          dtDay= dtArray[3];
          dtYear = dtArray[5];        

          if (dtMonth < 1 || dtMonth > 12) 
              return false;
          else if (dtDay < 1 || dtDay> 31) 
              return false;
          else if ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay ==31) 
              return false;
          else if (dtMonth == 2) 
          {
              var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
              if (dtDay> 29 || (dtDay ==29 && !isleap)) 
                      return false;
          }
          return true;
      }
    
    //tanggal lahir
    $(".datepicker").datepicker({
        dateFormat: 'dd/mm/yy' 
    }).val();
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

});
