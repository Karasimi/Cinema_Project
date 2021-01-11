<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\phim;
use App\Models\rap;
use App\Models\lich;
use App\Models\ghe;
use App\Models\ve;
use App\Models\theloai;
use App\Models\lichchieu;
use App\Models\khungtgchieu;
use Illuminate\Http\Response;
use Carbon\Carbon;
use stdClass;
use Illuminate\Database\Eloquent\Collection;

class APIController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function getPhim()
    {
      $phim = phim::all();
      foreach ($phim as $key=>$value) {
        $phim[$key]->tenphim = $value->tenphim;
        $phim[$key]->theloai = $value->tl->tentheloai;
        $phim[$key]->daodien = $value->dd->tendaodien;
        $phim[$key]->dienvien = $value->dv->tendienvien;
        $phim[$key]->quocgia = $value->qg->tenquocgia;
        $phim[$key]->nsx = $value->nsxs->tennsx;
        $phim[$key]->thoiluong = $value->thoiluong;
        $phim[$key]->trailer = $value->trailer;
        $hinhanh="upload/".$value->hinhanh;
        $imagedata = file_get_contents($hinhanh);
        $base64 = base64_encode($imagedata);
        $phim[$key]->hinhanh = $base64;
      }
      return response()->json($phim, Response::HTTP_OK);

    }
    public function postPhim(Request $request)
    {
      $id = $request->id;
      $phim = phim::find($id);
      $phim->theloai = $phim->tl->tentheloai;
      $phim->daodien = $phim->dd->tendaodien;
      $phim->dienvien = $phim->dv->tendienvien;
      $phim->quocgia = $phim->qg->tenquocgia;
      $phim->nsx = $phim->nsxs->tennsx;
      $hinhanh="upload/".$phim->hinhanh;
      $imagedata = file_get_contents($hinhanh);
      $base64 = base64_encode($imagedata);
      $phim->hinhanh = $base64;
      return response()->json($phim, Response::HTTP_OK);

    }
    public function postLC(Request $request)
    {
      $id =$request->id;
      $ngay =$request->ngaychieu;
      $lc = lichchieu::join('khungtgchieus', 'khungtgchieus.id', '=', 'lichchieus.thoigian')
      ->where('khungtgchieus.ngaychieu', $ngay)
      ->where('lichchieus.phim',$id)
      ->distinct()->distinct()->get('rap');
      foreach ($lc as $key => $value) {
        $rap = rap::find($value->rap);
        $dsr[$key] = array('id' =>$rap->id,'tenrap'=>$rap->tenrap,'socot'=>$rap->socot);
      }
      $gio = lichchieu::join('khungtgchieus', 'khungtgchieus.id', '=', 'lichchieus.thoigian')->get(['ngaychieu','rap','giochieu','thoigian']);
      return response()->json(['rap'=>$dsr,'gio'=>$gio], Response::HTTP_OK);

    }
    public function dslich(){
      $t = [
        0 => 'CN',
        1 => 'TH2',
        2 => 'TH3',
        3 => 'TH4',
        4 => 'TH5',
        5 => 'TH6',
        6 => 'TH7',
      ];
      $ngay[0] = Carbon::now()->toDateString();
      for ($i=1; $i < 7 ; $i++) { 
        $ngay[$i] = Carbon::parse($ngay[$i-1])->addDay()->toDateString();
      }
      foreach ($ngay as $key => $value) {
        $thu = Carbon::parse($value)->dayOfWeek;
        $ngay = Carbon::parse($value)->day;  
        $thang = Carbon::parse($value)->month;  
        $nam = Carbon::parse($value)->year;    
        $lich[$key] = array('ntn' => $value, 'thu' =>$t[$thu] , 'ngay' => $ngay, 'thang' => $thang, 'nam' => $nam);
      }


      return response()->json($lich, Response::HTTP_OK);

    }
    public function postlichchieu(Request $request)
    {
      $id = $request->id;
      $lc = lichchieu::all();
      return response()->json($lc, Response::HTTP_OK);

    }
    public function postgiochieu(Request $request)
    {
      $id = $request->idRap;
      $idPhim = $request->idPhim;
      $ngaychieu = $request->ngayChieu;
      $giochieu = lichchieu::where('phim',$idPhim)->where('rap',$id)->get('thoigian');
      foreach ($giochieu as $key => $value) {
        $r[$key]= khungtgchieu::where('id',$value->thoigian)->where('ngaychieu',$ngaychieu)->first();
      }
      return response()->json($r, Response::HTTP_OK);

    }
    public function ghe(Request $request)
    {
      $id = $request->rap;
      $ghe = ghe::where('rap',$id)->get();
      return response()->json($ghe, Response::HTTP_OK);
    }
    public function datve(Request $request){
       $a = $request->ghe;
       $ghedat = json_decode($a);
       foreach ($ghedat as $key => $value) {

       }
      return $a;
 }
   public function hihi(){
        $rap = rap::all();
        $rap = $rap->reverse()->values();
        $a = $rap->reverse()->values();
        return [$rap,$a];
 }
}
