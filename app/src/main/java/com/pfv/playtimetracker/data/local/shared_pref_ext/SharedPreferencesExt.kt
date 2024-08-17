package com.pfv.playtimetracker.data.local.shared_pref_ext

import android.content.SharedPreferences

private const val KEY_PLAY_TIME = "key_play_time"

fun SharedPreferences.savePlayTime(
    playTime: Long
) {
    edit().putLong(KEY_PLAY_TIME, playTime).apply()
}

fun SharedPreferences.getPlayTime() = getLong(KEY_PLAY_TIME, 0L)