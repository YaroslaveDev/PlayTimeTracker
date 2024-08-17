package com.pfv.playtimetracker.ui.screens.home

import androidx.lifecycle.ViewModel
import com.pfv.playtimetracker.domain.use_case.GetPlayTimeUseCase
import com.pfv.playtimetracker.domain.use_case.SavePlayTimeUseCase
import com.pfv.playtimetracker.tools.PlayTimeManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPlayTimeUseCase: GetPlayTimeUseCase
) : ViewModel() {

    private val _currentPlayTime = MutableStateFlow<Long>(0L)
    val currentPlayTime: StateFlow<Long> = _currentPlayTime.asStateFlow()

    init {
        _currentPlayTime.tryEmit(getPlayTimeUseCase())
    }
}