package com.pfv.playtimetracker.di

import android.content.Context
import android.content.SharedPreferences
import com.pfv.playtimetracker.data.repository.PlayTimeTrackerRepositoryImpl
import com.pfv.playtimetracker.domain.repository.PlayTimeTrackerRepository
import com.pfv.playtimetracker.domain.use_case.GetPlayTimeUseCase
import com.pfv.playtimetracker.domain.use_case.SavePlayTimeUseCase
import com.pfv.playtimetracker.tools.PlayTimeManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providePlayTimeRepository(
        sharedPreferences: SharedPreferences,
    ): PlayTimeTrackerRepository {
        return PlayTimeTrackerRepositoryImpl(sharedPreferences = sharedPreferences)
    }

//    @Provides
//    fun providePlayTimeManager(
//        getPlayTimeUseCase: GetPlayTimeUseCase,
//        savePlayTimeUseCase: SavePlayTimeUseCase
//    ): PlayTimeManager = PlayTimeManager(getPlayTimeUseCase, savePlayTimeUseCase)
}
