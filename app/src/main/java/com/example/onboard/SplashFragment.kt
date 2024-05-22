package com.example.onboard

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.onboard.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashBinding.inflate(inflater, container, false)

        val animTop = AnimationUtils.loadAnimation(binding.root.context, R.anim.fly_in_top)
//        val animBottom = AnimationUtils.loadAnimation(binding.root.context, R.anim.fly_in_bottom)

//        binding.tvSplash.animation = animBottom
        binding.imageView.animation = animTop


        Handler(Looper.getMainLooper()).postDelayed({

            if (onBoardingIsFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }

        }, 2500)

        return binding.root
    }
    private fun onBoardingIsFinished(): Boolean{

        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("finished",false)
    }

}