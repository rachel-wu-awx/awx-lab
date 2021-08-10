package com.example.lab3

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Weather(@Id val city: String = "",
                   val temp_lo: Int =0,
                   val temp_hi : Int =0,
                   val prcp : Double =0.0 , val date : Date =Calendar.getInstance().time)
