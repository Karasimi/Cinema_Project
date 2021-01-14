<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateDsvesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('dsves', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('khachhang')->unsigned();
            $table->integer('soluong');
            $table->datetime('ngaymua');
            $table->timestamps();

            $table->foreign('khachhang')->references('id')->on('khachhangs');


        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('dsves');
    }
}
