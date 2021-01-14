@extends('Pages/admin')
@section('content')
<div class="panel panel-default">
  <div class="panel-heading">
       VÉ
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
          <th>Tên Phim</th>
          <th>Rạp Chiếu</th>
          <th>Thời Gian</th>
          <th>Ghế</th>
          <th>Giá</th>
          <th>Trạng Thái</th>
          <th style="width:30px;"></th>
        </tr>
      </thead>

      <tbody>
        @foreach($ve as $key => $d)
        <tr>
          <td><label class="i-checks m-b-none"></label></td>
          <!--<td></td>-->
          <td><span class="text-ellipsis">{{$d->p->tenphim}}</span></td>
          <td>{{$d->r->tenrap}}</td>
          <td>{{$d->tg->giochieu}}</td>
          <td>{{$d->g->hang}}{{$d->g->cot}}</td>
          <td>{{$d->gi->gia}}</td>
          <td>{{$d->trangthai}}</td>
        </tr>
      </tbody>
      @endforeach
    </table>
  </div>
</div>
</div>
</section>
@stop