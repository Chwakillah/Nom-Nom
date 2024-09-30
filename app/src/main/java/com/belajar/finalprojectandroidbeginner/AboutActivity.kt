package com.belajar.finalprojectandroidbeginner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val ivBtnBack = findViewById<ImageView>(R.id.iv_btnBack)
        ivBtnBack.setOnClickListener{
            finish()
        }
    }
}