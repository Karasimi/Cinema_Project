<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class daodien extends Model
{
    protected $table = 'daodiens';
    protected $fillable = ['tendaodien'];
    
    public function phim(){

        return $this->hasMany('App\Models\phim','daodien','id'); 
    }
}
