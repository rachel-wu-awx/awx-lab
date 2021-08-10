package com.example.lab3

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class WeatherController (val service: WeatherService){

    @GetMapping("/weather")
    fun all():List<Weather> = service.findAllWeather()


    @GetMapping("/weatherByCity")
    fun findByCity(@RequestParam city: String):List<Weather> {
        var result: Weather? = service.findWeatherByCity(city)
        if(result != null){
            return listOf(result)
        }else{
            return listOf()
        }

    }

    @PostMapping("/weather")
    fun postWeather(@RequestBody weather: Weather):Weather{
        return  service.postWeather(weather)

    }
}