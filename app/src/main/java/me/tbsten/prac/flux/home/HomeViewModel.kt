package me.tbsten.prac.flux.home

import androidx.lifecycle.ViewModel
import me.tbsten.prac.flux.counter.CounterAction
import me.tbsten.prac.flux.counter.CounterStore
import me.tbsten.prac.flux.flux.selectedStateFlow

class HomeViewModel(
    private val counterStore: CounterStore,
) : ViewModel() {
    val count = selectedStateFlow(counterStore) { it.count }
    val canChange = selectedStateFlow(counterStore) { it.canChange }

    fun dispatchCount(action: CounterAction) = counterStore.dispatch(action)
}
