extends('Pages/admin')
@section('content')
<a class="btn bg-olive text-primary bg-primary" style="margin-bottom: 20px;" href="{{route('themCN')}}"></i> Thêm Chi Nhánh</a>
  <div class="panel panel-default">
    <div class="panel-heading">
      DANH SÁCH CHI NHÁNH
    </div>
    @if(session('thongbao'))
      <div class="alert alert-success">
        {{session('thongbao')}}
      </div>
     @endif 
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
            <th>Tên Chi Nhánh</th>
            <th>Địa Chỉ</th>

            <th style="width:30px;"></th>
          </tr>
        </thead>
       
        <tbody>
        @foreach($chinhanh as $key => $d)
          <tr>
            <td><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></td>
            <td>{{$d->tenchinhanh}}</td>
            <td>{{$d->diachi}}</td>
            <td>
              <a href="{{route('suaNSX', $d->id)}}" class="active" ui-toggle-class="">
                <i class="fa fa-edit text-success text-active">Sửa</i>
                </a>
                <a href="{{route('xoaCN', $d->id)}}" class="active" ui-toggle-class="">
                <i class="fa fa-times text-danger text">Xóa</i>
              </a>
            </td>
          </tr>
          @endforeach
        </tbody>
      </table>
    </div>

  </div>
</div>
</section>
@stop