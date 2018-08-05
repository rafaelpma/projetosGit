package com.example.rafaelpaz.persistenciadados

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import com.example.rafaelpaz.persistenciadados.database.AppDatabase
import com.example.rafaelpaz.persistenciadados.database.dao.PersonagemDao

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var personagemDao : PersonagemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
         "persistencia-dados").allowMainThreadQueries()
                .build();

        personagemDao = database.personagemDao();
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.button -> {
                personagemDao.add(Personagem(0,"Rafael Paz", "Terra"))
            }
            R.id.button2 -> {
                var lista = personagemDao.all();
                var texto : String = ""
                for ( p in lista){
                    texto = texto +p.id+" - "+p.nome;
                }
                textView.text = texto;

            }
        }

    }



}
