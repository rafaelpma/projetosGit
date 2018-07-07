package com.example.rafaelpaz.bebeaguamizera

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class Configuracao {
    private var CHAVE_INTERVALO = "INTERVALO";
    private var CHAVE_QUANTIDADE_COSUMIDA = "QUANTIDADE_CONSUMIDA";
    private var CHAVE_QUANTIDADE_DIARIA = "QUANTIDADE_DIARIA";
    private var CHAVE_PESO = "PESO";
    private var CHAVE_HISTORICO = "HISTORICO";


    var intervaloAlerta: Int = 0;
    var quantidadeConsumida: Int = 0;
    var peso : Int = 0; // analisar necessidade desse atributo
    var quantidadeDiaria: Int = 0;
    var historico: String = "";


    fun salvarDados(context: Context ){
        var pref : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        var editor = pref.edit()
        editor.putInt(CHAVE_INTERVALO, intervaloAlerta)
        editor.putInt(CHAVE_QUANTIDADE_COSUMIDA, quantidadeConsumida)
        editor.putInt(CHAVE_PESO, peso)
        editor.putInt(CHAVE_QUANTIDADE_DIARIA, quantidadeDiaria)
        editor.putString(CHAVE_HISTORICO, historico)
        editor.commit()
    }

    fun carregarDados(context: Context ){
        var pref : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        var editor = pref.edit()

        intervaloAlerta = pref.getInt(CHAVE_INTERVALO, 0 )
        quantidadeConsumida = pref.getInt(CHAVE_QUANTIDADE_COSUMIDA, 0 )
        peso = pref.getInt(CHAVE_PESO, 0)
        quantidadeDiaria = pref.getInt(CHAVE_QUANTIDADE_DIARIA, 0)
        historico = pref.getString(CHAVE_HISTORICO, "")

    }

    companion object {


    }
}