<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class phim extends Model
{
    
    protected $table = 'phims';
    

    public $fillable = ['tenphim','hinhanh','noidung','dotuoi','thoiluong','trailer','daodien','dienvien','theloai','nsx','quocgia','trangthai'];
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
    public function lc(){

        return $this->hasMany('App\Models\lichchieu','phim','id'); 
    }
<<<<<<< HEAD
        public function dg(){

        return $this->hasMany('App\Models\danhgia','phim','id'); 
    }
       public function ve(){

        return $this->hasMany('App\Models\ve','phim','id'); 
    }
=======
>>>>>>> f7cdbaabfc12dd4ef86502c324c8bcacce225e52
}
