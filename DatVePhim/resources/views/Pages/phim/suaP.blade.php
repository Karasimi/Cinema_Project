@extends('Pages/admin')
@section('content')
<a class="btn bg-olive text-primary bg-primary" style="margin-bottom: 20px;" href="{{route('dsP')}}"></i> Danh Sách Phim</a>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                SỬA PHIM {{$phim->tenphim}} 
            </header>
            <div class="panel-body">
                <div class="position-center">
                    <!-- thong bao loi -->
                    @if(session('thongbao1'))
                    <div class="alert alert-success">
                        {{session('thongbao')}}
                    </div>
                    @endif   
                    @if(session('thongbao'))
                    <div class="alert alert-success">
                        {{session('thongbao')}}
                    </div>
                    @endif   
                    <form action="{{route('suaP',$phim->id)}}"  method="POST" enctype="multipart/form-data">
                     @csrf
                     <input type="hidden" name="id" value="{{$phim->id}}">
                     <div class="form-group">
                        <label for="exampleInputPassword1">Tên Phim</label>
                        <input type="" value="{{$phim->tenphim}}" name="tenphim" class="form-control" id="exampleInputPassword1" placeholder="Password">           
                    </div>

                    <div class="form-group">
                        <label for="exampleInput1">Diễn viên</label>
                        <select class="form-control" name="dienvien">
                            @foreach($dienvien as $cn)
                            <option value="{{$cn->id}}">{{$cn->tendienvien}}</option>
                            @endforeach
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="exampleInput1">Đạo diễn</label>
                        <select class="form-control" name="daodien">
                            @foreach($daodien as $daodien)
                            <option value="{{$daodien->id}}">{{$daodien->tendaodien}}</option>
                            @endforeach
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="exampleInput1">NSX</label>
                        <select class="form-control" name="nsx">
                            @foreach($nsx as $daodien)
                            <option value="{{$daodien->id}}">{{$daodien->tennsx}}</option>
                            @endforeach
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="exampleInput1">Thể loại</label>
                        <select class="form-control" name="theloai">
                            @foreach($theloai as $cn)
                            <option value="{{$cn->id}}">{{$cn->tentheloai}}</option>
                            @endforeach
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Quốc gia</label>
                        <select class="form-control" name="quocgia">
                            @foreach($quocgia as $cn)
                            <option value="{{$cn->id}}">{{$cn->tenquocgia}}</option>
                            @endforeach
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Độ tuổi</label>
                        <input type="" value="{{$phim->dotuoi}}" name="dotuoi" class="form-control" id="exampleInputPassword1" placeholder="Password"> 
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Nội Dung </label>
                        <input type="" name="noidung" value="{{$phim->noidung}}" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Thời lượng(Phút)</label>
                        <input type="number" value="{{$phim->thoiluong}}" name="thoiluong" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Trailer</label>
                        <input type="" name="trailer" value="{{$phim->trailer}}" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Trạng Thái</label>
                         <select class="form-control" name="trangthai" value="{{$phim->trangthai}}" id="trangthai">
                        <option value=0>Đang Chiếu</option>
                        <option value=1>Sắp Chiếu</option>
                    </select>
                </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Ngày</label>
                        <input type="date" name="ngay" value="{{$phim->ngay}}" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputFile">Hình Ảnh</label>
                        <input type="file" name="hinhanh" value="{{$phim->hinhanh}}"  id="exampleInputPassword1">
                        <img src="/upload/{{$phim->hinhanh}}" width="100px" height="100px">
                    </div>
                    <button type="submit" class="btn btn-info">Submit</button>
                </form> 
            </div>
        </div>
    </section>
</div>
</div>

@stop