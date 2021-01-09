<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class loaighe extends Model
{
     protected $table = 'loaighes';
    protected $fillable = ['tenloai'];
    
    public function ghe(){

        return $this->hasMany('App\Models\ghe','loaighe','id'); 
    }
}
