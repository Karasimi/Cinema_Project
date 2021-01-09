@extends('Pages/admin')
@section('content')
<div class="row">
    <div class="col-md-8">
        <div class="panel" id="loadl">
        </div>
    </div>
    <div class="col-md-4">
        <span class="error text-enter alert alert-danger hidden"></span>
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <header class="panel-heading">
                        THÊM RẠP
                    </header>
                    <div class="alert alert-danger" id="loithem" hidden="true"></div>
                    <div class="panel-body">
                        <div class="position-center">
                            <form action=""  method="POST" enctype="multipart/form-data" id="themr">
                                @csrf
                                <div class="form-group">
                                    <input type="hidden" name="token" value="{{csrf_token()}}"/>
                                    <label for="exampleInput1">Tên Rạp</label>
                                    <input type="" name="tentheloai" class="form-control" id="tenrap" placeholder="Enter ">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInput1">Chi Nhánh</label>
                                    <select class="form-control" id="chinhanh">
                                        @foreach($chinhanh as $cn)
                                        <option value="{{$cn->id}}">{{$cn->tenchinhanh}}</option>
                                        @endforeach
                                    </select>
                                </div>
                                       <div class="form-group">
                                    <label for="exampleInput1">Số Dãy</label>
                                    <select class="form-control" name="chinhanh" id="soday">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                    </select>
                                </div>
                                       <div class="form-group">
                                    <label for="exampleInput1">Số Cột</label>
                                    <select class="form-control" name="chinhanh" id="socot">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                    </select>
                                </div>

                                <button type="submit" class="btn btn-info" id="btnhthem">Thêm</button>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </div> 
        <div>
        </div>

    </div>
    
</div>


@include('Pages.rap.suaR')

<script type="text/javascript">
    function load(){
        $.ajax({
         type:'GET',
         url:"{{route('themR')}}",
         success: function(data){
           $('#loadl').html(data);
       }
   })
    }
    $(document).ready(function(){

        $.ajaxSetup({
            headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            }
        })
        load();
        $("#btnhthem").click(function(e){
            e.preventDefault();
            var rap = $("#tenrap").val();
            var chinhanh = $("#chinhanh").val();
            var soday = $("#soday").val();
            var socot = $("#socot").val();

            $.ajax({
             type:'POST',
             url:"{{route('themR')}}",
             data:{tenrap:rap, chinhanh:chinhanh, socot:socot, soday:soday},
             success: function(data)
             {
                if (data.errors != null) {
                 $.each(data.errors, function(key, value){
                    $('#loithem').show();
                    $('#loithem').text(value);
                })
             }else{
                load();
                $('#themr').reset();
            }           
        }
    })
        })


    })

    $(document).on('click', '#sua', function(e){
        var id= $(this).data('sua');
        $('#chinhsua').modal('show');
        $.ajax({
            type:'GET',
            url:"{{route('suaR')}}",
            data:{id:id},
            success: function(data){
                @foreach ($chinhanh as $cn){
                    if ({{$cn->id}} == data.chinhanh){
                        document.getElementById("cn").value = "{{$cn->id}}";
                    }
                }
                @endforeach
                document.getElementById("day").value = data.soday;
                document.getElementById("cot").value = data.socot;
                $('#tenr').val(data.tenrap);
                $('#id').val(data.id);
                if (data.trangthai ==1 ) {
                    document.getElementById("trangthai").value = "1";
                }else {
                    document.getElementById("trangthai").value = "0";

                }
            }
        })
    })
    $('#luurap').on('click', function(e){
       e.preventDefault();
       var id = $('#id').val();
       var r = $('#tenr').val();
        var cn = $('#cn').val();
        var d = $('#day').val();
        var c = $('#cot').val();
       var tt = $('#trangthai').val();
       $.ajax({
        type:'POST',
        url:"{{route('suaR')}}",
        data:{id:id,tenrap:r, chinhanh:cn, soday:d, socot:c, trangthai:tt},
        success: function(data){
            if (data.errors != null) {
             alert(data.errors);
         }else{
            load();
            $('#suar').reset();
        }    
    }
})
   })
    $(document).on('click','#xoa', function(){
        var id= $(this).data('xoa');
        if (confirm("Có Chắc Muốn Xóa ???")) {
            $.ajax({
                type:'GET',
                url:"{{route('xoaR')}}",
                data:{id:id},
                success: function(data){
                    load();
                }
            })
        }
    })



</script> 
@stop

