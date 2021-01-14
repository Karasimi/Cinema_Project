@extends('Pages/admin')
@section('content')
<div class="row">
    <div class="col-md-8">
        <div class="panel" id="loadl">
</div>
    </div>
        <div class="col-md-4">
        <span class="error text-enter alert alert-danger hidden"></span>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                THÊM Giá
            </header>
            <div class="alert alert-danger" id="loithem" hidden="true"></div>
            <div class="panel-body">
                <div class="position-center">
                    <form action=""  method="POST" enctype="multipart/form-data" id="themtheloai">
                        @csrf
                     
                        <div class="form-group">
                                    <label for="exampleInput1">Phim</label>
                                    <select class="form-control" id="p">
                                        @foreach($phim as $cn)
                                        <option value="{{$cn->id}}">{{$cn->tenphim}}</option>
                                        @endforeach
                                    </select>
                                </div>
                              <div class="form-group">
                            <input type="hidden" name="token" value="{{csrf_token()}}"/>
                            <label for="exampleInput1">Giá</label>
                            <input type="number" name="tentheloai" class="form-control" id="g" placeholder="Enter ">
                        </div>

                        <button type="submit" class="btn btn-info" id="btnhthem">Thêm</button>
                    </form>
                </div>
            </div>
        </section>
    </div>
</div> 
<div>
    </div>
    
</div>
</div>
 @include('Pages.gia.suaG')

<script type="text/javascript">
    function load(){
        $.ajax({
         type:'GET',
         url:"{{route('themGia')}}",
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
            var gia = $("#g").val();
            var phim = $('#p').val();
            $.ajax({
             type:'POST',
             url:"{{route('themGia')}}",
             data:{gia:gia,phim:phim},
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
            url:"{{route('suaGia')}}",
            data:{id:id},
            success: function(data){
                $('#phim').val(data.phim);
                $('#id').val(data.id);
               $('#gia').val(data.gia);
                if (data.trangthai ==1 ) {
                    document.getElementById("trangthai").value = "1";
                }else {
                    document.getElementById("trangthai").value = "0";

                }
            }
        })
    })
    $('#luugia').on('click', function(e){
     e.preventDefault();
     var id = $('#id').val();
     var gia = $('#gia').val();
     var tt = $('#trangthai').val();
     $.ajax({
        type:'POST',
        url:"{{route('suaGia')}}",
        data:{id:id,gia:gia, trangthai:tt},
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
                type:'GET',
                url:"{{route('xoaGia')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })

</script> 
@stop


