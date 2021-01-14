<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateBinhluansTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('binhluans', function (Blueprint $table) {
            $table->string('noidung');
            $table->integer('phim')->unsigned();;
            $table->integer('khachhang')->unsigned();;
            $table->boolean('trangthai');
            $table->timestamps();
            $table->foreign('phim')->references('id')->on('phims');
            $table->foreign('khachhang')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('binhluans');
    }
}
