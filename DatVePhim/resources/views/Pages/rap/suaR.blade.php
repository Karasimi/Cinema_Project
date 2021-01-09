<div class="modal fade" id="chinhsua" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Sửa Rạp</h4>
    </div>
    <div class="modal-body">
        <form action=""  method="POST" id="suar" enctype="multipart/form-data">
         @csrf
         <div class="form-group">
            <input type="" hidden="true" id="id">
            <label for="exampleInput1">Tên Rạp</label>
            <input type="" name="tentheloai" value="" class="form-control" id="tenr" placeholder="Enter "> 
            <label for="exampleInput1">Chi Nhánh</label>
            <select class="form-control" id="cn" name="chinhanh">
                @foreach($chinhanh as $cn)
                <option value="{{$cn->id}}">{{$cn->tenchinhanh}}</option>
                @endforeach
            </select>
                     <div class="form-group">
                                    <label for="exampleInput1">Số Dãy</label>
                                    <select class="form-control" name="chinhanh" id="day">
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
                                    <select class="form-control" name="chinhanh" id="cot">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                    </select>
                                </div>
            <label for="exampleInput1">Trang Thái</label>
            <select class="form-control" name="" id="trangthai">
                <option value=1>Hoạt Động</option>
                <option value=0>Không Hoạt Động</option>
            </select>
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="submit" class="btn btn-success" id="luurap">Lưu</button>
    <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
</div>

</div>
</div>
</div>