<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class gia extends Model
{
    protected $table = 'gias';
    protected $fillable = ['loaighe','phim','gia'];
   public function lg(){
        return $this->hasMany('App\Models\phim','phim','id');
    }
       public function r(){
        return $this->hasMany('App\Models\ghe','loaighe','id');
    }
}
