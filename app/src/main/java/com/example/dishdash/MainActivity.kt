package com.example.dishdash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

// Tambahkan bayangan dengan setElevation
        ViewCompat.setElevation(bottomNavigationView, resources.getDimension(R.dimen.bottom_nav_elevation))

    }
}