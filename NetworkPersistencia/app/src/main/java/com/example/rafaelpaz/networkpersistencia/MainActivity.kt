package com.example.rafaelpaz.networkpersistencia

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

import java.net.URL

class MainActivity : AppCompatActivity(), View.OnClickListener {




    override fun onClick(p0: View?) {
        Thread{
            var img = downloadUrl1("https://www.yamaha-motor.com.br/upload/produto/285/23584451_10211788403479363_468042674_n.jpg")

            runOnUiThread {
                imagem.setImageBitmap(img)
            }


        }.start()

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
}
