package com.example.entrega4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.entrega4.CountryStuff.CountryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CountryViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        val adapterCountry = AdapterCountryPaging()
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        rv.adapter = adapterCountry

        GlobalScope.launch(Dispatchers.IO){
            viewModel.pagingSource().collect(){
                adapterCountry.submitData(it)
            }
        }
    }
}
