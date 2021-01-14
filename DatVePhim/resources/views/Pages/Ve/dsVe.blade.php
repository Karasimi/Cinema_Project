@extends('Pages/admin')
@section('content')
<a class="btn bg-olive text-primary bg-primary" style="margin-bottom: 20px;" href="{{route('themP')}}"></i> Thêm Phim</a>
<div class="panel panel-default">
  <div class="panel-heading">
    DANH SÁCH VÉ
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
          <th>Tên Khách hàng</th>
          <th>Số lượng</th>
          <th>Ngày mua</th>
          
          <th style="width:30px;"></th>
        </tr>
      </thead>

      <tbody>
        @foreach($dsve as $key => $d)
        <tr>
          <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
          <!--<td></td>-->
          <td><span class="text-ellipsis">{{$d->kh->name}}</span></td>
          <td>{{$d->soluong}}</td>
          <td>{{$d->ngaymua}}</td>
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