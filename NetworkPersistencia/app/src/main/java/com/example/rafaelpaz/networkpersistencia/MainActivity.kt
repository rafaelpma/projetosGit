package com.example.rafaelpaz.networkpersistencia

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback


import java.net.URL

class MainActivity : AppCompatActivity(), View.OnClickListener {

    fun existeConexao() : Boolean{
        var  connectivit = this.getSystemService(android.content.Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var  conexoes = connectivit.allNetworks
        for (c in conexoes){
            val info = connectivit.getNetworkInfo(c)
            if (info.state == NetworkInfo.State.CONNECTED){
                return true;
            }

        }
//        if (connectivit.activeNetworkInfo != null &&
//                connectivit.activeNetworkInfo.isAvailable && connectivit.activeNetworkInfo.isConnected){
//            return true;
//        }
        return false;
    }

// a mesma coisa da função existeConexao(), mas feita de forma diferente
    fun existeConexao2() : Boolean{
        var  connectivit = this.getSystemService(android.content.Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var  conexoes = connectivit.allNetworks
        return conexoes.map { connectivit.getNetworkInfo(it) }
                .any { it.state == NetworkInfo.State.CONNECTED }


    }

    override fun onClick(p0: View?) {
        if (existeConexao()){
            when(p0!!.id){
                R.id.button->{
                    Thread{
                        var img = downloadUrl1("https://www.yamaha-motor.com.br/upload/produto/285/23584451_10211788403479363_468042674_n.jpg")

                        runOnUiThread {
                            imagem.setImageBitmap(img)
                        }
                   }.start()


                    testRetrofit()
                }
                R.id.button2->{

                    val handler = Handler()
                    Thread{
                        var img = downloadUrl1("http://n.i.uol.com.br/licaodecasa/biografias/dercy.jpg")

                        handler.post {
                            imagem.setImageBitmap(img)
                        }
                    }.start()


                    testeVolley()
                }
            }
        } else {
            Toast.makeText(this, "Sem conexão!!!", Toast.LENGTH_SHORT ).show()
        }


    }

    fun testeVolley(){

        val queue = Volley.newRequestQueue(this)

        val getRequest = object : StringRequest(Request.Method.GET, "https://swapi.co/api/people/1",
                Response.Listener<String>{ response ->  textView.text = "Response is: ${response.substring(0, 500)}"
        }, Response.ErrorListener { textView.text = "Erro ao baixar imagens!!!" }){
            override fun getParams(): MutableMap<String, String> {
                return super.getParams()
            }

        }

        queue.add(getRequest)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun downloadUrl1(url: String): Bitmap {

        URL(url).openStream().use {
            return BitmapFactory.decodeStream(it)
        }
    }

    fun testRetrofit() {


        val call =  Api.testService().response()

        call.enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>?, response: retrofit2.Response<Root>?) {

                val root =  response!!.body() as Root
                textView.text = "Retrofit = "+root.name
            }


            override  fun onFailure(call: Call<Root>, t: Throwable) {
                //Do something with failure
            }
        })
       /* runOnUiThread{
            var resposta = Api.testService().response().execute().body()
            textView.text = "Retrofit = "+resposta
        }*/

    }



}
