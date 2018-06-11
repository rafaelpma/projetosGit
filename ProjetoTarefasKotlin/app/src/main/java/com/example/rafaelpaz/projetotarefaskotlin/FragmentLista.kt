package com.example.rafaelpaz.projetotarefaskotlin


import android.app.Fragment
import android.content.Context
import android.os.Bundle
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentLista.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FragmentLista.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentLista : Fragment() {
    private var itensListV: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_fragment_lista, container, false)

        val itens = ArrayList<Tarefa>()


        itens.add(Tarefa("Estudo 1", "Descricao linha 1"))
        itens.add(Tarefa("Estudo 2", "Descricao linha 2"))
        itens.add(Tarefa("Estudo 3", "Descricao linha 3"))
        itens.add(Tarefa("Estudo 4", "Descricao linha 4"))
        itens.add(Tarefa("Estudo 5", "Descricao linha 5"))
        itens.add(Tarefa("Estudo 6", "Descricao linha 6"))
        itens.add(Tarefa("Estudo 7", "Descricao linha 7"))

        //Cria o adapter
        val adapter = MeuAdapter(activity as Context, itens)

        itensListV = root.findViewById(R.id.lvTarefas)
        //Seta o adapter criado acima no listView
        itensListV!!.adapter = adapter

        return root
    }

}
