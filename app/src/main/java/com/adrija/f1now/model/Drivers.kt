package com.adrija.f1app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drivers (

  @SerializedName("driverId"        ) var driverId        : String? = null,
  @SerializedName("permanentNumber" ) var permanentNumber : String? = null,
  @SerializedName("code"            ) var code            : String? = null,
  @SerializedName("url"             ) var url             : String? = null,
  @SerializedName("givenName"       ) var givenName       : String? = null,
  @SerializedName("familyName"      ) var familyName      : String? = null,
  @SerializedName("dateOfBirth"     ) var dateOfBirth     : String? = null,
  @SerializedName("nationality"     ) var nationality     : String? = null

) : Parcelable
