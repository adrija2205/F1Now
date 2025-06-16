package com.adrija.f1now.model

data class Drivers(
  val driver_number: String?,
  val name_acronym: String?,
  val broadcast_name: String?,
  val full_name: String?,
  val team_name: String?,
  val headshot_url: String? = null
)
