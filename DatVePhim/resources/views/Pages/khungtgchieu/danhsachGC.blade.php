@extends('Pages/admin')
@section('content')
<!-- thong bao loi -->
@if(count($errors)>0)
<div class="alert alert-danger">
  @foreach($errors->all() as $e)
  {{$e}}<br>
  @endforeach
</div>
@endif
@if(session('thongbao'))
<div class="alert alert-success">
  {{session('thongbao')}}
</div>
@endif
<div class="container" style="margin-top:30px">
  <div class="col-sm-8">
    <div class="panel panel-default">
      <div class="panel-heading">
        KHUNG THỜI GIAN CHIẾU
      </div>
      <div class="row w3-res-tb">
        <div class="input-group">
          <input type="text" class="input-sm form-control" placeholder="Search">
          <span class="input-group-btn">
            <button class="btn btn-sm btn-default" type="button">Go!</button>
          </span>
        </div>
      </div>
      <div class="table-responsive">
        <table class="table table-striped b-t b-light">
          <thead>
            <tr>
              <th style="width:20px;">
              </th>
              <th>Giờ Chiếu</th>
              <th style="width:30px;"></th>
            </tr>
          </thead>

          <tbody>
            @foreach($khungtgchieu as $key => $d)
            <tr>
              <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
              <td>{{$d->giochieu}}</td>
              <td>
                <a href="{{route('suaGC', $d->id)}}" class="active" ui-toggle-class="">
                  <i class="fa fa-edit text-success text-active">Sửa</i>
                </a>
                <a href="{{route('xoaGC', $d->id)}}" class="active" ui-toggle-class="">
                  <i class="fa fa-times text-danger text">Xóa</i>
                </a>
              </td>
            </tr>
            @endforeach
          </tbody>
        </table>
      </div>
      <footer class="panel-footer">
        <div class="row">

          <div class="col-sm-5 text-center">
            <small class="text-muted inline m-t-sm m-b-sm">Showing 20-30 of 50 items</small>
          </div>
          <div class="col-sm-7 text-right text-center-xs">
            <ul class="pagination pagination-sm m-t-none m-b-none">
              <li><a href=""><i class="fa fa-chevron-left"></i></a></li>
              <li><a href="">1</a></li>
              <li><a href="">2</a></li>
              <li><a href="">3</a></li>
              <li><a href="">4</a></li>
              <li><a href=""><i class="fa fa-chevron-right"></i></a></li>
            </ul>
          </div>
        </div>
      </footer>
    </div>
  </div>

  <div class="col-sm-4">
    <div class="row" style="margin-right: 60px;">
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
</div>
</section>
<script type="text/javascript">
  $.ajaxSetup({
    headers: {
      'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
    }
  });
  function load(){
    $.ajax({
     type:'GET',
     url:"{{route('dsGC')}}",
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
</script>
@stop