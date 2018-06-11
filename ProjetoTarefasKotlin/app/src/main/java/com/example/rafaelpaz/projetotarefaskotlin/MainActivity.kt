package com.example.rafaelpaz.projetotarefaskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.rafaelpaz.projetotarefaskotlin.R.layout.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        btn = findViewById(R.id.button);
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button -> {
                var itent = Intent(this, ListaTarefas::class.java)
                startActivity(itent)
            }
        }


    }
}
