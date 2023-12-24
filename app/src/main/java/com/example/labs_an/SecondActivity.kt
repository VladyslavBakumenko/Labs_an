package com.example.labs_an

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.labs_an.adapter.RecyclerViewAdapter
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
        binding.image.text = intent.getStringExtra("test")
    }
}