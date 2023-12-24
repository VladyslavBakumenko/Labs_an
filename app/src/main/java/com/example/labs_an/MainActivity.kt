package com.example.labs_an

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.labs_an.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        startFragments()
    }

    private fun startFragments() {
        supportFragmentManager.beginTransaction().add(R.id.firstFragmentContainerView, SecondFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.secondFragmentContainerView, FirstFragment()).commit()
    }
}