package com.example.imagesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bersyte.retrofitdaggerhilt.model.ImageItem
import com.example.imagesapp.adapter.ImageAdapter
import com.example.imagesapp.databinding.ActivityMainBinding
import com.example.imagesapp.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter : ImageAdapter
    private val viewModel:ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        imageAdapter = ImageAdapter()
        binding.recyclerView.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
        viewModel.responseImages.observe(this, { response : List<ImageItem>->
            if (response != null) {
                imageAdapter.submitList(response)
            }
        })
    }
}