<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class chinhanh extends Model
{
    protected $table = 'chinhanhs';
    protected $fillable = ['tenchinhanh','diachi'];
    
    public function rap(){

        return $this->hasMany('App\Models\rap','chinhanh','id'); 
    }
}
