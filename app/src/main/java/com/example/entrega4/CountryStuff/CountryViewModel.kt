package com.example.entrega4.CountryStuff


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CountryViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository

    init {
        val countryDao = CountryDatabase.getInstance(application).countryDao
        repository = Repository(countryDao)
    }

    fun insertCountry(country: Country) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCountry(country)
        }
    }

    fun pagingSource() : Flow<PagingData<Country>> {

        return Pager(PagingConfig(pageSize = 20, initialLoadSize = 20 * 5, enablePlaceholders = false, prefetchDistance = 3)) {
            repository.countriesPaging
        }.flow.cachedIn(viewModelScope)
    }

}