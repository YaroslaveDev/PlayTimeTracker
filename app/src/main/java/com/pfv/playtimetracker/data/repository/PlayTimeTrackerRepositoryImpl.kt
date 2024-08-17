package com.pfv.playtimetracker.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.pfv.playtimetracker.data.local.shared_pref_ext.getPlayTime
import com.pfv.playtimetracker.data.local.shared_pref_ext.savePlayTime
import com.pfv.playtimetracker.domain.repository.PlayTimeTrackerRepository

class PlayTimeTrackerRepositoryImpl(
    private val sharedPreferences: SharedPreferences,
) : PlayTimeTrackerRepository {

    override fun getPlayTime(): Long {

        return sharedPreferences.getPlayTime()
    }

    override fun setPlayTime(time: Long) {

        sharedPreferences.savePlayTime(time)
    }
}