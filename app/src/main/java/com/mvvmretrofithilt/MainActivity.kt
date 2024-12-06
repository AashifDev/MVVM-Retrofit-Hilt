package com.mvvmretrofithilt

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.mvvmretrofithilt.adapter.ProductAdapter
import com.mvvmretrofithilt.model.ProductResponseItem
import com.mvvmretrofithilt.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var adapter: ProductAdapter

    lateinit var recyclerView: RecyclerView
    val viewModel: ProductViewModel by viewModels()

    @Inject
    lateinit var productResponseItem: ProductResponseItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.rv)


        setDataToRecyclerView()
    }

    private fun setDataToRecyclerView() {
        viewModel.productLiveData.observe(this){
            if (it.isNotEmpty()){
                adapter.differ.submitList(it)
                recyclerView.adapter = adapter
            }
        }
    }
}