<?php




Route::get('/a', function () {
    return view('welcome');
});
Route::get('/aac','AdminController@ac')->name('aac');
Route::get('dangxuat','AdminController@getdangxuat');
Route::get('profile','AdminController@profile');

Route::group(['prefix'=>'dangnhap','middleware'=>'checkAdmin'],function(){
    Route::get('/','AdminController@dangnhap')->name('dangnhap');
    Route::post('/','AdminController@postdangnhap')->name('dangnhap');
});
Route::group(['prefix'=>'dangky'],function(){
    Route::get('/','AdminController@dangky')->name('dangky');
    Route::post('/','AdminController@postdangky')->name('dangky');
});
Route::group(['prefix'=>'admin','middleware'=>'CheckLogout'],function(){
    Route::get('/','AdminController@index')->name('admin');
    Route::get('khachhang','AdminController@danhsachKH')->name('dsKH');
    Route::group(['prefix'=>'theloai'],function(){
        Route::get('danhsach','AdminController@danhSachTL')->name('dsTL');;

        //them the loại
        Route::get('them','AdminController@ThemTL')->name('themTL');
        Route::post('them','AdminController@postThemTL')->name('themTL');

        //sua the loai
        Route::get('sua','AdminController@SuaTL')->name('suaTl');
        Route::post('sua','AdminController@postSuaTL')->name('suaTl');

        //xoa the loai
        Route::post('xoa','AdminController@XoaTL')->name('xoaTl');
    });
         //phim
    Route::group(['prefix'=>'phim'],function(){
        Route::get('danhsach','AdminController@danhSachP')->name('dsP');
        Route::get('them','AdminController@ThemP')->name('themP');
        Route::post('them','AdminController@postThemP')->name('themP');

        Route::get('sua/{id}','AdminController@SuaP')->name('suaP');
        Route::post('sua/{id}','AdminController@updateP')->name('suaP');

        Route::get('xoa/{id}','AdminController@XoaP')->name('xoaP');
        Route::get('danhgia','AdminController@dsDG')->name('dsDG');

    });
    //binh luan
    Route::group(['prefix'=>'binhluan'],function(){
        Route::get('danhsachBL','AdminController@danhSachBL')->name('dsBL');
    });

    //ds ve
    Route::group(['prefix'=>'dsve'],function(){
        Route::get('danhsachve','AdminController@danhSachVe')->name('dsVE');
        Route::get('ve','AdminController@Ve')->name('VE');
    });
    //ghe
    Route::group(['prefix'=>'ghe'],function(){
        Route::get('danhsach','AdminController@danhSachG')->name('dsG');
        Route::get('them','AdminController@ThemG')->name('themG');
        Route::post('them','AdminController@postThemG')->name('themG');

        Route::get('sua','AdminController@SuaG')->name('suaG');
        Route::post('sua','AdminController@postSuaG')->name('suaG');
        Route::get('xoa','AdminController@XoaG')->name('xoaG');
        Route::get('hoatdong','AdminController@GheHoatDong')->name('hoatdongghe');


    });
    

    //dao dien
    Route::group(['prefix'=>'daodien'],function(){
        Route::get('danhsach','AdminController@danhSachDD')->name('dsDD');;

        //them the loại
        Route::get('them','AdminController@ThemDD')->name('themDD');
        Route::post('them','AdminController@postThemDD')->name('themDD');

        //sua the loai
        Route::get('sua','AdminController@SuaDD')->name('suaDD');
        Route::post('sua','AdminController@postSuaDD')->name('suaDD');

        //xoa the loai
        Route::get('xoa','AdminController@XoaDD')->name('xoaDD');
    });
    
    //dien vien

    Route::group(['prefix'=>'dienvien'],function(){
        Route::get('danhsach','AdminController@danhSachDV')->name('dsDV');;
        
            //them the loại
        Route::get('them','AdminController@ThemDV')->name('themDV');
        Route::post('them','AdminController@postThemDV')->name('themDV');
        
            //sua the loai
        Route::get('sua','AdminController@SuaDV')->name('suaDV');
        Route::post('sua','AdminController@postSuaDV')->name('suaDV');
        
            //xoa the loai
        Route::get('xoa','AdminController@XoaDV')->name('xoaDV');
    });

     //nha san xuat 
    Route::group(['prefix'=>'nsx'],function(){
        Route::get('danhsach','AdminController@danhSachNSX')->name('dsNSX');;

        //them the loại
        Route::get('them','AdminController@ThemNSX')->name('themNSX');
        Route::post('them','AdminController@postThemNSX')->name('themNSX');

        //sua nha san xuat
        Route::get('sua','AdminController@SuaNSX')->name('suaNSX');
        Route::post('sua','AdminController@postSuaNSX')->name('suaNSX');

        //xoa the loai
        Route::get('xoa','AdminController@XoaNSX')->name('xoaNSX');
    }); 
    
    
    // quoc gia 
    Route::group(['prefix'=>'quocgia'],function(){
        Route::get('danhsach','AdminController@danhSachQG')->name('dsQG');;

        //them the loại
        Route::get('them','AdminController@ThemQG')->name('themQG');
        Route::post('them','AdminController@postThemQG')->name('themQG');

        //sua nha san xuat
        Route::get('sua','AdminController@SuaQG')->name('suaQG');
        Route::post('sua','AdminController@postSuaQG')->name('suaQG');

        //xoa the loai
        Route::get('xoa','AdminController@XoaQG')->name('xoaQG');
    }); 

    //chi nhanh 
    Route::group(['prefix'=>'chinhanh'],function(){
        Route::get('danhsach','AdminController@danhSachCN')->name('dsCN');;
        
            //them chi nhanh
        Route::get('them','AdminController@ThemCN')->name('themCN');
        Route::post('them','AdminController@postThemCN')->name('themCN');
        
            //sua chi nhanh
        Route::get('sua','AdminController@SuaCN')->name('suaCN');
        Route::post('sua','AdminController@postSuaCN')->name('suaCN');
        
            //xoa chi nhanh
        Route::get('xoa','AdminController@XoaCN')->name('xoaCN');
    }); 
        //rap
    Route::group(['prefix'=>'rap'],function(){
        Route::get('danhsach','AdminController@danhSachR')->name('dsR');;
        
            //them rap
        Route::get('them','AdminController@ThemR')->name('themR');
        Route::post('them','AdminController@postThemR')->name('themR');
        
            //sua rap
        Route::get('sua','AdminController@SuaR')->name('suaR');
        Route::post('sua','AdminController@postSuaR')->name('suaR');
        
            //xoa rap
        Route::get('xoa','AdminController@XoaR')->name('xoaR');
    }); 
 //lich chieu
    Route::group(['prefix'=>'lichchieu'],function(){
        Route::get('danhsach','AdminController@danhSachLC')->name('dsLC');;

            //them rap
        Route::get('them','AdminController@ThemLC')->name('themLC');
        Route::post('them','AdminController@postThemLC')->name('themLC');

            //sua rap
        Route::get('sua/{id}','AdminController@SuaLC')->name('suaLC');
        Route::post('sua/{id}','AdminController@postSuaLC')->name('suaLC');

            //xoa rap
        Route::get('xoa/{id}','AdminController@XoaLC')->name('xoaLC');


        //tim kiem
        Route::get('timkiem','AdminController@timKiem')->name('tk');
        Route::get('timkiemR','AdminController@timKiemR')->name('tkR');

    });
    Route::group(['prefix'=>'giochieu'],function(){
        Route::get('danhsach','AdminController@danhSachGC')->name('dsGC');;

            //them rap
        Route::get('them','AdminController@ThemGC')->name('themGC');
        Route::post('them','AdminController@postThemGC')->name('themGC');

            //sua rap
        Route::get('sua','AdminController@SuaGC')->name('suaGC');
        Route::post('sua','AdminController@postSuaGC')->name('suaGC');

            //xoa rap
        Route::get('xoa','AdminController@XoaGC')->name('xoaGC');
    }); 

        ///------
    Route::group(['prefix'=>'dsve'],function(){
        Route::get('danhsach','AdminController@danhSachDsVe')->name('dsVe');;
    });
                //ve
    Route::group(['prefix'=>'ve'],function(){
        Route::get('danhsach','AdminController@danhSachVe')->name('dsV');;
        Route::get('chitiet','AdminController@danhSachCT')->name('dsV');;
    });
        Route::group(['prefix'=>'gia'],function(){
        Route::get('danhsach','AdminController@danhSachGia')->name('dsGia');
        Route::get('them','AdminController@ThemGia')->name('themGia');
        Route::post('them','AdminController@postThemGia')->name('themGia');

        Route::get('sua','AdminController@SuaGia')->name('suaGia');
        Route::post('sua','AdminController@postSuaGia')->name('suaGia');

        Route::get('xoa','AdminController@XoaGia')->name('xoaGia');


    }); 
});