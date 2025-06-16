package com.adrija.f1now.model

import com.google.gson.annotations.SerializedName


data class DriverTable (

  @SerializedName("season"  ) var season  : String?            = null,
  @SerializedName("Drivers" ) var Drivers : ArrayList<Drivers> = arrayListOf()

)