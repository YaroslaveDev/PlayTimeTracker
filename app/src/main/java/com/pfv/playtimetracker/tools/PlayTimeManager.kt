package com.pfv.playtimetracker.tools

import android.icu.util.Calendar
import android.util.Log
import com.pfv.playtimetracker.domain.use_case.GetPlayTimeUseCase
import com.pfv.playtimetracker.domain.use_case.SavePlayTimeUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayTimeManager @Inject constructor(
    val getPlayTimeUseCase: GetPlayTimeUseCase,
    val savePlayTimeUseCase: SavePlayTimeUseCase
) {

    private var startTime : Long = 0
    private var timerJob: Job? = null

    private val _playTime = MutableStateFlow(0L)
    val playTime: StateFlow<Long> = _playTime.asStateFlow()

    fun start() {

        startTime = Calendar.getInstance().timeInMillis

        if (_playTime.value == 0L) {
            _playTime.tryEmit(getPlayTimeUseCase())
        }

        timerJob = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                _playTime.value += 1
                savePlayTimeUseCase(_playTime.value)
                delay(1000)
            }
        }
    }

    fun stop(){

        timerJob?.cancel()

        savePlayTimeUseCase(
            time = _playTime.value
        )
    }
}