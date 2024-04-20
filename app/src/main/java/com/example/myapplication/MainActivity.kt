package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val users = arrayOf(
        Pair("Carolina Panthers", R.drawable.panthers),
        Pair("Tampa Bay Bucanners", R.drawable.tampa),
        Pair("New Orleans Saints", R.drawable.saints),
        Pair("Atlanta Falcons", R.drawable.falcon)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListView()
    }

    private fun setupListView() {
        val listView = findViewById<ListView>(R.id.userlist)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users.map { it.first })
        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            if (position in users.indices) {
                val selectedItem = users[position]
                navigateToDetailActivity(selectedItem)
            }
        }
    }

    private fun navigateToDetailActivity(selectedItem: Pair<String, Int>) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("name", selectedItem.first)
        intent.putExtra("imageResId", selectedItem.second)
        startActivity(intent)
    }
}
