<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class ve extends Model
{
 protected $table = 'ves';
    protected $fillable = ['phim','rap','thoigian','ghe','gia'];
   public function lg(){
        return $this->belongsTo('App\Models\loaighe','loaighe','id');
    }
       public function r(){
        return $this->belongsTo('App\Models\rap','rap','id');
    }
    
}
