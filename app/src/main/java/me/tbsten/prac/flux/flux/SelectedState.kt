package me.tbsten.prac.flux.flux

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


fun <State, Action, SliceValue> selectedStateFlow(
    store: FluxStore<State, Action>,
    coroutineScope: CoroutineScope,
    selector: (state: State) -> SliceValue,
) =
    store.flow
        .map(selector)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = selector(store.initialState),
        )

fun <State, Action, SliceValue> ViewModel.selectedStateFlow(
    store: FluxStore<State, Action>,
    selector: (state: State) -> SliceValue,
) =
    selectedStateFlow(
        store = store,
        coroutineScope = viewModelScope,
        selector = selector,
    )
