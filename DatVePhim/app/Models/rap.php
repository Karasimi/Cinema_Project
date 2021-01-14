<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class rap extends Model
{
    protected $table = 'raps';
    protected $fillable = ['tenrap','chinhanh','soday','socot'];
    
    public function r(){
        return $this->belongsTo('App\Models\chinhanh','chinhanh','id');
    }

    //lich chieu
    public function lc(){

        return $this->hasMany('App\Models\lichchieu','rap','id'); 
    }
     public function ghe(){

        return $this->hasMany('App\Models\ghe','rap','id'); 
    }
}

