package com.example.dishdash.ui.WelcomeActivity

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.dishdash.R

class PlacesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places)

        // Mendapatkan ImageView dari layout
        val imageView: ImageView = findViewById(R.id.imageView)

        // Mendapatkan drawable dari image.png
        val drawable = ContextCompat.getDrawable(this, R.drawable.img)

        // Menerapkan ColorFilter dengan warna #14213D
        val colorFilter = PorterDuffColorFilter(Color.parseColor("#14213D"), PorterDuff.Mode.SRC_IN)
        drawable?.colorFilter = colorFilter

        // Menetapkan drawable yang sudah diubah warnanya ke ImageView
        imageView.setImageDrawable(drawable)
    }
}