<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class ghe extends Model
{
      protected $table = 'ghes';
    protected $fillable = ['hang','cot','rap','loaighe'];
   public function lg(){
        return $this->belongsTo('App\Models\loaighe','loaighe','id');
    }
       public function r(){
        return $this->belongsTo('App\Models\rap','rap','id');
    }
}
