package com.example.onboard.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onboard.R
import com.example.onboard.databinding.FragmentThirdScreenBinding

class ThirdScreenFragment : Fragment() {
    private lateinit var binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThirdScreenBinding.inflate(inflater, container, false)

        binding.tvFinish.setOnClickListener {

            findNavController().navigate(R.id.action_onBoardingFragment_to_homeFragment)
            onBoardingIsFinished()
        }

        return binding.root
    }

    private fun onBoardingIsFinished(){

        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("finished",true)
        editor.apply()
    }
}