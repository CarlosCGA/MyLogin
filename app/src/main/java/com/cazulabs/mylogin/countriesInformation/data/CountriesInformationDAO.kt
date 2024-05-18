package com.cazulabs.mylogin.countriesInformation.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface CountriesInformationDAO {

    @Insert
    suspend fun insertAll(countriesInformation: List<CountryInformationEntity>)

    @Delete
    suspend fun deleteAll()

}