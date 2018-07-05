package com.example.rafaelpaz.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var alarmManager: AlarmManager? = null
    var alarmIntent: PendingIntent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button2 ->{

                Log.i("INFO","Clique no Botão 2")

                alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

                intent = Intent(this, MyReceiver::class.java)

                alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

                //alarmManager!!.setRepeating(AlarmManager.RTC_WAKEUP, 1, 60, alarmIntent)
                alarmManager!!.set(AlarmManager.RTC_WAKEUP, 60, alarmIntent)

            }
            R.id.button1 ->{




            }
        }
    }
}
