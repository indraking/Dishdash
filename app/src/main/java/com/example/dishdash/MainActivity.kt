package com.example.dishdash

import CustomCircularProgressIndicator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.dishdash.databinding.ActivityMainBinding
import com.example.dishdash.ui.Jetpack.CustomRoundedHorizontalProgressIndicator
import com.example.dishdash.ui.Jetpack.gray
import com.example.dishdash.ui.Jetpack.orange
import com.example.dishdash.ui.Jetpack.orangeLight
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.bottomNav
        val menu = bottomNavigationView.menu

        // Mengubah warna Icon
        val homeItem = menu.findItem(R.id.nav_home)
        homeItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_home_selected)

        // Tambahkan bayangan dengan setElevation
        ViewCompat.setElevation(bottomNavigationView, resources.getDimension(R.dimen.bottom_nav_elevation))


        val composeViewCarbo : ComposeView = binding.circularComposeCarbo
        val composeViewProtein : ComposeView = binding.circularComposeProtein
        val composeViewFat : ComposeView = binding.circularComposeFat

        val composeViewHorizontal : ComposeView = binding.horizontalPercentage


        composeViewCarbo.setContent {
            CustomCircularProgressIndicator(
                modifier = Modifier
                    .size(130.dp),
                initialValue = 60,
                primaryColor = orange,
                secondaryColor = orangeLight,
                circleRadius = 170f,
                type = "Carbo",
                onPositionChange = {

                }
            )
        }
        composeViewProtein.setContent {
            CustomCircularProgressIndicator(
                modifier = Modifier
                    .size(130.dp),
                initialValue = 80,
                primaryColor = orange,
                secondaryColor = orangeLight,
                circleRadius = 170f,
                type = "Protein",
                onPositionChange = {

                }
            )
        }
        composeViewFat.setContent {
            CustomCircularProgressIndicator(
                modifier = Modifier
                    .size(130.dp),
                initialValue = 78,
                primaryColor = orange,
                secondaryColor = orangeLight,
                circleRadius = 170f,
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
                primaryColor = orange,
                secondaryColor = orangeLight,
                onPositionChange = {

                }
            )
        }
    }
}