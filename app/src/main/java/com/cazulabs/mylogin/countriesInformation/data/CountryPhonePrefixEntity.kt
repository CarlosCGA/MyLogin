package com.cazulabs.mylogin.countriesInformation.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryPhonePrefixEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String,
    val emoji: String,
    val dialCode: String,
)