package com.example.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding
    lateinit var model :MainActivityViewModel
    lateinit var factory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        factory = MainActivityViewModelFactory(200)
        model = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

        //Observing for data change
        model.totalSum.observe(this, Observer {
                binding.resultTxt.text = it.toString() }
        )

        binding.btn.setOnClickListener(){
            model.sumUp(binding.editText.text.toString().toInt())
        }
    }
}