package com.example.lab3.repo

import com.example.lab3.Weather
import org.springframework.data.repository.CrudRepository

interface WeatherRepository : CrudRepository<Weather, String> {






}