<div class="modal fade" id="chinhsua" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Sửa Quốc Gia</h4>
    </div>
    <div class="modal-body">
        <form action=""  method="POST" id="suaqg" enctype="multipart/form-data">
           @csrf
           <div class="form-group">
            <input type="" hidden="true" id="id">
            <label for="exampleInput1">Tên Quốc Gia</label>

            <input type="" name="tentheloai" value="" class="form-control" id="qg" placeholder="Enter "> 
            <label for="exampleInput1">Trang Thái</label>
            <select class="form-control" name="" id="trangthai">
                <option value=1>Hoạt Động</option>
                <option value=0>Không Hoạt Động</option>
            </select>
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="submit" class="btn btn-success" id="luuqg">Lưu</button>
    <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
</div>

</div>
</div>
</div>