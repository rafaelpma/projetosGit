package com.example.rafaelpaz.exemploservices

import android.os.AsyncTask
import android.util.Log

object MeuAsyncTask : AsyncTask<Void, Void, String>() {

    var ativo: Boolean = true

    override fun doInBackground(vararg p0: Void?): String? {
        Log.i("INFO","MeuAsyncTask :: Iniciando o MeuAsyncTask...")
        var i : Int = 0
        while(ativo){
            i++

            Thread.sleep(1000)
            Log.i("INFO","Numero = "+ i)
        }
        return "OK"
    }


}