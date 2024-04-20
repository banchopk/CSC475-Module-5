package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")
        val imageResId = intent.getIntExtra("imageResId", R.drawable.panthers)

        val detailTextView = findViewById<TextView>(R.id.detailTextView)
        val detailImageView = findViewById<ImageView>(R.id.detailImageView)

        detailTextView.text = name
        detailImageView.setImageResource(imageResId)
    }
}
