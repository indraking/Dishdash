package com.example.dishdash.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dishdash.R
import com.example.dishdash.databinding.ActivityDetailRestaurantBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DetailRestaurantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRestaurantBinding
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync { map ->
            googleMap = map
            // Tambahkan logika lain yang Anda perlukan untuk peta di sini
        }


    }
    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

}
