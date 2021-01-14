@extends('Pages/admin')
@section('content')
<div class="panel" id="loadl">
</div>
<span class="error text-enter alert alert-danger hidden"></span>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                THÊM ĐẠO DIỄN
            </header>
            <div class="alert alert-danger" id="loithem" hidden="true"></div>
            <div class="panel-body">
                <div class="position-center">
                    <form action=""  method="POST" enctype="multipart/form-data" id="themtheloai">
                        @csrf
                        <div class="form-group">
                            <input type="hidden" name="token" value="{{csrf_token()}}"/>
                            <label for="exampleInput1">Tên đạo diễn</label>
                            <input type="" name="tentheloai" class="form-control" id="tentl" placeholder="Enter ">
                        </div>

                        <button type="submit" class="btn btn-info" id="btnhthem">Thêm</button>
                    </form>
                </div>
            </div>
        </section>
    </div>
</div> 
<div>
 @include('Pages.theloai.suaTL');
</div>

<script type="text/javascript">
    function load(){
        $.ajax({
         type:'GET',
         url:"{{route('dsTL')}}",
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
            var theloai = $("#tentl").val();
            $.ajax({
             type:'POST',
             url:"{{route('themTL')}}",
             data:{tentheloai:theloai},
             success: function(data)
             {
                if (data.errors != null) {
                     $.each(data.errors, function(key, value){
                    $('#loithem').show();
                    $('#loithem').text(value);
                    })
                }else{
                        load();
                $('#themtheloai').reset();
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
            url:"{{route('suaTl')}}",
            data:{id:id},
            success: function(data){
                $('#tentheloai').val(data.tentheloai);
                $('#id').val(data.id);
                if (data.trangthai ==1 ) {
                    document.getElementById("trangthai").value = "1";
                }else {
                    document.getElementById("trangthai").value = "0";

                }
            }
        })
    })
    $('#luutheloai').on('click', function(e){
     e.preventDefault();
     var id = $('#id').val();
     var tl = $('#tentheloai').val();
     var tt = $('#trangthai').val();
     $.ajax({
        type:'POST',
        url:"{{route('suaTl')}}",
        data:{id:id,tentheloai:tl, trangthai:tt},
        success: function(data){
            if (data.errors != null) {
                   alert(data.errors);
                }else{
                    load();
                $('#themtheloai').reset();
                                    }    
        }
    })
 })
    $(document).on('click','#xoa', function(){
        var id= $(this).data('xoa');
        if (confirm("Có Chắc Muốn Xóa ???")) {
            $.ajax({
                type:'POST',
                url:"{{route('xoaTl')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })

</script> 
@stop


