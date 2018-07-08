package com.example.rafaelpaz.bebeaguamizera

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

object AlarmeUtil {

    fun ativarAlarme(context: Context, tempo :Long){
        var alarmManager: AlarmManager? = null
        var alarmIntent: PendingIntent? = null

        val calendar = Calendar.getInstance()
        calendar.setTimeInMillis(System.currentTimeMillis())
        alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intent = Intent(context, AlarmeReceiver::class.java)
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager!!.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis+tempo, tempo, alarmIntent)

        Log.i("INFO", "AlarmeUtil :: ativarAlarme - Setando tempo para "+tempo+" Milissegundos")

    }

}