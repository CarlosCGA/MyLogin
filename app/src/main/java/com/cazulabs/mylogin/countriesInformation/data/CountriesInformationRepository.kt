package com.cazulabs.mylogin.countriesInformation.data

import com.cazulabs.mylogin.countriesInformation.data.model.CountryInformationModel
import com.cazulabs.mylogin.countriesInformation.data.model.CountryPhonePrefixModel
import com.cazulabs.mylogin.countriesInformation.data.network.CountriesInformationService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountriesInformationRepository @Inject constructor(
    private val countriesInformationDAO: CountriesInformationDAO,
    private val api: CountriesInformationService
) {

    var countriesInformation: List<CountryInformationModel> =
        countriesInformationDAO.getCountriesInformation()
            .map {
                CountryInformationModel(
                    it.name,
                    it.countryCode,
                    it.emoji,
                    it.unicode,
                    it.dialCode,
                    it.imageURL
                )
            }

    var countriesPhonePrefix: List<CountryPhonePrefixModel> =
        countriesInformationDAO.getCountriesPhonePrefix()
            .map {
                CountryPhonePrefixModel(
                    it.name,
                    it.emoji,
                    it.dialCode
                )
            }

    /*
    val countriesInformation: Flow<List<CountryInformationModel>> =
        countriesInformationDAO.getCountriesInformation().map { items -> items.map { CountryInformationModel(it.id, it.task, it.isDone) } }
        */


    suspend fun insertAll(countriesInformation: List<CountryInformationModel>) {
        countriesInformationDAO.insertAll(countriesInformation.map { countryInformationModel ->
            countryInformationModel.toData()
        })
    }

    suspend fun deleteAll() {
        countriesInformationDAO.deleteAll()
    }

    suspend fun getCountriesInformation(): List<CountryInformationModel> {
        if (countriesInformation.isEmpty()) {
            countriesInformation = api.getCountriesInformation().map { countryResponse ->
                CountryInformationModel(
                    name = countryResponse.name ?: "",
                    countryCode = countryResponse.countryCode ?: "",
                    emoji = countryResponse.emoji ?: "",
                    unicode = countryResponse.unicode ?: "",
                    dialCode = countryResponse.dialCode ?: "",
                    imageURL = countryResponse.imageURL ?: ""
                )
            }
            insertAll(countriesInformation)
        }

        return countriesInformation
    }

    suspend fun getCountriesPhonePrefix(): List<CountryPhonePrefixModel> {
        return countriesPhonePrefix.ifEmpty {
            insertAll(api.getCountriesInformation().map { countryResponse ->
                CountryInformationModel(
                    name = countryResponse.name ?: "",
                    countryCode = countryResponse.countryCode ?: "",
                    emoji = countryResponse.emoji ?: "",
                    unicode = countryResponse.unicode ?: "",
                    dialCode = countryResponse.dialCode ?: "",
                    imageURL = countryResponse.imageURL ?: ""
                )
            })
            emptyList()
        }
    }

}

fun CountryInformationModel.toData(): CountryInformationEntity {
    return CountryInformationEntity(
        null,
        this.name,
        this.countryCode,
        this.emoji,
        this.unicode,
        this.dialCode,
        this.imageURL
    )
}