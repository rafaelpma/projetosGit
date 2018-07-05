package com.example.rafaelpaz.myapplication

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("INFO", "MyReceiver Ativado!!!!")

        var intent = Intent(context, ActivitySecundaria::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        var pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT )

        var notification = NotificationCompat.Builder(context,  "id").
                setSmallIcon(R.drawable.notification_icon_background).
                setContentTitle("Tarefas").setContentText("Texto de tarefas").
                setContentIntent(pendingIntent).setAutoCancel(false).build();
        var manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        manager.notify(0, notification)

        Toast.makeText(context, "TETETSTSTTTSADUYAGSDGASHDGASDJFGADSGFHGDAKSFGAFD", Toast.LENGTH_LONG).show()
    }
}
