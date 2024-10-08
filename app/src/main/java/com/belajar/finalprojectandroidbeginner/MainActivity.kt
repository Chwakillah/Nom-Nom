package com.belajar.finalprojectandroidbeginner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFoods: RecyclerView
    private val list = ArrayList<FoodItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_food)
        rvFoods.setHasFixedSize(true)

        list.addAll(getListFoods())
        showRecyclerList()

        val aboutMe = findViewById<ImageView>(R.id.about_page)
        aboutMe.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListFoods(): ArrayList<FoodItem> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_desc)
        val dataReview = resources.getStringArray(R.array.data_review)
        val dataRating = resources.obtainTypedArray(R.array.data_rating)
        val dataPhoto = resources.obtainTypedArray(R.array.data_img)

        val listFood = ArrayList<FoodItem>()
        for (i in dataName.indices) {
            val food = FoodItem(dataName[i], dataDescription[i], dataReview[i], dataRating.getFloat(i, 0f),dataPhoto.getResourceId(i, -1))
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = MainAdapter(list)
        rvFoods.adapter = listFoodAdapter
    }
}
