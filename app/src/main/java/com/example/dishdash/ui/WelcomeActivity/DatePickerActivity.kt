package com.example.dishdash.ui.WelcomeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dishdash.R
import com.example.dishdash.databinding.ActivityDatePickerBinding

class DatePickerActivity : AppCompatActivity() {
    private lateinit var binding  : ActivityDatePickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}