package com.example.rafaelpaz.bebeaguamizera

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnClickListener {
    private var radioButton100ml : RadioButton? = null
    private var radioButton150ml : RadioButton? = null
    private var radioButton200ml : RadioButton? = null
    private var radioButton300ml : RadioButton? = null
    private var radioButton500ml : RadioButton? = null
    private var radioButton600ml : RadioButton? = null

    private var QTD_100ml : Int =  100;
    private var QTD_150ml : Int =  150;
    private var QTD_200ml : Int =  200;
    private var QTD_300ml : Int =  300;
    private var QTD_500ml : Int =  500;
    private var QTD_600ml : Int =  600;


    private var CONFIGURACAO = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        radioButton100ml = findViewById(R.id.radioButton100ml)
        radioButton150ml = findViewById(R.id.radioButton150ml)
        radioButton200ml = findViewById(R.id.radioButton200ml)
        radioButton300ml = findViewById(R.id.radioButton300ml)
        radioButton500ml = findViewById(R.id.radioButton500ml)
        radioButton600ml = findViewById(R.id.radioButton600ml)



    }


    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btnConfig ->{
                var intent = Intent(this, ConfigActivity::class.java)
                startActivityForResult(intent, CONFIGURACAO)
            }
            R.id.btnRegConsumo ->{
                registraConsumoAgua()



            }
        }
    }

    fun registraConsumoAgua(){
        var qtd :  Int = retornaQtdSelecionada()

    }

    private fun retornaQtdSelecionada() : Int{
        var retorno = 0
        if (radioButton100ml!!.isChecked) {
            retorno = QTD_100ml
        }
        if (radioButton150ml!!.isChecked) {
            retorno = QTD_150ml
        }
        if (radioButton200ml!!.isChecked) {
            retorno = QTD_200ml
        }
        if (radioButton300ml!!.isChecked) {
            retorno = QTD_300ml
        }
        if (radioButton500ml!!.isChecked) {
            retorno = QTD_500ml
        }
        if (radioButton600ml!!.isChecked) {
            retorno = QTD_600ml
        }

        return retorno;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            Toast.makeText(this, "Configuração Atualizada!", Toast.LENGTH_SHORT).show()
        }
    }



}
