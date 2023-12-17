package com.example.dishdash.ui

import CustomCircularProgressIndicator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.dishdash.R
import com.example.dishdash.adapter.FoodAdapter
import com.example.dishdash.data.response.FoodResponse
import com.example.dishdash.databinding.FragmentHomeBinding
import com.example.dishdash.ui.Jetpack.CustomRoundedHorizontalProgressIndicator
import com.example.dishdash.ui.Jetpack.navy
import com.example.dishdash.ui.Jetpack.navyLight
import com.example.dishdash.ui.Jetpack.orange
import com.example.dishdash.ui.Jetpack.orangeLight

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var foodList: ArrayList<FoodResponse>

    lateinit var photoUrl : Array<Int>
    lateinit var name : Array<String>
    lateinit var calori : Array<String>


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        val composeViewCarbo : ComposeView = binding.circularComposeCarbo
        val composeViewProtein : ComposeView = binding.circularComposeProtein
        val composeViewFat : ComposeView = binding.circularComposeFat

        val composeViewHorizontal : ComposeView = binding.horizontalPercentage


        binding.textReadMore.setOnClickListener {
            startActivity(Intent(requireContext(), MoreFoodActivity::class.java))
        }


        composeViewCarbo.setContent {
            CustomCircularProgressIndicator(
                modifier = Modifier,
                initialValue = 60,
                primaryColor = navy,
                secondaryColor = navyLight,
                circleRadius = 125f,
                type = "Carbo",
                onPositionChange = {

                }
            )
        }
        composeViewProtein.setContent {
            CustomCircularProgressIndicator(
                modifier = Modifier,
                initialValue = 80,
                primaryColor = navy,
                secondaryColor = navyLight,
                circleRadius = 125f,
                type = "Protein",
                onPositionChange = {

                }
            )
        }
        composeViewFat.setContent {
            CustomCircularProgressIndicator(
                modifier = Modifier,
                initialValue = 78,
                primaryColor = navy,
                secondaryColor = navyLight,
                circleRadius = 125f,
                type = "Fat",
                onPositionChange = {

                }
            )
        }
        composeViewHorizontal.setContent {
            CustomRoundedHorizontalProgressIndicator(
                modifier = Modifier
                    .width(300.dp)
                    .height(20.dp),
                initialValue = 78,
                primaryColor = navy,
                secondaryColor = navyLight,
                onPositionChange = {

                }
            )
        }

        photoUrl = arrayOf(
            R.drawable.icon_app,
            R.drawable.welcome_image,
            R.drawable.img
        )

        name = arrayOf(
            "Namso",
            "Campa",
            "Miso"
        )

        calori = arrayOf(
            "Kalori : 133",
            "Kalori : 232",
            "Kalori : 234"
        )
        newRecyclerView = binding.rvFood
        newRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        newRecyclerView.setHasFixedSize(true)

        foodList = arrayListOf<FoodResponse>()
        getFoodData()
        return view
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
