 package com.example.rafaelpaz.exemploservices

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var intentService:Intent? = null

    var myService: MyService? = null

    var connected: Boolean = false

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button2 ->{

                myService!!.iniciaContador()
            }
            R.id.button1 ->{
                if (intentService != null){
                    myService!!.paraContador()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentService = Intent(this, MyService::class.java)

        bindService(intentService, myConnection, Context.BIND_AUTO_CREATE)

    }


    private val myConnection = object : ServiceConnection{
        override fun onServiceConnected(className : ComponentName, binder: IBinder){
            myService = (binder as MyService.MyBinder).getService()
            connected = true
        }

        override fun onServiceDisconnected(name : ComponentName){
            connected = false
        }

    }
}
