package com.example.rafaelpaz.projetotarefaskotlin

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.view.View
import android.view.View.OnClickListener

class ActivitySecundaria : AppCompatActivity(), OnClickListener {
    override fun onClick(v: View?) {

        var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // android 8
        //var channel = NotificationChannel("com.lala.laladkj", "name", NotificationManager.IMPORTANCE_HIGH)
        //manager.createNotification(channel)

        var bigTexto = "Testet sdasdasdaa asd dasf das fdsa f dsf " +
                "dasf dasf das fda sf dsf df  ads fad f " +
                "dasf daf a sf adsf as f asf dasf ad sf asf " +
                "adsf as f adsf das f adsf das f asf af ds fa dfa df";

        var intent = Intent(this, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT )

        var builder = NotificationCompat.Builder(this,  "id");

        var bigNotif = NotificationCompat.BigTextStyle(builder).bigText(bigTexto).
                setBigContentTitle("Teste Big Titulo").setSummaryText("Summary text")

        builder.setStyle(bigNotif).setContentTitle("Content Title").
                setContentText("Texto").setSmallIcon(R.drawable.navigation_empty_icon).
                setContentIntent(pendingIntent).setAutoCancel(false)


        manager.notify(0, builder.build())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secundaria)
    }
}
