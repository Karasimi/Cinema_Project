
<?php
use App\Models\lichchieu;
use App\Models\phim;
use Carbon\Carbon;

function kiemtra($phim, $rap, $khungtgchieu, $dt){
  $i=0;
  $k=0;
  foreach ($rap as $key => $value2) {
    foreach ($phim as $key => $value) {  
      $p = phim::find($value);
      $ngay = Carbon::parse($dt)->addDays();
      if ($p->ngay < $ngay) {

       foreach ($khungtgchieu as $ki => $value1) {   
        if ($k == 0) {

          if (lichchieu::where('thoigian',$value1->id)->count() == 0){
           $lichchieu = new lichchieu();
           $lichchieu->phim = $value;
           $lichchieu->rap = $value2;
           $lichchieu->thoigian = $value1->id;
           $lichchieu->save();
           $i++;
           $k=1;
         }else{
          if(lichchieu::where('thoigian',$value1->id)->where('rap',$value2)->count() == 0){
           $lichchieu = new lichchieu();
           $lichchieu->phim = $value;
           $lichchieu->rap = $value2;
           $lichchieu->thoigian = $value1->id;
           $lichchieu->save();
           $i++;
           $k=1;
         }
         else{
         }

       } 
     }
   }
   $k=0;
 }

}
}
return $i;
}
