package com.example.recordkeeper.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recordkeeper.EditRunningRecordActivity
import com.example.recordkeeper.databinding.FragmentRunningBinding
import com.example.recordkeeper.local_storage.RunningStaticInfo

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFields()
        setupClickListeners()
    }

    private fun initFields() {
        binding.textViewTime.text = RunningStaticInfo.time5
        binding.textViewDate.text = RunningStaticInfo.date5

        binding.textViewTime10km.text = RunningStaticInfo.time10
        binding.textViewDate10km.text = RunningStaticInfo.date10

        binding.textViewTime15km.text = RunningStaticInfo.time15
        binding.textViewDate15km.text = RunningStaticInfo.date15

        binding.textViewTime20km.text = RunningStaticInfo.time20
        binding.textViewDate20km.text = RunningStaticInfo.date20
    }

    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { launchRunningRecordEditScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningRecordEditScreen("10km") }
        binding.container15km.setOnClickListener { launchRunningRecordEditScreen("15km") }
        binding.container20km.setOnClickListener { launchRunningRecordEditScreen("20km") }
    }

    private fun launchRunningRecordEditScreen(distance: String) {
        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }
}