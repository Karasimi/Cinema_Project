
<div class="alert alert-danger" id="loithem" hidden="true"></div>
<div class="modal fade" id="chinhsua" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Sửa Giờ</h4>
    </div>
    <div class="modal-body">
        <form action=""  method="POST" id="suagio" enctype="multipart/form-data">
         @csrf
         <input type="" hidden="true" id="id">
         <div class="form-group">
          <input type="hidden" name="token" value="{{csrf_token()}}" />
          <label for="exampleInput1">Thời Gian</label>
          <input type="time" name="gio" class="form-control" id="tg" placeholder="Enter">
      </div>
      <div class="form-group">
       <label for="exampleInputPassword1">Ngày</label>
       <input type="date"  name="ngaybd" required class="form-control" id="ng">
   </div>
       <select class="form-control" name="" id="trangthai">
                <option value=1>Hoạt Động</option>
                <option value=0>Không Hoạt Động</option>
            </select>
        
</form>
</div>
<div class="modal-footer">
    <button type="submit" class="btn btn-success" id="luugio">Lưu</button>
    <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
</div>
</div>
</div>
</div>
</div>