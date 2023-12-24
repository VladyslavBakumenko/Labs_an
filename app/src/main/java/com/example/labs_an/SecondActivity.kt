package com.example.labs_an

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.labs_an.adapters.RecyclerViewAdapter
import com.example.labs_an.databinding.SecondActivityBindingBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBindingBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        parseArgs()
    }

    private fun parseArgs() {
        binding.tvPrinter.text = intent.getStringExtra("printer")
        binding.tvCost.text = (intent.getIntExtra("cost", 0)).toString()
    }
}