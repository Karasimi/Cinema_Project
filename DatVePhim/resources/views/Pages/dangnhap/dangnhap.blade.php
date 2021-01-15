@include('Pages.header')
<div class="log-w3">
<div class="w3layouts-main">
	
	@if(Session::has('flag'))
                <div class="alert alert-{{Session::get('flag')}}">{{Session::get('message')}}</div>
	       @endif    	
	<h2>ĐĂNG NHẬP</h2>
		<form action="{{route('dangnhap')}}" method="post" class="beta-form-checkout">
			<input type="hidden" name="token" value="{{csrf_token()}}" />
			@csrf
			
			<input type="email" class="ggg" name="email" placeholder="E-MAIL" required="">
			<input type="password" class="ggg" name="password" placeholder="Mật Khẩu" required="">
			<!--<span><input type="checkbox" />Remember Me</span>-->
			<!--<h6><a href="#">Forgot Password?</a></h6>-->
				<div class="clearfix"></div>
				<input type="submit" value="Đăng Nhập" name="dangnhap">
		</form>
		<p>Chưa Có Tài kHoản ?<a href="{{route('dangky')}}">Tạo Tài Khoản</a></p>
</div>
</div>

@include('Pages.footer')
