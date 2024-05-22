package com.example.onboard.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.onboard.R
import com.example.onboard.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        binding.tvSkip2.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_homeFragment)
            onBoardingIsFinished()
        }

        binding.tvNext2.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return binding.root
    }

    private fun onBoardingIsFinished() {
        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("finished",true)
        editor.apply()
    }
}