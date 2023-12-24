package com.example.labs_an

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs_an.adapters.DialogEditUserNameFragment
import com.example.labs_an.adapters.RecyclerViewAdapter
import com.example.labs_an.databinding.ActivityMainBinding
import java.time.LocalDate

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
            ProductData("Телевізор Samsung UE43CU7100UXUA", 1999, 4, "2023.01.01"),
            ProductData("Телевізор 55 дюймів Sony XR-55A80L", 2999, 4, "2023.01.04"),
            ProductData("Телевізор Sony XR-55A90K", 5000, 4, "2023.01.02"),
            ProductData("Телевізор Sony XR-55A90J EU", 999, 4, "2023.01.06"),
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
                    newList.add(ProductData(printerName, cost, 4, LocalDate.now().toString()))
                    recyclerViewAdapter.submitList(newList)
                }
            }
        fragment.show(this.supportFragmentManager, "DialogEditUserNameFragment")
    }
}