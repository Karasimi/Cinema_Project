   
@include('Pages.header')
<body>
    <section id="container">
        <!--header start-->
        <header class="header fixed-top clearfix">
            <!--logo start-->
            <div class="brand">
                <a href="{{route('admin')}}" class="logo">
                    VISITORS
                </a>
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars"></div>
                </div>
            </div>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-success">8</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <li>
                                <p class="">You have 8 pending tasks</p>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info clearfix">
                                        <div class="desc pull-left">
                                            <h5>Target Sell</h5>
                                            <p>25% , Deadline  12 June’13</p>
                                        </div>
                                        <span class="notification-pie-chart pull-right" data-percent="45">
                                            <span class="percent"></span>
                                        </span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info clearfix">
                                        <div class="desc pull-left">
                                            <h5>Product Delivery</h5>
                                            <p>45% , Deadline  12 June’13</p>
                                        </div>
                                        <span class="notification-pie-chart pull-right" data-percent="78">
                                            <span class="percent"></span>
                                        </span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info clearfix">
                                        <div class="desc pull-left">
                                            <h5>Payment collection</h5>
                                            <p>87% , Deadline  12 June’13</p>
                                        </div>
                                        <span class="notification-pie-chart pull-right" data-percent="60">
                                            <span class="percent"></span>
                                        </span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="task-info clearfix">
                                        <div class="desc pull-left">
                                            <h5>Target Sell</h5>
                                            <p>33% , Deadline  12 June’13</p>
                                        </div>
                                        <span class="notification-pie-chart pull-right" data-percent="90">
                                            <span class="percent"></span>
                                        </span>
                                    </div>
                                </a>
                            </li>

                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-important">4</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <li>
                                <p class="red">You have 4 Mails</p>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="photo"><img alt="avatar" src="images/3.png"></span>
                                    <span class="subject">
                                        <span class="from">Jonathan Smith</span>
                                        <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hello, this is an example msg.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="photo"><img alt="avatar" src="images/1.png"></span>
                                    <span class="subject">
                                        <span class="from">Jane Doe</span>
                                        <span class="time">2 min ago</span>
                                    </span>
                                    <span class="message">
                                        Nice admin template
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="photo"><img alt="avatar" src="images/3.png"></span>
                                    <span class="subject">
                                        <span class="from">Tasi sam</span>
                                        <span class="time">2 days ago</span>
                                    </span>
                                    <span class="message">
                                        This is an example msg.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="photo"><img alt="avatar" src="images/2.png"></span>
                                    <span class="subject">
                                        <span class="from">Mr. Perfect</span>
                                        <span class="time">2 hour ago</span>
                                    </span>
                                    <span class="message">
                                        Hi there, its a test
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                    <!-- notification dropdown start-->
                    <li id="header_notification_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                            <i class="fa fa-bell-o"></i>
                            <span class="badge bg-warning">3</span>
                        </a>
                        <ul class="dropdown-menu extended notification">
                            <li>
                                <p>Notifications</p>
                            </li>
                            <li>
                                <div class="alert alert-info clearfix">
                                    <span class="alert-icon"><i class="fa fa-bolt"></i></span>
                                    <div class="noti-info">
                                        <a href="#"> Server #1 overloaded.</a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="alert alert-danger clearfix">
                                    <span class="alert-icon"><i class="fa fa-bolt"></i></span>
                                    <div class="noti-info">
                                        <a href="#"> Server #2 overloaded.</a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="alert alert-success clearfix">
                                    <span class="alert-icon"><i class="fa fa-bolt"></i></span>
                                    <div class="noti-info">
                                        <a href="#"> Server #3 overloaded.</a>
                                    </div>
                                </div>
                            </li>

                        </ul>
                    </li>
                    <!-- notification dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-nav clearfix">
                <!--search & user info start-->
                <ul class="nav pull-right top-menu">
                    <li>
                        <input type="text" class="form-control search" placeholder=" Search">
                    </li>
                    <!-- user login dropdown start-->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" src="images/2.png">
                            <span class="username">{{Auth::guard('nhanvien')->user()->hoten}}</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <li><a href="{{asset('profile')}}"><i class=" fa fa-suitcase"></i>Hò sơ</a></li>
                            <li><a href="{{asset('dangxuat')}}"><i class="fa fa-key"></i> Đăng xuất</a></li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->

                </ul>
                <!--search & user info end-->
            </div>
        </header>
        <!--sidebar start-->
        <aside>
            <div id="sidebar" class="nav-collapse">
                <!-- sidebar menu start-->
                <div class="leftside-navigation">
                    <ul class="sidebar-menu" id="nav-accordion">
                        <li>
                            <a class="active" href="{{URL::to('/admin')}}">
                                <i class="fa fa-dashboard"></i>
                                <span>Trang Chủ</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="{{route('themLC')}}">
                                <i class="fa fa-book"></i> 
                                <span>Lịch Chiếu</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="{{route('dsGC')}}">
                                <i class="fa fa-book"></i> 
                                <span>Giờ Chiếu</span>
                            </a>
                        </li>
                       <li class="sub-menu">
                            <a href="javascript:;">
                                <i class="fa fa-book"></i>
                                <span>Phim</span>
                            </a>
                            <ul class="sub">
                                <li><a href="{{route('dsP')}}">Danh sách bộ phim</a></li>
                                <li><a href="{{route('themP')}}">Thêm Phim</a></li>
                                <li><a href="{{route('dsDG')}}">Đánh Giá</a></li>

                            </ul>
                        </li>
                            <li class="sub-menu">
                            <a href="javascript:;">
                                <i class="fa fa-book"></i>
                                <span>Vé</span>
                            </a>
                            <ul class="sub">
                                <li><a href="{{route('dsVE')}}">Danh sách Vé</a></li>
                                <li><a href="{{route('VE')}}">Vé</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="{{route('dsGia')}}">
                                <i class="fa fa-book"></i> 
                                <span>Giá</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="{{route('dsR')}}">
                                <i class="fa fa-book"></i> 
                                <span>Rạp</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="{{route('themG')}}">
                                <i class="fa fa-book"></i> 
                                <span>Ghế</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="{{route('dsKH')}}">
                                <i class="fa fa-book"></i> 
                                <span>Danh sách khách hàng</span>
                            </a>
                        </li>
                        <!-- the loai -->
                        <li class="sub-menu">
                            <a href="{{route('themTL')}}">
                                <i class="fa fa-book"></i> 
                                <span>Thể Loại</span>
                            </a>
                        </li>
                        <!-- chi nhanh -->
                        <li class="sub-menu">
                            <a href="javascript">
                                <i class="fa fa-book"></i> 
                                <span>Danh Sách</span>
                            </a>
                            <ul class="sub">
                              <li><a href="{{route('themCN')}}">Danh Sách Chi Nhánh</a></li>
                              <li><a href="{{route('themDD')}}">Danh Sách Đạo Diễn</a></li>
                              <li><a href="{{route('themDV')}}">Danh Sách Diễn Viên</a></li>
                              <li><a href="{{route('themNSX')}}">Danh Sách NSX</a></li>
                              <li><a href="{{route('themQG')}}">Danh Sách Quốc Gia</a></li>
                          </ul>
                      </li>
                       <!-- Binh luận -->
                <li class="sub-menu">
                    <a href="javascript">
                        <i class="fa fa-book"></i> 
                        <span>Bình luận</span>
                    </a>
                    <ul class="sub">
						<li><a href="{{route('dsBL')}}">Danh Sách Bình Luận</a></li>
                    </ul>
                </li>      
</div>
</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- //market-->
        @yield('content')

    </section>
    @include('Pages.footer')

