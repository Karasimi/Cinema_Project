@extends('Pages/admin')
@section('content')
<a class="btn bg-olive text-primary bg-primary" style="margin-bottom: 20px;" href="{{route('themP')}}"></i> Thêm Phim</a>
<div class="panel panel-default">
  <div class="panel-heading">
    DANH MỤC PHIM
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
  <div class="table-responsive">
    <table class="table table-striped b-t b-light">
      <thead>
        <tr>
          <th style="width:20px;">
            <label class="i-checks m-b-none">
              <input type="checkbox"><i></i>
            </label>
          </th>
          <th>Tên Phim</th>
          <th>Thể loại</th>
          <th>Thời Lượng</th>
          <th>Hình ảnh</th>
          <th>Trailer</th>
          <th>Quốc gia</th>
          <th>NSX</th>
          <th>Đạo Diễn</th>
          <th>Diễn Viên</th>
          <th>Điểm</th>
          <th style="width:30px;"></th>
        </tr>
      </thead>

      <tbody>
        @foreach($phim as $key => $phim)
        <tr>
          <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
          <td>{{$phim->tenphim}}</td>
          <td><span class="text-ellipsis">{{$phim->tl->tentheloai}}</span></td>
          <td>{{$phim->thoiluong}}</td>

          <td>
            <img src="upload/{{$phim->hinhanh}}" width="100" height="100" controls></td>
          <td>
            {{$phim->trailer}}
          </td>
          <td><span class="text-ellipsis">{{$phim->qg->tenquocgia}}</span></td>
          <td><span class="text-ellipsis">{{$phim->nsxs->tennsx}}</span></td>
          <td><span class="text-ellipsis">{{$phim->dd->tendaodien}}</span></td>
          <td><span class="text-ellipsis">{{$phim->dv->tendienvien}}</span></td>
          <td>{{$phim->diem}}</td>
        <td>
        <a href="{{route('suaP', $phim->id)}}" class="active" ui-toggle-class="">
                <i class="fa fa-edit text-success text-active">Sửa</i>
                </a>
                <a href="{{route('xoaP', $phim->id)}}" class="active" ui-toggle-class="">
                <i class="fa fa-times text-danger text">Xóa</i>
              </a>
        </td>
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