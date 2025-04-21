package org.geeksforgeeks.demo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.Random


class MainActivity : AppCompatActivity() {
    // initialize views
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var listView: ListView
    // define a list to display in the listview
    private var arrayList: ArrayList<String> = ArrayList(
        mutableListOf(
            "C-Language", "Java", "Data Structure",
            "Networking", "Operating System", "Compiler Design", "Theory Of Computation",
            "Software Engineering", "Web Engineering"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting the reference of SwipeRefreshLayout and ListView
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        listView = findViewById(R.id.listView)

        // simple_list_item_1 is a built in layout. It is part of Android OS, instead of creating our own
        // xml layout we are using built-in layout
        val arrayAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, arrayList as List<Any?>)
        listView.adapter = arrayAdapter

        // Implementing setOnRefreshListener on SwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            // User defined method to shuffle the array list items
            shuffleListItems()
        }
    }

    private fun shuffleListItems() {
        // Shuffling the arraylist items on the basis of system time
        arrayList.shuffle(Random(System.currentTimeMillis()))
        val arrayAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, arrayList as List<Any?>)
        listView.adapter = arrayAdapter
    }
}