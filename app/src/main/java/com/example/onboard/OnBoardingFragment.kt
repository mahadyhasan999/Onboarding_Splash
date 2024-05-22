package com.example.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboard.databinding.FragmentOnBoardingBinding
import com.example.onboard.screens.FirstScreenFragment
import com.example.onboard.screens.SecondScreenFragment
import com.example.onboard.screens.ThirdScreenFragment

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter= ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewPager)
        return binding.root
    }

}