package com.example.rafaelpaz.persistenciadados

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.rafaelpaz.persistenciadados.database.AppDatabase
import com.example.rafaelpaz.persistenciadados.database.dao.PersonagemDao
import kotlinx.android.synthetic.main.activity_main.*

class DetalheActivity : AppCompatActivity() {

    private lateinit var personagemDao : PersonagemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        val database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "persistencia-dados").allowMainThreadQueries()
                .build();

        personagemDao = database.personagemDao();

        var texto = ""
        for (p in personagemDao.all()){
            texto = texto+p.id+" - "+p.nome+" - "+p.altura+" - "+p.corDeCabelo+" \n"
        }
        textView.text = texto;
    }
}
