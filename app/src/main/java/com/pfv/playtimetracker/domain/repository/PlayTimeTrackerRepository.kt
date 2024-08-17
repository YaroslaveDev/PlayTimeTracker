package com.pfv.playtimetracker.domain.repository

interface PlayTimeTrackerRepository {

    fun getPlayTime() : Long
    fun setPlayTime(time: Long)
}