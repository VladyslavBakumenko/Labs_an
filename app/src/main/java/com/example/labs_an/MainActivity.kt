package com.example.labs_an

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs_an.adapter.RecyclerViewAdapter
import com.example.labs_an.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0
    private var selectedPlacesList = mutableListOf<String>()
    private var selectedList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
        binding.startOtherActivity.setOnClickListener {
            startSecondActivity()
        }
        binding.tvPlaces.text = "Ціна купівлі application = $totalCost"
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter(minusListener = {
            totalCost -= it.cost
            selectedList.remove(it.product)
            binding.tvPlaces.text = "Ціна купівлі application = $totalCost"
        }, plusListener = {
            totalCost += it.cost
            selectedList.add(it.product)
            binding.tvPlaces.text = "Ціна купівлі application = $totalCost"
        })

        with(binding.rvProducts) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
        recyclerViewAdapter.submitList(createList())
    }

    private fun createList(): List<ProductData> {
        return listOf(
            ProductData("TikTok", 100000, 4, R.drawable.download),
            ProductData("Instagram", 200000, 4, R.drawable.inst),
            ProductData("Facebook", 15000, 4, R.drawable.fb),
            ProductData("Whats App", 400000, 4, R.drawable.app),
            ProductData("Google", 100000000, 4, R.drawable.gg),
            ProductData("YouTube", 5000000, 4, R.drawable.u),
            ProductData("Google maps", 20000, 4, R.drawable.b),
            ProductData("Snapchat", 10000, 4, R.drawable.s),
            ProductData("Discord", 200000, 4, R.drawable.n),
            ProductData("Spotify", 60000, 4, R.drawable.ss),
        )
    }

    private fun startSecondActivity() {

        val cleanedString = selectedList.toString().trim('[', ']', ' ')
        val formattedList = cleanedString.split(", ")
        val resultString = StringBuilder()
        formattedList.forEach {
            resultString.append(it)
            resultString.append(",")
        }
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("test", formattedList.toString())
        }
        startActivity(intent)
    }
}