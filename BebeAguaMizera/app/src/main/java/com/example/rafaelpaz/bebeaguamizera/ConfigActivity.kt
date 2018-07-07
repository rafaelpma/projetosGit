package com.example.rafaelpaz.bebeaguamizera

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class ConfigActivity : AppCompatActivity(), View.OnClickListener {

    private var editTextPeso: EditText? = null
    private var editTextQtdDiaria: EditText? = null

    private var QTD_POR_KILO = 35;

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
                var intent = Intent()

//                intent.putExtra("CONFIG", "")

                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            R.id.btnCancelar ->{
                var intent = Intent()

//                intent.putExtra("CONFIG", "")

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


    }
}
