package com.pfv.playtimetracker.ui.navigation.constants

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object HomeScreen : Routes()
}