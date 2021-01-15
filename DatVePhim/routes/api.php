<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

        //api
Route::group(['prefix'=>'api'],function(){
	Route::get('phim','APIController@getPhim')->name('dsPhim');;
	Route::post('phim','APIController@postPhim')->name('dsPhim');;
	Route::post('rap','APIController@postLC')->name('dsR');;
	Route::post('lichchieu','APIController@postlichchieu')->name('dsR');;
	Route::post('giochieu','APIController@postgiochieu')->name('dsg');;
	Route::get('dslich','APIController@dslich')->name('dslich');;
	Route::post('ghe','APIController@ghe')->name('dsg');;
	Route::get('ngay','APIController@layngay')->name('dsh');;
	Route::post('datve','APIController@datve')->name('dv');;
		Route::get('datve','APIController@hihi')->name('dv');;

});  
Route::post('login', 'Api\UserController@login');
Route::post('dangky', 'Api\UserController@dangky');
Route::get('dangxuat', 'Api\UserController@dangxuat');
Route::post('save_user_info','Api\UserController@saveUser')->middleware('jwtAuth');
// Route::middleware('auth:api')->get('/user', function (Request $request) {
// 	return $request->user();
// });
