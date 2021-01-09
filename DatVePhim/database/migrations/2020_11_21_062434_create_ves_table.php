<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateVesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ves', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('phim')->unsigned();
            $table->integer('rap')->unsigned();
            $table->integer('thoigian')->unsigned();
            $table->integer('ghe')->unsigned();
            $table->integer('gia')->unsigned();
            $table->boolean('trangthai')->default(1);
            $table->integer('dsve')->unsigned();
            $table->timestamps();

            $table->foreign('phim')->references('phim')->on('lichchieus');
            $table->foreign('rap')->references('rap')->on('lichchieus');
            $table->foreign('thoigian')->references('thoigian')->on('lichchieus');
            $table->foreign('ghe')->references('id')->on('ghes');
            $table->foreign('gia')->references('id')->on('gias');
            $table->foreign('dsve')->references('id')->on('dsves');

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ves');
    }
}
