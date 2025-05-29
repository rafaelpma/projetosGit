package com.example.rafaelpaz.bebeaguamizera

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.util.Log

class AlarmeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.i("INFO", "AlarmeReceiver :: Iniciado...")
        var intent = Intent(context, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        var pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT )

        var notification = NotificationCompat.Builder(context,  "id").
                setSmallIcon(R.drawable.notification_icon_background).
                setContentTitle("Bebe Água Mizera!!").setContentText("É o momento de manter o corpo hidratado!").
                setContentIntent(pendingIntent).setAutoCancel(false).build();
        var manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        manager.notify(0, notification)
        Log.i("INFO", "AlarmeReceiver :: Finalizado...")
    }
}
