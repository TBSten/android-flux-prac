package me.tbsten.prac.flux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.tbsten.prac.flux.home.HomeScreen
import me.tbsten.prac.flux.ui.theme.FluxPracTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FluxPracTheme {
                HomeScreen()
            }
        }
    }
}
