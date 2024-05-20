package com.cazulabs.mylogin.countriesInformation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryInformationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "country_code") val countryCode: String?,
    @ColumnInfo(name = "emoji") val emoji: String?,
    @ColumnInfo(name = "unicode") val unicode: String?,
    @ColumnInfo(name = "dial_code") val dialCode: String?,
    @ColumnInfo(name = "image_url") val imageURL: String?,
)