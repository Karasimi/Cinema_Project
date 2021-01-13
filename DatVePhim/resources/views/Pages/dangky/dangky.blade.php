@include('Pages.header');
<div class="log-w3">
<div class="w3layouts-main">
	@if(count($errors)>0)
			    <div class="alert alert-danger">
					@foreach ($errors->all() as $item)
						{{$item}}
					@endforeach
				</div>
			@endif
		@if(Session::has('thanhcong'))
		       <div class ="alert alert-success">{{Session::get('thanhcong')}}</div>
		@endif
	<h2>ĐĂNG KÝ</h2>
		<form action="{{route('dangky')}}" method="post" enctype="multipart/form-data">			
		@csrf
		    <input type="hidden" name="token" value="{{csrf_token()}}" />
		    <input type="text" class="ggg" name="hoten" placeholder="Họ tên" required="">
			<input type="email" class="ggg" name="email" placeholder="E-MAIL" required="">
			<input type="password" class="ggg" name="password" placeholder="Mật Khẩu" required="">
			<input type="password" class="ggg" name="re_password" placeholder="Nhập lai Mật Khẩu" required="">
            <input type="text" class="ggg" name="sdt" placeholder="Số điện thoại" required="">
			
			<!--<span><input type="checkbox" />Remember Me</span>-->
			<!--<h6><a href="#">Forgot Password?</a></h6>-->
				<div class="clearfix"></div>
				<input type="submit" value="Đăng Ký" name="dangky">
		</form>
		<p><a href="{{route('dangnhap')}}">Đăng nhập</a></p>
</div>
</div>

@include('Pages.footer');