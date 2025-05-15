package com.example.rafaelpaz.persistenciadados

import android.arch.persistence.room.Room
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.Toast
import com.example.rafaelpaz.persistenciadados.database.AppDatabase
import com.example.rafaelpaz.persistenciadados.database.dao.PersonagemDao
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var personagemDao : PersonagemDao

    fun existeConexao() : Boolean{
        var  connectivit = this.getSystemService(
                android.content.Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        var  conexoes = connectivit.allNetworks
        return conexoes.map { connectivit.getNetworkInfo(it) }
                .any { it.state == NetworkInfo.State.CONNECTED }
    }

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
                if (existeConexao()){

                    consultaServidorPersonagem()


                } else {
                    Toast.makeText(this,"Problema com a conexão internet! ", Toast.LENGTH_LONG).show()
                }

            }
            R.id.button2 -> {


                var personagem = Personagem(0,
                        editNome!!.text.toString(),
                        editAltura!!.text.toString(),
                        editPeso!!.text.toString(),
                        editCorCabelo!!.text.toString(),
                        editAnoNascimento!!.text.toString())

                personagemDao.add(personagem);

                Toast.makeText(this,"Personagem salvo na base de dados! ", Toast.LENGTH_LONG).show()

            }
            R.id.button3 -> {
                for (c in personagemDao.all()){

                }
                var itent = Intent(this, DetalheActivity::class.java)
                startActivityForResult(itent, 1)

            }
        }

    }

    fun consultaServidorPersonagem(){
        textView.text = "Aguarde..."

        val call =  Api.testService().response()

        call.enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>?, response: retrofit2.Response<Root>?) {

                val root =  response!!.body() as Root
                editNome.text.clear()
                editAltura.text.clear()
                editPeso.text.clear()
                editCorCabelo.text.clear()
                editAnoNascimento.text.clear()

                editNome.text.append(root.name)
                editAltura.text.append(root.height)
                editPeso.text.append(root.mass)
                editCorCabelo.text.append(root.hair_color)
                editAnoNascimento.text.append(root.birth_year)

                textView.text = "";

            }


            override  fun onFailure(call: Call<Root>, t: Throwable) {
                //Do something with failure
            }
        })


    }

}
