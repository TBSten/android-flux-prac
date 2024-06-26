package me.tbsten.prac.flux.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import me.tbsten.prac.flux.counter.CounterAction
import me.tbsten.prac.flux.singletonCounterStore

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel {
        HomeViewModel(singletonCounterStore)
    }
    val count by homeViewModel.count.collectAsState()
    val canChange by homeViewModel.canChange.collectAsState()

    HomeScreen(
        count = count,
        canChange = canChange,
        onIncrease = { homeViewModel.dispatchCount(CounterAction.CountUp(1)) },
        onDecrease = { homeViewModel.dispatchCount(CounterAction.CountDown(1)) },
        onToggleEnabled = { homeViewModel.dispatchCount(CounterAction.ToggleCanChange) },
    )
}

@Composable
private fun HomeScreen(
    count: Int,
    canChange: Boolean,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onToggleEnabled: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("$count")
        Row {
            Button(onClick = onIncrease, enabled = canChange) {
                Text("+")
            }
            Button(onClick = onDecrease, enabled = canChange) {
                Text("-")
            }
        }
        Button(onClick = onToggleEnabled) {
            Text("toggle enabled")
        }
    }
}
