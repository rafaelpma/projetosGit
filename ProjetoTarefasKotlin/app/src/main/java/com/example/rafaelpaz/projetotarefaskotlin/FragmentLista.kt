package com.example.rafaelpaz.projetotarefaskotlin


import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
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
class FragmentLista : Fragment(){//, OnClickListener {


    private var itensListV: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_fragment_lista, container, false)

        val itens = ArrayList<Tarefa>()
        itens.addAll(RepositorioTarefas.tarefas);




        //Cria o adapter
        val adapter = MeuAdapter(activity as Context, itens)

        itensListV = root.findViewById(R.id.lvTarefas)
        //Seta o adapter criado acima no listView
        itensListV!!.adapter = adapter

        

        return root
    }

}
