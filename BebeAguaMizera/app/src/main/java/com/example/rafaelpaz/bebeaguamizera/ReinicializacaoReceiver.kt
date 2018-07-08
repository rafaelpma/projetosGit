package com.example.rafaelpaz.bebeaguamizera


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReinicializacaoReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var config = Configuracao.create();
        config .carregarDados(context)

        AlarmeUtil.ativarAlarme(context, config.intervaloAlerta)
    }
}
