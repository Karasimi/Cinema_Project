<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class dsve extends Model
{
    public function kh(){
        return $this->belongsTo('App\User','User','id');
    }
}
