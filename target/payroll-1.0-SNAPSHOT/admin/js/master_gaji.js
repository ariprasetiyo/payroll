/*
 * dimamik item 
 */
$(document).ready(function() {
  

$('.av').maskMoney({prefix:'Rp. ', thousands:'.', decimal:',', precision:0, allowZero:true});
  /*
   * filter data
   */
    var b_filter_stat = "false";
    $(".b_filter").on("click", function(e){
        b_filter_stat = "filter";
        $("#halKe").val(0);
        ambilDataListPelamar( 0,  20);
    });
    $(".b_new").on("click", function(e){
        b_filter_stat = "new";
        $("#halKe").val(0);
        ambilDataListPelamar( 0,  20);
    });
    var lastRow;
    $(".b_save").on("click", function(e){
        var id_kar = new Array();
        for ( var i = 0; i < lastRow; i++) {
            id_kar.push(document.getElementById("id_kar"+i).getAttribute("itemid"));
        }
        var sendid_kar = JSON.stringify(id_kar);
        var user  = $("b#usernya").text();
        var dataString = "&usernya="+user;
         $.ajax({
            type: "POST",
            url: "payroll_data.ari?xcv="+1+"&sta=0"+dataString,
            data: {sendid_kar: sendid_kar},
            dataType: "json",
            //if received a response from the server
            beforeSend: function(){
                    ajaxindicatorstart('loading data.. please wait..');
                    window.setTimeout(  ajaxindicatorstart('loading data.. please wait..'), 500 );
            },
            success: function( data, textStatus, jqXHR) {
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
        ambilDataListPelamar( 0,  20);
    });
    function ambilDataListPelamar( limitBawah,  limitAtas){
        //jika 1 maka edit
        //set nilai 0
        $("#status_edit").html(0);
        // difungsikan buat gerbang akses pada server side
        // pintu = 1 ( normal )
        var pintu = 2, user;
        dataString = "limitBawah="+limitBawah
                +"&limitAtas="+limitAtas;
        // jika tombol filter diklik       
        if (b_filter_stat === "filter"){
            // pemisah tanggal
            var periode = $(".f_tgl_buat").val();
            dataString += "&f_id="+$(".f_id").val()
                +"&f_nama="+$(".f_nama").val()
                +"&f_jabatan="+$(".f_jabatan").val()
                +"&f_area="+$(".f_area").val()
                +"&f_s_plmr="+$(".f_s_plmr").val()
                +"&f_s_karyawan="+$(".f_s_karyawan").val()
            //alert(f_tgl_buat1+"dan"+f_tgl_buat2);
           // if (typeof periode[1] !== 'undefined'){
                +"&f_tgl_buat1="+periode;
           // }
        }
        else if(b_filter_stat === "new"){
            pintu = 22;
        }
        
        //menampilkan data  ( listing data )
        $.ajax({
            type: "GET",
            url: "payroll_data.ari?xcv="+pintu+"",
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
                    var i=0;
                    if(b_filter_stat === "new"){
                        for ( i=0; i< dataTableLengt ; i++){
                        var data_table ="<tr id='id_kar"+i+"' itemid='"+data.dataTable[i].idKaryawan +"'>"
                                        +"<td class='text-center'>-</td>"
                                        +"<td class='text-center'><a href='#' class='info tbl-edit' id='"+data.dataTable[i].idKaryawan +"'> "+data.dataTable[i].idKaryawan+"</a></td>"
                                        +"<td class='text-center' nowrap> "+data.dataTable[i].nama+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].jabatan+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].area+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].statusPegawai+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].statusPekerja+"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].gajiPokok +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].tunjangan +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].lembur +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].potongan +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].gajiBersih +"</td>"
                                        +"<td class='text-center' syle='position: relative;' ><a disabled id='"+data.dataTable[i].idKaryawan +"' data-toggle='modal' data-target='#v_edit' class='btn btn-primary kryw_edit'><div class='glyphicon glyphicon-edit'></div></a></td>"
                                        +"</tr>";
                        //$(msg_data).appendTo("#content");
                        $('#ariDataTablePelamar').append(data_table);
                        }
                        //only number
                        /*
                        * source http://jsfiddle.net/techrevolt/Fp4sJ/
                        * input hanya angka saja
                        */
                        $(".angka").on("keypress keyup blur",function (event) {    
                            $(this).val($(this).val().replace(/[^\d].+/, ""));
                            if ((event.which === 8 ||  (  event.which >= 48 && event.which <= 58 )  )  ) {
                           
                            }
                            else {
                                //mencegah
                                event.preventDefault();
                            }
                        });
                         
                    }
                    else{
                        for ( i=0; i< dataTableLengt ; i++){
                        var data_table ="<tr id='id_kar"+i+"' itemid='"+data.dataTable[i].id +"'>"
                                        +"<td class='text-center'><a href='#' class='info tbl-edit' id='"+data.dataTable[i].id +"'> "+data.dataTable[i].id+"</a></td>"
                                        +"<td class='text-center'><a href='#' class='info tbl-edit' id='"+data.dataTable[i].idKaryawan +"'> "+data.dataTable[i].idKaryawan+"</a></td>"
                                        +"<td class='text-center' nowrap> "+data.dataTable[i].nama+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].jabatan+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].area+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].statusPegawai+"</td>"
                                        +"<td class='text-center' nowrap>"+data.dataTable[i].statusPekerja+"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].gajiPokok +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].tunjangan +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].lembur +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].potongan +"</td>"
                                        +"<td class='text-right' nowrap>"+data.dataTable[i].gajiBersih +"</td>"
                                        +"<td class='text-center' nowrap><a   href='payroll_data.ari?sta=3&xcv=3&f_id="+data.dataTable[i].idKaryawan +"&noSlip="+data.dataTable[i].id+"' class='btn btn-primary slip_print'><div class='glyphicon glyphicon-edit'></div></a></td>"
                                        +"</tr>";
                        //$(msg_data).appendTo("#content");
                       $('#ariDataTablePelamar').append(data_table);
                        }
                        $("a.slip_print").printPage();
                    }
                    lastRow = i;
                }
                else {
                    $('#ariDataTablePelamar').html("<div class='no_result text-center'><b>no result</b></div>");
                }
                // membuat paggination
                // pagingDataList(jmlhRow)
                $("#jmlhRow").val(data.dataIndependent);
                setPaggination();
                     //currency number format indonesia
            //$('.av').maskMoney({prefix:'Rp. ', thousands:'.', decimal:',', precision:0, allowZero:true});
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
    
    //ambil datadetail
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
     *
     //tanggal filter range periode
     $('#filterRange').datepick({ 
        dateFormat: 'dd/mm/yyyy' ,
        rangeSelect: true, monthsToShow: 2, showTrigger: '#calImg'
    });
   */
    //tanggal lahir
    $("#filterRange").datepicker({
        dateFormat: 'mm/yy' ,
        changeMonth: true,
	changeYear: true,
        onClose: function() {
           var iMonth = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
           var iYear = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
           $(this).datepicker('setDate', new Date(iYear, iMonth, 1));
        },

        beforeShow: function() {
          if ((selDate = $(this).val()).length > 0)
          {
             iYear = selDate.substring(selDate.length - 4, selDate.length);
             iMonth = jQuery.inArray(selDate.substring(0, selDate.length - 5),
                      $(this).datepicker('option', 'monthNames'));
             $(this).datepicker('option', 'defaultDate', new Date(iYear, iMonth, 1));
             $(this).datepicker('setDate', new Date(iYear, iMonth, 1));
          }
       }
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
