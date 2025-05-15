 package com.example.rafaelpaz.exemploservices

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {
   // var service: MyService? = null
    var intentService:Intent? = null //Intent(this, MyService::class.java)

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button2 ->{
                intentService = Intent(this, MyService::class.java)

                startService(intentService)
            }
            R.id.button1 ->{
//                intentService = Intent(this, MyService::class.java)
                if (intentService != null){
                    stopService(intentService)
                }

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   service = MyService()

    }
}
