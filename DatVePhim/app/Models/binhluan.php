<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class binhluan extends Model
{
	   protected $table = 'binhluans';
    protected $fillable = ['phim','khachhang','noidung'];
    public function p(){
        return $this->belongsTo('App\Models\phim','phim','id');
    }public function kh(){
        return $this->belongsTo('App\Models\user','khachhang','id');
    }
}
