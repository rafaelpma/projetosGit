package com.example.rafaelpaz.exemploservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.math.log

class MyService : Service() {
    var meuTask = MeuAsyncTask




    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("INFO","Iniciando o servico...")
//        for (i in 1..3){
//
//            Thread.sleep(10000)
//            Log.i("INFO","Numero = "+i)
//        }

        meuTask.execute()
        Log.i("INFO","Finalizando o servico...")





        return START_STICKY
        //return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy() {
        super.onDestroy()
        meuTask.cancel(true)
        Log.i("INFO","!!!!!!!!!!!!!!!!!!!!!!!!!!!!DESTRUINDO O SERVICO!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    }
}
