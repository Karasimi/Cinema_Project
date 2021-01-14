@extends('Pages/admin')
@section('content')
<div class="alert alert-danger" id="loithem" hidden="true"></div>
<form  id="xeplicha" enctype="multipart/form-data">
  @csrf
  <div method="POST" action="" class="row">
    <div class="col-md-6">
      <div class="form-group">
       <label for="exampleInputPassword1">Từ Ngày</label>
       <input type="date"  name="ngaybd" required class="form-control" id="ngaybd">
     </div>
   </div>
   <div class="col-md-6">
    <div class="form-group">
      <label for="exampleInputPassword1">Đến Ngày</label>
      <input type="date" name="ngaykt"  required="" class="form-control" id="ngaykt">
    </div>
  </div>
</div>

<div class="row">
  <div class="col-md-8">
    <div class="panel panel-default">
      <div class="panel-heading">
        Chọn Phim Xếp Lịch
      </div>
      <div style="margin: 10px">
        <input class="form-control" type="text" placeholder="Tìm Kiếm" id="timphim" aria-label="Search">
      </div>
      <div class="table-responsive">
        <table class="table table-striped b-t b-light">
          <thead>
            <tr>
              <th style="width:20px;">
                <label class="i-checks m-b-none">
                </label>
              </th>
              <th>Phim</th>
              <th style="width:50px;"></th>
            </tr>
          </thead>

          <tbody id="loadp">
            @foreach($phim as $key => $p)
            <tr>
              <td><input type="checkbox" name="phim[]" value="{{$p->id}}"></td>
              <td>{{$p->tenphim}}</td>
            </tr>
            @endforeach
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <div class="col-md-4">
    <div class="row">
      <div class="col-lg-12">
        <section class="panel">
          <header class="panel-heading">
            CHỌN RẠP
          </header>
          <div style="margin: 10px">
            <input class="form-control" type="text" placeholder="Tìm Kiếm" id="timrap" aria-label="Search">
          </div>
          <table class="table table-striped b-t b-light">
            <thead>
              <tr>
                <th style="width:20px;">
                  <label class="i-checks m-b-none">
                  </label>
                </th>
                <th>Rạp</th>
                <th style="width:50px;"></th>
              </tr>
            </thead>
            <tbody id="loadr">
              @foreach($rap as $key => $rap)
              <tr>
                <td><input type="checkbox" name="rap[]" value="{{$rap->id}}"></td>
                <td>{{$rap->tenrap}}</td>
              </tr>
              @endforeach
            </tbody>
          </table>
        </div>
      </div> 
      <button type="submit" class="btn btn-primary" id="xeplich">Thêm</button>

    </div> 
  </div>
</form>

<div class="panel panel-default">
  <div class="panel-heading">
    LỊCH CHIẾU
  </div>
  <div class="row w3-res-tb">
    <div class="col-sm-5 m-b-xs">
      <select class="input-sm form-control w-sm inline v-middle">
        <option value="0">Bulk action</option>
        <option value="1">Delete selected</option>
        <option value="2">Bulk edit</option>
        <option value="3">Export</option>
      </select>
      <button class="btn btn-sm btn-default">Apply</button>                
    </div>
    <div class="col-sm-4">
    </div>
    <div class="col-sm-3">
      <div class="input-group">
        <input type="text" class="input-sm form-control" placeholder="Search">
        <span class="input-group-btn">
          <button class="btn btn-sm btn-default" type="button">Go!</button>
        </span>
      </div>
    </div>
  </div>
  <div class="panel" id="loadl">
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
     url:"{{route('dsLC')}}",
     success: function(data){
       $('#loadl').html(data);
     }
   });
  } 
  load();
  $("#xeplich").click(function(e){
    e.preventDefault();
    $.ajax({
     type:'POST',
     url:"{{route('themLC')}}",
     data:$('#xeplicha').serialize(),
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
  $('#timphim').on('keyup',function(){
    $value = $(this).val();
    $.ajax({
      type: 'GET',
      url: "{{ route('tk') }}",
      data: {
        tukhoa: $value
      },
      success:function(data){
        $('#loadp').html('');
          $.each(data, function(index, value){
          tableRow = '<tr><td><input type="checkbox" name="phim[]" value='+value.id+'></td><td> '+value.tenphim+'</td> </tr>';
          $('#loadp').append(tableRow);
        });
      }
    });
  })
  $('#timrap').on('keyup',function(){
    $value = $(this).val();
    $.ajax({
      type: 'GET',
      url: "{{ route('tkR') }}",
      data: {
        tukhoa: $value
      },
      success:function(data){
        $('#loadr').html('');
          $.each(data, function(index, value){
          tableRow = '<tr><td><input type="checkbox" name="rap[]" value="'+value.id+'"></td><td>'+value.tenrap+'</td></tr>';
          $('#loadr').append(tableRow);
        });
      }
    });
  })
</script>
@stop
