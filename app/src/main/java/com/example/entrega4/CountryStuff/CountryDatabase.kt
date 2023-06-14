package com.example.entrega4.CountryStuff


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Country::class,

    ],
    version = 1,
    exportSchema = true
)
abstract class CountryDatabase : RoomDatabase() {

    abstract val countryDao: CountryDao

    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null

        fun getInstance(context: Context): CountryDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CountryDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}