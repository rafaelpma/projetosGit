package com.example.rafaelpaz.bebeaguamizera

import android.app.IntentService
import android.content.Intent

import android.util.Log



class IntentServiceAlarme : IntentService("IntentServiceAlarme") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i("INFO","IntentServiceAlarme :: onHandleIntent - Reconfigurando o Alarme!!!")
        var config = Configuracao.create();
        config .carregarDados(applicationContext)
        AlarmeUtil.ativarAlarme(applicationContext, config.intervaloAlerta)

        Log.i("INFO","IntentServiceAlarme :: onHandleIntent - Fim.")
    }
}
