package com.cazulabs.mylogin.countriesInformation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CountriesInformationDAO {


    @Query("SELECT * FROM countries")
    fun getCountriesInformation(): Flow<List<CountryInformationEntity>>

    /*
        @Query("SELECT * FROM CountryInformationEntity")
        fun getCountriesInformation(): Flow<List<CountryInformationEntity>>
     */

    @Query("SELECT id, name, emoji, dial_code FROM countries")
    fun getCountriesPhonePrefix(): List<CountryInformationEntity>

    @Insert
    suspend fun insertAll(countriesInformation: List<CountryInformationEntity>)

    /*
    @DeleteTable()
    suspend fun deleteAll()
    */

}