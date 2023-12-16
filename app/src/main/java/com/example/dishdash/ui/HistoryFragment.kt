package com.example.dishdash.ui


import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import com.example.dishdash.R
import com.example.dishdash.databinding.FragmentHistoryBinding
import java.text.SimpleDateFormat
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.N)
class HistoryFragment : Fragment() {
    private lateinit var binding : FragmentHistoryBinding
    private val myCalendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val view = binding.root


        val btnDatePicker = binding.datePiker
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val todayDate = dateFormat.format(myCalendar.time)
        btnDatePicker.text = todayDate

        btnDatePicker.setOnClickListener {
            showDatePicker()
        }
        return view
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                // Do something with the formatted date, for example, update a TextView
                binding.datePiker.text = formattedDate
            },
            myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        )
        //Membatasi input tanggal
        val minDate = Calendar.getInstance()
        minDate.add(Calendar.DAY_OF_MONTH, -6)
        datePickerDialog.datePicker.minDate = minDate.timeInMillis

        val maxDate = Calendar.getInstance()
        maxDate.add(Calendar.DAY_OF_MONTH, 0)
        datePickerDialog.datePicker.maxDate = maxDate.timeInMillis
        datePickerDialog.show()
    }

}