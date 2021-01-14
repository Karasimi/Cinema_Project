<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class danhgia extends Model
{
    protected $table = 'danhgias';
    protected $fillable = ['phim','khachhang','diem'];
    
    public function kh(){

        return $this->belongsTo('App\User','khachhang','id'); 
    }
    public function p(){

        return $this->belongsTo('App\Models\phim','phim','id'); 
    }
}
