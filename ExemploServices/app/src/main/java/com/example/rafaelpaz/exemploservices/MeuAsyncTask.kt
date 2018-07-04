package com.example.rafaelpaz.exemploservices

import android.os.AsyncTask
import android.util.Log

object MeuAsyncTask : AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg p0: Void?): String? {
        Log.i("INFO","MeuAsyncTask :: Iniciando o MeuAsyncTask...")
        for (i in 1..30){

            Thread.sleep(10000)
            Log.i("INFO","Numero = "+i)
        }
        return "OK"
    }


}