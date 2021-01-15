<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePhimsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('phims', function (Blueprint $table) {
            $table->increments('id');
            $table->string('tenphim')->unique();
            $table->string('hinhanh');
            $table->string('thoiluong');
            $table->string('noidung');
            $table->integer('dotuoi');
            $table->string('trailer');
            $table->integer('trangthai')->default(1);
            $table->integer('daodien')->unsigned();
            $table->integer('dienvien')->unsigned();
            $table->integer('theloai')->unsigned();
            $table->integer('nsx')->unsigned();
            $table->integer('quocgia')->unsigned();
            $table->date('ngay');
            $table->timestamps();

            $table->foreign('daodien')->references('id')->on('daodiens');
            $table->foreign('dienvien')->references('id')->on('dienviens');
            $table->foreign('theloai')->references('id')->on('theloais');
            $table->foreign('quocgia')->references('id')->on('quocgias');
            $table->foreign('nsx')->references('id')->on('nsxes');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phims');
    }
}
