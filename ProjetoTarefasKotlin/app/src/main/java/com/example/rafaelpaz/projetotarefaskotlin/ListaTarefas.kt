package com.example.rafaelpaz.projetotarefaskotlin

import android.app.Fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ListaTarefas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tarefas)


        val fragment = FragmentLista()
        fragment.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout, fragment as Fragment)
        transaction.commit()


    }
}