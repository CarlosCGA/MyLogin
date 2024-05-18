package com.cazulabs.mylogin.countriesInformation.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryInformationEntity::class], version = 1)
abstract class CountriesInformationDatabase: RoomDatabase() {

    abstract fun getCountriesInformationDAO(): CountriesInformationDAO

}