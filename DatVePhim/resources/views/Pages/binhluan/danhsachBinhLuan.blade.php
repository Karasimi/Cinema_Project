@extends('Pages/admin')
@section('content')
<div class="panel panel-default">
  <div class="panel-heading">
    DANH SÁCH BÌNH LUẬN
  </div>
  <div class="row w3-res-tb">
    <div class="col-sm-4">
    </div>
  </div>
  <div class="table-responsive">
    <table class="table table-striped b-t b-light">
      <thead>
        <tr>
          <th style="width:20px;">
           
          </th>
          <th>Phim</th>
          <th>Nội dung</th>
          <th>Khách hàng</th>
          
          <th style="width:30px;"></th>
        </tr>
      </thead>

      <tbody>
        @foreach($binhluan as $key => $binhluan)
        <tr>
          <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
          <td>{{$binhluan->phim}}</td>
          <td><span class="text-ellipsis">{{$binhluan->phim->tenphim}}</span></td>
          <td><span class="text-ellipsis">{{$binhluan->noidung}}</span></td>
          <td><span class="text-ellipsis">{{$phim->kh->hoten}}</span></td>
          <td>{{$phim->diem}}</td>
        </tr>
      </tbody>
      @endforeach
    </table>
  </div>
  <footer class="panel-footer">
    <div class="row">

      <div class="col-sm-5 text-center">
        <small class="text-muted inline m-t-sm m-b-sm">showing 20-30 of 50 items</small>
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
</section>
@stop