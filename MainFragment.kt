package com.bignerdranch.android.weatherforecast.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.weatherforecast.data.database.BaseCity
import com.bignerdranch.android.weatherforecast.data.database.DatabaseCity
import com.bignerdranch.android.weatherforecast.data.network.WeatherResponse
import com.bignerdranch.android.weatherforecast.databinding.FragmentFirstBinding
import com.bignerdranch.android.weatherforecast.domain.MainFragmentViewModel

const val API_KEY = "0ef8741c77ee4b75b33102700242807"

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var mainFragmentViewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        mainFragmentViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]

        binding.resultTempBTNFF.setOnClickListener {
            mainFragmentViewModel.getWeather(binding.cityEDT.toString())
            mainFragmentViewModel.resultResponse.observe(
                viewLifecycleOwner,
                Observer { weatherData ->
                    binding.resultTempFF.text = weatherData.current.temp_c
                })
        }

        binding.button.setOnClickListener {
            mainFragmentViewModel.createCityInfo()
            mainFragmentViewModel.saveCityInfo()
        }
        return binding.root
    }
}





