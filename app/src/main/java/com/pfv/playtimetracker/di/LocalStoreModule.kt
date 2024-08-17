package com.pfv.playtimetracker.di

import android.content.Context
import android.content.SharedPreferences
import com.pfv.playtimetracker.constants.BaseAppConstants.PrefsName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalStoreModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PrefsName, Context.MODE_PRIVATE)
    }
}