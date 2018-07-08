package com.example.rafaelpaz.bebeaguamizera

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import java.util.*

class ConfigActivity : AppCompatActivity(), View.OnClickListener {

    private var editTextPeso: EditText? = null
    private var editTextQtdDiaria: EditText? = null



    private var QTD_POR_KILO = 35;


    private var radioButton1Min : RadioButton? = null
    private var radioButton10Min : RadioButton? = null
    private var radioButton1Hora : RadioButton? = null
    private var radioButton2Horas : RadioButton? = null

    private var UM_MINUTO :Long = 60000
    //private var DEZ_MINUTOS :Long = 600000
    private var DEZ_MINUTOS :Long = 180000// setando 3 minutos para teste
    private var UMA_HORA :Long = 3600000
    private var DUAS_HORAS :Long = 7200000


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnCalcular ->{
                if (!editTextPeso!!.text.toString().isEmpty()){
                    var peso : Int = editTextPeso!!.text.toString().toInt()
                    var qtdCalculada : Int = calcularPeloPeso(peso)

                    editTextQtdDiaria!!.text.clear()
                    editTextQtdDiaria!!.text.append(qtdCalculada.toString())
                }
            }
            R.id.btnSalvar ->{
                var peso : Int = 0;
                var qtdCalculada : Int = 0;
                if (!editTextPeso!!.text.toString().isEmpty()){
                    peso = editTextPeso!!.text.toString().toInt()
                }
                if (!editTextQtdDiaria!!.text.toString().isEmpty()){
                    qtdCalculada = editTextQtdDiaria!!.text.toString().toInt()
                }


                var configuracao : Configuracao = Configuracao.create()

                configuracao.peso = peso
                configuracao.intervaloAlerta = retornarIntervaloEmSegundos()
                configuracao.quantidadeDiaria = qtdCalculada;


                configuracao.salvarDados(this)

                AlarmeUtil.ativarAlarme(this, configuracao.intervaloAlerta)

                var intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            R.id.btnCancelar ->{
                var intent = Intent()
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            }
        }
    }

    fun calcularPeloPeso(peso: Int) : Int {
        return QTD_POR_KILO * peso;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        editTextPeso = findViewById(R.id.editTextPeso)
        editTextQtdDiaria = findViewById(R.id.editTextQtdDiaria)

        radioButton1Min = findViewById(R.id.radioButton1Min)
        radioButton10Min = findViewById(R.id.radioButton10Min)
        radioButton1Hora = findViewById(R.id.radioButton1Hora)
        radioButton2Horas = findViewById(R.id.radioButton2Hora)


        carregarDadosTela()
    }

    fun carregarDadosTela(){
        var configuracao = Configuracao()
        configuracao.carregarDados(this)

        var intervalo = configuracao.intervaloAlerta
        when(intervalo){
            UM_MINUTO -> radioButton1Min!!.setChecked(true)
            DEZ_MINUTOS -> radioButton10Min!!.setChecked(true)
            UMA_HORA -> radioButton1Hora!!.setChecked(true)
            DUAS_HORAS -> radioButton2Horas!!.setChecked(true)
            else -> radioButton1Min!!.setChecked(true)
        }
        if (configuracao.peso != 0){
            editTextPeso!!.text.append(""+configuracao.peso)
        }
        if (configuracao.quantidadeDiaria != 0){
            editTextQtdDiaria!!.text.append(""+configuracao.quantidadeDiaria)
        }
        editTextQtdDiaria = findViewById(R.id.editTextQtdDiaria)
    }


    fun retornarIntervaloEmSegundos() :Long {
        var tempo :Long  = 0
        if (radioButton1Min!!.isChecked){
            tempo = UM_MINUTO;
        }
        if (radioButton10Min!!.isChecked){
            tempo = DEZ_MINUTOS;
        }
        if (radioButton1Hora!!.isChecked){
            tempo = UMA_HORA;
        }
        if (radioButton2Horas!!.isChecked){
            tempo = DUAS_HORAS;
        }
        return tempo;
    }

}
