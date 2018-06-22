package com.example.rafaelpaz.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
// estatico
class MeuReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var acao = intent!!.action

        Toast.makeText(context, "Acao: "+acao, Toast.LENGTH_LONG).show()

    }
}