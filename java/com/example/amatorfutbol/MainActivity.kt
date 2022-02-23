package com.example.amatorfutbol

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.amatorfutbol.databinding.ActivityMainBinding
import com.example.amatorfutbol.objects.AppObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


         var spinAdapter = ArrayAdapter.createFromResource(this,R.array.list_group,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
         binding.spinnerList.adapter = spinAdapter

        binding.spinnerList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               // Toast.makeText(this@MainActivity,"Secilen:" + p2, Toast.LENGTH_SHORT).show()
                when(p2){
                    0 ->{
                        AppObject.url= "http://www.amatorfutbol.org/askf/trabzon/1-amator-playoff/puandurumu-7556.html"
                       // Toast.makeText(applicationContext, ""+AppObject.url, Toast.LENGTH_SHORT).show()
                    }
                    1 ->{
                        AppObject.url= "http://www.amatorfutbol.org/askf/trabzon/1-amator/puandurumu-7055.html"
                    }
                    2->{
                       AppObject.url ="http://www.amatorfutbol.org/askf/trabzon/1-amator/puandurumu-7056.html"
                    }
                    3->{
                        AppObject.url ="http://www.amatorfutbol.org/askf/trabzon/1-amator/puandurumu-7057.html"
                    }
                    4->{
                        AppObject.url ="http://www.amatorfutbol.org/askf/trabzon/2-amator/puandurumu-7059.html"
                    }
                    5->{
                        AppObject.url ="http://www.amatorfutbol.org/askf/trabzon/2-amator/puandurumu-7060.html"
                    }
                    else ->
                        Toast.makeText(applicationContext, "Bu alan boş", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.btnList.setOnClickListener {
            val fragment = ListFragment()
            changeFragment(fragment)
        }
    }

    fun changeFragment(fragment: Fragment){
        val tra = supportFragmentManager.beginTransaction()
        tra.replace(binding.frame.id,fragment)
        tra.commit()
    }
}