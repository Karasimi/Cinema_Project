<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class theloai extends Model
{
    protected $table = 'theloais';
    protected $fillable = ['tentheloai'];
    
    public function phim(){

        return $this->hasMany('App\Models\phim','theloai','id'); 
    }
}
