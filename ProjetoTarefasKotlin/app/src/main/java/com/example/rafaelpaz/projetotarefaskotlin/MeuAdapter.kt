package com.example.rafaelpaz.projetotarefaskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView

class MeuAdapter(context: Context,  private var lista: List<Tarefa>): BaseAdapter() {


    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(context)

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ListRowHolder

        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.linha_tarefa, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.labelTitulo.text = lista[position].titulo
        vh.labelDescricao.text = lista[position].descricao

        vh.botaoExluir.setOnClickListener {
            lista = lista.minus(lista[position])
            this.notifyDataSetChanged()
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return lista.size
    }



}

private class ListRowHolder(row: View?) {
    public val labelDescricao: TextView
    public val labelTitulo: TextView
    public val botaoExluir: ImageButton

    init {
        this.labelTitulo = row?.findViewById(R.id.txtTitulo) as TextView
        this.labelDescricao = row?.findViewById(R.id.txtDescricao) as TextView
        this.botaoExluir = row?.findViewById(R.id.imageButton2) as ImageButton


    }

}