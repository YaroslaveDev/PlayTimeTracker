package com.pfv.playtimetracker.domain.use_case

import com.pfv.playtimetracker.domain.repository.PlayTimeTrackerRepository

class SavePlayTimeUseCase(private val repository: PlayTimeTrackerRepository) {

    operator fun invoke(time: Long) = repository.setPlayTime(time)
}