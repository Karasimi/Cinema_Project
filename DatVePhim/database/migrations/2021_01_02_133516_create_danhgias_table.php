<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateDanhgiasTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('danhgias', function (Blueprint $table) {
            $table->integer('diem');
            $table->integer('phim')->unsigned();;
            $table->integer('khachhang')->unsigned();;
            $table->boolean('trangthai')->default(1);
            $table->timestamps();

            $table->foreign('phim')->references('id')->on('phims');
            $table->foreign('khachhang')->references('id')->on('users');
            $table->primary(['khachhang']);
        
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('danhgias');
    }
}
