package com.example.entrega4.CountryStuff

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {
    @Query("SELECT * from Country")
    fun getAllCountry(): LiveData<List<Country>>

    @Query("SELECT * from Country")
    fun getAllCountryPaging(): PagingSource<Int, Country>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountry(country: Country  )

    @Query("SELECT * from Country WHERE CountryId = :countryId")
    fun getCourse(countryId: Int): Country?
}