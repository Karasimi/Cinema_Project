@extends('Pages/admin')
@section('content')
<div class="row">
            <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            SỬA RẠP <small> {{$rap->tenrap}}</small>
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
                            <form action="{{route('themP')}}"  method="POST" enctype="multipart/form-data">
                                <!-- {{ csrf_field() }} -->    @csrf
                                <div class="form-group">
                                    <label for="exampleInput1">Tên Phim</label>
                                    <input type="" name="tenphim" class="form-control" id="exampleInput1" placeholder="Enter ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInput1">Đạo diễn</label>
                                    <select class="form-control" name="chinhanh">
                                    @foreach($daodien as $cn)
                                        <option 
                                        @if ($daodien->daodien == $cn->id){{"selected"}}
                                            @endif
                                        value ="{{$cn->id}}">{{$cn->tenchinhanh}}
                                        </option>
                                        @endforeach
                                    </select>
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
                                    <label for="exampleInputPassword1">Nhà sản xuất</label>
                                    <select class="form-control" name="nsx">
                                        @foreach($nsx as $cn)
                                        <option value="{{$cn->id}}">{{$cn->tennsx}}</option>
                                        @endforeach
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Thời lượng</label>
                                    <input type="" name="thoiluong" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Điểm</label>
                                    <input type="" name="diem" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Trailer</label>
                                    <input type="" name="trailer" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                              
                                <div class="form-group">
                                    <label for="exampleInputFile">Hình Ảnh</label>
                                    <input type="file" name="hinhanh"  id="exampleInputPassword1">
                                   
                                </div>
                                <button type="submit" class="btn btn-info">Submit</button>
                            </form> 
            
                            </div>

                        </div>
                    </section>

            </div>
            </div>
        
 @stop