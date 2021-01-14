<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class lichchieu extends Model
{
    protected $table = 'lichchieus';
    protected $fillable = ['phim','thoigian','rap'];
    
    //rap
    public function r(){
        return $this->belongsTo('App\Models\rap','rap','id');
    }
    //phim
    public function p(){
        return $this->belongsTo('App\Models\phim','phim','id');
    }
    //thoi gian
    public function tg(){
        return $this->belongsTo('App\Models\khungtgchieu','thoigian','id');
    }
}
