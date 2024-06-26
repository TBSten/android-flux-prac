package me.tbsten.prac.flux.flux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class FluxStore<State, Action>(
    initialState: State,
) {
    private val _flow = MutableStateFlow(initialState)
    val flow = _flow.asStateFlow()

    internal val initialState = initialState

    abstract fun reducer(prevState: State, action: Action): State
    fun dispatch(action: Action) {
        _flow.update { reducer(it, action) }
    }
}
