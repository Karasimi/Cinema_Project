@extends('Pages/admin')
@section('content')
<div class="panel" id="loadl">
</div>
<span class="error text-enter alert alert-danger hidden"></span>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                THÊM CHI NHÁNH
            </header>
            <div class="alert alert-danger" id="loithem" hidden="true"></div>
            <div class="alert alert-danger" id="loithemdc" hidden="true"></div>
            <div class="panel-body">
                <div class="position-center">
                    <form action=""  method="POST" enctype="multipart/form-data" id="themdaodien">
                        @csrf
                        <div class="form-group">
                            <input type="hidden" name="token" value="{{csrf_token()}}"/>
                            <label for="exampleInput1">Tên Chi Nhánh</label>
                            <input type="" name="tentheloai" class="form-control" id="tencn" placeholder="Enter ">
                            <label for="exampleInput1">Địa Chỉ</label>
                            <input type="" name="diachi" class="form-control" id="dc" placeholder="Enter ">
                        </div>

                        <button type="submit" class="btn btn-info" id="btnhthem">Thêm</button>
                    </form>
                </div>
            </div>
        </section>
    </div>
</div> 
<div>
   @include('Pages.chinhanh.suaCN')
</div>

<script type="text/javascript">
    function load(){
        $.ajax({
           type:'GET',
           url:"{{route('dsCN')}}",
           success: function(data){
             $('#loadl').html(data);
         }
     })
    }
    $(document).ready(function(){

        $.ajaxSetup({
            headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            }
        })
        load();
        $("#btnhthem").click(function(e){
            e.preventDefault();
            var tenchinhanh = $("#tencn ").val();
            var diachi = $("#dc ").val();
            $.ajax({
               type:'POST',
               url:"{{route('themCN')}}",
               data:{tenchinhanh:tenchinhanh, diachi:diachi},
               success: function(data)
               {
                if (data.errors != null) {
                    $('#loithem').show();
                    $('#loithemdc').show();
                    $('#loithem').text(data.errors[0]);
                    $('#loithemdc').text(data.errors[1]);
                }else{
                    load();
                    $('#themdaodien').reset();
                }           
            }
        })
        })


    })

    $(document).on('click', '#sua', function(e){
        var id= $(this).data('sua');
        $('#chinhsua').modal('show');
        $.ajax({
            type:'GET',
            url:"{{route('suaCN')}}",
            data:{id:id},
            success: function(data){
                $('#tenchinhanh').val(data.tenchinhanh);
                $('#diachi').val(data.diachi);
                $('#id').val(data.id);
                if (data.trangthai ==1 ) {
                    document.getElementById("trangthai").value = "1";
                }else {
                    document.getElementById("trangthai").value = "0";

                }
            }
        })
    })
    $('#luuchinhanh').on('click', function(e){
       e.preventDefault();
       var id = $('#id').val();
       var cn = $('#tenchinhanh').val();
       var dc = $('#diachi').val();
       var tt = $('#trangthai').val();
       $.ajax({
        type:'POST',
        url:"{{route('suaCN')}}",
        data:{id:id,tenchinhanh:cn, diachi:dc, trangthai:tt},
        success: function(data){
              load();
            if (data.errors[0] != null) {
                alert(data.errors[0]);
            }
           if (data.errors[1] != null) {
                alert(data.errors[1]);

            }
        
        }
    })
   })
    $(document).on('click','#xoa', function(){
        var id= $(this).data('xoa');
        if (confirm("Có Chắc Muốn Xóa ???")) {
            $.ajax({
                type:'GET',
                url:"{{route('xoaCN')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })
</script> 
@stop


