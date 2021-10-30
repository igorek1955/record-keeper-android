package com.example.recordkeeper

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recordkeeper.databinding.ActivityEditCyclingRecordBinding
import com.example.recordkeeper.local_storage.CyclingStaticInfo
import java.text.SimpleDateFormat
import java.util.*

class EditCyclingRecordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditCyclingRecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle()
        setUpClickListeners()
    }

    private fun setUpClickListeners() {

        val distance = intent.getStringExtra("Distance")
        lateinit var date: String
        lateinit var time: String

        binding.buttonCurrentData.setOnClickListener {
            val calendar: Date = Calendar.getInstance().time;
            val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            val timeFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            date = dateFormatter.format(calendar).toString()
            time = timeFormatter.format(calendar).toString()
            setDateTimeAndStartActivity(distance, date, time)
        }

        binding.buttonSubmit.setOnClickListener {
            date = binding.editTextDate.text.toString()
            time = binding.editTextTime.text.toString()
            setDateTimeAndStartActivity(distance, date, time)
        }
    }

    private fun setDateTimeAndStartActivity(distance: String?, date: String, time: String) {
        when (distance) {
            "25km" -> {
                CyclingStaticInfo.date25 = date
                CyclingStaticInfo.time25 = time
            }
            "35km" -> {
                CyclingStaticInfo.date35 = date
                CyclingStaticInfo.time35 = time
            }
            "50km" -> {
                CyclingStaticInfo.date50 = date
                CyclingStaticInfo.time50 = time
            }
            "60km" -> {
                CyclingStaticInfo.date60 = date
                CyclingStaticInfo.time60 = time
            }
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun setTitle() {
        val newTitle = "${intent.getStringExtra("Distance")} record"
        title = newTitle
    }
}