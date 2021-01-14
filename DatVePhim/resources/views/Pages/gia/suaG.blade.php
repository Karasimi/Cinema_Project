<div class="modal fade" id="chinhsua" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Sửa Giá</h4>
    </div>
    <div class="modal-body">
        <form action=""  method="POST" id="suar" enctype="multipart/form-data">
           @csrf
            <div class="form-group">
                  <input type="hidden" name="token" value="{{csrf_token()}}" />
                 <input type="hidden" name="id" id="id" />
                  <label for="exampleInput1">Phim</label>
                  <input type="" name="gio" class="form-control" id="phim" placeholder="Enter">
                </div>
        <div class="form-group">
            <label for="exampleInput1">Giá</label>
            <input type="number" name="tentheloai" class="form-control" id="gia" placeholder="Enter ">
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
    <button type="submit" class="btn btn-success" id="luugia">Lưu</button>
    <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
</div>

</div>
</div>
</div>