package com.example.duck

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.load
import com.example.duck.repo.Repository
import com.example.duck.viewmodel.DuckViewModel
import com.example.duck.viewmodel.DuckViewModelFactory
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo = Repository()
        val viewmodelFactory = DuckViewModelFactory(repo)
        val duckViewModel = ViewModelProvider(this,viewmodelFactory).get(DuckViewModel::class.java)

        val image = findViewById<ShapeableImageView>(R.id.image_view)
        val getButton = findViewById<Button>(R.id.btn_get)

        duckViewModel.getDuck()

        getButton.setOnClickListener {
            duckViewModel.getDuck()
        }

        duckViewModel.myResponse.observe(this, Observer {response->
            image.load(response.url)
        })


    }
}