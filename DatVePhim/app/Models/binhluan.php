<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class binhluan extends Model
{
    public function phim(){
        return $this->belongsTo('App\Models\phim','phim','id');
    }public function kh(){
        return $this->belongsTo('App\Models\khachhang','khachhang','id');
    }
}
