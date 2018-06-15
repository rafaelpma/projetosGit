package com.example.rafaelpaz.projetotarefaskotlin

import android.app.Activity
import android.app.Fragment
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class ListaTarefas : AppCompatActivity(), OnClickListener{
    var btnVoltar: Button? = null

    val DETALHE: String = "DETALHE"
    override fun onClick(v: View?) {
        if (v!!.id == R.id.voltar){
            var intent = Intent()
            // Estou passando esta informação só para verificar o fincionamento do retorno...
            intent.putExtra(DETALHE, "Usuário Clicou no Botão Voltar")

            setResult(Activity.RESULT_OK, intent)
            finish()

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tarefas)
        btnVoltar = findViewById(R.id.voltar)
        btnVoltar!!.setOnClickListener(this)

        val fragment = FragmentLista()
        fragment.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout, fragment as Fragment)
        transaction.commit()


    }
}