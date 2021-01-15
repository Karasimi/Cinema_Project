<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\User;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Tymon\JWTAuth\Facades\JWTAuth;

class UserController extends Controller
{
    //
    public function login(Request $req)
    {
        $a = $req->only(['email','password']);
        if(!$token=auth()->attempt($a))
        {
            return response()->json([
                'success' => false,
                'message'=>'Khong hop le'
            ]);
        }
        return response()->json([
            'success' => true,
            'token'=>$token,
            'user'=> Auth::User()
        ]);
    }
    public function dangky(Request $req)
    {
        $pw = Hash::make($req->password);

        $user = new User;
        try{
            //$user->name = $req->name;
            $user->email = $req->email;
            $user->password = $pw;
            $user->save();
            return $this->login($req);
        }
        catch(Exception $e)
        {
            return response()->json([
                'success' => false,
                'message'=>''.$e
            ]);
        }
    }
    public function dangxuat(Request $req)
    {
        try{
            JWTAuth::invalidate(JWTAuth::parseToken($req->token));
            return response()->json([
                'success' =>true,
                'message'=>'dang xuat thanh cong',
            ]);
        }
        catch(Exception $e){
           
            return response()->json([
                'success' => false,
                'message'=>''.$e
            ]);
        }
    }
    public function saveUser(Request $req)
    {
        $user = User::find(Auth::user()->id);
        $user->name = $req->name;
        $user->sdt = $req->sdt;
        $user->diachi = $req->diachi;
        $anh ='';
        if($req->anh != ''){
            $photo = time().'.jpg';
            file_put_contents('storage/profiles/'.$photo, base64_decode($req->photo));
            $user->anh = $anh;
        }
        $user->update();
        return response()->json([
            'success' => true,
            'anh' => $anh
        ]);
    }
}
