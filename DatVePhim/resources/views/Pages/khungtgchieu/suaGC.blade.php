@extends('Pages/admin')
@section('content')
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                SỬA THỜI GIAN <small> {{$khungtgchieu->giochieu}}</small>
            </header>
            <div class="panel-body">
                <div class="position-center">
                    <!-- thong bao loi -->
                    @if(count($errors)>0)
                    <div class="alert alert-danger">
                        @foreach($errors->all() as $e)
                        {{$e}}<br>
                        @endforeach
                    </div>
                    @endif
                    @if(session('thongbao'))
                    <div class="alert alert-success">
                        {{session('thongbao')}}
                    </div>
                    @endif
                    <form action="{{ route('suaGC',$khungtgchieu->id) }}" method="POST" enctype="multipart/form-data">
                        @csrf
                        <div class="form-group">
                            <input type="hidden" name="token" value="{{csrf_token()}}" />
                            <label for="exampleInput1">Thời Gian</label>
                            <input type="time" name="gio" class="form-control" value="{{$khungtgchieu->giochieu}}" id="exampleInput1" placeholder="Enter">
                        </div>

                        <button type="submit" class="btn btn-info">Submit</button>
                    </form>
                </div>

            </div>
        </section>

    </div>
</div>

@stop