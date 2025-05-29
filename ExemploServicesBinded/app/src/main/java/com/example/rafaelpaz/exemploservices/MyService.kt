package com.example.rafaelpaz.exemploservices

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlin.math.log

class MyService : Service() {

    var mBinder =  MyBinder()

    inner class MyBinder: Binder(){
        fun getService(): MyService{
            return this@MyService
        }
    }

    var meuTask = MeuAsyncTask

    fun iniciaContador(): Int {
        Log.i("INFO","iniciaContador (INICIO)")
        meuTask.execute()
        Log.i("INFO","iniciaContador (FIM)")
        return START_STICKY
    }

    fun paraContador(): Int {
        Log.i("INFO","paraContador (INICIO)")
        //meuTask.cancel(true)
        meuTask.ativo = false;
        Log.i("INFO","paraContador (FIM)")
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder;
    }

    override fun onDestroy() {
        super.onDestroy()
        meuTask.cancel(true)
        Log.i("INFO","!!!!!!!!!!!!!!!!!!!!!!!!!!!!DESTRUINDO O SERVICO!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    }
}
