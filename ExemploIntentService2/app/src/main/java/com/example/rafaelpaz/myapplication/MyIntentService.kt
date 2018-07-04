package com.example.rafaelpaz.myapplication

import android.app.IntentService
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log


class MyIntentService : IntentService("MyIntentService") {
    var ativo: Boolean = true

    var mBinder =  MyBinder()

    override fun onHandleIntent(intent: Intent?) {

        Log.i("INFO","MeuAsyncTask :: Iniciando o MeuAsyncTask...")
        var i : Int = 0
        while(ativo){
            i++

            Thread.sleep(1000)
            Log.i("INFO","Numero = "+ i)
        }

    }


    override fun onBind(intent: Intent): IBinder {
        return mBinder;
    }


    inner class MyBinder: Binder(){
        fun getService(): MyIntentService{
            return this@MyIntentService
        }
    }
    fun paraContador(): Int {
        Log.i("INFO","paraContador (INICIO)")
        //meuTask.cancel(true)
        ativo = false;
        Log.i("INFO","paraContador (FIM)")
        return START_STICKY
    }


}
