<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateGhesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ghes', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('rap')->unsigned();
            $table->string('hang');
            $table->string('cot');
            $table->integer('loaighe')->unsigned();
            $table->boolean('trangthai')->default(1);
            $table->timestamps();

            $table->foreign('rap')->references('id')->on('raps');
            $table->foreign('loaighe')->references('id')->on('loaighes');

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ghes');
    }
}
