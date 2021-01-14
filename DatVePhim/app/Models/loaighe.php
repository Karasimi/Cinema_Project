<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class loaighe extends Model
{
     protected $table = 'loaighes';
    protected $fillable = ['tenloai'];
    
    public function g(){

        return $this->beLongTO('App\Models\ghe','loaighe','id'); 
    }
}
