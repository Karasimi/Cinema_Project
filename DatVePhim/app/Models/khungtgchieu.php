<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class khungtgchieu extends Model
{
    

    protected $table = 'khungtgchieus';
    protected $fillable = ['giochieu','ngaychieu'];

    //lich chieu
    public function khungtg(){

        return $this->hasMany('App\Models\lichchieu','thoigian','id'); 
    }
}
