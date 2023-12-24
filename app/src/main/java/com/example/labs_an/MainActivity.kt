package com.example.labs_an

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs_an.adapter.DialogEditUserNameFragment
import com.example.labs_an.adapter.RecyclerViewAdapter
import com.example.labs_an.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0
    private var selectedProductsList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
        binding.btnCreateNew.setOnClickListener {
            startDialogEditUserName()
        }
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter { printer, cost ->
            startSecondActivity(printer, cost)
        }

        with(binding.rvProducts) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
        recyclerViewAdapter.submitList(createList())
    }

    private fun createList(): List<ProductData> {
        return listOf(
            ProductData("Samsung UE43CU7100UXUA", 200, 4),
            ProductData("Телевізор iFFALCON iFF43U62", 1000, 4),
            ProductData("Телевізор Nokia Smart TV QLED 5500D", 199, 4),
            ProductData("Телевізор Xiaomi TV A2 55 (959127)", 10000, 4),
        )
    }

    private fun startSecondActivity(printerName: String, cost: Int) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("printer", printerName)
            putExtra("cost", cost)
        }
        startActivity(intent)
    }

    private fun startDialogEditUserName() {
        val fragment = DialogEditUserNameFragment.newInstance()

        fragment.onCreateNewPrinterListener =
            object : DialogEditUserNameFragment.OnCreateNewPrinterListener {
                override fun onCreateNewPrinterListener(printerName: String, cost: Int) {
                    val newList = mutableListOf<ProductData>()
                    for (i in recyclerViewAdapter.currentList) {
                        newList.add(i)
                    }
                    newList.add(ProductData(printerName, cost, 4))
                    recyclerViewAdapter.submitList(newList)
                }
            }
        fragment.show(this.supportFragmentManager, "DialogEditUserNameFragment")
    }
}