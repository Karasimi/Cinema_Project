<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateGiasTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('gias', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('loaighe')->unsigned();
            $table->integer('phim')->unsigned();
            $table->float('gia');
             $table->integer('trangthai')->default(1);
            $table->timestamps();

            $table->foreign('loaighe')->references('id')->on('loaighes');
            $table->foreign('phim')->references('id')->on('phims');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('gias');
    }
}
