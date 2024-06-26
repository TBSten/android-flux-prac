package me.tbsten.prac.flux.counter

import me.tbsten.prac.flux.flux.FluxStore

class CounterStore : FluxStore<CounterState, CounterAction>(CounterState.Initial) {
    override fun reducer(prevState: CounterState, action: CounterAction): CounterState =
        when (action) {
            is CounterAction.CountUp ->
                if (prevState.canChange)
                    prevState.copy(count = prevState.count + action.count)
                else
                    prevState

            is CounterAction.CountDown ->
                if (prevState.canChange)
                    prevState.copy(count = prevState.count - action.count)
                else
                    prevState

            CounterAction.ToggleCanChange ->
                prevState.copy(canChange = !prevState.canChange)
        }
}
