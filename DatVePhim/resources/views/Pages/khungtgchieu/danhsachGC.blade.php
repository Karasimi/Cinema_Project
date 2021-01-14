@extends('Pages/admin')
@section('content')
  <div class="row">
  <div class="col-sm-8 panel" id="loadl">
  </div>
  <div class="col-sm-4">
    <div class="row" >
      <div class="col-lg-12">
        <section class="panel">
          <header class="panel-heading">
            THÊM KHUNG THỜI GIAN
          </header>
          <div class="panel-body">
            <div class="position-center">
              <form action="{{ route('themGC') }}" method="POST" enctype="multipart/form-data">
                @csrf
                <div class="form-group">
                  <input type="hidden" name="token" value="{{csrf_token()}}" />
                  <label for="exampleInput1">Thời Gian</label>
                  <input type="time" name="gio" class="form-control" value="12:00" id="thoigian" placeholder="Enter">
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">Ngày</label>
                     <input type="date"  name="ngaybd" required class="form-control" id="ngay">
               </div>
               <button type="submit" class="btn btn-info" id="themGC">Thêm</button>
             </form>
           </div>
         </div>
       </section>
     </div>
   </div>
 </div>
 @include('Pages.khungtgchieu.suaGC')
</div>
<script type="text/javascript">
  $.ajaxSetup({
    headers: {
      'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
    }
  });
  function load(){
    $.ajax({
     type:'GET',
     url:"{{route('themGC')}}",
     success: function(data){
       $('#loadl').html(data);
     }
   })
  }
  load();
  $("#themGC").click(function(e){
    e.preventDefault();
    var thoigian = $("#thoigian").val();
    var ngay = $("#ngay").val();
    $.ajax({
     type:'POST',
     url:"{{route('themGC')}}",
     data:{thoigian:thoigian, ngay:ngay},
     success: function(data)
     {
      if (data.errors != null) {
        $('#loithem').show();
        $('#loithem').text(data.errors);
        
      }else{
        load();
      }
    },
    error: function(data)
    {
      console.log(data);
    }
  });
  });
$(document).on('click', '#sua', function(e){
        var id= $(this).data('sua');
        $('#chinhsua').modal('show');
        $.ajax({
            type:'GET',
            url:"{{route('suaGC')}}",
            data:{id:id},
            success: function(data){
                  document.getElementById("tg").value = data.giochieu;
                  document.getElementById("ng").value = data.ngaychieu;
                $('#id').val(data.id);
                if (data.trangthai ==1 ) {
                    document.getElementById("trangthai").value = "1";
                }else {
                    document.getElementById("trangthai").value = "0";

                }
            }
        })
    })
    $('#luugio').on('click', function(e){
     e.preventDefault();
     var id = $('#id').val();
     var tl = $('#tg').val();
     var ng = $('#ng').val();    
      var tt = $('#trangthai').val();
     $.ajax({
        type:'POST',
        url:"{{route('suaGC')}}",
        data:{id:id,thoigian:tl, ngaychieu:ng, trangthai:tt},
        success: function(data){
            if (data.errors != null) {
                   alert(data.errors);
                }else{
                    load();
                $('#themGC').reset();
                                    }    
        }
    })
 })
    $(document).on('click','#xoa', function(){
        var id= $(this).data('xoa');
        if (confirm("Có Chắc Muốn Xóa ???")) {
            $.ajax({
                type:'GET',
                url:"{{route('xoaGC')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })
</script>
</section>
@stop