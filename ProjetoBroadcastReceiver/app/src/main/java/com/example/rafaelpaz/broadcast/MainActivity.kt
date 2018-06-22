package com.example.rafaelpaz.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v4.widget.TextViewCompat
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.rafaelpaz.broadcast.R.id.textView

class MainActivity : AppCompatActivity(), OnClickListener {


    val MINHA_ACAO = "com.example.rafaelpaz.broadcast.MINHA_ACAO"

    val MINHA_ACAO_LOCAL = "com.example.rafaelpaz.broadcast.MINHA_ACAO_LOCAL"

    override fun onClick(v: View?) {
        when (v!!.id){
            R.id.button ->{
                enviaBroadcast(v)
            }
            R.id.button2 ->{
                enviaLocalBroadcast(v)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = IntentFilter(MINHA_ACAO_LOCAL)
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, intent)


    }
    fun enviaBroadcast(v: View){
        val it = Intent(MINHA_ACAO)
        sendBroadcast(it)
    }

    fun enviaLocalBroadcast(v: View){
        val it = Intent(MINHA_ACAO_LOCAL)
        LocalBroadcastManager.getInstance(this).sendBroadcast(it)
    }
    // dinamico
    var mReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "ACAO LOCAL = "+intent!!.action, Toast.LENGTH_LONG).show()
        }

    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver)

    }
}
