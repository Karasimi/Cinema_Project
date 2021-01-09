<?php

namespace App\Models;

use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;

class nhanvien extends Authenticatable
{
    use Notifiable;
    protected $guard = 'nhanvien';

protected $fillable = [
    'name', 'email', 'password',
];

protected $hidden = [
    'password', 'remember_token',
];
}
