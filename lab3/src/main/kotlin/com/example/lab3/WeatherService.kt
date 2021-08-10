package com.example.lab3

import com.example.lab3.repo.WeatherRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service

class WeatherService (val weatherRepo: WeatherRepository){

    fun findAllWeather(): List<Weather>{

        return weatherRepo.findAll().asSequence().toList()
    }
    fun findWeatherByCity( city: String): Weather? = weatherRepo.findByIdOrNull(city)
    fun postWeather(weather: Weather) : Weather{
        weatherRepo.save(weather)
        return weather
    }
}