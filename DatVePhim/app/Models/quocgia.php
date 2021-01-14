<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class quocgia extends Model
{
    protected $table = 'quocgias';
    protected $fillable = ['tenquocgia'];
    
    public function phim(){

        return $this->hasMany('App\Models\quocgia','quocgia','id'); 
    }
}
