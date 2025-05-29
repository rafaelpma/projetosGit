package com.example.rafaelpaz.projetotarefaskotlin

import android.app.Activity
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rafaelpaz.projetotarefaskotlin.R.layout.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btn: Button? = null
    private var textNome: TextInputLayout? = null
    private var textDescricao: EditText? = null
    private var LISTA_TAREFAS = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        btn = findViewById(R.id.button);

        textNome = findViewById(R.id.nomeTarefa);
        textDescricao = findViewById(R.id.editText);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            var texto = data!!.getStringExtra("DETALHE")
            Toast.makeText(applicationContext,texto,Toast.LENGTH_LONG).show()

        }

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button -> {
                var itent = Intent(this, ListaTarefas::class.java)
                startActivityForResult(itent, LISTA_TAREFAS)
            }
            R.id.button2 -> {
                var strNome = textNome!!.editText!!.text.toString() ;
                var strDescricao = textDescricao!!.text.toString() ;

                var tarefa = Tarefa(strNome, strDescricao, false)
                RepositorioTarefas.tarefas.add(tarefa)

                exibeCxDialogo()

                textNome!!.editText!!.text.clear() ;
                textDescricao!!.text.clear() ;

            }
            R.id.btnNotifica ->{
                var intent = Intent(this, ActivitySecundaria::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT )

                var notification = NotificationCompat.Builder(this,  "id").
                        setSmallIcon(R.drawable.navigation_empty_icon).
                        setContentTitle("Tarefas").setContentText("Texto de tarefas").
                        setContentIntent(pendingIntent).setAutoCancel(false).build();
                var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                manager.notify(0, notification)

            }

        }


    }

    fun exibeCxDialogo(){

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle(applicationContext.getString(R.string.dialog_title))
        builder.setMessage(applicationContext.getString(R.string.dialog_msg))

        builder.setPositiveButton("OK"){dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext,applicationContext.getString(R.string.dialog_msg),Toast.LENGTH_SHORT).show()


        }

        val dialog: AlertDialog = builder.create()

        dialog.show();

    }
}
