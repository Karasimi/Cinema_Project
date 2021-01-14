@extends('Pages/admin')
@section('content')
<div class="panel" id="loadl">
</div>
<span class="error text-enter alert alert-danger hidden"></span>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                THÊM NHÀ SẢN XUẤT
            </header>
            <div class="alert alert-danger" id="loithem" hidden="true"></div>
            <div class="panel-body">
                <div class="position-center">
                    <form action=""  method="POST" enctype="multipart/form-data" id="themnsx">
                        @csrf
                        <div class="form-group">
                            <input type="hidden" name="token" value="{{csrf_token()}}"/>
                            <label for="exampleInput1">Tên NSX</label>
                            <input type="" name="tendienvien" class="form-control" id="tennsx" placeholder="Enter ">
                        </div>

                        <button type="submit" class="btn btn-info" id="btnhthem">Thêm</button>
                    </form>
                </div>
            </div>
        </section>
    </div>
</div> 
<div>
 @include('Pages.nsx.suaNSX')
</div>

<script type="text/javascript">
    function load(){
        $.ajax({
         type:'GET',
         url:"{{route('dsNSX')}}",
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
            var tennsx = $("#tennsx ").val();
            $.ajax({
             type:'POST',
             url:"{{route('themNSX')}}",
             data:{tennsx:tennsx},
             success: function(data)
             {
                if (data.errors != null) {
                    $('#loithem').show();
                    $('#loithem').text(data.errors);
                }else{
                        load();
                $('#themnsx').reset();
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
            url:"{{route('suaNSX')}}",
            data:{id:id},
            success: function(data){
                $('#nsx').val(data.tennsx);
                $('#id').val(data.id);
                if (data.trangthai ==1 ) {
                    document.getElementById("trangthai").value = "1";
                }else {
                    document.getElementById("trangthai").value = "0";

                }
            }
        })
    })
    $('#luunsx').on('click', function(e){
     e.preventDefault();
     var id = $('#id').val();
     var tl = $('#nsx').val();
     var tt = $('#trangthai').val();
     $.ajax({
        type:'POST',
        url:"{{route('suaNSX')}}",
        data:{id:id,tennsx:tl, trangthai:tt},
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
                url:"{{route('xoaNSX')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })

</script> 
@stop


