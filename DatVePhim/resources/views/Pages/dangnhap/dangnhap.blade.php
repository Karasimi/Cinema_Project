@include('Pages.header');
<div class="log-w3">
<div class="w3layouts-main">
	<h2>ĐĂNG NHẬP</h2>
		<form action="{{route('dangnhap')}}" method="post">
		@csrf
			<input type="email" class="ggg" name="email" placeholder="E-MAIL" required="">
			<input type="password" class="ggg" name="matkhau" placeholder="Mật Khẩu" required="">
			<!--<span><input type="checkbox" />Remember Me</span>-->
			<!--<h6><a href="#">Forgot Password?</a></h6>-->
				<div class="clearfix"></div>
				<input type="submit" value="Đăng Nhập" name="dangnhap">
		</form>
		<p>Chưa Có Tài kHoản ?<a href="registration.html">Tạo Tài Khoản</a></p>
</div>
</div>
@include('Pages.footer');
