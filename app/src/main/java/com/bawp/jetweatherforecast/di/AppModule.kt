package com.bawp.jetweatherforecast.di

import android.content.Context
import androidx.room.Room
import com.bawp.jetweatherforecast.data.WeatherDao
import com.bawp.jetweatherforecast.data.WeatherDatabase
import com.bawp.jetweatherforecast.network.WeatherApi
import com.bawp.jetweatherforecast.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideWeatherDao(weatherDatabase: WeatherDatabase): WeatherDao
    = weatherDatabase.weatherDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeatherDatabase
     = Room.databaseBuilder(
          context,
          WeatherDatabase::class.java,
          "weather_database")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideOpenWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }








}