@extends('Pages/admin')
@section('content')
<div class="row">
            <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Basic Forms
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                                <form action="{{URL::to('savemovie')}}"  method="POST" enctype="multipart/form-data">
                                <!-- {{ csrf_field() }} -->    @csrf
                                <div class="form-group">
                                    <label for="exampleInput1">Tên Phim</label>
                                    <input type="" name="name" class="form-control" id="exampleInput1" placeholder="Enter ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInput1">Đạo diễn</label>
                                    <input type="" name="daodien" class="form-control" id="exampleInput1" placeholder="Enter ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInput1">Diễn viên</label>
                                    <input type="" name="dienvien" class="form-control" id="exampleInput1" placeholder="Enter ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInput1">Thể loại</label>
                                    <input type="" name="theloai" class="form-control" id="exampleInput1" placeholder="Enter ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Quốc gia</label>
                                    <input type="" name="quocgia" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Nhà sản xuất</label>
                                    <input type="" name="nsx" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Thời lượng</label>
                                    <input type="" name="thoiluong" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Trạng Thái</label>
                                    <input type="" name="trangthai" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">trailer</label>
                                    <input type="" name="trailer" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                
                              
                                <div class="form-group">
                                    <label for="exampleInputFile"> Hinh anh</label>
                                    <input type="file" name="mv_hinhanh"  id="exampleInputPassword1">
                                   
                                </div>
                               
                                <button type="submit" class="btn btn-info">Submit</button>
                            </form>
                            </div>

                        </div>
                    </section>

            </div>
            
               
        </div> 
        <!-- <form action="{{URL::to('savemovie')}}"  method="post" enctype="multipart/form-data">
        <input type="file" name="hinhanh">
        <input type="submit">
        </form> -->
 @stop