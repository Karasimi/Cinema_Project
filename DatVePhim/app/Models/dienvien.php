<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class dienvien extends Model
{
    protected $table = 'dienviens';
    protected $fillable = ['tendienvien'];
    
    public function phim(){

        return $this->hasMany('App\Models\dienvien','dienvien','id'); 
    }
}
