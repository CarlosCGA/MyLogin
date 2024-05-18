package com.cazulabs.mylogin.countriesInformation.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryInformationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String,
    val countryCode: String,
    val emoji: String,
    val unicode: String,
    val dialCode: String,
    val imageURL: String,
)