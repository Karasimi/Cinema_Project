@extends('Pages/admin')
@section('content')
        <div class="panel" id="loadl">
        </div>

@include('Pages.ghe.suaG')

<script type="text/javascript">
    function load(){
        $.ajax({
         type:'GET',
         url:"{{route('dsG')}}",
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

    })
    $(document).on('click','#xoa', function(){
        var id= $(this).data('xoa');
        if (confirm("Có Chắc Muốn Xóa ???")) {
            $.ajax({
                type:'GET',
                url:"{{route('xoaG')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })
     $(document).on('click','#hoatdong', function(){
        var id= $(this).data('xoa');
            $.ajax({
                type:'GET',
                url:"{{route('hoatdongghe')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
    })



</script> 
@stop

