package com.pfv.playtimetracker.domain.use_case

import com.pfv.playtimetracker.domain.repository.PlayTimeTrackerRepository

class GetPlayTimeUseCase(private val repository: PlayTimeTrackerRepository) {

    operator fun invoke() = repository.getPlayTime()
}