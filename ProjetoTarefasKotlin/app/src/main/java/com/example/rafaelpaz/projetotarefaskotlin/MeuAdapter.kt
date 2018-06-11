package com.example.rafaelpaz.projetotarefaskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MeuAdapter(context: Context,  private val lista: List<Tarefa>): BaseAdapter() {


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

        vh.label.text = lista[position].descricao
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
    public val label: TextView

    init {
        this.label = row?.findViewById(R.id.txtDescricao) as TextView
    }
}