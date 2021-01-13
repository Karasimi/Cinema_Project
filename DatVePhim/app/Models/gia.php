<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class gia extends Model
{
	protected $table = 'gias';
    protected $fillable = ['loaighe','phim','gai'];
   public function ghe(){
        return $this->hasMany('App\Models\loaighe','loaighe','id');
    }
   
       public function phim(){

        return $this->hasMany('App\Models\phim','gia','id'); 
    }

}
