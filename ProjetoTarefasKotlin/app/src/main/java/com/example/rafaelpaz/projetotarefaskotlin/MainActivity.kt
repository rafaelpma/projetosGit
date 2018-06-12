package com.example.rafaelpaz.projetotarefaskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.rafaelpaz.projetotarefaskotlin.R.layout.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btn: Button? = null
    private var textNome: TextInputLayout? = null
    private var textDescricao: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        btn = findViewById(R.id.button);

        textNome = findViewById(R.id.nomeTarefa);
        textDescricao = findViewById(R.id.editText);
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button -> {
                var itent = Intent(this, ListaTarefas::class.java)
                startActivity(itent)
            }
            R.id.button2 -> {
                var strNome = textNome!!.editText!!.text.toString() ;
                var strDescricao = textDescricao!!.text.toString() ;

                var tarefa = Tarefa(strNome, strDescricao)
                RepositorioTarefas.tarefas.add(tarefa)

            }
        }


    }
}
