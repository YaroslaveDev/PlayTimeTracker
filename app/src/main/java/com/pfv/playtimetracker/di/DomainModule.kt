package com.pfv.playtimetracker.di

import com.pfv.playtimetracker.domain.repository.PlayTimeTrackerRepository
import com.pfv.playtimetracker.domain.use_case.GetPlayTimeUseCase
import com.pfv.playtimetracker.domain.use_case.SavePlayTimeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetPlayTimeUseCase(playTimeTrackerRepository: PlayTimeTrackerRepository) =
        GetPlayTimeUseCase(repository = playTimeTrackerRepository)

    @Provides
    fun provideSavePlayTimeUseCase(playTimeTrackerRepository: PlayTimeTrackerRepository) =
        SavePlayTimeUseCase(repository = playTimeTrackerRepository)
}