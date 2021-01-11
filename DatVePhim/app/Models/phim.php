<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class phim extends Model
{
    protected $table = 'phims';
    protected $fillable = ['tenphim','hinhanh','thoiluong','trailer','daodien','dienvien','theloai','nsx','quocgia','trangthai'];
    //public $timestamps =false;
 
    //the loai
    public function tl(){
        return $this->belongsTo('App\Models\theloai','theloai','id');
    }
    //đao dien
    public function dd(){
        return $this->belongsTo('App\Models\daodien','daodien','id');
    }
    //dien vien
    public function dv(){
        return $this->belongsTo('App\Models\dienvien','dienvien','id');
    }
    //nha san xuat
    public function nsxs(){
        return $this->belongsTo('App\Models\nsx','nsx','id');
    }
    //quoc gia
    public function qg(){
        return $this->belongsTo('App\Models\quocgia','quocgia','id');
    }
        //lich chieu
    public function phim(){

        return $this->hasMany('App\Models\lichchieu','phim','id'); 
    }
        public function dg(){

        return $this->hasMany('App\Models\danhgia','phim','id'); 
    }
}
