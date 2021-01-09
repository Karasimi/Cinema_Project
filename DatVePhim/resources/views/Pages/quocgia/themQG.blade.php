@extends('Pages/admin')
@section('content')
<div class="panel" id="loadl">
</div>
<span class="error text-enter alert alert-danger hidden"></span>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                THÊM QUỐC GIA
            </header>
            <div class="alert alert-danger" id="loithem" hidden="true"></div>
            <div class="panel-body">
                <div class="position-center">
                    <form action=""  method="POST" enctype="multipart/form-data" id="themquocgia">
                        @csrf
                        <div class="form-group">
                            <input type="hidden" name="token" value="{{csrf_token()}}"/>
                            <label for="exampleInput1">Tên Quốc Gia</label>
                            <input type="" name="tendienvien" class="form-control" id="tenquocgia" placeholder="Enter ">
                        </div>

                        <button type="submit" class="btn btn-info" id="btnhthem">Thêm</button>
                    </form>
                </div>
            </div>
        </section>
    </div>
</div> 
<div>
 @include('Pages.quocgia.suaQG')
</div>

<script type="text/javascript">
    function load(){
        $.ajax({
         type:'GET',
         url:"{{route('dsQG')}}",
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
            var tenquocgia = $("#tenquocgia ").val();
            $.ajax({
             type:'POST',
             url:"{{route('themQG')}}",
             data:{tenquocgia:tenquocgia},
             success: function(data)
             {
                if (data.errors != null) {
                    $('#loithem').show();
                    $('#loithem').text(data.errors);
                }else{
                        load();
                $('#themquocgia').reset();
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
            url:"{{route('suaQG')}}",
            data:{id:id},
            success: function(data){
                $('#qg').val(data.tenquocgia);
                $('#id').val(data.id);
                if (data.trangthai ==1 ) {
                    document.getElementById("trangthai").value = "1";
                }else {
                    document.getElementById("trangthai").value = "0";

                }
            }
        })
    })
    $('#luuqg').on('click', function(e){
     e.preventDefault();
     var id = $('#id').val();
     var tl = $('#qg').val();
     var tt = $('#trangthai').val();
     $.ajax({
        type:'POST',
        url:"{{route('suaQG')}}",
        data:{id:id,tenquocgia:tl, trangthai:tt},
        success: function(data){
            if (data.errors != null) {
                   alert(data.errors);
                }else{
                    load();
                $('#suansx').reset();
                                    }    
        }
    })
 })
    $(document).on('click','#xoa', function(){
        var id= $(this).data('xoa');
        if (confirm("Có Chắc Muốn Xóa ???")) {
            $.ajax({
                type:'GET',
                url:"{{route('xoaQG')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })

</script> 
@stop


