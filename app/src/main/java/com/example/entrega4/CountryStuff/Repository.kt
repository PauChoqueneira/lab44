package com.example.entrega4.CountryStuff

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource

class Repository(private val countryDao: CountryDao) {

    val allCountry : LiveData<List<Country>> = countryDao.getAllCountry()
    val countriesPaging : PagingSource<Int, Country> = countryDao.getAllCountryPaging()

    suspend fun addCountry(country: Country ){
        countryDao.insertCountry(country)
    }


}