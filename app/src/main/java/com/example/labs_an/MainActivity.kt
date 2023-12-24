package com.example.labs_an

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs_an.adapter.RecyclerViewAdapter
import com.example.labs_an.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0
    private var selectedPlacesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
        binding.startOtherActivity.setOnClickListener {
            startSecondActivity()
        }
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter { state, placeName ->
            if (state) addToList(placeName)
            else removeFromList(placeName)
            val string = selectedPlacesList.toString()
            binding.tvPlaces.text = string
        }

        with(binding.rvProducts) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
        recyclerViewAdapter.submitList(createList())
    }

    private fun createList(): List<ProductData> {
        return listOf(
            ProductData("TikTok", 30, 4, R.drawable.download),
            ProductData("Instagram", 20, 4, R.drawable.inst),
            ProductData("Facebook", 1, 4, R.drawable.fb),
            ProductData("Whats App", 40, 4, R.drawable.app),
            ProductData("Google", 40, 4, R.drawable.gg),
            ProductData("YouTube", 40, 4, R.drawable.u),
            ProductData("Google maps", 40, 4, R.drawable.b),
            ProductData("Snapchat", 40, 4, R.drawable.s),
            ProductData("Discord", 40, 4, R.drawable.n),
            ProductData("Spotify", 40, 4, R.drawable.ss),
        )
    }

    private fun addToList(placeName: String) {
        selectedPlacesList.add(placeName)
    }

    private fun removeFromList(placeName: String) {
        selectedPlacesList.remove(placeName)
    }

    private fun startSecondActivity() {
        if (selectedPlacesList.isNotEmpty()) {
            val id = when (selectedPlacesList.first()) {
                "TikTok" -> R.drawable.download
                "Instagram" -> R.drawable.inst
                "Facebook" -> R.drawable.fb
                "Whats App" -> R.drawable.app
                "Google" -> R.drawable.gg
                "YouTube" -> R.drawable.u
                "Google maps" -> R.drawable.b
                "Snapchat" -> R.drawable.s
                "Discord" -> R.drawable.n
                "Spotify" -> R.drawable.ss
                else -> 4
            }
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("test", id)
            }
            startActivity(intent)
        }
    }
}