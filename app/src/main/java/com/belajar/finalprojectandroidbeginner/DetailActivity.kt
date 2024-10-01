package com.belajar.finalprojectandroidbeginner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ivImgDetail = findViewById<ImageView>(R.id.iv_foodPic)
        val tvTitleDetail = findViewById<TextView>(R.id.tv_foodTitle)
        val tvRating = findViewById<TextView>(R.id.rating_points)
        val tvReview = findViewById<TextView>(R.id.tv_descriptionReview)
        val tvDescriptionDetail = findViewById<TextView>(R.id.tv_descriptionDetail)

        val foodImage = intent.getIntExtra("EXTRA_IMAGE", 0)
        val foodTitle = intent.getStringExtra("EXTRA_TITLE")
        val foodDescription = intent.getStringExtra("EXTRA_DESC")
        val foodRating = intent.getFloatExtra("EXTRA_RATING", 0f)
        val foodReview = intent.getStringExtra("EXTRA_REVIEW")

        ivImgDetail.setImageResource(foodImage)
        tvTitleDetail.text = foodTitle
        tvDescriptionDetail.text = foodDescription
        tvRating.text = foodRating.toString()
        tvReview.text = foodReview

        val ivBtnBack = findViewById<ImageView>(R.id.iv_btnBack)
        ivBtnBack.setOnClickListener{
            finish()
        }

        val ivShare = findViewById<ImageView>(R.id.action_share)
        ivShare.setOnClickListener {
            shareContent(foodTitle, foodDescription)
        }
    }
    private fun shareContent(title: String?, description: String?) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, "$title\n\n$description")
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}