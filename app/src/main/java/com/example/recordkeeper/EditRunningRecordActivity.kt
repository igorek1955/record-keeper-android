package com.example.recordkeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recordkeeper.databinding.ActivityEditRunningRecordBinding
import com.example.recordkeeper.local_storage.RunningStaticInfo
import java.text.SimpleDateFormat
import java.util.*

class EditRunningRecordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditRunningRecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
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
        }
    }

    private fun setDateTimeAndStartActivity(distance: String?, date: String, time: String) {
        when (distance) {
            "5km" -> {
                RunningStaticInfo.date5 = date
                RunningStaticInfo.time5 = time
            }
            "10km" -> {
                RunningStaticInfo.date10 = date
                RunningStaticInfo.time10 = time
            }
            "15km" -> {
                RunningStaticInfo.date15 = date
                RunningStaticInfo.time15 = time
            }
            "20km" -> {
                RunningStaticInfo.date20 = date
                RunningStaticInfo.time20 = time
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