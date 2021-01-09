@extends('Pages/admin')
@section('content')
<div class="row">
            <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            THÊM LỊCH
                        </header>
                        <div class="panel-body">
                            <div class="position-center">
                            <!-- thong bao loi -->      
                                </div>
                                @if(session('thongbao1'))
                                    <div class="alert alert-danger">
                                    {{session('thongbao1')}}
                                </div>
                            @endif 
                            @if(session('thongbao'))
                                    <div class="alert alert-success">
                                    {{session('thongbao')}}
                                </div>
                            @endif    
                                <form action="{{route('themLC')}}" method="POST" enctype="multipart/form-data">
                                @csrf
                                <div class="form-group">
                                    <input type="hidden" name="token" value="{{csrf_token()}}"/>
                                    <div class="form-group">
                                    <label for="exampleInputPassword1">Phim</label>
                                    <select class="form-control" name="phim">
                                    @foreach($phim as $cn)
                                        <option 
                                        @if ($lichchieu->phim == $cn->id){{"selected"}}
                                            @endif
                                        value ="{{$cn->id}}">{{$cn->tenphim}}
                                        </option>
                                        @endforeach
                                    </select>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Rạp</label>
                                    <select class="form-control" name="rap" >
                                    @foreach($rap as $cn)
                                        <option 
                                        @if ($lichchieu->rap == $cn->id){{"selected"}}
                                            @endif
                                        value ="{{$cn->id}}">{{$cn->tenrap}}
                                        </option>
                                        @endforeach
                                    </select>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Giờ Chiếu</label>
                                    <select class="form-control"  name="gio">
                                    @foreach($khungtgchieu as $cn)
                                        <option 
                                        @if ($lichchieu->thoigian == $cn->id){{"selected"}}
                                            @endif
                                        value ="{{$cn->id}}">{{$cn->giochieu}}
                                        </option>
                                        @endforeach
                                    </select>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Ngày Chiếu</label>
                                    <input type="date" name="ngay" class="form-control" id="ngay" value={{$lichchieu->ngay}}>
                                </div>
                                </div>
                                <div class="form-group">
                                   <button type="submit" class="btn btn-primary" id="t">Thêm</button>
            </div>
                            </form>
                            </div>
                        </div>
                    </section>
            </div>
        </div> 
 @stop