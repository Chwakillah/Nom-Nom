package com.belajar.finalprojectandroidbeginner

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val listFood: List<FoodItem>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = listFood[position]
        holder.textTitle.text = food.title
        holder.textDesc.text = food.description
        holder.imagePic.setImageResource(food.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("EXTRA_IMAGE", food.image)
                putExtra("EXTRA_TITLE", food.title)
                putExtra("EXTRA_DESC", food.description)
                putExtra("EXTRA_RATING", food.rating)
                putExtra("EXTRA_REVIEW", food.review)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle = view.findViewById<TextView>(R.id.tv_foodTitle)
        val textDesc = view.findViewById<TextView>(R.id.tv_foodDesc)
        val imagePic = view.findViewById<ImageView>(R.id.iv_foodPic)
    }
}
