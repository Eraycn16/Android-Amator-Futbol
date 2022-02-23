package com.example.amatorfutbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amatorfutbol.adapters.TeamAdapter
import com.example.amatorfutbol.databinding.FragmentListBinding
import com.example.amatorfutbol.models.TeamModel
import com.example.amatorfutbol.objects.AppObject
import com.example.amatorfutbol.parser.HtmlParser

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding:FragmentListBinding
    private lateinit var list:ArrayList<TeamModel>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(inflater,container,false)
        binding.reycPuan.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)


        return binding.root
    }

    override fun onStart() {
        super.onStart()

        //binding.deneme.setText(AppObject.url)

        val parse = HtmlParser()
        list = parse.puanTablosu()
        Thread.sleep(1000)
        val adapter = TeamAdapter(list)
        binding.reycPuan.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    companion object {

        @JvmStatic fun newInstance(param1: String, param2: String) =
                ListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}