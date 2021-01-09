<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateRapsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('raps', function (Blueprint $table) {
            $table->increments('id');
            $table->string('tenrap');
            $table->integer('chinhanh')->unsigned();
            $table->integer('soday');
            $table->integer('socot');
            $table->boolean('trangthai')->default(1);
            $table->timestamps();

            $table->foreign('chinhanh')->references('id')->on('chinhanhs');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('raps');
    }
}
