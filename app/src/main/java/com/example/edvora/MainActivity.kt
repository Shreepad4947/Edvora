package com.example.edvora


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.edvora.databinding.ActivityMainBinding
import com.example.edvora.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {



        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout =  binding.tabs
        tabs.setupWithViewPager(viewPager)

        val spinner: Spinner = findViewById(R.id.planets_spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.states,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
run("https://assessment.api.vweb.app/rides");
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.recycle_ctivity)
//
//        // data to populate the RecyclerView with
//
//
    }
    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }


}