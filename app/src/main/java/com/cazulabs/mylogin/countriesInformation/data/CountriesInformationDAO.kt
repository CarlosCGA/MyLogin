package com.cazulabs.mylogin.countriesInformation.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountriesInformationDAO {


    @Query("SELECT * FROM CountryInformationEntity")
    fun getCountriesInformation(): List<CountryInformationEntity>

    /*
        @Query("SELECT * FROM CountryInformationEntity")
        fun getCountriesInformation(): Flow<List<CountryInformationEntity>>
     */

    @Query("SELECT id, name, emoji, dialCode FROM CountryInformationEntity")
    fun getCountriesPhonePrefix(): List<CountryInformationEntity>

    @Insert
    suspend fun insertAll(countriesInformation: List<CountryInformationEntity>)

    @Delete
    suspend fun deleteAll()

}