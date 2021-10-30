package com.example.recordkeeper.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recordkeeper.EditCyclingRecordActivity
import com.example.recordkeeper.databinding.FragmentCyclingBinding
import com.example.recordkeeper.local_storage.CyclingStaticInfo

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFields()
        setupClickListeners()
    }

    private fun initFields() {
        binding.textViewTime25km.text = CyclingStaticInfo.time25
        binding.textViewDate25km.text = CyclingStaticInfo.date25

        binding.textViewTime35km.text = CyclingStaticInfo.time35
        binding.textViewDate35km.text = CyclingStaticInfo.date35

        binding.textViewTime50km.text = CyclingStaticInfo.time50
        binding.textViewDate50km.text = CyclingStaticInfo.date50

        binding.textViewTime60km.text = CyclingStaticInfo.time60
        binding.textViewDate60km.text = CyclingStaticInfo.date60
    }

    private fun setupClickListeners() {
        binding.container25km.setOnClickListener { launchRunningRecordEditScreen("25km") }
        binding.container35km.setOnClickListener { launchRunningRecordEditScreen("35km") }
        binding.container50km.setOnClickListener { launchRunningRecordEditScreen("50km") }
        binding.container60km.setOnClickListener { launchRunningRecordEditScreen("60km") }
    }

    private fun launchRunningRecordEditScreen(distance: String) {
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }
}