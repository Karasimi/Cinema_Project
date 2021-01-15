<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\phim;
use App\Models\rap;
use App\Models\lich;
use App\Models\ghe;
use App\Models\gia;
use App\Models\danhgia;
use App\Models\dsve;
use App\Models\ve;
use App\Models\theloai;
use App\Models\user;
use App\Models\binhluan;
use App\Models\lichchieu;
use App\Models\khungtgchieu;
use Illuminate\Http\Response;
use Carbon\Carbon;
use stdClass;
use DateTime;
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
      $phim = phim::where('trangthai','<>',0)->get();
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


      $danhgia = danhgia::where('phim',$id)->avg('diem');
      $diem = array('diem' => $danhgia);
      return response()->json(['phim'=>$phim,'diem'=>$diem], Response::HTTP_OK);

    }
    public function chamdiem(Request $request){
      $id = $request->phim;
      $diem = $request->diem;
      $khachhang = $request->khachhang;
      $danhgia = new danhgia;
      $danhgia->phim = $id;
      $danhgia->diem = $diem;
      $danhgia->khachhang = $khachhang;
      $danhgia->save();
      $danhgia = danhgia::where('phim',$id)->avg('diem');
      $diem = array('diem' => $danhgia);
      return Response()->json($diem);
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
      $gio = lichchieu::join('khungtgchieus', 'khungtgchieus.id', '=', 'lichchieus.thoigian')->
      where('khungtgchieus.ngaychieu','>=',$ngay)->get(['ngaychieu','rap','giochieu','thoigian']);
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
      $gio = $request->thoigian;
      $ghe = ghe::where('rap',$id)->get();
      $gia = gia::where('trangthai',1)->get();
      foreach ($ghe as $key => $value) {
        $g = ghe::join('ves','ves.ghe','=','ghes.id')->where('ves.thoigian',$gio)->where('ves.ghe',$value->id)->count();
        if ($g != 0) {
          $ghe[$key]->trangthai = 2;
        }
      }
      return response()->json(['ghe'=>$ghe,'gia'=>$gia], Response::HTTP_OK);
    }
    public function hihi(Request $request){
      $id = $request->phim;
      $diem = $request->diem;
      $khachhang = $request->khachhang;
      $kiemTra = danhgia::where('phim',$id)->where('khachhang',$khachhang)->count();
      if ($kiemTra == 0) {
        $danhgia = new danhgia;
        $danhgia->phim = $id;
        $danhgia->diem = $diem;
        $danhgia->khachhang = $khachhang;
        $danhgia->save();
      }else
      {
        // $chamDiem = danhgia::where('phim',$id)->where('khachhang',$khachhang)->get();
        // $chamDiem->khachhang = $khachhang;
        // $chamDiem->phim = $id;
        // $chamDiem->diem = $diem;
        // $danhgia->save();
      }
      $danhgia = danhgia::where('phim',$id)->avg('diem');
      $diem = array('diem' => $danhgia);
      return Response()->json($chamDiem);

    }
    public function datve(Request $request){
      $phim = $request->phim;
      $thoigian = $request->thoigian;
      $rap = $request->rap;
      $ghedat = json_decode($request->ghe);
      $i = count($ghedat);
      $ds = new dsve;
      $ds->khachhang = 1;
      $ds->soluong = $i;
      $ds->ngaymua = Carbon::now();
      $ds->save();
      $dsve = dsve::all()->last();
      foreach ($ghedat as $key => $value) {
        $kt = ve::where('phim',$phim)->where('ghe',$value->id)->where('rap',$rap)->where('thoigian', $thoigian)->count();
        if ($kt == 0) {
          $ve =  new ve;
          $ve->phim = $phim;
          $ve->rap =$rap;
          $ve->thoigian = $thoigian;
          $ve->ghe = $value->id;
          $ve->dsve = $dsve->id;
          $gia = gia::where('phim',$phim)->where('loaighe',$value->loai)->first('id');
          $ve->gia = $gia->id;
          $ve->save();
        }else {

        }
        $v = ve::where('dsve',$dsve->id)->get();
      }
      return Response()->json($v);
    }
    public function thanhtoan(Request $request){
      $p = $request->phim;
      $r =$request->rap;
      $tg = $request->thoigian;
      $phim = phim::find($p)->first(['id','tenphim','hinhanh']);
      $rap = rap::find($r);
      $thoigian = khungtgchieu::find($tg);
      $hinhanh="upload/".$phim->hinhanh;
      $imagedata = file_get_contents($hinhanh);
      $base64 = base64_encode($imagedata);
      $arrayName = array('tenphim'=>$phim->tenphim, 'hinhanh'=>$base64, 'tenrap'=>$rap->tenrap, 'giochieu'=>$thoigian->giochieu, 'ngaychieu'=>$thoigian->ngaychieu);
      return Response()->json($arrayName);
    }   
    public function thanhtoan1(Request $request){
      $danhgia = danhgia::where('phim',1)->avg('diem');
      $arrayName = array('diem' => $danhgia);
      return $arrayName;
    }
    public function binhluan(Request $request)
    {
      $phim = $request->phim;
      $binhluan = binhluan::where('phim',$phim)->get();

      foreach ($binhluan as $key => $value) {
        if ($value->kh->name != null) {
          $binhluan[$key]->khachhang=$value->kh->name;
        }else{
          $binhluan[$key]->khachhang=$value->kh->email;
        }
      }
      return Response()->json($binhluan);

    }
    public function bl(Request $request)
    {
      $phim = $request->phim;
      $noidung = $request->noidung;
      $khachhang = $request->khachhang;
      $binhluan = binhluan::all();
      $bl = new binhluan;
      $bl->khachhang = $khachhang;
      $bl->noidung = $noidung;
      $bl->phim = $phim;
      $bl->save();
      $bl = binhluan::where('phim',$phim)->get();
      foreach ($bl as $key => $value) {
        if ($value->kh->name != null) {
          $bl[$key]->khachhang=$value->kh->name;
        }else{
          $bl[$key]->khachhang=$value->kh->email;
        }
      }
      return Response()->json($bl);
    }
    public function ttcanhan(Request $request)
    {
      $id = $request->khachhang;
      $khachhang =user::find($id);
      return Response()->json($khachhang);
    }
    public function capnhatcanhan(Request $request)
    {
      $id = $request->khachhang;
      $t = $request->name;
      $dc = $request->diachi;
      $e = $request->email;
      $p = $request->phone;
      $khachhang =user::find($id);
      $khachhang->name = $t;
      $khachhang->email = $e;
      $khachhang->diachi = $dc;
      $khachhang->sdt = $p;
      $khachhang->save();
      return Response()->json($khachhang);
    }
    public function lsgiaodich(Request $request)
    {
      $id = $request->khachhang;
      $giaodich =dsve::where('khachhang',$id)->get();
      foreach ($giaodich as $key => $value) {
        $giaodich[$key]->khachhang = $value->kh->name;
      }
      return Response()->json($giaodich);
    }
  }
