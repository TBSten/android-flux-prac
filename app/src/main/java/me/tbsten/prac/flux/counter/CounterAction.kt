package me.tbsten.prac.flux.counter

sealed interface CounterAction {
    data class CountUp(val count: Int) : CounterAction
    data class CountDown(val count: Int) : CounterAction
    data object ToggleCanChange : CounterAction
}
