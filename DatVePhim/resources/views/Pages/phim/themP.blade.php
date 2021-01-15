@extends('Pages/admin')
@section('content')
<a class="btn bg-olive text-primary bg-primary" style="margin-bottom: 20px;" href="{{route('dsP')}}"></i> Danh Sách Phim</a>
<div class="row">
            <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Basic Forms
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form action="{{route('themP')}}"  method="POST" enctype="multipart/form-data">
                                        @csrf

                                <div class="form-group">
                                    <label for="exampleInput1">Tên Phim</label>
                                    <input type="" name="tenphim" class="form-control" id="exampleInput1" placeholder="Enter ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInput1">Đạo diễn</label>
                                    <select class="form-control" name="daodien">
                                        @foreach($daodien as $cn)
                                        <option value="{{$cn->id}}">{{$cn->tendaodien}}</option>
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
                                    <label for="exampleInputPassword1">Thời lượng (Phút)</label>
                                    <input type="number" name="thoiluong" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>

                                  <div class="form-group">
                                    <label for="exampleInputPassword1">Nội Dung</label>
                                    <input type="text" name="noidung" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>

                                  <div class="form-group">
                                    <label for="exampleInputPassword1">Độ tuổi</label>
                                    <input type="" name="dotuoi" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Trailer</label>
                                    <input type="" name="trailer" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Ngày</label>
                                    <input type="date" name="ngay" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                              
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Trạng Thái</label>
                                    <select class="form-control" name="trangthai"  id="trangthai">
                                        <option value=0>Đang Chiếu</option>
                                        <option value=1>Sắp Chiếu</option>
                                    </select>
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