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
            $table->integer('user')->unsigned();
            $table->integer('soluong');
            $table->datetime('ngaymua');
            $table->timestamps();

<<<<<<< HEAD
            $table->foreign('khachhang')->references('id')->on('users');
=======
            $table->foreign('user')->references('id')->on('users');
>>>>>>> f7cdbaabfc12dd4ef86502c324c8bcacce225e52


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
