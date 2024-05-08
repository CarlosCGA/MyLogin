package com.cazulabs.mylogin.countriesInformation.data.network.response

import com.google.gson.annotations.SerializedName

data class CountryInformationResponse(
    @SerializedName("name") val name: String,
    @SerializedName("code") val countryCode: String,
    @SerializedName("emoji") val emoji: String,
    @SerializedName("unicode") val unicode: String,
    @SerializedName("dial_code") val dialCode: String,
    @SerializedName("image") val imageURL: String,
    )
