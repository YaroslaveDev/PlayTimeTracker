package com.pfv.playtimetracker

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pfv.playtimetracker.tools.PlayTimeManager
import com.pfv.playtimetracker.ui.navigation.RootNavGraph
import com.pfv.playtimetracker.ui.theme.PlayTimeTrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var playTimeManager: PlayTimeManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PlayTimeTrackerTheme {

                val currentPlayTime by playTimeManager.playTime.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = currentPlayTime.toString())
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        playTimeManager.start()
    }

    override fun onPause() {
        super.onPause()
        playTimeManager.stop()
    }

}