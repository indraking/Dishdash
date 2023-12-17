package com.example.dishdash.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dishdash.R
import com.example.dishdash.adapter.FoodAdapter
import com.example.dishdash.data.response.FoodResponse
import com.example.dishdash.databinding.ActivityMoreFoodBinding

class MoreFoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoreFoodBinding

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var foodList : ArrayList<FoodResponse>

    lateinit var photoUrl : Array<Int>
    lateinit var name : Array<String>
    lateinit var calori : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupAction()
    }

    private fun setupAction(){
        photoUrl = arrayOf(
            R.drawable.icon_app,
            R.drawable.welcome_image,
            R.drawable.icon_app,
            R.drawable.welcome_image,
            R.drawable.icon_app,
            R.drawable.welcome_image,
            R.drawable.img
        )
        name = arrayOf(
            "Namso",
            "Campa",
            "Namso",
            "Campa",
            "Namso",
            "Campa",
            "Miso"
        )
        calori = arrayOf(
            "Kalori : 133",
            "Kalori : 232",
            "Kalori : 133",
            "Kalori : 232",
            "Kalori : 133",
            "Kalori : 232",
            "Kalori : 234"
        )

        newRecyclerView = binding.rvMoreFood
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        foodList = arrayListOf()
        getFoodData()

        binding.btnArrowBack.setOnClickListener {
            finish()
        }
    }
    private fun getFoodData() {
        for (i in photoUrl.indices){
            val food = FoodResponse(photoUrl[i],name[i],calori[i])
            foodList.add(food)
        }
        var adapter = FoodAdapter(foodList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object  : FoodAdapter.onItemClickListener{
            override fun onItemClick(position :Int){

            }
        })
    }
}