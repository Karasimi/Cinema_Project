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
    public function tg(){
        return $this->belongsTo('App\Models\khungtgchieu','thoigian','id');
    }
    public function g(){
        return $this->belongsTo('App\Models\ghe','ghe','id');
    }
    public function gi(){
        return $this->belongsTo('App\Models\gia','gia','id');
    }
    public function p(){
        return $this->belongsTo('App\Models\phim','phim','id');
    }
}
