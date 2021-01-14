<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class dsve extends Model
{ protected $table = 'dsves';
    protected $fillable = ['khachhang','soluong','ngaymua'];
   public function kh(){
        return $this->belongsTo('App\Models\user','khachhang','id');
    }
       public function r(){
        return $this->belongsTo('App\Models\rap','rap','id');
    }
}
