package com.example.dishdash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dishdash.R
import com.example.dishdash.data.response.FoodResponse
import com.google.android.material.imageview.ShapeableImageView

class FoodAdapter(private val foodList: ArrayList<FoodResponse>) :
    RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_food_like, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: FoodAdapter.MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.photoUrl.setImageResource(currentItem.photoUrl)
        holder.name.text = currentItem.name
        holder.calori.text = currentItem.calori
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val photoUrl: ImageView = itemView.findViewById(R.id.iv_food)
        val name: TextView = itemView.findViewById(R.id.tv_name_food)
        val calori: TextView = itemView.findViewById(R.id.tv_calori)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}
