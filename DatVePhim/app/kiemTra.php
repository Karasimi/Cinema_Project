<?php
use App\Models\lichchieu;
function kiemTra($phim, $gio, $rap, $ngay){
    if (lichchieu::where('thoigian','=',$gio)->count() == 0){
        return true;
    }else{
        if(lichchieu::where([['thoigian','=',$gio],['rap','=',$rap]])->count() == 0){
            return true;
        }
        else{
                return false;
        }
    }
} 
?>