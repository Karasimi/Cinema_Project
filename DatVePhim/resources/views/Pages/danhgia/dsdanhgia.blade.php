@extends('Pages/admin')
@section('content')
<div class="panel panel-default">
  <div class="panel-heading">
    ĐÁNH GIÁ
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
          <th>Khách Hàng</th>
          <th>Phim</th>
          <th>Điểm</th>
          <th>Trạng Thái</th>
          <th style="width:30px;"></th>
        </tr>
      </thead>
      <tbody>
        @foreach($danhgia as $key => $danhgia)
        <tr>
          <td><label class="i-checks m-b-none"></td>
          <td>{{$danhgia->kh->name}}</td>
          <td><span class="text-ellipsis">{{$danhgia->p->tenphim}}</span></td>
          <td><span class="text-ellipsis">{{$danhgia->diem}}</span></td>
          <td><span class="text-ellipsis">{{$danhgia->trangthai}}</span></td>
        </tr>
      </tbody>
      @endforeach
    </table>
  </div>
</div>
</div>
</section>
@stop