<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class nsx extends Model
{
    protected $table = 'nsxes';
    protected $fillable = ['tennsx'];
    
    public function phim(){

        return $this->hasMany('App\Models\nsx','nsx','id'); 
    }
}
